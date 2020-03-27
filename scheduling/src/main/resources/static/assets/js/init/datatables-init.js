(function($) {
	// "use strict";

	/*
	 * Data Table -------------
	 */
	$('#teacher_breaktime').DataTable({

		lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
		"scrollY" : "350px",
		"scrollX" : true,
		dom : 'lBfrtip',
		"paging" : false,
		buttons : [ 'excel', 'pdf', 'print', ]

	});
	
	$('#roomShift_Breaktime').DataTable({

		lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
		"scrollY" : "350px",
		"scrollX" : true,
		dom : 'lBfrtip',
		"paging" : false,
		buttons : [ 'excel', 'pdf', 'print', ]

	});
	
	
	
	// Data table in room shift
	$('#break_table').DataTable({

		lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
		"scrollY" : "350px",
		"scrollX" : true,
		dom : 'lBfrtip',
		"paging" : false,
		buttons : [ 'excel', 'pdf', 'print', ]

	});
	
	$('#subject_table').DataTable({

		lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
		"scrollY" : "350px",
		"scrollX" : true,
		dom : 'lBfrtip',
		"paging" : false,
		buttons : [ 'excel', 'pdf', 'print', ]

	});


	// schedule in room shift
	$('#schedule_table').DataTable({

		lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
		"scrollY" : "350px",
		"scrollX" : true,
		dom : 'lBfrtip',
		"paging" : false,
		buttons : [ 'excel', 'pdf', 'print', ]

	});

	// student in room shift
	$('#student_table').DataTable({

		lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
		"scrollY" : "350px",
		"scrollX" : true,
		dom : 'lBfrtip',
		"paging" : false,
		buttons : [ 'excel', 'pdf', 'print', ]

	});

	// end of room shift

	// var table = $('#bootstrap-data-table').DataTable();

	$('#bootstrap-data-table').DataTable({

		lengthMenu : [ [ 10, 20, 50, -1 ], [ 10, 20, 50, "All" ] ],
		"scrollY" : "350px",
		"scrollX" : true,
		dom : 'lBfrtip',
		"paging" : false,
		buttons : [ 'excel', 'pdf', 'print', ]

	});

	$('#table_main').DataTable({
		"scrollY" : "350px",
		dom : 'lBfrtip',
		buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]

	});

	// table.buttons().container().appendTo( $('.col-sm-6:eq(0)',
	// table.table().container() ) );

	$('#bootstrap-data-table-export').DataTable({
		dom : 'lBfrtip',
		lengthMenu : [ [ 10, 25, 50, -1 ], [ 10, 25, 50, "All" ] ],
		buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ],
		responsive : true
	});

	$('#row-select')
			.DataTable(
					{
						initComplete : function() {
							this
									.api()
									.columns()
									.every(
											function() {
												var column = this;
												var select = $(
														'<select class="form-control"><option value=""></option></select>')
														.appendTo(
																$(
																		column
																				.footer())
																		.empty())
														.on(
																'change',
																function() {
																	var val = $.fn.dataTable.util
																			.escapeRegex($(
																					this)
																					.val());

																	column
																			.search(
																					val ? '^'
																							+ val
																							+ '$'
																							: '',
																					true,
																					false)
																			.draw();
																});

												column
														.data()
														.unique()
														.sort()
														.each(
																function(d, j) {
																	select
																			.append('<option value="'
																					+ d
																					+ '">'
																					+ d
																					+ '</option>')
																});
											});
						}
					});

})(jQuery);