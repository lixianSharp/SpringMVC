<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.js"></script>

</script>


<script type="text/javascript">
     function btnClick(){
    		var formData = new FormData($("#uploadForm")[0]);
    		 $.ajax({
    			type:"POST",
    			url:"${pageContext.request.contextPath }/fileupload.action",
    			data: formData,
    			//必填  
    	        processData: false,  
    	       //必填  
    	        contentType: false,
    			dataType:"json",
    			success:function(data){
    				alert(data);
    			},
    			error:function(){
    				alert("失败");
    			}
    		 }); //ajax的括号
      } 


</script>
</head>
<body>

	<form id="uploadForm" action="${pageContext.request.contextPath }/fileupload.action"
	 method="POST" enctype="multipart/form-data">
	 
		<table width="100%" border=1>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name" value=""/></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="text" name="sex" value=""/></td>
		</tr>
		<tr>
			<td>图片</td>
			<td>
				<input type="file"  name="pictureFile"/> 
			</td>
		</tr>
		
		<tr>
		<td colspan="2" align="center">
		<button type="button"  onclick="btnClick()">提交</button>
		</td>
		</tr>
	</table>
	</form>
</body>
</html>