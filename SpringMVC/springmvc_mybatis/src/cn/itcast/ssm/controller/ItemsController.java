package cn.itcast.ssm.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;
/**
 * 商品管理
 * @author 贤元
 *
 */
@Controller
//定义url的跟路径，访问时跟路径+方法的url
@RequestMapping("/items")
public class ItemsController {
	//注入service
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems()throws Exception{
		
		//调用service查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.addObject("second", "second:原来可以传输多个数据");
		//指定逻辑视图名
		modelAndView.setViewName("itemsList");
		
		return modelAndView;
	}
	
	
	//商品修改页面显示
	//使用method=RequestMethod.GET限制使用get方法
	@RequestMapping(value="/editItems",method={RequestMethod.GET})
	public ModelAndView editItems()throws Exception{
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		//调用service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
		//将模型数据传到jsp
		modelAndView.addObject("itemsCustom", itemsCustom);
		
		//指定逻辑视图名
		modelAndView.setViewName("editItem_2");
		
		return modelAndView;
	}
	
	
	//方法返回字符串，字符串就是逻辑视图名，Model作用是将数据填充到request域，在页面展示
	//使用method=RequestMethod.GET限制使用get方法
//	@RequestMapping(value="/editItems",method={RequestMethod.GET})
//	public String editItems(Model model)throws Exception{
//		
//		//调用Service查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		
//		model.addAttribute("item", itemsCustom);
//		
//		return "editItem";//逻辑视图名
//	}
	
	
	//方法返回void
//	@RequestMapping(value="/editItems",method={RequestMethod.GET}) ////使用method=RequestMethod.GET限制使用get方法
//	public void editItems(HttpServletRequest request,HttpServletResponse response,
			//@RequestParam(value = "item_id", required = false, defaultValue = "1") Integer id	
//			)throws Exception{
//		//调用service查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		request.setAttribute("item", itemsCustom);
//		//注意如果使用request转向页面，这里指定页面的完整路径
//		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request, response);
//		
//	}
	
	
	
	//商品修改提交
	//itemsQueryVo是包装类型的pojo
	//public String editItemSubmit(Integer id,ItemsCustom itemsCustom,ItemsQueryVo itemsQueryVo)throws Exception{
	@RequestMapping("/editItemSubmit")  //访问方式是：  http://localhost:8080/跟路径+方法的url/action
	public String editItemSubmit(Integer id,ItemsCustom itemsCustom)throws Exception{
		
		//调用service接口更新商品信息
		//itemsService.updateItems(id, itemsCustom);
		//请求重定向
		return "redirect:queryItems.action";
		//转发
		//return "forward:queryItems.action";
	}
	
	
	//自定义属性编辑器
//	@InitBinder
//	public void initBinder(WebDataBinder binder)throws Exception{
//		//Data.class必须是与controller方法形参pojo属性一致的date类型,这里是java.util.date
//		binder.registerCustomEditor(Date.class, 
//					new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"),true));
//	}
//	
	
	
	
	
	
}