var chkBttns = document.querySelectorAll(".check");
// 체크 버튼에 대한 노드 리스트 가져와서 chkBttns에 저장.

// 각 버튼에 대해 적용되도록 for문 활용.
for(var i = 0; i<chkBttns.length; i++) {
    chkBttns[i].addEventListener("click", function() {
        // 1번째 버튼 클릭 시 이벤트 처리 부여
        if(this.parentNode) {       // 클릭한 버튼의 부모 노드가 있을 경우
            this.parentNode.style.color = "#ccc";
        // 부모노드가 p 요소이므로 부모 노드에 스타일 부여.
     }
    })
}