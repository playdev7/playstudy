// 필요한 객체 querySelector로 가져와서 변수에 저장.
var radius = document.querySelector("#radius");
var startBttn = document.querySelector("#start");

// startBttn 클릭 이벤트 발생 시 calcCircle() 함수 실행.
startBttn.addEventListener("click", calcCircle);


function calcCircle() {
    // Number() 함수 통해 숫자로 변환 and Math.PI 객체 활용하여 PI 값 가져옴.
    var round = Number(radius.value)*2*Math.PI;
    var area = Number(radius.value)*Number(radius.value)*Math.PI

    // 연산 완료된 값을 각 객체의 value로 정의.
    document.querySelector("#round").value = round;
    document.querySelector("#area").value = area;
}