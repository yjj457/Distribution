<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/icon.css">
<script type="text/javascript" src="../resource/js/jquery.min.js"></script>
<script type="text/javascript" src="../resource/plugins/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script>
$(function(){
	$('#dg').datagrid({singleSelect:(this.value==1)});
	$('#dg').datagrid({selectOnCheck:$(this).is(':checked')});
	$('#dg').datagrid({checkOnSelect:$(this).is(':checked')});
});
function getChecked(){
	var checkedItems = $('#dg').datagrid('getChecked');
 	var names = [];
	$.each(checkedItems, function(index, item){
		names.push(item.pro_id);
	});           
//	alert(names.join(","));
	$.ajax({
        type: "POST",
        url: "./../storeHouse/in2StoreDo",
        data: {orgIds : names.join(",")},
     // dataType: "json",
        success: function(data){
			alert("进仓成功!");
        	
        	//初始化表格数据
			$('#dg').datagrid("reload"); 
        }
    });
	//console.log(names.join(","));
}
</script>

<title>Insert title here</title>
</head>
<body>

	<table id="dg" class="easyui-datagrid" title="进仓确认" style="width:700px;height:440px"
            data-options="rownumbers:true,singleSelect:true,url:'./../storeHouse/in2Store',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'ck',checkbox:true"></th>
                <th data-options="field:'pro_id',width:120">货品代号</th>
                <th data-options="field:'pro_nm',width:120">货品名称</th>
                <th data-options="field:'inv_qty',width:120,align:'right'">货品数量</th>
            </tr>
        </thead>
    </table>
	<input type="button" value="进仓" onclick="getChecked()" />
</body>
</html>