var userFetchApi = "/userStatus/";
var questiongFetchApi = "/questions/";

var answerUpdated = false;
var userStatusUpdater = function(){
	timeOutFunction = setTimeout("fetchUserData()",2000);
}
var fetchUserData = function(){
	$.ajax({
		  url: userFetchApi+userName,
		  context: document,
		  dataType: 'json'
		}).done(function(data) { 
			updateQuestion(data);
			updateCheckedInUsers(data["checkinUsers"]);
			updateAttackedScene(data);
		});
	setTimeout("fetchUserData()",10000);
}
var updateQuestion = function(data){
	if(data["user"]["engaged"] == true && answerUpdated == false){
		var question;
		if(data["user"]["question"]){
			question = data["user"]["question"].split("|");
			$("#QuestionAttacked")[0].innerHTML= question[0];
		for(var i=1;i<question.length;i++){
			jQuery('<input/>', {
			    name: 'answer'+i,
			    type: 'radio',
			    text: question[i]
			}).appendTo('#answerAttacked');
			jQuery('<br/>').appendTo('#answerAttacked');
		}
		}
		answerUpdated =true;
		$("#questionaireAnswer").show();
	}
}

var updateAttackedScene = function(data){
	if(data["user"]["engaged"] == "true"){
		$("#usersInLocation").hide();
		$("attackedBy").append(createCheckedInUsers(data["enemy"]));
		$("attackedBy").show();
	}
}
var updateCheckedInUsers = function(checkInUsers){
	$("#usersInLocation")[0].innerHTML = "";
	for(var user in checkInUsers){
		$("#usersInLocation").append(createCheckedInUsers(checkInUsers[user]));
	}
}
var createCheckedInUsers = function(user){
	var userDiv = document.createElement("div");
	userDiv.className = "clan"+user.clan+" "+"toAttack";
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
	$.ajax({
		  url: questiongFetchApi+userId+"/"+victimId,
		  context: document,
		  dataType: 'json'
		}).done(function(data) { 
			updateOnChallenge(data);
		});
}
var updateOnChallenge = function(data){
	answerUpdated = true;
	$("#usersInLocation").hide();
	$("#questionaire").show();
	//console.log(data);
	if(data["question"]){
		var question = data["question"].split("|")[0];
		$("#Question")[0].innerHTML= question;
	}
}
$(document).ready(function(){
	$("#questionaire").hide();
	$("attackedBy").hide();
	$("#questionaireAnswer").hide();
	userStatusUpdater();
});