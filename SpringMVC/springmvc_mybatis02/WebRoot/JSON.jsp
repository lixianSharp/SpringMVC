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
		/* function btnClick(){
		
		
			alert("准备提交")
			 //提交表单并上传文件
			 var formData = new FormData($("#formID")[0]);
			 $.ajax({
		        url : "${pageContext.request.contextPath }/addPersonAndFile.action",
		        data : formData,
		        type : 'POST',
		        dataType : 'json',
		        success : function(data){
		        	alert(data.name);//李贤元
		        }
		    });   
					
		}	 */
					
			/* $.ajax({
		        url : "${pageContext.request.contextPath }/addname.action",
		        data : {
		        	"name":"李贤元",
		        	"sex":"男"
		        },
		        type : 'POST',
		        dataType : 'json',
		        async:true,
		        success : function(data){
		        	alert(data.name);//李贤元
		        }
		    }); 
		 */
		
			/* $.ajax({
		        url : "${pageContext.request.contextPath }/addname.action",
		        data : {
		        	"name":"李贤元",
		        	"sex":"男"
		        },
		        type : 'POST',
		        dataType : 'json',
		        async:true,
		        success : function(data){
		        	alert(data);//李贤元
		        }
		    });   */
		    
		   
		    
		    
		   /*  $.ajax({
		        url : "${pageContext.request.contextPath }/addusername.action",
		        data : {
		        	"username":"李贤元"
		        },
		        type:"POST",
		        dataType : 'json',
		        async:true,
		        success : function(data){
		        	alert("成功")
		        	alert(data);//李贤元
		        }
		    });  */
		
	
	
	</script>



  </head>
  
  <body>
   <form id="formID" action="" method="POST" enctype="multipart/form-data">
	  // <!--  姓名：<input type="text" name="name" value=""/> <br/><br/> -->
	    
	   // <!-- 性别：<input type="text" name="sex" value=""/><br/><br/> -->
	选择文件：  <input type="file"  name="pictureFile"/>  
   	<button type="button" onclick="btnClick()">提交</button>
   </form>
  </body>
</html>
