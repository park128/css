var fullImg = document.querySelector(".full-img");
var miniImg = document.querySelectorAll(".mini-img");

function changeImg(x) {

    var targetImg = miniImg[x - 1];
    var imgAttr = targetImg.getAttribute("src");

    fullImg.setAttribute("src", imgAttr);

}