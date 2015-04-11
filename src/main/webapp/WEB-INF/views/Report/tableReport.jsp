<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>折叠报表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="resources/plugins/jquery.mobile-1.4.5/jquery.mobile-1.4.5.css">
    <link rel="stylesheet" href="resources/css/table-1.0.3.css">
	<script type="text/javascript" src="resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="resources/plugins/jquery.mobile-1.4.5/jquery.mobile-1.4.5.js"></script>
	<script type="text/javascript" src="resources/js/fixedHeader-1.0.14.js"></script>
	<script type="text/javascript" src="resources/js/fold-1.0.js"></script>
</head>
<script type="text/javascript">
$(function () {
    $('#table').fixedHeaderTable('1');//数字可选 为左侧固定的个数
    fold(0);//数字可选 0,1,2 为默认收合 层级 
});
</script>

<body>

<table id="table" class="bordered">
<thead>
	<tr class="thead">
		<th>店铺名</th>
		<th>商品名</th>
		<th>日期</th>
		<th>销售量</th>
		<th>销售额</th>
		<th>销售量</th>
		<th>库存量</th>
		<th style="background:none;border-bottom:0px;"></th>
	</tr>
</thead>

<tbody id="tbody" grouptype="">
	<c:forEach items="${results}" var="result">
	
	<tr class="tbody" group1="${result.region_id}">
		<td group1="${result.org_nm}"><nobr>${result.org_nm}</nobr></td>
		<td>${result.pro_nm}</td>
		<td>${result.pdate}</td>
		<td>${result.sal_qty}</td>
		<td>${result.sal_amt}</td>
		<td>${result.sal_qty}</td>
		<td style='border-bottom:0px;border-top:0px;'>&nbsp;</td>
	</tr>
	</c:forEach>
</tbody>
</table>


</body>
</html>