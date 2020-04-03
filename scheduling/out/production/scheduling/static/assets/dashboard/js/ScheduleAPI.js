fetch('http://localhost:8080/api/teacher/count').then(function(response) {
	return response.json();
}).then(function(obj) {
	document.getElementById("teacher_count").innerHTML = obj;
})


fetch('http://localhost:8080/api/section/count').then(function(response) {
	return response.json();
}).then(function(obj) {
	document.getElementById("section_count").innerHTML = obj;
});

fetch('http://localhost:8080/api/room/count').then(function(response) {
	return response.json();
}).then(function(obj) {
	document.getElementById("room_count").innerHTML = obj;
});

fetch('http://localhost:8080/api/subject/count').then(function(response) {
	return response.json();
}).then(function(obj) {
	document.getElementById("subject_count").innerHTML = obj;
});
