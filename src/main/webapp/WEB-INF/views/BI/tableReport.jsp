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
    <link rel="stylesheet" href="../resource/css/table-1.0.3.css">
	<script type="text/javascript" src="../resource/js/jquery.min.js"></script>
	<script type="text/javascript" src="../resource/plugins/jquery.mobile-1.4.5/jquery.mobile-1.4.5.js"></script>
	<script type="text/javascript" src="../resource/js/fixedHeader-1.0.14.js"></script>
	<!-- script type="text/javascript" src="../resource/js/fold-1.0.js"></script -->
</head>
<script type="text/javascript">
$(function () {
	console.log("tableReport");
    $('#table').fixedHeaderTable('2');//数字可选 为左侧固定的个数
//    fold(1);//数字可选 0,1,2 为默认收合 层级 
});
</script>

<body>
<div data-role="page">
<div data-role="header" data-theme="a">
	<div data-role="navbar">
    <ul>
      <li><a href="./../BI/tableReport" data-ajax="false">报表</a></li>
      <li><a href="./../BI/histogram" data-ajax="false">柱状图</a></li>
      <li><a href="./../BI/dash" data-ajax="false">仪表盘</a></li>
    </ul>
  </div>
</div>
<div data-role="content" >
<table id="table" class="bordered">
<thead>
	<tr class="thead">
		<th>店铺名</th>
		<th>商品名</th>
		<th>销售量</th>
		<th>销售额</th>
		<th>库存量</th>
		<th style="background:none;border-bottom:0px;"></th>
	</tr>
</thead>

<tbody id="tbody" grouptype="">
	<c:forEach items="${results}" var="result">
	
	<tr class="tbody">
		<td><nobr>${result.org_nm}</nobr></td>
		<td><nobr>${result.pro_nm}</nobr></td>
		<td>${result.sal_qty}</td>
		<td>${result.sal_amt}</td>
		<td>${result.sal_qty}</td>
		<td style='border-bottom:0px;border-top:0px;'>&nbsp;</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>