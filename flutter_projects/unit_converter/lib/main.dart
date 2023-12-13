import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  MyAppState createState() => MyAppState();
}

class MyAppState extends State<MyApp> {
  @override
  // 상태 초기자 - 상태 객체가 빌드되면서 호출됨
  void initState() {
    _numberFrom = 0;
    // 끝단에 반드시 조상의 상태초기자 실행 필요
    super.initState();
  }

  // 멤버 추가
  // Null Safety로 인해 초기화 필수
  double _numberFrom = 0.0;

  // 시작할 측정단위 변수 선언 => Null Safety로 인해 초기값 meters 초기화
  String _startMeasure = "meters";
  // 변환할 측정단위 변수 선언
  String _convertedMeasure = "meters";

  // final 상수로서 측정값 문자열 리스트 멤버 생성
  final List<String> _measures = [
    "meters",
    "kilometers",
    "grams",
    "kilograms",
    "feet",
    "miles",
    "pounds (lbs)",
    "ounces",
  ];

  // 측정 단위를 변환하기 위한 Matrix 구조 구현
  // Dart에도 Python dict 같은 Map 자료형 객체가 있어 이를 활용
  // 측정법 문자열을 숫자로 임베딩
  final Map<String, int> _measuresMap = {
    // Key, value 각각 제네릭 부여 가능
    "meters": 0,
    "kilometers": 1,
    "grams": 2,
    "kilograms": 3,
    "feet": 4,
    "miles": 5,
    "pounds (lbs)": 6,
    "ounces": 7,
  };
  // 임베딩에 해당하는 측정값 변환 공식 자료 구현
  final dynamic _formulas = {
    '0': [1, 0.001, 0, 0, 3.28084, 0.000621371, 0, 0],
    '1': [1000, 1, 0, 0, 3280.84, 0.621371, 0, 0],
    '2': [0, 0, 1, 0.0001, 0, 0, 0.00220462, 0.035274],
    '3': [0, 0, 1000, 1, 0, 0, 2.20462, 35.274],
    '4': [0.3048, 0.0003048, 0, 0, 1, 0.000189394, 0, 0],
    '5': [1609.34, 1.60934, 0, 0, 5280, 1, 0, 0],
    '6': [0, 0, 453.592, 0.453592, 0, 0, 1, 16],
    '7': [0, 0, 28.3495, 0.0283495, 3.28084, 0, 0.0625, 1],
  };

