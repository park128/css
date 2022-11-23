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

$(".resttime").hide();
$(".resttime").delay(1500).fadeIn(1500);

