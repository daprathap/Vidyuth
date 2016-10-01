var data = [{
    name: 'Internet Explorer',
    avgWatt: 56.33
}, {
    name: 'Chrome',
    avgWatt: 24.03
}, {
    name: 'Firefox',
    avgWatt: 10.38
}, {
    name: 'Safari',
    avgWatt: 4.77
}, {
    name: 'Opera',
    avgWatt: 0.91
}, {
    name: 'Proprietary or Undetectable',
    avgWatt: 0.2
}];
$(function () {
	 $.ajax({url: "voltagesDaily", success: function(result){
	        //console.log(result.list);
	        //console.log(data);
	        data = result.list;
	        console.log(data);
	        $.each(data, function (i, point) {
	        	point.y = point.avgWatt;
	    	});
	        $('#container').highcharts({
	            chart: {
	                plotBackgroundColor: null,
	                plotBorderWidth: null,
	                plotShadow: false,
	                type: 'pie'
	            },
	            title: {
	                text: 'Average Voltages'
	            },
	            tooltip: {
	               // pointFormat: '{series.name}: <b>{point.percentage:.1f} watt</b>'
	            },
	            plotOptions: {
	                pie: {
	                    allowPointSelect: true,
	                    cursor: 'pointer',
	                    dataLabels: {
	                        enabled: true,
	                       // format: '<b>{point.name}</b>: {point.percentage:.1f} watt',
	                        style: {
	                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                        }
	                    }
	                }
	            },
	            series: [{
	                name: 'Wattage',
	                colorByPoint: true,
	                data: data
	            }]
	        });
	 }});
	 
	
   


});
