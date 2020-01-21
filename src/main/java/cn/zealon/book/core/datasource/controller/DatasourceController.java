package cn.zealon.book.core.datasource.controller;

import cn.zealon.book.core.datasource.DataSourceEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("datasource")
public class DatasourceController {

	@ResponseBody
	@RequestMapping("select")
	public String getAllDataSource(){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int i=0;
		for(DataSourceEnum ds : DataSourceEnum.values()){
			if(i>0){sb.append(",");}
			String text = ds.toString();
			String id = ds.getDataSource();
			sb.append("{\"text\":\""+text+"\",\"id\":\""+id+"-"+text+"\"}");
			i++;
		}
		sb.append("]");
		return sb.toString();
	}
}
