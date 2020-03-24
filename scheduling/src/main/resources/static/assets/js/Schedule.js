function back(number) {
	alert(number)
	window.history.go(number)
}

if (performance.navigation.type == 1) {
	var frame = document.getElementById("iFrame");
}

function ChageTable_RoomShift(table_name) {

	var break_content = document.getElementById("break_content");
	var student_content = document.getElementById("student_content");
	var schedule_content = document.getElementById("schedule_content");

	if (table_name == "break_table") {
		display(break_content,student_content,schedule_content);
	} else if (table_name == "student_table") {
		display(student_content,break_content,schedule_content);	
	} else if (table_name == "schedule_table") {
		display(schedule_content,break_content,student_content);
	}

}

function display (content_display,content_none,content2_none){
	
	content_display.style.display = 'block';
	content_none.style.display = 'none';
	content2_none.style.display = 'none';
}