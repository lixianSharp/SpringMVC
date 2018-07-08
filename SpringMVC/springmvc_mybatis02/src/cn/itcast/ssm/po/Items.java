package cn.itcast.ssm.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.itcast.ssm.controller.validation.ValidGroup1;

/**
 * 校验的需求：
	商品信息提交时校验 ，商品生产日期不能为空，商品名称长度在1到30字符之间
 * @author 贤元
 *
 */
public class Items {
    private Integer id;
    
    //商品名称的长度请限制在1到30个字符
    @Size(min=1,max=30,message="{items.name.length.error}",groups={ValidGroup1.class})
    private String name;

    private Float price;

    private String pic;
    
    //请输入商品生产日期
    @NotNull(message="{items.createtime.is.notnull}")
    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price
				+ ", pic=" + pic + ", createtime=" + createtime + ", detail="
				+ detail + "]";
	}
    
    
}