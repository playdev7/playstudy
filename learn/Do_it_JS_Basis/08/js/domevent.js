    var pic = document.querySelector('#pic');
    pic.addEventListener("mouseover", changePic, false); 
    // addEventListner("이벤트명, 명령_또는_호출할_함수명, 캡처 여부)
    // 이벤트명은 on을 제외하고 소문자로.
    // 캡처여부는 false-버블링이 기본. true 시 캡처링 진행.
    pic.addEventListener("mouseout", originPic, false);

		function changePic() {			
			pic.src = "images/boy.png";
    }
    function originPic() {
      pic.src = "images/girl.png";
    }