package cn.itcast.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.controller.validation.ValidGroup1;
import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;


/**
 * 
 * <p>
 * Title: ItemsController
 * </p>
 * <p>
 * Description:商品管理
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2015-3-20下午3:04:57
 * @version 1.0
 */
@Controller
//定义url的根路径，访问时根路径+方法的url
@RequestMapping("/items")
public class ItemsController {

	//注入service
	@Autowired
	private ItemsService itemsService;
	
	//单独将商品类型的方法提出来，将方法返回值填充到request，在页面显示
	@ModelAttribute("itemsTypea")
	public Map<String, String> getItemsType()throws Exception{
		
		HashMap<String, String> itemsType = new HashMap<String,String>();
		itemsType.put("001", "数码1");
		itemsType.put("002", "服装2");
		return itemsType;
		
	}
	

	
	//商品信息方法
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception {
		
		System.out.println(request.getParameter("id"));
	
		//调用service查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemsList", itemsList);
		// 指定逻辑视图名
		modelAndView.setViewName("itemsList");

		return modelAndView;
	}
	
	//批量修改商品查询
	@RequestMapping("/editItemsList")
	public ModelAndView editItemsList(HttpServletRequest request) throws Exception {
		
		System.out.println(request.getParameter("id"));
	
		//调用service查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);

		/*Map<String,ItemsCustom> itemsCustomMap = new LinkedHashMap<String,ItemsCustom>();
		int i = 0;
		for(ItemsCustom itemsCustom:itemsList){
			i++;
			itemsCustomMap.put("键key"+i, itemsCustom);
		}
		
		System.out.println("有数据吗？"+itemsCustomMap);*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		// 指定逻辑视图名
		modelAndView.setViewName("editItemsList");

		return modelAndView;
	}
	
	//批量修改商品提交
	@RequestMapping("/editItemsListSubmit")
	public String editItemsListSubmit(ItemsQueryVo itemsQueryVo)throws Exception{
		Map<String, ItemsCustom> itemsCustomMap = itemsQueryVo.getItemsCustomMap();
		//打印数据
		Set<String> keys = itemsCustomMap.keySet();
		System.out.println("所有键"+keys.toString());
		for(String key:keys){
			ItemsCustom itemsCustom = itemsCustomMap.get(key);
			System.out.println("数据："+itemsCustom);
		}
		/**所有打印结果：
		 所有键[v0, v1, v2, x0, x1, x2, y0, y1, y2, z0, z1, z2]
		数据：Items [id=null, name=null, price=null, pic=null, createtime=null, detail=QGHappy]
		数据：Items [id=null, name=null, price=null, pic=null, createtime=null, detail=ç¬è®°æ¬æ§è½å¥½ï¼è´¨éå¥½ï¼ï¼ï¼ï¼ï¼]
		数据：Items [id=null, name=null, price=null, pic=null, createtime=null, detail=åçèåï¼å®¹éå¤§è´¨éå¥½ï¼ï¼ï¼ï¼]
		数据：Items [id=null, name=thinkpad, price=null, pic=null, createtime=null, detail=null]
		数据：Items [id=null, name=ç¬è®°æ¬, price=null, pic=null, createtime=null, detail=null]
		数据：Items [id=null, name=èå, price=null, pic=null, createtime=null, detail=null]
		数据：Items [id=null, name=null, price=1234.0, pic=null, createtime=null, detail=null]
		数据：Items [id=null, name=null, price=6000.0, pic=null, createtime=null, detail=null]
		数据：Items [id=null, name=null, price=201.0, pic=null, createtime=null, detail=null]
		数据：Items [id=null, name=null, price=null, pic=null, createtime=null, detail=null]
		数据：Items [id=null, name=null, price=null, pic=null, createtime=null, detail=null]
		数据：Items [id=null, name=null, price=null, pic=null, createtime=null, detail=null]
		 */
		return "success";
	}
	
	//商品修改页面显示
	//使用method=RequestMethod.GET限制使用get方法
//	@RequestMapping(value="/editItems",method={RequestMethod.GET})
//	public ModelAndView editItems()throws Exception{
//		
//		ModelAndView modelAndView = new ModelAndView();
//		
//		//调用 service查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		//将模型数据传到jsp
//		modelAndView.addObject("item", itemsCustom);
//		//指定逻辑视图名
//		modelAndView.setViewName("editItem");
//		
//		return modelAndView;
//		
//	}
	
