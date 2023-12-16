import "package:flutter/material.dart";

// 콜백 함수 포인터 정의
typedef CallbackSetting = void Function(String, int);

class ProductivityButton extends StatelessWidget {
  // 멤버 선언
  final Color color;
  final String text;
  final double size;
  final VoidCallback onPressed;

  // 생성자 오버라이딩 -> 필수 파라미터 정의
  ProductivityButton(
      {required this.color,
      required this.text,
      required this.onPressed,
      this.size = 0});

  // build 메소드 오버라이딩 -> 생성자의 파라미터에 대응하는 버튼 생성
  @override
  Widget build(BuildContext context) {
    return MaterialButton(
        child: Text(
          this.text,
          style: TextStyle(color: Colors.white),
        ),
        onPressed: this.onPressed,
        color: this.color,
        minWidth: this.size);
  }
}

// 설정에서 사용할 메뉴버튼 클래스
class SettingButton extends StatelessWidget {
  // 멤버변수 공간
  late final Color color;
  late final String text;
  late final double size;
  late final int value;
  late final String setting;
  late final CallbackSetting callback;

  // 초기자 정의
  SettingButton(this.color, this.text, this.size, this.value, this.setting,
      this.callback);

  @override
  Widget build(BuildContext context) {
    return MaterialButton(
      child: Text(
        this.text,
        style: TextStyle(color: Colors.white),
      ),
      onPressed: () => this.callback(this.setting, this.value),
      color: this.color,
      minWidth: this.size,
    );
  }
}
