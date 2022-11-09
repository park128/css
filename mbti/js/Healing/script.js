$(document).ready(function () {
  var stars = 800;
  var $stars = $(".stars");
  var r = 800;
  for (var i = 0; i < stars; i++) {
    var $star = $("<div/>").addClass("star");
    $stars.append($star);
  }
  $(".star").each(function () {
    var cur = $(this);
    var s = 0.2 + (Math.random() * 1);
    var curR = r + (Math.random() * 300);
    cur.css({
      transformOrigin: "0 0 " + curR + "px",
      transform: " translate3d(0,0,-" + curR + "px) rotateY(" + (Math.random() * 360) + "deg) rotateX(" + (Math.random() * -50) + "deg) scale(" + s + "," + s + ")"

    })
  })
})

let card = document.querySelector('.card1');
card.addEventListener('click', click);

let back1 = document.querySelector(".back1");

function click(event) {
  let elem = event.currentTarget;
  if (elem.style.transform == "rotateY(180deg)") {
    elem.style.transform = "rotateY(0deg)";
  } else {
    elem.style.transform = "rotateY(180deg)";
  }

  console.log(back1.style);
  if (back1.style.animationName == "") {
    back1.style.animationName = "flip1";
  }
  else {
    back1.style.animationName = "";
  }
}