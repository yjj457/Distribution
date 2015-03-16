<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/icon.css">
<script type="text/javascript" src="../resource/js/jquery.min.js"></script>
<script type="text/javascript" src="../resource/plugins/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table id="dg" title="<c:forEach items="${org_id}" var="node"><c:out value="${node}"></c:out></c:forEach>库存情况" class="easyui-datagrid" style="width:700px;height:250px"
            url="./../storeHouse/searchStore"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="pro_id" width="50">货品代号</th>
                <th field="pro_nm" width="50">货品名称</th>
                <th field="inv_qty" width="50">库存数量</th>
            </tr>
        </thead>
    </table>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">User Information</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>货品代号</label>
                <input name="pro_id" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>货品名称</label>
                <input name="pro_nm" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>库存数量</label>
                <input name="inv_qty" class="easyui-textbox">
            </div>
        </form>
    </div>
    <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
        .fitem input{
            width:160px;
        }
    </style>
</body>
</html>