  Widget build(BuildContext context) {
    // 공통 디자인 사전 정의
    // 사용자 입력 위젯(텍스트필드, 드롭다운메뉴)에 정의될 스타일 - TextStyle 자료형 사용
    final TextStyle inputStyle = TextStyle(
      fontSize: 20,
      color: Colors.blue[900],
    );
    // 출력할 텍스트들에 대한 스타일
    final TextStyle labelStyle = TextStyle(
      fontSize: 24,
      // gray 없어서 투명도 있는 black 사용
      color: Colors.black45,
    );

    return MaterialApp(
      title: "Measures Converter",
      home: Scaffold(
        appBar: AppBar(
          title: Text("Measures Converter"),
        ),
        // Container 위젯으로 감싸서 디바이스 끝단으로부터 패딩 부여
        // 예시 - 텍스트 필드가 디바이스 전체를 덮는 것에 대한 패딩 부여
        body: Container(
          // 수평 패딩만 부여
          padding: EdgeInsets.symmetric(horizontal: 30),
          // 키보드 토스팅에 대응하여 ScrollView 위젯으로 감쌈
          child: SingleChildScrollView(
            // 감싸기 위해 최소 박스 범위 지정 - BoxConstraints in ConstrainedBox
            child: ConstrainedBox(
              constraints: BoxConstraints(minHeight: 700),
              child: IntrinsicHeight(
                child: Column(children: [
                  // Spacer 객체를 생성하여 열 마진을 줄 수 있음 => flex 프로퍼티를 통해 마진 수준 지정.
                  Spacer(),
                  Text(
                    "Value",
                    style: labelStyle, // 사전 정의한 labelStyle 적용.
                  ),
                  Spacer(),

                  // TextFiled 위젯 -> 텍스트를 입력할 수 있는 공간
                  // onChanged 프로퍼티를 통해 상태 변화를 감지하고 setState method를 통해 멤버 변수 업데이트
                  // 상태 클래스의 멤버변수 업데이트 => 상태 업데이트
                  TextField(
                      style: inputStyle,
                      // InputDecoration 객체를 통해 텍스트필드를 장식할 수 있음
                      decoration: InputDecoration(
                        hintText: "Please insert the measure to be converted",
                      ),
                      onChanged: (text) {
                        // tryParse() 메소드를 통해 문자열을 double로 캐스팅
                        var rv = double.tryParse(text);
                        if (rv != null) {
                          setState(() {
                            _numberFrom = rv;
                          });
                        }
                      }),
                  Spacer(),

                  Text(
                    "From",
                    style: labelStyle, // 사전 정의한 labelStyle 적용.
                  ),
                  Spacer(),

                  // 입력되는 측정법을 선택하는 드롭다운 버튼 생성
                  DropdownButton(
                    style: inputStyle,
                    // map 메소드를 통해 iterable 한 객체의 각 원소를 순회하며 공통된 함수를 적용할 수 있음
                    items: _measures.map((String value) {
                      // 카운터변수 value로 리스트를 순회하며 아이템들을 모두 보여주도록 설계 - DropdownMenuItem Class
                      // Text 위젯으로 value 변수의 내용을 하나씩 그려줌
                      return DropdownMenuItem<String>(
                        // class<Type> 꼴로 제네릭 선언 -> 안에 들어올 수 있는 자료형을 사전 정의하여 고정
                        value: value,
                        child: Text(
                          value,
                          style: inputStyle,
                        ),
                      );
                    }).toList(),
                    // 특정 값을 선택하는 이벤트 발생 시 setState() 메소드 통한 상태 업데이트
                    onChanged: (value) {
                      // Null Safety => null이 아닐때만 상태를 업데이트하도록 구문 추가
                      if (value != null) {
                        setState(() {
                          _startMeasure = value;
                        });
                      }
                    },
                    // 상태가 업데이트 될 때 마다 버튼 자체가 값을 보유하고 있도록 설계
                    // Null Safety => _startMeasure 초기값 갖도록.
                    value: _startMeasure,
                  ),
                  Spacer(),

                  Text("To", style: labelStyle),
                  Spacer(),

                  // 변환할 측정법을 선택하는 드롭다운 버튼 생성
                  DropdownButton(
                    isExpanded: true,
                    style: inputStyle,
                    items: _measures.map((String value) {
                      return DropdownMenuItem<String>(
                          value: value,
                          child: Text(
                            value,
                            style: inputStyle,
                          ));
                    }).toList(),
                    onChanged: (value) {
                      setState(() {
                        // null safety
                        if (value != null) {
                          _convertedMeasure = value;
                        }
                      });
                    },
                    // 현재 선택된 측정법을 기억하도록.
                    value: _convertedMeasure,
                  ),

                  // 변환 버튼 생성
                  // 열 공백을 크게
                  Spacer(flex: 2),
                  ElevatedButton(
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.lightBlueAccent),
                    child: Text("Convert!", style: inputStyle),
                    onPressed: () {
                      // 제대로 체크되지 않았다면 convert() 실행하지 않고 반환
                      if (_startMeasure.isEmpty ||
                          _convertedMeasure.isEmpty ||
                          _numberFrom == 0) {
                        return;
                      } else {
                        convert(_numberFrom, _startMeasure, _convertedMeasure);
                      }
                    },
                  ),
                  Spacer(flex: 2),

                  // 변환 결과에 대한 텍스트 위젯
                  Text((_resultMessage == "") ? "" : _resultMessage,
                      style: labelStyle),
                  // 최하단 아이템이므로 열 공백을 크게
                  Spacer(flex: 8),
                ]),
              ),
            ),
          ),
        ),
      ),
    );
  }

  // 측정법을 변환하는 메소드 선언
  void convert(double value, String from, String to) {
    var nFrom = _measuresMap[from]; // int
    var nTo = _measuresMap[to]; // int
    var multiplier = _formulas[nFrom.toString()][nTo];
    var result = value * multiplier;

    // 결과값에 따라 결과 문자열 및 상태 업데이트
    if (result == 0) {
      _resultMessage = "This conversion cannot be performed";
    } else {
      _resultMessage =
          "${_numberFrom.toString()} $_startMeasure are ${result.toString()} $_convertedMeasure";
    }
    setState(() {
      _resultMessage = _resultMessage;
    });
  }

  // 결과 메세지
  String _resultMessage = "";
}
