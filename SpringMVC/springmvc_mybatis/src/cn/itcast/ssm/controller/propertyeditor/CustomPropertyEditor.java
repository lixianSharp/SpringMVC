package cn.itcast.ssm.controller.propertyeditor;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
/**
 * 自定义属性编辑器
 * @author 贤元
 *
 */
public class CustomPropertyEditor implements PropertyEditorRegistrar{

	@Override
	public void registerCustomEditors(PropertyEditorRegistry binder) {
		//registerCustomEditor()方法：中的第一个参数：表示哪种类型     第二个参数：哪种属性编辑器
		//CustomDateEditor构造方法中的第一个参数：数据格式，第二个参数：是否允许为空
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"),true));
		
	}
}
