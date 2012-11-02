package net.tt64.nutz.plugin.scoffold;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.mvc.View;
import org.nutz.mvc.view.JspView;

public class ScoffoldVmView implements View{

	
	private String viewName = null;
	
	public ScoffoldVmView(String viewName){
		this.viewName = viewName;
	}
	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp,
			Object obj) throws Throwable {
		req.setAttribute("scoffold_viewName", viewName);
		req.setAttribute("obj", obj);
		new JspView("views.scoffold").render(req, resp, obj);
	}
}
