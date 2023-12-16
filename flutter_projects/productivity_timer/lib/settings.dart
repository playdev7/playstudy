// 사용자 설정 화면(라우트) 공간
import "package:flutter/material.dart";
import "./widgets.dart";
// shared_preferences 를 통해 앱 내부 공간에 간단한 데이터를 저장 및 로드할 수 있음 (암호화되지 않음)
import "package:shared_preferences/shared_preferences.dart";

class SettingsScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Settings"),
        ),
        body: Settings());
  }
}

// <stful> 에밋으로 빠르게 생성 가능
class Settings extends StatefulWidget {
  @override
  State<Settings> createState() => _SettingsState();
}

class _SettingsState extends State<Settings> {
  // 사용자의 값을 텍스트로 읽고 쓰기 위한 TextEditingController 객체 정의
  late TextEditingController txtWork;
  late TextEditingController txtShort;
  late TextEditingController txtLong;

  // shared_preferece와 상호작용 하도록 필요한 멤버 정의
  static const String WORKTIME = "workTime";
  static const String SHORTBREAK = "shortBreak";
  static const String LONGBREAK = "longBreak";
  late int workTime;
  late int ShortBreak;
  late int LongBreak;

  // SharedPreferences 객체 공간 정의
  SharedPreferences? prefs;

  @override
  // 초기자를 통해 상태가 생성되자마자 TextEditingController 객체들이 생성되도록
  void initState() {
    txtWork = TextEditingController();
    txtShort = TextEditingController();
    txtLong = TextEditingController();
    // 초기자 실행 시 끝단에 항상 조상 초기자 실행
    super.initState();
  }

  Widget build(BuildContext context) {
    // 설정 불러오기
    readSettings();
    // 텍스트 스타일 기본 디자인 정의
    TextStyle textStyle = TextStyle(fontSize: 24);
    double buttonSize = 10.0;

    return Container(
        // GrideView 객체를 통해 여러 위젯을 표 형태로 표현 가능(갤러리 느낌)
        child: GridView.count(
      scrollDirection: Axis.vertical,
      crossAxisCount: 3,
      childAspectRatio: 3,
      mainAxisSpacing: 10,
      // 들어가야하는 위젯 정의
      children: <Widget>[
        // Work 시간 설정
        Text("Work", style: textStyle),
        Text(""),
        Text(""),
        SettingButton(
            Color(0xff455A64), "-", buttonSize, -1, WORKTIME, updateSetting),
        TextField(
          style: textStyle,
          textAlign: TextAlign.center,
          keyboardType: TextInputType.number,
          // 텍스트필드에 텍스트 컨트롤러 추가
          controller: txtWork,
        ),
        SettingButton(
            Color(0xff009688), "+", buttonSize, 1, WORKTIME, updateSetting),

        // 숏 시간 설정
        Text("Short", style: textStyle),
        Text(""),
        Text(""),
        SettingButton(
            Color(0xff455A64), "-", buttonSize, -1, SHORTBREAK, updateSetting),
        TextField(
          style: textStyle,
          textAlign: TextAlign.center,
          keyboardType: TextInputType.number,
          // 텍스트필드에 텍스트 컨트롤러 추가
          controller: txtShort,
        ),
        SettingButton(
            Color(0xff009688), "+", buttonSize, 1, SHORTBREAK, updateSetting),

        // 롱 시간 설정
        Text("Long", style: textStyle),
        Text(""),
        Text(""),
        SettingButton(
            Color(0xff455A64), "-", buttonSize, -1, LONGBREAK, updateSetting),
        TextField(
          style: textStyle,
          textAlign: TextAlign.center,
          keyboardType: TextInputType.number,
          // 텍스트필드에 텍스트 컨트롤러 추가
          controller: txtLong,
        ),
        SettingButton(
            Color(0xff009688), "+", buttonSize, 1, LONGBREAK, updateSetting),
      ],
      padding: const EdgeInsets.all(20),
    ));
  }

  // 설정을 읽는 비동기 메소드 정의
  readSettings() async {
    final SharedPreferences prefs = await SharedPreferences.getInstance();
    // null-safety => 자료형 뒤에 ?을 붙여 null일수도 있음을 명시
    int? workTime = prefs.getInt(WORKTIME);
    if (workTime == null) {
      await prefs.setInt(WORKTIME, 30);
    }
    int? shortBreak = prefs.getInt(SHORTBREAK);
    if (shortBreak == null) {
      await prefs.setInt(SHORTBREAK, 5);
    }
    int? longBreak = prefs.getInt(LONGBREAK);
    if (longBreak == null) {
      await prefs.setInt(LONGBREAK, 20);
    }

    setState(() {
      txtWork.text = workTime.toString();
      txtShort.text = shortBreak.toString();
      txtLong.text = longBreak.toString();
    });
  }

  // 설정 업데이트 메소드
  void updateSetting(String key, int value) async {
    final SharedPreferences prefs = await SharedPreferences.getInstance();
    switch (key) {
      case WORKTIME:
        {
          // Null Safety => null이면 기본값으로 30분 설정
          int? workTime =
              (prefs.getInt(WORKTIME) == null) ? 30 : prefs.getInt(WORKTIME);
          if (workTime != null) {
            workTime += value;
          }
          // workTime은 1~180분 범위에서 설정가능하도록
          if (workTime != null && workTime >= 1 && workTime <= 180) {
            prefs.setInt(WORKTIME, workTime);
            setState(() {
              txtWork.text = workTime.toString();
            });
          }
        }
        break;
      case SHORTBREAK:
        {
          // null이면 5분으로 기본값 설정
          int? short =
              prefs.getInt(SHORTBREAK) == null ? 5 : prefs.getInt(SHORTBREAK);
          if (short != null) {
            short += value;
          }
          print(short);
          // 숏브는 1~120분 범위에서 설정 가능하도록
          if (short != null && short >= 1 && short <= 120) {
            prefs.setInt(SHORTBREAK, short);
            setState(() {
              txtShort.text = short.toString();
            });
          }
        }
        break;
      case LONGBREAK:
        {
          // 기본 20분 설정
          int? long =
              prefs.getInt(LONGBREAK) == null ? 20 : prefs.getInt(LONGBREAK);
          if (long != null) {
            long += value;
          }
          // 롱브는 1~180분
          if (long != null && long >= 1 && long <= 180) {
            prefs.setInt(LONGBREAK, long);
            setState(() {
              txtLong.text = long.toString();
            });
          }
        }
        break;
    }
  }
}
