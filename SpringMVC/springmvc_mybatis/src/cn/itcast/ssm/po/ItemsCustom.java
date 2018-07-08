package cn.itcast.ssm.po;
/**
 * 商品信息扩展类
 * @author 贤元
 *
 */
public class ItemsCustom extends Items{
	
	//一些扩展字段。。。。
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
