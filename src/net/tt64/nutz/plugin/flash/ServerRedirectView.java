package net.tt64.nutz.plugin.flash;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.lang.Strings;
import org.nutz.lang.util.Context;
import org.nutz.mvc.view.AbstractPathView;

/**
 * 重定向视图
 * <p>
 * 在入口函数上声明：
 * <p>
 * '@Ok("redirect:/pet/list.nut")'
 * <p>
 * 实际上相当于：<br>
 * new ServerRedirectView("/pet/list.nut");
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public class ServerRedirectView extends AbstractPathView {
	public static final String REFERER = "SESSION_LAST_REFERER";
	public static final String MESSAGE = "SESSION_MESSAGE";
	public ServerRedirectView(String dest) {
		super(dest);
	}

	public void render(HttpServletRequest req, HttpServletResponse resp, Object obj)
			throws Exception {

		String path = evalPath(req, obj);

		// Another site
		if (path.startsWith("http://") || path.startsWith("https://")) {}
		// Absolute path, add the context path for it
		else if (path.length() > 0 && path.charAt(0) == '/') {
			path = req.getContextPath() + path;
		}
		resp.sendRedirect(path); // 这个原生支持相对路径的,就不要再做无用功了
		resp.flushBuffer();
		String referer = req.getHeader("Referer");
		if(! Strings.isEmpty(referer) && obj != null){
			if(obj instanceof String){
				req.getSession().setAttribute(REFERER, referer);
				req.getSession().setAttribute(MESSAGE, obj);
			}else if(obj instanceof Context){
				Context temp = (Context) obj;
				if(temp.get("message") != null){
					req.getSession().setAttribute(REFERER, referer);
					req.getSession().setAttribute(MESSAGE, temp.get("message"));
				}
			}
		}
	}

}
