var check = document.querySelector("#shippingInfo"); // 체크 상자 요소를 가져와 check 변수에 저장.

check.addEventListener("click", function() {    // 체크 상자 클릭 이벤트 팔생 시 함수 실행.
    if(check.checked == true) { // 체크상자가 체크되어 있다면
        document.querySelector("#shippingName").value = document.querySelector("#billingName").value;
        //  배송정보 이름의 값을 주문정보 이름의 값으로
        document.querySelector("#shippingTel").value = document.querySelector("#billingTel").value;
        //  배송정보 연락처의 값을 주문정보 연락처 값으로.
        document.querySelector("#shippingAddr").value = document.querySelector("#billingAddr").value;
        //  배송정보 주소의 값을 주문정보 주소의 값으로.
    }
    else{   // 체크 상자의 체크가 해제된다면.
        // shipping 배송 정보 관련 텍스트 필드를 빈 값으로 설정.
        document.querySelector("#shippingName").value = "";
        document.querySelector("#shippingTel").value = "";
        document.querySelector("#shippingAddr").value = "";
    }
});