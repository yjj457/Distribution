<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>报表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../resource/plugins/jquery.mobile-1.4.5/jquery.mobile-1.4.5.css">
	<script type="text/javascript" src="../resource/js/jquery.min.js"></script>
	<script type="text/javascript" src="../resource/plugins/jquery.mobile-1.4.5/jquery.mobile-1.4.5.js"></script>
	<script type="text/javascript" src="../resource/plugins/Highcharts-4.1.3/js/highcharts.js"></script>
	<script type="text/javascript" src="../resource/plugins/Highcharts-4.1.3/js/highcharts-more.js"></script>
</head>
<script type="text/javascript">
$(function () {
//	console.log(${results});
	console.log("dash");
	$('#container').highcharts({
		
	    chart: {
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: true
	    },
	    
	    title: {
	        text: '总销售额'
	    },
	    
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#FFF'],
	                    [1, '#333']
	                ]
	            },
	            borderWidth: 0,
	            outerRadius: '109%'
	        }, {
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#333'],
	                    [1, '#FFF']
	                ]
	            },
	            borderWidth: 1,
	            outerRadius: '107%'
	        }, {
	            // default background
	        }, {
	            backgroundColor: '#DDD',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 500000,
	        
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 10,
	        tickColor: '#666',
	        labels: {
	            step: 2,
	            rotation: 'auto'
	        },
	        title: {
	            text: '元'
	        },
	        plotBands: [{
	            from: 0,
	            to: 100000,
	            color: '#55BF3B' // green
	        }, {
	            from: 100000,
	            to: 350000,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 350000,
	            to: 500000,
	            color: '#DF5353' // red
	        }]        
	    },
	
	    series: [{
	        name: '销售额',
	        data: [0],
	        tooltip: {
	            valueSuffix: ' 元'
	        }
	    }]
	
	}, 
	// Add some life
	function (chart) {
		if (!chart.renderer.forExport) {
	        var point = chart.series[0].points[0],
	            newVal,
	            inc = -${results};
	        
	        newVal = point.y + inc;
	        if (newVal < 0 || newVal > 200) {
	            newVal = point.y - inc;
	        }
	        
	        point.update(newVal);
		}
	});
});
</script>

<body>
<div data-role="page">
	<div data-role="header" data-theme="a">
		<div data-role="navbar" data-insert="true">
	    <ul>
	      <li><a href="./../BI/tableReport" data-ajax="false">报表</a></li>
	      <li><a href="./../BI/histogram" data-ajax="false">柱状图</a></li>
	      <li><a href="./../BI/dash" data-ajax="false">仪表盘</a></li>
	    </ul>
	    </div>
	</div>
	<div data-role="content" >
		<div id="container" style="min-width:300px;height:300px"></div>
	</div>
</div>
</body>
</html>