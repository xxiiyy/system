package com.pro.blogL.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * Created by lhd on 2017/3/24.
 * @author lhd
 */
public class FormAuthentication extends FormAuthenticationFilter{

	/**
	 * 表单过滤器，可以验证验证码是否正确
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,
									 ServletResponse response) throws Exception {
		/*System.out.println(111);
		HttpSession session = ((HttpServletRequest)request).getSession();
        //页面输入的验证码
        String randomcode = request.getParameter("randomcode");
        //从session中取出验证码
        String validateCode = (String) session.getAttribute("validateCode");
        if (!randomcode.equals(validateCode)) {
               // randomCodeError表示验证码错误
               request.setAttribute("shiroLoginFailure", "randomCodeError");
               //拒绝访问，不再校验账号和密码
               return true;
        }*/
		return super.onAccessDenied(request, response);
	}


}
