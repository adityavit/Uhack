var userFetchApi = "/userStatus/";

var userStatusUpdater = function(){
	timeOutFunction = setTimeout("fetchUserData()",2000);
}
var fetchUserData = function(){
	$.ajax({
		  url: userFetchApi+userName,
		  context: document,
		  dataType: 'json'
		}).done(function(data) { 
			updateCheckedInUsers(data["checkinUsers"]);
		});
	setTimeout("fetchUserData()",2000);
}

var updateCheckedInUsers = function(checkInUsers){
	$("#usersInLocation")[0].innerHTML = "";
	for(var user in checkInUsers){
		$("#usersInLocation").append(createCheckedInUsers(checkInUsers[user]));
	}
}
var createCheckedInUsers = function(user){
	var userDiv = document.createElement("div");
	userDiv.className = "clan"+user.clan;
	userDiv.id = user.id;
	var userName = document.createElement("div");
	userName.className = "attackUserName";
	userName.innerHTML = user.userName;
	var power = document.createElement("div");
	power.className = "attackPower";
	power.innerHTML = user.power;
	var health = document.createElement("div");
	health.className = "attackHealth";
	health.innerHTML = user.health;
	var attachBtn = document.createElement("button");
	attachBtn.innerHTML = "Attack";
	attachBtn.className = "attack";
	$(attachBtn).click(function(){
		attack(user.id);
	});
	
	userDiv.appendChild(userName);
	userDiv.appendChild(power);
	userDiv.appendChild(health);
	userDiv.appendChild(attachBtn);
	return userDiv;
}

var attack = function(victimId){
	
}

$(document).ready(function(){
	//userStatusUpdater();
});