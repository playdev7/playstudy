function newRegister() {
    var newP = document.createElement("p"); // 새 p 요소 생성.
    var userName = document.querySelector("#userName"); // userName 텍스트 필드의 내용을 가져옴.
    var newText = document.createTextNode(userName.value); // 새로운 텍스트 노드 생성 - userName의 값을 사용.
    var nameList = document.querySelector("#nameList"); // #nameList 인 div 요소를 가져옴.
    
    newP.appendChild(newText); // newP의 자식 노드로 newText 텍스트노드 연결.

   // 이름 삭제 버튼 관련 노드 추가.
    var delBttn = document.createElement("span"); // span 요소 노드 추가
    var delText = document.createTextNode("X"); // X 가 담긴 텍스트 노드 추가   
    delBttn.setAttribute("class", "del");   // delBttn에 class="del" 속성 부여.
    delBttn.appendChild(delText);     // delText 요소를 delBttn의 자식 노드로 연결.
    newP.appendChild(delBttn);    // delBttn 요소를 newP의 자식 노드로 연결.           

    // newP 를 LIFO 처럼 출력되도록.
    nameList.insertBefore(newP, nameList.childNodes[0]); 
    // newP 가 nameList의 첫 번째 자식노드로 추가되도록.
                    //  nameList.appendChild(newP); // nameList div의 자식 노드로 newP 요소 노드 연결.

    userName.value = "";    // 새로운 입력 받도록 userName 값 NULL로 초기화.

    var removeBttns = document.querySelectorAll(".del"); // .del 속성 담긴 X 버튼 가져옴.


    // X 버튼을 누르면 해당 부모 p를 삭제하도록 for문
    for (var i=0; i<removeBttns.length; i++) {
        removeBttns[i].addEventListener("click", function() {
                    // i번째 버튼을 눌렀을 때 사용할 함수
            if (this.parentNode.parentNode)  {  // this (i번째 버튼)의 부모의 부모 노드가 있다 -> T일 경우.
                this.parentNode.parentNode.removeChild(this.parentNode);
                // this의 부모의부모 노드가 부모 노드를 삭제하도록.
            }   
        });
    }
}

