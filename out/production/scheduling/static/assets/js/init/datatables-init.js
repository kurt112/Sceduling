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
	creatable("#breaktime_table",column2);
	creatable("#strand_table",column1);
	creatable("#strandSubject_table",column6);
	creatable("#subjectSchedule_table",column3);
	creatable("#subject_table",column6);
	creatable("#roomBreakTime_table",column4);
	creatable("#shiftSchedule_table",column8);
	creatable("#roomShift_table",column6);
	creatable("#room_table",column1);
	creatable("#studentSchedule_table",column6);
	creatable("#studentList_table",column8);
	creatable("#teacherLecture_table",column5);
	creatable("#teacherSubject_table",column3);
	creatable("#teacherBreakTime_table",column6);
	creatable("#teacherSchedule_table",column5);
	creatable("#teacherInformation_table",column4);

	// table one level in main form
	creatable("#breakTime_RoomShift_Table",column2);
	creatable("#breakTime_Teacher_Table",column1);

	creatable("#strand_Subject_Table", column5);

	creatable("#subject_Strand_Table", column1);

	creatable("#roomShift_breaktime_Table", column2);
	creatable("#roomShift_Student_Table", column7);
	creatable("#roomShift_Schedule_Table", column5);

	creatable("#room_RoomShift_Table",column7);

	creatable("#teacher_Breaktime_Table", column4);
	creatable("#teacher_Student_Table", column8);
	creatable("#teacher_Schedule_Table",column2);
	creatable("#teacher_Subject_Table", column6);
	creatable("#teacher_Lecture_Table",column4);



	// this function will create a table
	function creatable(tableName, column_data){
		$(tableName).DataTable({

			lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
			"scrollY" : "350px",
			"scrollX" : true,
			dom : 'lBfrtip',
			"paging" : false,
			buttons : [{
				extend: 'print',
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