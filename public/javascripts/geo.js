var findLocation = function(){
	if (navigator.geolocation) {
		  navigator.geolocation.getCurrentPosition(success, error);
		} else {
		  error('not supported');
		}
}

var error = function(msg){
	document.write("msg:"+ msg);
}
var success = function(position){
	document.write("latitiute:"+position.coords.latitude+ "<br>" +"longitude="+ position.coords.longitude);
}

$(document).ready(function(){
	findLocation();
})