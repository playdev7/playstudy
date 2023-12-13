import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: "Hello World Travel Title",
        home: Scaffold(
            appBar: AppBar(
              title: Text("Hello World Travel App"),
              backgroundColor: Colors.deepPurple,
            ),
            // Builder 객체를 통해 컨텍스트 기반의 흐름제어 및 전달 가능
            body: Builder(
                // ScrollView 객체를 통해 스크롤되는 위젯 생성 가능
                builder: (context) => SingleChildScrollView(
                    child:
                        // Padding 위젯을 통해 Center Widget이 20 논리픽셀만큼 offset 부여
                        Padding(
                            padding: EdgeInsets.all(20),
                            child: Center(
                                // Center의 자식 위젯으로 Container인 Columns를 주면 여러 위젯 플로팅 가능
                                child: Column(children: [
                              // 텍스트 위젯과 이미지에 각각의 10, 5, 15 패딩 부여
                              Padding(
                                padding: EdgeInsets.all(10),
                                child: Text("Hello World Travel",
                                    style: TextStyle(
                                        fontSize: 26,
                                        fontWeight: FontWeight.bold,
                                        color: Colors.blue[800])),
                              ),
                              Padding(
                                  padding: EdgeInsets.all(5),
                                  child: Text("Discover the World",
                                      style: TextStyle(
                                          fontSize: 20,
                                          color: Colors.deepPurpleAccent))),
                              Padding(
                                padding: EdgeInsets.all(15),
                                child: Image.network(
                                    "https://media.istockphoto.com/id/658290604/vector/realistic-vector-baseball-isolated-design-template-in-eps10.webp?b=1&s=612x612&w=0&k=20&c=Az1pFuUhfoLU3QyAE6wgZt9y9F4uoET7FUUXy-rjksQ=",
                                    height: 350),
                              ),
                              // RaisedButton -> ElevatedButton 으로 Notation 변경
                              Padding(
                                  padding: EdgeInsets.all(15),
                                  child: ElevatedButton(
                                    style: ElevatedButton.styleFrom(
                                      primary: Colors.deepPurple,
                                    ),
                                    child: Text("Contact US"),
                                    onPressed: () => contactUs(context),
                                  ))
                            ])))))));
  }

  // contactUs Function Define.
  void contactUs(BuildContext context) {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
              title: Text("Contact Us"),
              content: Text("Mail us at playdev7@gmail.com"),
              // 사용자 액션 정의
              actions: <Widget>[
                TextButton(
                  // 현재 네비게이터의 끝단 위젯 제거
                  onPressed: () => Navigator.of(context).pop(),
                  child: Text("Close"),
                )
              ]);
        });
  }
}
