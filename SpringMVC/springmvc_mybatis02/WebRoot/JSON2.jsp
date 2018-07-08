<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="multipart/form-data;         charset=utf-8" />
    <title>My JSP 'JSON.jsp' starting page</title>
    
	
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>


<script type="text/javascript">
function doUpload() {  
     var formData = new FormData($( "#myform" )[0]);  
      $.ajax({  
           url: 'fileupload.action',  
           type: 'POST',  
           data: formData,  
           async: false,  
           cache: false,  
           contentType: false,  
           processData: false,  
           success: function (returndata) {  
               alert(returndata);  
           },  
           error: function (returndata) {  
               alert(returndata);  
           }  
      });  
}  
</script>
	

  </head>
  
  <body>
  
 <form id="myform"  method="post" >
       登录名<input type="text" name="loginName" />
       <br>
      上传录音<input type="file" name="record" />
      <input type="button" onclick="doUpload()" value="提交" />
   </form> 
  </body>


</html>
