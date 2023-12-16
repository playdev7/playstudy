// 비동기
import "dart:async";
import "./timermodel.dart";
import "package:shared_preferences/shared_preferences.dart";

class CountDownTimer {
  // 카운트다운 타이머에 대한 멤버변수 공간
  double _radius = 1;
  bool _isActive = true; // 작동여부 -> default 작동중
  late Timer timer; // 타이머 객체를 저장하는 공간
  // Duration Type으로서 시간을 저장하는 공간 -  Null Safety 반영
  Duration _time = Duration(seconds: 0);
  Duration _fullTime = Duration(seconds: 0);

  // 버튼별 실행 분 수에 대한 멤버변수
  int work = 30;
  int shortBreak = 5;
  int longBreak = 20;

  // 시간 텍스트 함수 정의
  String returnTime(Duration t) {
    // 한자리수 분이 되면 0을 붙이기
    String minute = (t.inMinutes < 10)
        ? "0" + t.inMinutes.toString()
        : t.inMinutes.toString();
    // 남은 초가 한자리수가 되면 0을 붙이기
    int numSeconds = t.inSeconds - (t.inMinutes * 60);
    String seconds =
        (numSeconds < 10) ? numSeconds.toString() : numSeconds.toString();
    String formattedTime = minute + ":" + seconds;
    return formattedTime;
  }

  // Work를 실행하는 메소드
  void startWork() async {
    await readSettings();
    _isActive = true;
    _radius = 1;
    _time = Duration(minutes: this.work, seconds: 0);
    _fullTime = _time;
  }

  // 브레이크 실행 메소드 => 파라미터로 숏인지 받아서 숏/롱 구분
  void startBreak(bool isShort) async {
    await readSettings();
    _radius = 1;
    _time = Duration(
        // 파라미터로 숏인지 받아서 숏/롱 구분
        minutes: (isShort) ? shortBreak : longBreak,
        seconds: 0);
    _fullTime = _time;
  }

  // 타이머 실행 메소드
  void startTimer() {
    if (_time.inSeconds > 0) {
      this._isActive = true;
    }
  }

  // 타이머 중단 메소드
  void stopTimer() {
    this._isActive = false;
  }

  // 비동기 스트림 메서드
  // async* 선언 => 스트림 제네레이터 / Stream 이므로 끝에 asterisk를 붙임.
  Stream<TimerModel> stream() async* {
    // yield 선언 => 함수를 종료하지 않고 정의된 Duration 마다 반환
    yield* Stream.periodic(Duration(seconds: 1), (int a) {
      String time;
      if (this._isActive) {
        // 시간 음수화 개선 => 0 이하이면 0으로 표시
        _time = ((_time - Duration(seconds: 1)) > Duration(seconds: 0))
            ? _time - Duration(seconds: 1)
            : Duration(seconds: 0);
        // Zero Division 개선 => 0이하일 경우 0으로
        _radius = (_time.inSeconds <= 0 && _fullTime.inSeconds <= 0)
            ? 0
            : _time.inSeconds / _fullTime.inSeconds;
        // 만약 시간이 00:00 보다 작게 되면 비활성화
        if (_time.inSeconds < 0) {
          _isActive = false;
        }
      }
      // "00:00"으로 표시되도록
      time = (returnTime(_time) == "00:0") ? "00:00" : returnTime(_time);
      // yield로 반환되는 것은 TimerModel Object.
      return TimerModel(time, _radius);
    });
  }

  // SharedPreference instance read method
  Future readSettings() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    dynamic work =
        prefs.getInt("workTime") == null ? 30 : prefs.getInt("workTime");
    dynamic shortBreak =
        prefs.getInt("shortBreak") == null ? 5 : prefs.getInt("shortBreak");
    dynamic longBreak =
        prefs.getInt("longBreak") == null ? 20 : prefs.getInt("longBreak");

    this.work = int.parse(work.toString());
    this.shortBreak = int.parse(shortBreak.toString());
    this.longBreak = int.parse(longBreak.toString());
  }
}
