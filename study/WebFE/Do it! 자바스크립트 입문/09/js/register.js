// 목표 - Form Validation. 입력한 값이 요구 조건에 맞는지 검증하는 함수 구현.

// 변수 리터럴 표기 - 필요한 필드 객체들 가져와 변수에 저장.
var userId = document.querySelector("#user-id");
var pw1 = document.querySelector("#user-pw1");
var pw2 = document.querySelector("#user-pw2");

//userId.onChange = checkId;

// addEventListner() 통한 이벤트 처리 정의.
userId.addEventListener("change", checkId);     // userId 입력 길이 검증하는 checkId 함수 실행.
pw1.addEventListener("change", checkPw);    // pw1 입력 길이 검증하는 checkPw 함수 실행.
pw2.addEventListener("change", comparePw);  // pw 값들을 비교하는 comparePw 함수 실행.
// change (onChange) 이벤트는 "텍스트필드에 내용을 입력하고 빠져나온 순간" 이 정의된 이벤트.

// 개념정리 - select() 와 focus() 함수의 차이
    // select() - 필드 값을 초기화 하지 않고 다시 선택만 함.
    // focus() - null로 초기화 된 필드에 커서를 다시 조준함.


// 입력한 값에 대해 검증하는 함수 구현부 - Form Validation.

// userId 입력 길이 검증하는 checkId 함수.
function checkId() {
    if (userId.value.length < 4 || userId.value.length > 15) { // userID의 값의 길이가 4보다 작거나 (or) 15보다 클 때.
        alert("4~15자리의 영문과 숫자를 사용하세요.");  // 조건 맞추도록 알럿 팝업 출력.
        userId.select();    // 다시 입력할 수 있도록 userId 텍스트필드 재 선택. - select() 내장 함수
    }
}

// pw1 길이 검증하는 checkPw 함수.
function checkPw() {
    if (pw1.value.length < 8) {
        // 입력한 비밀번호 값의 길이가 8자리 미만일때.
        alert("8자리 이상의 비밀번호를 사용하세요."); // 조건 맞추도록 alert 팝업 출력.
        pw1.value = ""; // pw1 필드 값 null 로 초기화.
        pw1.focus();    // 다시 입력하도록 텍스트 필드에 커서 고정 - focus() 함수.
            // focus() 함수는 요소에 포커스를 맞추는 내장 함수.
    }
}

// pw1 과 pw2 값을 비교하는 comparePw 함수.
function comparePw() {
    if(pw1.value != pw2.value) {
       // pw1 과 pw2 의 값이 서로 다를때.
       alert("비밀번호가 이전과 다릅니다. 다시 입력하세요.");
       pw2.value = "";  // pw2 필드 값 null로 초기화.
       pw2.focus();     // focus() 함수 사용. 
    }
}