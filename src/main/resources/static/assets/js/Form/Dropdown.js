var room;
var shift;
var strand;
var subject;
var teacher;

$(document).ready(function() {
	Change_RoomShift();
	Change_Subject();
	
	$("#day_lecture").change(function() {
		Change_Teacher();
	});
	
	$("#room").change(function() {
		Change_RoomShift();
	});

	$("#strand").change(function() {
		Change_Subject();
	});
	$("#strand_subject").change(function() {
		Change_Teacher();
	});

});

function Change_RoomShift() {
	var room = $("#room").val();
	$.get("/api/room/shift?room_id=" + room, function(data) {
		$("#shift").empty();
		data.forEach(function(item) {
			if (shift === item.id) {
				 var option = "<option value = " + item.id + " selected>" + item.shiftName +  "</option>";
			} else {
				 var option = "<option value = " + item.id + ">" + item.shiftName +  "</option>";
					
			}
			$("#shift").append(option);
		});

	});
}

function Change_Subject() {

	var strand = $("#strand").val();
	$.get("/api/strand/subject?strand_id=" + strand, function(data) {
		$("#strand_subject").empty();
		data.forEach(function(item) {
			if (subject === item.id) {
				var option = "<option value = " + item.id + " selected>"
						+ item.subjectName + "</option>";
			} else {
				var option = "<option value = " + item.id + ">"
						+ item.subjectName + "</option>";
			}
			$("#strand_subject").append(option);
		});
		Change_Teacher();
	});
}

function Change_Teacher() {
	
	var subject = $("#strand_subject").val();
	var day = $("#day_lecture").val();
	$.get("/api/teacher/with/subject?subject_id=" + subject +"&lecture_day="+day+"", function(data) {
		$("#teacher").empty();
		data.forEach(function(item) {
			if(teacher === item.id){
				var option = "<option value = " + item.id + " selected >" + item.firstName
				+ "</option>";
			}else{
				var option = "<option value = " + item.id + ">" + item.firstName
				+ "</option>";
			}
			$("#teacher").append(option);
		});

	});
}

function Change_id(subject_id, shift_id, teacher_id) {
	subject = subject_id;
	shift = shift_id;
	teacher = teacher_id;
}
