(function($) {
	// "use strict";

	/*
	 * Data Table -------------
	 */

	// datable to be print in table column in main list
	var column1 = [0];
	var column2 =[0,1];
	var column3 =[0,1,2];
	var column4 =[0,1,2,3];
	var column5 =[0,1,2,3,4];
	var column6 =[0,1,2,3,4,5];
	var column7 =[0,1,2,3,4,5,6];
	var column8 =[0,1,2,3,4,5,6,7];
	var column9 =[0,1,2,3,4,5,6,7,8];




	// var table = $('#bootstrap-data-table').DataTable();
	creatable("#breaktime_table",column2,"List of Breaktime");
	creatable("#strand_table",column1,"List of Strand");
	creatable("#strandSubject_table",column7,"List of Subject for Strand");
	creatable("#subjectSchedule_table",column4,"List of Schedule for Subject");
	creatable("#subject_table",column6,"List of Subject");
	creatable("#roomBreakTime_table",column5,"List of Breaktime for Room Shift");
	creatable("#shiftSchedule_table",column8,"List of Schedule for Room Shift");
	creatable("#roomShift_table",column7,"List of Room Shift");
	creatable("#room_table",column1,"List of Room");
	creatable("#studentSchedule_table",column7,"List of Schedule for Student");
	creatable("#studentList_table",column8,"List of Student");
	creatable("#teacherLecture_table",column4,"List of Lecture for Teacher");
	creatable("#teacherSubject_table",column3,"List of Subject for Teacher");
	creatable("#teacherBreakTime_table",column6,"List of Breaktime for Teacher");
	creatable("#teacherSchedule_table",column5,"List of Schedule for Teacher");
	creatable("#teacherInformation_table",column4,"List of Teacher");

	// table one level in main form
	creatable("#breakTime_RoomShift_Table",column2,"List of RoomShift");
	creatable("#breakTime_Teacher_Table",column1,"List of Teacher");

	creatable("#strand_Subject_Table", column5,"List of Subject");

	creatable("#subject_Strand_Table", column1,"List os Strand");

	creatable("#roomShift_breaktime_Table", column2,"List of Breaktime");
	creatable("#roomShift_Student_Table", column7,"List of Student");
	creatable("#roomShift_Schedule_Table", column5,"List Schedule");

	creatable("#room_RoomShift_Table",column7, "List of RoomShift");
	

	creatable("#teacher_Breaktime_Table", column4,"List Breaktime");
	creatable("#teacher_Student_Table", column8,"List of Student");
	creatable("#teacher_Schedule_Table",column2,"List of Schedule for Teacher");
	creatable("#teacher_Subject_Table", column6,"List of Subjects for Teacher");
	creatable("#teacher_Lecture_Table",column4,"List of Lecture for Teacher");



	// this function will create a table
	function creatable(tableName, column_data,title){
		$(tableName).DataTable({

			lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
			"scrollY" : "350px",
			"scrollX" : true,
			dom : 'lBfrtip',
			"paging" : false,
              
			buttons : [{
				extend: 'print',
				title: title,
				className: 'btn btn-outline-primary',
				text:'<i class="fa fa-print" aria-hidden="true"></i>',  //'<i class="fa fa-print" aria-hidden="true"></i>',
				exportOptions: {
					columns:column_data
				}
			},{
				extend: 'csv',
				className: 'btn btn-outline-primary',
				text:'<i class="fa fa-file" aria-hidden="true"></i>',
				exportOptions: {
					columns: column_data
				}
			},{
				extend: 'pdf',
				title: title,
				className: 'btn btn-outline-primary',
				text:'<i class="fa fa-file-pdf-o" aria-hidden="true"></i>',
				exportOptions: {
					columns: column_data
				}
			},{
				extend: 'excel',
				className: 'btn btn-outline-primary',
				text:'<i class="fa fa-table" aria-hidden="true"></i>',
				exportOptions: {
					columns:column_data
				}
			}
			],

		});
	}

})(jQuery);