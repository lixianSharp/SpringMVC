package cn.itcast.ssm.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期转换器  
 * 		这种方式需要实现Converter接口，该接口在spring的核心包下
 * @author 贤元
 *
 */
public class CustomDateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		//source表示你的源数据(原来的数据，就是要转换的数据)
		//进行日期转换  字符串->日期   字符串转日期
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}