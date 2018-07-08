package cn.itcast.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.Person;
import cn.itcast.ssm.po.User;

/**
 * 
 * <p>
 * Title: JsonTest
 * </p>
 * <p>
 * Description: json测试
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2015-3-22上午11:24:12
 * @version 1.0
 */
@Controller
public class JsonTest {

	// 请求json响应json，请求商品信息，商品信息用json格式，输出商品信息
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(
			@RequestBody ItemsCustom itemsCustom) throws Exception {

		return itemsCustom;
	}

	// 请求key/value响应json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom)
			throws Exception {

		return itemsCustom;
	}

	// 请求key/value响应json
	@RequestMapping("/addUser")
	public @ResponseBody User addUser(User user) throws Exception {
		System.out.println(user);

		return user;
	}

	// 请求key/value响应json
	@RequestMapping("/addname")
	public @ResponseBody Person addname(Person person) throws Exception {
		System.out.println(person);
		return person;
	}
	
	
	@RequestMapping("/addPersonAndFile")
	public @ResponseBody Person addPersonAndFile(Person person,
			//上传图片
			CommonsMultipartFile  pictureFile
			)throws Exception{
		//进行数据回显
		//进行图片上传
		/*if(pictureFile!=null&& pictureFile.getOriginalFilename()!=null && pictureFile.getOriginalFilename().length()>0){
			//图片上传成功后，将图片的地址写到数据库
			String filePath = "D:\\images\\";
			//上传文件原始名称
			String originalFilename = pictureFile.getOriginalFilename();
			//新的图片名称
			String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			//新文件
			File file = new File(filePath+newFileName);
			//将内存中的文件写入到磁盘中
			pictureFile.transferTo(file);
			//之后的操作，将图片路径写入数据库
			//。。。。
		}*/
		//提交后回到修改页面
		return person;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*// 请求key/value响应json
	@RequestMapping("/addname")
	public @ResponseBody String addname(String name,String sex) throws Exception {
		
		return name;
	}*/

	// 请求key/value响应json
	@RequestMapping("/addusername")
	public @ResponseBody String addusername(String	username) throws Exception {
		System.out.println(username);
		return username;
	}
	
	
	
	@RequestMapping(value = "/saveHeaderPic", method = RequestMethod.POST)
	public void saveHeaderPic(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {

	        String resMsg = "";
	    try {

	        long  startTime=System.currentTimeMillis();

	        System.out.println("fileName："+file.getOriginalFilename());
	        String path="D:\\images\\"+new Date().getTime()+file.getOriginalFilename();

	        File newFile=new File(path);
	        //通过CommonsMultipartFile的方法直接写文件
	        file.transferTo(newFile);//将文件写入磁盘
	        long  endTime=System.currentTimeMillis();
	        System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
	        resMsg = "1";
	    } catch (IllegalStateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        resMsg = "0";
	    }
	          response.getWriter().write(resMsg);

	      }
	
	
	@RequestMapping("/upload")
	 public void upload(HttpServletRequest request,HttpServletResponse response,String loginName) throws Exception {
	     //获取服务器中保存文件的路径
	  String path = "D:\\images\\";
	  System.out.println(path);
	   //获取解析器  
	     CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	     //判断是否是文件  
	     if(resolver.isMultipart(request)){  
	         //进行转换  
	         MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)(request);  
	         //获取所有文件名称  
	         Iterator<String> it = multiRequest.getFileNames();  
	         while(it.hasNext()){  
	             //根据文件名称取文件  
	             MultipartFile file = multiRequest.getFile(it.next());  
	             String fileName = file.getOriginalFilename();  
	             String localPath = path + fileName;  
	             //创建一个新的文件对象，创建时需要一个参数，参数是文件所需要保存的位置
	             File newFile = new File(localPath);  
	             //上传的文件写入到指定的文件中  
	             file.transferTo(newFile);  
	         }  
	     }

	}


		//文件上传
		//上传文件会自动绑定到MultipartFile中
		@RequestMapping("/fileupload")
		public @ResponseBody String fileupload(
				 Person person,
				//上传图片
				MultipartFile pictureFile
				)throws Exception{
			System.out.println(person);
			//进行数据回显
			//进行图片上传
			if(pictureFile!=null&& pictureFile.getOriginalFilename()!=null && pictureFile.getOriginalFilename().length()>0){
				//图片上传成功后，将图片的地址写到数据库
				String filePath = "D:\\images\\";
				//上传文件原始名称
				String originalFilename = pictureFile.getOriginalFilename();
				//新的图片名称
				String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				//新文件
				File file = new File(filePath+newFileName);
				//将内存中的文件写入到磁盘中
				pictureFile.transferTo(file);
				//图片上传成功，将新图片地址写入数据库   //后续操作......
			}
			String result = "成功";
			//提交后回到修改页面
			return result;
		}
}