<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

function excelUpload(){
	$.ajaxFileUpload({
         url:'doajaxfileupload.php', //你处理上传文件的服务端
         secureuri:false,
         fileElementId:'excel_upload',
         dataType: 'json',
         success: function (data){
       	 	
         }
    });
}
</script>
</head>
<body>

<h5>提交Excel(现在仅支持 Excel 2003 *.xls)</h5><hr/>  
    <form id="file_upload_id" name="file_upload_name" action="./../goodsManager/upExcel" method="post" enctype="multipart/form-data">  
        <input type="hidden" name="functionId" value="${functionId}"/>  
        <input type="hidden" name="fileType" value="${fileType}"/>  
        <input type="hidden" name="maxSize" value="${maxSize}"/>  
        <div><input type="file" name="excel_uploads"/></div>  
        <div><input type="submit" value="上传"/></div>  
    </form>
</body>
</html>