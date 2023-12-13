var itemList = [];

var addBtn = document.querySelector("#add"); // add인 요소를 가져와서 addBtn 변수로 저장.
addBtn.addEventListener("click", addList); // addBtn을 클릭하면 addList 함수 실행하도록 설정.

function addList() {
    var item = document.querySelector("#item").value; // item인 텍스트필드의 값을 item 변수에 추가.

    if(item != null) {  // item에 값이 있을때만 조건문 수행.
        itemList.push(item); // push() 함수로 itemList 배열에 요소로서 item 변숫값 추가.
       document.querySelector("#item").value = ""; // 텍스트 필드 값 비우도록 재정의.
       document.querySelector("#item").focus(); // 텍스트필드에 focus() 함수 적용.
    }
    showList(); // showList 함수 실행.
}

// 리스트를 보여줄 showList() 함수 선언.
// 다음 코드 반복문으로 최적화 - document.write("<ul><li>itemList[0]</li><li>itemList[1]</li><li>itemList[2]</li></ul>");
function showList() {
    var list = "<ul>"; // 목록을 시작하는 <ul> 태그를 list 변수에 저장.
    for (var i=0; i<itemList.length; i++) {
        list += "<li>" + itemList[i] + "<span class='close' id='" + i + "'>X</span></li>"; // list 변수에 <li> 태그 및 itemList[인덱스] 반복하여 저장.
                                            // 연결 연산자를 통해 <span> 요소의 id 값을 카운터변수 i로 지정.
    }
    list += "</ul>" // 마지막으로, </ul> 종료태그 저장.

    document.querySelector("#itemList").innerHTML = list; // itemList인 div HTML요소 내에 list 변숫값 표시.

    var remove = document.querySelectorAll(".close"); // 삭제 버튼을 remove 변수에 저장. 배열 형태로 저장됨.

    for (var i=0; i<remove.length; i++) {  // remove 배열의 길이만큼 반복하는 반복문.
        remove[i].addEventListener("click", removeList); // X 를 클릭하면 removeList() 함수 실행.
    }
}

function removeList() {
    var id = this.getAttribute("id"); // this(누른 삭제 버튼)의 id 값을 id변수에 저장.
    // console.log(this); // this 값을 콘솔에 표시.
    itemList.splice(id, 1); // splice() 함수를 통해 id 인덱스인 요소를 1개 삭제.
    showList(); // showList() 함수 재실행.
}