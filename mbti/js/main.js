var chatAni = document.querySelector('.main-chat');
var restAni = document.querySelector(".main-resttime");
var creditAni = document.querySelector(".main-credits");
var noticeAni = document.querySelector(".main-noticeBoard");
console.log(restAni.style.opacity);

restAni.addEventListener("animationstart", function(e) {
    restAni.style.opacity = "1";
}, false);

creditAni.addEventListener("animationstart", function(e) {
    creditAni.style.opacity = "1";
}, false);

noticeAni.addEventListener("animationstart", function(e) {
    noticeAni.style.opacity = "1";
}, false);

console.log(chatAni.style);
console.log(chatAni.style.animationDuration);

chatAni.addEventListener("click", function(){
    chatAni.style.removeProperty('animation', 'move1')
    chatAni.style.animationName = "reverseMove1";
    chatAni.style.animationDuration = "1.5s";
    chatAni.style.opacity = "0";
    setTimeout(function(){
        window.location.href = "./chatting.html";
    }, 1800);
})