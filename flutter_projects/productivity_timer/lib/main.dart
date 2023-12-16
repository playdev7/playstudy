import 'package:flutter/material.dart';
import "widgets.dart";
// 인디케이터를 표시해주는 percent_indicator 패키지 import
import "package:percent_indicator/percent_indicator.dart";
import "./timer.dart";
import "./timermodel.dart";
import "./settings.dart";

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "My Work Timer",
      theme: ThemeData(
        primarySwatch: Colors.blueGrey,
      ),
      // 위젯 클래스를 설계한 다음 해당 객체를 home 으로 지정
      home: TimerHomePage(),
    );
  }
}

class TimerHomePage extends StatelessWidget {
  // 기본 패딩 선언
  final double defaultPadding = 5.0;
  final CountDownTimer timer = CountDownTimer();

  @override
  Widget build(BuildContext context) {
    // 라우터 전환을 위한 팝업 메뉴 리스트 추가
    final List<PopupMenuItem<String>> menuItems = [];
    menuItems.add(PopupMenuItem(
      value: "Settings",
      child: Text("Settings"),
    ));

    return Scaffold(
        appBar: AppBar(
          title: Text("My Work Timer"),
          // 사용자 액션으로 팝업메뉴 버튼 추가
          actions: [
            PopupMenuButton(
              itemBuilder: (BuildContext context) => menuItems.toList(),
              // Settings 선택 시 goToSettings 메소드를 통해 라우트 전환
              onSelected: (s) =>
                  (s == "Settings") ? goToSettings(context) : false,
            )
          ],
        ),
        // LayoutBuilder 를 통해 반응형 위젯 빌드
        body: LayoutBuilder(
            builder: (BuildContext context, BoxConstraints constraints) {
          // constraints 변수를 활용하여 하위 위젯의 크기도 반응형으로 계산할 수 있음
          // 최대 너비를 가용 너비로
          final double availableWidth = constraints.maxWidth;
          return Column(
            children: [
              // 상단 버튼 3개
              Padding(padding: EdgeInsets.all(defaultPadding)),
              Row(
                children: [
                  Padding(padding: EdgeInsets.all(defaultPadding)),
                  // 버튼이 균형을 지키며 최대한 차지할 수 있도록 Expanded 위젯 사용
                  Expanded(
                      child: ProductivityButton(
                    color: Color(0xff009688),
                    text: "Work",
                    onPressed: () => timer.startWork(),
                  )),
                  Padding(padding: EdgeInsets.all(defaultPadding)),

                  Padding(padding: EdgeInsets.all(defaultPadding)),
                  Expanded(
                      child: ProductivityButton(
                    color: Color(0xff607D8B),
                    text: "Short Break",
                    onPressed: () => timer.startBreak(true),
                  )),
                  Padding(padding: EdgeInsets.all(defaultPadding)),

                  Padding(padding: EdgeInsets.all(defaultPadding)),
                  Expanded(
                      child: ProductivityButton(
                    color: Color(0xff455A64),
                    text: "Long Break",
                    onPressed: () => timer.startBreak(false),
                  )),
                  Padding(padding: EdgeInsets.all(defaultPadding)),
                ],
              ),

              // 메인 시계
              Expanded(
                  // Stream 을 지원하는 StreamBuilder 위젯 생성
                  child: StreamBuilder(
                      // 비동기를 위한 초기 데이터 설정
                      initialData: "00:00",
                      // 스트림 메소드 지정
                      stream: timer.stream(),
                      // 빌더 지정 => 현재 빌드 문맥과 비동기 스냅샷까지 파라미터로 받음
                      builder: (BuildContext context, AsyncSnapshot snapshot) {
                        // 비동기 스냅샷에는 데이터 프로퍼티가 존재
                        TimerModel timer = (snapshot.data == "00:00")
                            ? TimerModel("00:00", 1)
                            : snapshot.data;
                        // 스트림이 yield* 로 반환하는 값들을 참조해서 Timer 객체 새로 빌드
                        return Container(
                          child: CircularPercentIndicator(
                            // 반지름은 가용 너비의 1/4
                            radius: availableWidth / 4,
                            lineWidth: 10.0,
                            percent: timer.percent,
                            center: Text(timer.time,
                                style: Theme.of(context).textTheme.headline4),
                            progressColor: Color(0xff009688),
                          ),
                        );
                      })),

              // 하단 버튼 2개
              Row(
                children: [
                  Padding(padding: EdgeInsets.all(defaultPadding)),
                  Expanded(
                      child: ProductivityButton(
                    color: Color(0xff212121),
                    text: "Stop",
                    onPressed: () => timer.stopTimer(),
                  )),
                  Padding(padding: EdgeInsets.all(defaultPadding)),
                  Expanded(
                      child: ProductivityButton(
                    color: Color(0xff009688),
                    text: "Restart",
                    onPressed: () => timer.startTimer(),
                  )),
                  Padding(padding: EdgeInsets.all(defaultPadding)),
                ],
              ),
              Padding(padding: EdgeInsets.all(defaultPadding)),
            ],
          );
        }));
  }

  // 셋팅 라우터로 라우팅하는 메소드
  // Flutter는 화면 위젯들을 쌓는 Stack 형태로 이루어져있음
  // 따라서 현재 Context를 기억하게 되고 그를 기준으로 Push/Pop 이 이루어짐.
  void goToSettings(BuildContext context) {
    // Navigator Stack안 에서 라우팅이 이루어짐
    Navigator.push(
        // MaterialPageRoute 클래스를 통해 현재 컨텍스트에서 푸쉬 할 라우트를 지정
        context,
        MaterialPageRoute(builder: (context) => SettingsScreen()));
  }
}
