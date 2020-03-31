function back(number) {
	alert(number)
	window.history.go(number)
}

if (performance.navigation.type == 1) {
	var frame = document.getElementById("iFrame");
}

// changing table room shift
function ChageTable_RoomShift(table_name) {
alert("Wew")
	var break_content = document.getElementById("break_content");
	var student_content = document.getElementById("student_content");
	var schedule_content = document.getElementById("schedule_content");
	var subject_content = document.getElementById("subject_content");
	

	// for breaktime form list
	var TeacherBreaktime_content = document
			.getElementById("TeacherBreaktime_content");
	var RoomShiftBreaktime_content = document
			.getElementById("RoomShiftBreaktime_content");

	if (table_name == "break_table") {
		break_content.style.display = 'block';
		student_content.style.display = 'none';
		schedule_content.style.display = 'none';
		lecture_content.style.display = 'none';
	
	} else if (table_name == "student_table") {
		break_content.style.display = 'none';
		student_content.style.display = 'block';
		schedule_content.style.display = 'none';
		lecture_content.style.display = 'none';
	} else if (table_name == "schedule_table") {
		break_content.style.display = 'none';
		student_content.style.display = 'none';
		schedule_content.style.display = 'block';
		lecture_content.style.display = 'none';

	} else if (table_name == "TeacherBreaktime_content") {
		display(TeacherBreaktime_content, RoomShiftBreaktime_content);
	} else if (table_name == "RoomShiftBreaktime_content") {
		display(RoomShiftBreaktime_content, TeacherBreaktime_content);
	}
}

function ChageTable_Teacher(table_name) {
	var lecture_content = document.getElementById("lecture_content");
	var break_content = document.getElementById("break_content");
	var student_content = document.getElementById("student_content");
	var schedule_content = document.getElementById("schedule_content");
	var subject_content = document.getElementById("subject_content");

	if (table_name == "break_table") {
		lecture_content.style.display = 'none';
		display4(break_content,subject_content, schedule_content,student_content);
	} else if (table_name == "student_table") {
		lecture_content.style.display = 'none';
		display4(student_content,subject_content, schedule_content, break_content);
	} else if (table_name == "schedule_table") {
		lecture_content.style.display = 'none';
		display4(schedule_content, subject_content, break_content,student_content);
	} else if (table_name == "subject_content") {
		display4(subject_content, schedule_content, break_content,student_content);
		lecture_content.style.display = 'none';
	}else if(table_name == "lecture_content"){
		break_content.style.display = 'none';
		student_content.style.display = 'none';
		schedule_content.style.display = 'none';
		subject_content.style.display='none';
		lecture_content.style.display = 'block';
	
	}
}

// function changing display
function display(content_display, content_none, content2_none) {

	content_display.style.display = 'block';
	content_none.style.display = 'none';
	content2_none.style.display = 'none';
}

function display4(content_display, content_none, content2_none, content3_none) {

	content_display.style.display = 'block';
	content_none.style.display = 'none';
	content2_none.style.display = 'none';
	content3_none.style.display = 'none';
}

function display(content_display, content_none) {

	content_display.style.display = 'block';
	content_none.style.display = 'none';
}

// ************************************************************* subject List
var modal_button = document.getElementById("message_button");
var body = document.getElementsByTagName("BODY")[0];

function DeleteSubject_id(id) {
	modal_button.innerText = "Yes, delete it ";
	modal_button.addEventListener('click', function() {
		location.replace("/subject/delete_main?subject_id=" + id);
	});
}
function UpdateSubject_id(id) {
	modal_button.innerText = "Yes, Update it ";
	modal_button.addEventListener('click', function() {
		location.replace("/subject/update?subject_id=" + id);
	});
}

// ************************************************************* Strand List

function DeleteStrand_id(id) {
	modal_button.innerText = "Yes, delete it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		location.replace("/strand/delete_list?strand_id=" + id);
	});
}
function UpdateStrand_id(id) {
	modal_button.innerText = "Yes, Update it ";
	modal_button.addEventListener('click', function() {
		location.replace("/strand/update?strand_id=" + id);
	});
}

// ************************************************************* Room List
function UpdateRoom_id(id) {
	modal_button.innerText = "Yes, Update it ";
	modal_button.addEventListener('click', function() {
		location.replace("/room/update?room_id=" + id);
	});
}

function DeleteRoom_id(id) {
	modal_button.innerText = "Yes, Delete it ";
	modal_button.addEventListener('click', function() {
		location.replace("/room/deleteMain?room_id=" + id);
	});
}

// ************************************************************* RoomShift List
function UpdateRoomShift_id(id) {
	modal_button.innerText = "Yes, Update it ";
	modal_button.addEventListener('click', function() {
		location.replace("/room/shift/update?roomShift_id=" + id);
	});
}

function DeleteRoomShift_id(id) {
	modal_button.innerText = "Yes, Delete it ";
	modal_button.addEventListener('click', function() {
		location.replace("/room/shift/delete_Main?roomShift_id=" + id);
	});
}

// ************************************************************* RoomBreak List
function DeleteRoomBreak_id(break_id, shift_id) {
	modal_button.innerText = "Yes, Delete it";
	modal_button.addEventListener('click', function() {
		location.replace("/room/break/delete?break_id=" + break_id
				+ "&shift_id=" + shift_id);
	});
}

// ************************************************************* Teacher List

// ------------------------------------------------------------- Alert in
// teacher information
function UpdateTeacher_id(id) {
	modal_button.innerText = "Yes, Update it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		location.replace("/teacher/update?teacher_id=" + id);
	});
}

function DeleteTeacher_id(id) {
	modal_button.innerText = "Yes, Delete it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		location.replace("/teacher/deleteMain?teacher_id=" + id);
	});
}

// ------------------------------------------------------------- Delete subject teacher
function DeleteSubjectTeacher_id(id) {
	modal_button.innerText = "Yes, Delete it ";
	modal_button.addEventListener('click', function() {
		location.replace("/teacher/subject/delete?subject_id=" + id);
	});
}
//------------------------------------------------------------- Delete Break teacher
function DeleteBreakTeacher_id(break_id, teacher_id){
	modal_button.innerText = "Yes, Delete it ";
	modal_button.addEventListener('click', function() {
		location.replace("/teacher/break/delete?break_id=" + break_id
				+ "&teacher_id=" + teacher_id);
	});
}

//-------------------------------------------------------------- Teacher Lecture

function UpdateLecture(id){
	modal_button.innerText = "Yes, Update it ";
	modal_button.addEventListener('click', function() {
		location.replace("/teacher/lecture/update?lecture_id=" + id);
	});
}

function DeleteLecture(id){
	modal_button.innerText = "Yes, Delete it ";
	modal_button.addEventListener('click', function() {
		location.replace("/teacher/lecture/DeleteMain?lecture_id=" + id);
	});
}


// ------------------------------------------------------------- Endteacher
// information

// ************************************************************* BreakTime
function UpdateBreakTime(id) {
	modal_button.innerText = "Yes, Update it ";
	modal_button.addEventListener('click', function() {
		location.replace("/breaktime/update?break_id=" + id);
	});
}

function DeleteBreakTimeMain(id) {
	modal_button.innerText = "Yes, Delete it ";
	modal_button.addEventListener('click', function() {
		location.replace("/breaktime/deleteMain?break_id=" + id);
	});
}

function DeleteBreakTime(id) {
	modal_button.innerText = "Yes, Delete it ";
	modal_button.addEventListener('click', function() {
		location.replace("/breaktime/delete?break_id=" + id);
	});
}
