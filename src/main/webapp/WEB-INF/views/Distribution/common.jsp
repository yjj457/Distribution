<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>分销系统</title>
    <link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/icon.css">
    <script type="text/javascript" src="../resource/js/jquery.min.js"></script>
    <script type="text/javascript" src="../resource/plugins/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <style>
    	.logout{float:right;}
    </style>
    <script type="text/javascript">
            function addTab(title, url){
                if ($('#tt').tabs('exists', title)){
                    $('#tt').tabs('select', title);
                } else {
                    var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:99%;height:99%;"></iframe>';
                    $('#tt').tabs('add',{
                        title:title,
                        content:content,
                        closable:true
                    });
                }
            }
        </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:80px;"><h2>分销系统</h2>
    
    	<a href="/Distribution/auth/logout" class="logout">退出登录</a>
    </div>
    
    <div data-options="region:'west',split:true" style="width:200px;">
           <div class="easyui-accordion" style="width:193px;height:515px;">
               <div title="店长操作" data-options="iconCls:'icon-add'" style="overflow:auto;padding:10px;">

                   
                   <div style="padding:5px 0;">
      					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',size:'large',iconAlign:'top'" onclick="addTab('&nbsp;&nbsp;&nbsp;&nbsp;销售&nbsp;&nbsp;&nbsp;&nbsp;','./../shopOwner/showSale')">&nbsp;&nbsp;&nbsp;&nbsp;销售&nbsp;&nbsp;&nbsp;&nbsp;</a><br /><br />
       					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',size:'large',iconAlign:'top'" onclick="addTab('&nbsp;&nbsp;&nbsp;&nbsp;退货&nbsp;&nbsp;&nbsp;&nbsp;','./../shopOwner/showReturn')">&nbsp;&nbsp;&nbsp;&nbsp;退货&nbsp;&nbsp;&nbsp;&nbsp;</a><br /><br />
       					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',size:'large',iconAlign:'top'" onclick="addTab('&nbsp;&nbsp;&nbsp;&nbsp;提货&nbsp;&nbsp;&nbsp;&nbsp;','./../shopOwner/showIn')">&nbsp;&nbsp;&nbsp;&nbsp;提货&nbsp;&nbsp;&nbsp;&nbsp;</a>
   				   </div>

                 
               </div>
               <div title="仓库管理员操作" data-options="iconCls:'icon-add'" style="padding:10px;">
              	   <div style="padding:5px 0;">
      					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',size:'large',iconAlign:'top'" onclick="addTab('&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;','./../storeHouse/showSearch')">&nbsp;&nbsp;&nbsp;&nbsp;查询&nbsp;&nbsp;&nbsp;&nbsp;</a><br /><br />
       					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',size:'large',iconAlign:'top'" onclick="addTab('&nbsp;&nbsp;&nbsp;&nbsp;进仓&nbsp;&nbsp;&nbsp;&nbsp;','./../storeHouse/showIn')">&nbsp;&nbsp;&nbsp;&nbsp;进仓&nbsp;&nbsp;&nbsp;&nbsp;</a><br /><br />
   				        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',size:'large',iconAlign:'top'" onclick="addTab('&nbsp;&nbsp;&nbsp;&nbsp;出仓&nbsp;&nbsp;&nbsp;&nbsp;','./../storeHouse/showOut')">&nbsp;&nbsp;&nbsp;&nbsp;出仓&nbsp;&nbsp;&nbsp;&nbsp;</a>
   				   </div>
               </div>
               <div title="货管操作" data-options="iconCls:'icon-add'" style="padding:10px;">
                   <div style="padding:5px 0;">
      					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',size:'large',iconAlign:'top'" onclick="addTab('&nbsp;&nbsp;&nbsp;&nbsp;货品&nbsp;&nbsp;&nbsp;&nbsp;','./../goodsManager/showManage')">&nbsp;&nbsp;&nbsp;&nbsp;货品&nbsp;&nbsp;&nbsp;&nbsp;</a><br /><br />
       					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',size:'large',iconAlign:'top'" onclick="addTab('&nbsp;&nbsp;&nbsp;&nbsp;进货&nbsp;&nbsp;&nbsp;&nbsp;','./../goodsManager/showBuy')">&nbsp;&nbsp;&nbsp;&nbsp;进货&nbsp;&nbsp;&nbsp;&nbsp;	</a>
   				   </div>
               </div>
           </div>
       </div>
    <div data-options="region:'center'," style="padding:5px;background:#eee;">
           
           <div id="tt" class="easyui-tabs" style="width:1000px;height:500px;">
               <div title="首页">

                  </div>
           </div>
       </div>


       <div data-options="region:'south',split:true" style="height:30px;"><center>Copyright © 尹健君 版权所有</center></div>
</body>
</html>