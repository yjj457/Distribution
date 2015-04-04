<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/icon.css">
<script type="text/javascript" src="../resource/js/jquery.min.js"></script>
<script type="text/javascript" src="../resource/plugins/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>

<script type="text/javascript">
	$(function(){
		$.ajax({
            type: "POST",
            url: "./../goodsManager/getPro",
            data: {},
            success: function(data){
            	var i = 0;
            	for(var o in data){ 
            		i++;
            		$("table").append('<tr><td><input type="hidden" name="pro_id' + i + '" value="' +data[o].pro_id + '" />' + data[o].pro_nm + '</td><td><input type="text" class="easyui-numberbox" name="inv_qty' + i + '" /></td></tr>');
            	}
            }
        });
	});
	
	function buy(){
		$.ajax({
            type: "POST",
            url: "./../goodsManager/buy",
            data: $("form").serialize(),
            dataType : "html",
            success: function(data){

            }
        });
	}
	
</script>
</head>
<body>
<form>
<table border="1px">
	<label>收货仓库:</label><input type="text" name="inv_id" value="" />
</table>
</form>
<a href="javascript:buy()" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="width:80px">进货</a>

</body>
</html>