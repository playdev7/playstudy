var bigPic = document.querySelector("#cup");    // 큰 이미지를 가져와 bigPic 변수에 저장.  
var smallPics = document.querySelectorAll(".small");     // 작은 이미지들을 가져와 노드리스트로 smallPics  에 저장.

for(var i=0; i<smallPics.length; i++) {     // 노드 리스트의 각 요소에 접근하도록 for문 수행.
    smallPics[i].onclick = showBig;   // 각 요소를 클릭 시 showBig() 함수 실행하도록.
}

function showBig() {    // showBig() 함수 선언
    var newPic = this.src;      // click 이벤트가 발생한 대상의 src를 가져와 newPic에 저장.
    bigPic.setAttribute("src", newPic); // bigPic의 src 속성을 상기 newPic 값으로 할당.
}