package cn.itcast.ssm.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义转换器  
 * 		这种方式需要实现Converter接口，该接口在spring的核心包下
 * @author 贤元
 *
 */
//目的：//去掉字符串两边空格，如果去除后为空设置为null
public class StringTrimConverter implements Converter<String, String>{

	@Override
	public String convert(String source) {
		//source表示你的源数据(原来的数据，就是要转换的数据)
		try {
			//去掉字符串两边空格，如果去除后为空设置为null
			if(source!=null){
				source = source.trim();
				if(source.equals("")){
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
