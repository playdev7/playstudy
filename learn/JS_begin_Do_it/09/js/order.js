var check = document.querySelector("#shippingInfo"); // #shippingInfo 인  checkbox 요소를 check 변수로 저장.

check.addEventListener("click", function(){   //  check에 대한 addEventListener() 사용 및 정의
    // addEventListener() 함수를 통해 특정 이벤트 발생 시 처리할 내용을 정의하게 됨.

    // 체크박스를 클릭 했을 때, 체크 여부에 따라 다르게 작동하도록 구현.
    if(check.checked == true) {        // check의 checked 상태가 참 일때
        document.querySelector("#shippingName").value      // #shippingName 의 값을 #billingName으로.
        = document.querySelector("#billingName").value;

        document.querySelector("#shippingTel").value   // #shippingTel 의 값을 #billingTel 으로.
        = document.querySelector("#billingTel").value;

        document.querySelector("#shippingAddr").value   // #shippingAddr 의 값을 #billingAddr 으로.
        = document.querySelector("#billingAddr").value;
    }

    else{      // check를 클릭해서 체크가 해제되었을때.
        document.querySelector("#shippingName").value = "";        // #shippingName 의 값을 null로 초기화.
        
        document.querySelector("#shippingTel").value = "";     // #shippingTel 의 값을 null로 초기화.
        
        document.querySelector("#shippingAddr").value = "";     // #shippingAddr 의 값을 null로 초기화.
        
        // 개념복기 - undefined 와 null의 차이점.
        // undefined 는 아직 값과 자료형이 정의되지 않은 상태의 변수.
        // null은 한 번 값이 정의되었다가, 없는 값으로 재정의 된 상태의 변수.
        // typeof 변수명 구문을 통해 자료형을 확인할 수 있다.
        // 핵심: JS는 undefined와 null을 구분한다.
    }
});