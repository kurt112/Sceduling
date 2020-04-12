var ctx = document.getElementById('bar').getContext('2d');
var strand_chart = document.getElementById('strand_composition').getContext('2d');
var asdf = 100;

$.getJSON('http://localhost:8080/api/subject/top?value=10', function(data) {

	  var subject_name = data.map(function(e) {
	         return e.name;
	  });
	  
	  var qty = data.map(function(e){
		  return e.qty;
	  })
	  
	  var chart = new Chart(ctx, {
			// The type of chart we want to create
			type : 'bar',
			// The data for our dataset
			data : {
				labels : subject_name,
				datasets : [ {
					label : 'Subject List',

					data : qty,
					backgroundColor : '#000d1a'
				} ]
			},
		  plugins: [{
			  beforeInit: function (chart) {
				  chart.data.labels.forEach(function (value, index, array) {
					  var a = [];
					  a.push(value.slice(0, 10));
					  var i = 1;
					  while(value.length > (i * 10)){
						  a.push(value.slice(i * 10, (i + 1) * 10));
						  i++;
					  }
					  array[index] = a;
				  })
			  }
		  }],

		  // Configuration options go here
		  options : {

			  legend: {
				  display: false
			  },

		  }
});

});

$.getJSON('http://localhost:8080/api/strand/composition', function(data) {
	var strand_name = data.map(function(e) {
		return e.name;
	});
	console.log(strand_name);
	var qty = data.map(function(e){
		return e.qty;
	});
	var myDoughnutChart = new Chart(strand_chart, {
		type: 'doughnut',
		data:{
			datasets: [{
				data:qty,
				backgroundColor : '#000d1a'
			}],

			// These labels appear in the legend and in the tooltips when hovering different arcs
			labels: strand_name
		},
		options : {
			legend: {
				display: false
			},
		}
	});
});
