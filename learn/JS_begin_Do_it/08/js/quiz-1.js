var myText = document.querySelector("#myText");
// #myText 요소를 가져와 myText 변수에 저장.

myText.addEventListener("click", editText);
    // addEventListner 함수 활용 - 클릭 시 editText() 함수 실행.

// 문제의 내용처럼 텍스트 스타일 변경해주는 함수 선언 및 정의.
function editText() {
    myText.style.fontSize = "20px";
    myText.style.color = "blue";
    myText.style.backgroundColor = "#ccc";
}