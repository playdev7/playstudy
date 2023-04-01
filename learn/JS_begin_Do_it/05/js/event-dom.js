var coverImage = document.querySelector("#cover");

// 마우스 클릭 시
coverImage.onclick = function() {
    alert('눌렀습니다');
};

// 마우스오버 시
coverImage.onmouseover = function() {
    coverImage.style.border = "5px black solid";
};

// 마우스아웃 시
coverImage.onmouseout = function() {
    coverImage.style.border = "";
};