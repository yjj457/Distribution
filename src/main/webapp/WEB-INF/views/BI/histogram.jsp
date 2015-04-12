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
	console.log("histogram");
	$('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '柱状图'
        },
        xAxis: {
            categories: [
              <c:forEach items="${results}" var="result">
	          	'${result.pro_nm}',
	          </c:forEach>
            ]
        },
        yAxis: {
            min: 0,
            title: {
                text: '量值'
            }
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '销售量',
            data: [
				<c:forEach items="${results}" var="result">
					${result.sal_qty},
				</c:forEach>
			]
        }, {
            name: '库存量',
            data: [
				<c:forEach items="${results}" var="result">
				${result.inv_qty},
				</c:forEach>
			]

        }]
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
		<div id="container" style="min-width:300px;height:200px"></div>
	</div>
</div>
</body>
</html>