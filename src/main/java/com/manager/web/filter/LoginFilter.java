package com.manager.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.manager.common.util.DwzJsonUtil;
import com.manager.common.util.RequestUtil;
import com.manager.common.web.Funcs;
import com.manager.common.web.JSONView;
import com.manager.model.LoginAccount;
import com.manager.model.Menu;

/**
 * @author Administrator
 *
 */
public class LoginFilter implements Filter {

	private List<String> ignoreUrlList = new ArrayList<String>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String temp = filterConfig.getInitParameter("ignoreUrl");
		if (null != temp && !"".equals(temp))
		{
			String[] ts = temp.split(";");
			for (String t : ts)
			{
				this.ignoreUrlList.add(t);
			}
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(false);
		String servletPath = request.getServletPath();

		if (null != request.getPathInfo()) {
			servletPath += request.getPathInfo();
		}

		if (ignoreUrlList.contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}
		
		LoginAccount account = null;
		String redirectUrl="";
		String path = request.getRequestURI();
		if (path.startsWith(request.getContextPath() + "/manager")) {
			account = Funcs.getSessionLoginAccount(session);
			if (account == null) {
				redirectUrl="/manager/adm_login";
				if (RequestUtil.isAjax(request)) {
					JSONView.writeJSONData(response, DwzJsonUtil.getSessionTimeOutMsg());
				} else {
					response.sendRedirect(request.getContextPath() + redirectUrl);
				}
				return;
			}
		} else {
			chain.doFilter(request, response);
		}
		
		//权限验证
		boolean isLegal = false; 
		
		if (account != null) {
			if (account.getUser().getRoleId() <= 2) {
				isLegal = true; 
			} else {
				isLegal = linkFilter(session, request, account);
			}
		}
		
		//暂时屏蔽后台系统验证
//		isLegal = true;
		if (!isLegal) {
			redirectUrl="/manager/adm_login";
			if (RequestUtil.isAjax(request)) {
				JSONView.writeJSONData(response, DwzJsonUtil.getSessionTimeOutMsg());
			} else {
				response.sendRedirect(request.getContextPath() + redirectUrl);
			}
			return;
		}
		chain.doFilter(request, response);
	}
	
	/**
	 * 权限验证具体方法
	 * @param session
	 * @param request
	 * @return
	 */
	public boolean linkFilter(HttpSession session, HttpServletRequest request, LoginAccount account) {
		List<Menu> menus = account.getMenus();
		
		String path = request.getRequestURI();
		
		if (StringUtils.isBlank(path)) {
			return false;
		}
//		初始页面或系统管理后台
		if ((request.getContextPath() + "/manager/index").equals(path)) {
			return true;
		}
		
		if (menus == null || menus.size() <= 0) {
			return false;
		}
		
		for (Menu menu : menus) {
			 if (path.equals(request.getContextPath() + "/manager/" + menu.getUrl().split("\\?")[0])) {
				 return true;
			 }
		}
		
		return false;
	}
}

