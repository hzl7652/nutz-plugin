package net.tt64.nutz.plugin.flash;

import org.nutz.mvc.View;
import org.nutz.mvc.view.ServerRedirectView;
import org.nutz.mvc.view.ViewWrapper;

public class Flash {
	
	public static View redirect(String url,Object data){
		return new ViewWrapper(new ServerRedirectView(url), data);
	}
}
