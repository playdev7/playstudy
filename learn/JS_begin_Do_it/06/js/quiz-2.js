// quiz-2.js

var r = prompt("원의 반지름은? (cm)");
var calc = new Circle(r); // clac 인스턴스 생성 및 인수 r 전달.
document.write("<p>반지름이 " + calc.radius + " 일 때 <br> 원의 둘레: " + calc.circumference() + " <br> 원의 너비: " + calc.circleArea() + "</p>");

function Circle(radius) {  // Circle 생성자 함수 선언 및 radius 파라미터 정의.
    this.radius = radius,
    this.circumference = function() {	// 원주(둘레) 계산해주는 circumference 함수 선언
        // 원주 공식 = 지름 * PI
        return radius*2*Math.PI; // Math 객체에 PI 속성 내장 됨.
    }
    this.circleArea = function() {		// 원의 너비 계산해주는 circleArea 함수 선언
        // 너비 공식 = 반지름 * 반지름 * PI
        return radius*radius*Math.PI; // Math 객체에 PI 속성 내장 됨.
    }
};