var isOpen = false;	// #detail 의 표시 여부를 저장하는 isOpen 변수 선언 및 기본값 false로.
var bigPic = document.querySelector("#cup");  
		var smallPics = document.querySelectorAll(".small");  

		for(i=0; i<smallPics.length; i++) {
			smallPics[i].addEventListener("click", function() {
				newPic = this.src;
				bigPic.setAttribute("src", newPic);
			});
		}

var view = document.querySelector("#view"); // #view 요소를 view 변수로.
view.addEventListener("click", viewDetail); // view 클릭 시 viewDetail 함수 실행.

// isOpen 변수 값에 따라 조건문 활용한 함수.
function viewDetail() {
	if (isOpen == false) {  // 기본 값 - 상세 설명이 안보일 때 클릭 시.
		document.querySelector("#detail").style.display = "block"; // #detail 내용 표시.
		view.innerHTML = "상세 설명 닫기";	// #view 의 텍스트 노드를 "상세 설명 닫기" 로 변경.
		isOpen = true; // isOpen을 true로.
		
	}

	else {	// 상세설명이 보일 때 - isOpen이 false 일 때 클릭 시
		document.querySelector("#detail").style.display = "none";	// #detail 내용 표시 안함.
		view.innerHTML = "상세 설명 보기"; // #view의 텍스트 노드를 "상세 설명 보기" 로 변경.
		isOpen = false;  // isOpen을 false로.
	}
}

// visibility:hidden 은 컨텐츠만 가려줄 뿐, 할당된 공간은 여백으로 유지 됨.
// display:none 은 컨텐츠와 할당된 공간 까지 모두 사라짐.