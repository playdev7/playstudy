var now = new Date();
// 오늘 날짜 정보에 대한 인스턴스를 now 인스턴스 객체로 생성.

var firstDay = new Date("2018-03-23");
// 처음 만난 날의 날짜 정보를 firstDay 인스턴스로 생성.
// 처음 만난 날을 18년 3월 23일로 설정.

// 연산을 위해 날짜를 밀리초 단위로 변환
var toNow = now.getTime(); // now 객체의 시간을 밀리초 단위로 toNow 변수에 저장.
var toFirst = firstDay.getTime(); // firstDay 객체의 시간을 밀리초단위로 toFirst 변수에 저장.
var passedTime = toNow - toFirst; // 오늘 날짜 - 처음 만난 날짜. (밀리초 값)
 
// 밀리초 값을 일로 나눔 -> 밀리초 값을 1일 만큼의 밀리초 값으로 나눔.
// 1000 * 60 * 60 * 24 = 1일 만큼의 밀리초 값.
// 값이 실수일 수도 있으므로 Math.round() 통한 반올림.
var passedDay = Math.round(passedTime / (1000 * 60 * 60 * 24));

// innerHTML 은 HTML 요소 태그 사용 가능
// innerText 는 텍스트만 삽입.
document.querySelector("#accent").innerText = passedDay + "일";

function calcDate(days) {
    var future = toFirst + days * (1000 * 60 * 60 * 24);
    var someday = new Date(future);
    var year = someday.getFullYear();
    var month = someday.getMonth() + 1;  //getMonth는 0부터 11까지.
    var date = someday.getDate();

    document.querySelector("#date" + days).innerHTML = year + " 년 " + month + " 월 " + date + "일";
}

calcDate(100);  // 인수 100 전달하여 clacDate 호출.
calcDate(200);  // 인수 200 전달하여 clacDate 호출.
calcDate(365);  // 인수 365 전달하여 clacDate 호출
calcDate(500);  // 인수 500 전달하여 clacDate 호출