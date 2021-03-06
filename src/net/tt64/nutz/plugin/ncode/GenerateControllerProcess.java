package net.tt64.nutz.plugin.ncode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import net.tt64.nutz.plugin.ncode.util.TextParse;

import org.nutz.lang.Strings;

/**
 * 生成项目:
 * 1,当前文件夹下不能存在与要创建的项目同名的文件夹，如果存在提醒是否删除
 * 2,创建src/controllers, src/domains, src/services,src/utils,src/filters
 * 3,创建resource/dao.js,log4j.properties
 * 4,创建webapp/img,js,css/   webapp/WEB-INF/classes,lib,views,templates, c.tld,fmt.tld,fn.tld
 * 5,将以上项目打包为zip包，然后直接解压到当前目录即可
 * @author tt
 *
 */
public class GenerateControllerProcess implements CmdProcess{

	@Override
	public void process(String args) {
		if(Strings.isEmpty(args)){
			System.out.println("args Invalid");
			return ;
		}else{
			try {
				OutputStream out = new FileOutputStream(new File("src/controllers/"+Strings.capitalize(args)+"Controller.java"));
				TextParse.parse("GenerateController.vm", generateModel(args),out);
				System.out.println("generate controller <" + args + "> success");
			} catch (Exception e) {
				System.out.println("occured some errors ,sorry\nerror code:"+e.getMessage());
			}
		}
	}
	private Map<String,String> generateModel(String name){
		Map<String,String> model = new HashMap<String, String>();
		model.put("domain_name", Strings.capitalize(name));
		model.put("low_domain_name", Strings.lowerFirst(name));
		return model;
	}
	@Override
	public String getInfo() {
		return "generate controller will make controller contains show,list,index,edit,create,save,update,delete,deleteAll methods";
	}
}
