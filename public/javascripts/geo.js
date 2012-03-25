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
	jQuery('<input/>', {
	    name: 'latitude',
	    type: 'hidden',
	    value: position.coords.latitude
	}).appendTo('#userForm');
	jQuery('<input/>', {
	    name: 'longitude',
	    type: 'hidden',
	    value: position.coords.longitude
	}).appendTo('#userForm');
}

$(document).ready(function(){
	findLocation();
})