	//方法返回 字符串，字符串就是逻辑视图名，Model作用是将数据填充到request域，在页面展示
	@RequestMapping(value="/editItems",method={RequestMethod.POST})
	public String editItems(Model model,Integer id)throws Exception{
		
		//将id传到页面
		model.addAttribute("id", id);
		
		//调用 service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
				
		model.addAttribute("itemsCustom", itemsCustom);

		return "editItem";
		//return "editItem";
		
	}
	
	@RequestMapping("/login")
	public String login()throws Exception{
		
		
		return "editItem";
	}
	
	
	//根据商品id查看商品信息rest接口
	//@RequestMapping中指定restful方式的url中的参数，参数需要用{}包起来
	//@PathVariable将url中的{}包起参数和形参进行绑定
	@RequestMapping("/viewItems/{id}")
	public @ResponseBody ItemsCustom viewItems(@PathVariable("id") Integer id) throws Exception{
		//调用 service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		return itemsCustom;
		
	}
	
	//方法返回void
//	@RequestMapping(value="/editItems",method={RequestMethod.GET})
//	public void editItems(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			//@RequestParam(value = "item_id", required = false, defaultValue = "1") Integer id
//			Integer id
//			)
//			throws Exception {
//	
//		//调用 service查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(id);
//		request.setAttribute("item", itemsCustom);
//		//注意如果使用request转向页面，这里指定页面的完整路径
//		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request, response);
//		
//	}
	
	//商品修改提交，修改之后进行数据回显
	//Model作用是将数据填充到request域，在页面展示
	/*@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Model model,Integer id,
		  @ModelAttribute(value="itemsCustom") ItemsCustom itemsCustom)throws Exception{

		//进行数据回显
		model.addAttribute("id", id);
		
		//调用service接口更新商品信息
		itemsService.updateItems(id, itemsCustom);
		
		//调用 service查询商品信息,查询出修改后的信息
		itemsCustom = itemsService.findItemsById(id);
		
		model.addAttribute("itemsCustom", itemsCustom);
		
		//提交后回到修改页面
		return "editItem";
	}*/
	
	
	//在@Validated中定义使用ValidGroup1组下边的校验
	//上传文件会自动绑定到MultipartFile中
	@RequestMapping("/editItemSubmit")
	public  String editItemSubmit(Model model,Integer id,
			@Validated(value={ValidGroup1.class})  @ModelAttribute ItemsCustom itemsCustom,
			BindingResult bindingResult,
			//上传图片
			MultipartFile pictureFile
			)throws Exception{
		
		//输出校验错误信息
		//如果参数绑定时有错
		if(bindingResult.hasErrors()){
			//获取错误信息
			List<ObjectError> errors = bindingResult.getAllErrors();
			//准备在页面输出errors，页面使用jstl遍历
			model.addAttribute("errors",errors);
			for(ObjectError error:errors){
				//输出错误信息
				System.out.println(error.getDefaultMessage());
			}
			//如果校验错误，回到商品修改页面
			return "editItem";
		}
		
		//进行数据回显
		model.addAttribute("id", id);
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
			//图片上传成功，将新图片地址写入数据库
			itemsCustom.setPic(newFileName);
		}
		//调用service接口更新商品信息
		itemsService.updateItems(id, itemsCustom);*/
		/*//提交后回到修改页面
		return "editItem";*/
		//请求重定向
		return "redirect:queryItems.action";
	}
	
	
	//文件下载
	@RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
            @RequestParam("filename") String filename,
            Model model)throws Exception {
       //下载文件路径
       String path = "D:\\images\\";
       File file = new File(path + filename);
       
       HttpHeaders headers = new HttpHeaders();  
       //下载显示的文件名，解决中文名称乱码问题  
       String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
       //通知浏览器以attachment（下载方式）打开图片
       headers.setContentDispositionFormData("attachment", downloadFielName); 
       //application/octet-stream ： 二进制流数据（最常见的文件下载）。
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       
       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
               headers, HttpStatus.CREATED);  
    }
	
	
	
	
	
	
	
	//删除 商品
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] delete_id)throws Exception{
		
		//调用service方法删除 商品
		//....
		for(Integer id:delete_id){
			System.out.println("id:"+id);
		}
		return "success";
	}
	
	//自定义属性编辑器
//	@InitBinder
//	public void initBinder(WebDataBinder binder) throws Exception {
//		// Date.class必须是与controler方法形参pojo属性一致的date类型，这里是java.util.Date
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
//	}

	

}
