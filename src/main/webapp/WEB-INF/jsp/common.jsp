<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>分销系统</title>
    <link rel="stylesheet" type="text/css" href="../resource/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/icon.css">
    <link rel="stylesheet" type="text/css" href="../resource/css/demo.css">
    <script type="text/javascript" src="../resource/js/jquery.min.js"></script>
    <script type="text/javascript" src="../resource/js/jquery.easyui.min.js"></script>
</head>
<body>
    <div class="easyui-layout" style="width:1024px;height:600px;">
        <div data-options="region:'north'" style="height:50px">
        	<h1>分销系统</h1>
        </div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        
        <div data-options="region:'west',split:true" title="West" style="width:150px;">
            <div class="easyui-accordion" style="width:150px;height:450px;">
                <div title="用户管理" data-options="iconCls:'icon-add'" style="overflow:auto;padding:10px;">

                    
                    <div style="padding:5px 0;">
       					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-large-shopowner',size:'large',iconAlign:'top'" onclick="addTab('店长','./userInfo')">&nbsp;&nbsp;店长&nbsp;&nbsp;</a>
        				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-large-notshopowner',size:'large',iconAlign:'top'" onclick="addTab('非店长','./notShopInfo')">&nbsp;非店长&nbsp;</a>
    				</div>

                  
                </div>
                <div title="用户组管理" data-options="iconCls:'icon-add'" style="padding:10px;">
               
                </div>
                <div title="统计报表" data-options="iconCls:'icon-add'" style="padding:10px;">
                    
                </div>
            </div>
        </div>
        <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
            <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
                <div title="DataGrid" style="padding:5px">
                    
                </div>
            </div>
        </div>
    </div>
</body>
</html>