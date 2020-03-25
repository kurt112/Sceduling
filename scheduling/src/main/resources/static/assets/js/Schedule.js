var id = 0;

function back(number) {
	alert(number)
	window.history.go(number)
}

if (performance.navigation.type == 1) {
	var frame = document.getElementById("iFrame");
}

// changing table room shift
function ChageTable_RoomShift(table_name) {

	var break_content = document.getElementById("break_content");
	var student_content = document.getElementById("student_content");
	var schedule_content = document.getElementById("schedule_content");

	if (table_name == "break_table") {
		display(break_content, student_content, schedule_content);
	} else if (table_name == "student_table") {
		display(student_content, break_content, schedule_content);
	} else if (table_name == "schedule_table") {
		display(schedule_content, break_content, student_content);
	}

}

// function changing display
function display(content_display, content_none, content2_none) {

	content_display.style.display = 'block';
	content_none.style.display = 'none';
	content2_none.style.display = 'none';
}

// ************************************************************* subject List
// ****************************************************//
var modal_button = document.getElementById("message_button");
var body = document.getElementsByTagName("BODY")[0];

function DeleteSubject_id(id) {
	modal_button.innerText = "Yes, delete it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		DeleteSubject_Main();
	});
}
function UpdateSubject_id(id) {
	modal_button.innerText = "Yes, Update it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		UpdateSubject();
	});
}

function DeleteSubject_Main() {
	location.replace("/subject/delete_main?subject_id=" + this.id);
}

function UpdateSubject() {
	location.replace("/subject/update?subject_id=" + this.id);
}

// ************************************************************* End of subject
// List ****************************************************//

// ************************************************************* Strand List
// ****************************************************//

function DeleteStrand_id(id) {
	modal_button.innerText = "Yes, delete it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		DeleteStrand_Main();
	});
}
function UpdateStrand_id(id) {
	modal_button.innerText = "Yes, Update it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		UpdateStrand();
	});
}

function DeleteStrand_Main() {
	location.replace("/strand/delete_list?strand_id=" + this.id);
}

function UpdateStrand() {
	location.replace("/strand/update?strand_id=" + this.id);
}

// ************************************************************* End subject
// List

// ************************************************************* Room List
function UpdateRoom_id(id) {
	modal_button.innerText = "Yes, Update it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		UpdateStrand();
	});
}

function DeleteRoom_id(id) {
	modal_button.innerText = "Yes, Delete it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		DeleteRoom_Main();
	});
}

function UpdateRoom() {
	location.replace("/room/update?room_id=" + this.id);
}

function DeleteRoom_Main() {
	location.replace("/room/deleteMain?room_id=" + this.id);
}
// ************************************************************* End Room List

// ************************************************************* RoomShift List
function UpdateRoomShift_id(id) {
	modal_button.innerText = "Yes, Update it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		 UpdateRoomShift();
	});
}

function DeleteRoomShift_id(id) {
	modal_button.innerText = "Yes, Delete it ";
	this.id = id;
	modal_button.addEventListener('click', function() {
		DeleteRoomShift_Main();
	});
}

function UpdateRoomShift() {
	location.replace("/room/shift/update?roomShift_id=" + this.id);
}

function DeleteRoomShift_Main() {
	location.replace("/room/shift/delete_Main?roomShift_id=" + this.id);
}
// ************************************************************* End RoomShift List

//************************************************************* RoomBreak List
function DeleteRoomBreak_id(break_id, shift_id){
	modal_button.innerText = "Yes, Delete it";
	modal_button.addEventListener('click', function() {
		DeleteRoomBreak(break_id,shift_id);
	});
}

function DeleteRoomBreak(break_id,shift_id){
	location.replace("/room/break/delete?break_id=" + break_id + "&shift_id=" + shift_id);
	//th:href="@{(break_id=${break.id},shift_id=${rooms.Id})}"
}
//*************************************************************End RoomBreak List



