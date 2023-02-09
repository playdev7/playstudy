var sideMenu = document.querySelectorAll(".checkbx");   // .checkbx 인 객체 집합으로 가져옴.
var price = 24000;  // 피자 최초 가격 설정.
var total = document.querySelector("#total");   // #total 필드 가져옴.

for(i=0; i<sideMenu.length; i++) {     // 모든 객체에 접근 - 카운터 변수로 sideMenu의 길이만큼 반복
    sideMenu[i].addEventListener("click", function() {  // i번째 체크박스 클릭 시
        // i번째 체크박스 클릭 시 클릭한 체크박스에 대한 연산 수행
        if(this.checked == true) {
            // 체크가 된다면 해당 값 만큼 증가.
            price += parseInt(this.value);  // value가 문자열이므로 parseInt() 사용
        }
        else {
            // 체크가 풀린다면 해당 값 만큼 감소.
            price -= parseInt(this.value);
        }
        total.value = price;    // total 필드의 값으로 price 변수 값 부여.
    });
}