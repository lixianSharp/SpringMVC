package cn.itcast.ssm.po;

import java.util.List;
import java.util.Map;

/**
 * 
 * <p>Title: ItemsQueryVo</p>
 * <p>Description: 商品的包装类</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-20下午2:52:00
 * @version 1.0
 */
public class ItemsQueryVo {
	
	//商品信息
	private ItemsCustom itemsCustom;
	
	//定义一个map
	private Map<String,ItemsCustom> itemsCustomMap;

	//定义一个list
	private List<ItemsCustom> itemsList;

	public Map<String, ItemsCustom> getItemsCustomMap() {
		return itemsCustomMap;
	}
	
	public void setItemsCustomMap(Map<String, ItemsCustom> itemsCustomMap) {
		this.itemsCustomMap = itemsCustomMap;
	}
	
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	@Override
	public String toString() {
		return "ItemsQueryVo [itemsCustom=" + itemsCustom + ", itemsList="
				+ itemsList + "]";
	}
	
	

}
