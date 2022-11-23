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

function Clock (){
    var today = new Date();

    var year = today.getFullYear();
    var month = ('0' + (today.getMonth() + 1)).slice(-2);
    var day = ('0' + today.getDate()).slice(-2);
    var hours = ('0' + today.getHours()).slice(-2); 
    var minutes = ('0' + today.getMinutes()).slice(-2);
    var seconds = ('0' + today.getSeconds()).slice(-2); 

    var dateString = year + '-' + month  + '-' + day;
    var timeString = hours + ':' + minutes  + ':' + seconds;
    document.getElementById("header-time").innerHTML = dateString + " | " + timeString;
}
Clock();
setInterval(Clock, 1000);

let card = document.querySelectorAll('.card');
let toBack = document.querySelector('#toBack');
let front = document.querySelectorAll('.front');
let back = document.querySelectorAll('.back');
let resttime = document.querySelector(".resttime");
card.forEach(element => {
  element.addEventListener('click', click);
});

// var arrayRemove = (arr, value) => {
//   return arr.filter((ele) => {
//       console.log('ele',ele);
//       return ele != value;
//   });
// };


function delay(){
  back1.style.animationName = 'test1';
}

function click(event) {
  console.log(event);
  console.log('event.currentTarget',event.currentTarget);
  console.log('card',card);
  front.forEach(element => {
    element.style.transform = "rotateY(180deg)";
  });
  let elem = event.currentTarget.lastElementChild;
  console.log(elem);

  // 카드가 앞면일때 뒤집기
  if (elem.style.transform == "rotateY(360deg)") {
    elem.style.transform = "rotateY(180deg)";
  } else {
    elem.style.transform = "rotateY(360deg)";
  }
    
  console.log('resttime',resttime);
  let restLeft =  $(resttime).width()/2  - $(card).width()/2;
  let restleft = restLeft - $(elem).offset().left;

    setTimeout(function() { 
      // $(elem).offset({}, 800);
      if (event.currentTarget == card[0]){
        $(elem).animate({
          top: "-6vh",
          left:restLeft,
          width: '60vw', 
          height: '60vh'
        },1200)
      }else{
        $(elem).animate({
          top: "-6vh",
          left:restleft,
          width: '60vw', 
          height: '60vh'
        },1200)
      }
    },800)
    
    setTimeout(function(){
      resttime.style.zIndex = '1';
      $(resttime).animate({
        opacity: 1
      },500)
    },2300)
    
}
// 주어.행동()
// 행동(목적어)
// 행동(); 
// 안에서 누구에게 행동할건지를 정의해줘야하니까 하드코딩이 되는거고

// 부모 객체의 자식들 배열 가져옴
// 클릭한 요소는 위에서 가져옴
// 배열에서 클릭한 요소 빼고, 배열의 요소들을 dom에서 제거

// 1. 클릭했을때 클릭한 객체 가져오는 함수 연동
// 1. 클릭한 객체 가져오는 함수 구현