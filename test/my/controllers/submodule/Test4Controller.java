package my.controllers.submodule;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

public class Test4Controller {
	@At("/helloAt")
	public void hello(){}
	@Ok("jsp:views.test1")
	public void test1(String arg){}
	public void test3(){}
}
