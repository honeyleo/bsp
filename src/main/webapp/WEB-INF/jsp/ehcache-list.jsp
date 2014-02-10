<?xml version="1.0" encoding="UTF-8"?>
<%@ page import="net.sf.ehcache.CacheManager"%>
<%@ page import="net.sf.ehcache.Cache" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ehcache</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
body {
	color:#272727;
	font-size: 18px;
	margin: 5;
	padding: 0;
	font-family: "微软雅黑",Helvetica;
	background:#B8D8B8;
}
</style>
<body>
<%
		if (null != request.getAttribute("ischeck")) {
			CacheManager cm = (CacheManager) request.getAttribute("cm");
			int cacheSize = cm.getCacheNames().length;
			out.println("CacheName:<br/>");
			for (int i = 0; i < cacheSize; i++) {
				out.println("[<a href=\"list.html?esid="+request.getAttribute("esid")+"&amp;cache="
				+ cm.getCacheNames()[i] + "\">"
				+ cm.getCacheNames()[i] + "</a>] ");
			}
		    out.print("<a href='list.html?action=out&amp;esid="+request.getAttribute("esid")+"'>LOGOUT</a>");
		    out.print("<br/>");
			if(null!=request.getParameter("action")){
				request.getSession().removeAttribute("ischeck");
				response.sendRedirect("ehcache/list.html");
			}
		if (null != request.getParameter("cache")) {
			String cachename = request.getParameter("cache");
			Cache cache = cm.getCache(cachename);
			out.println("<br/>[" + cachename + "] size: "
			+ cache.getSize()
			+ "     <a href=\"list.html?esid="+request.getAttribute("esid")+"&amp;cache=" + cachename
			+ "&amp;rmcache=" + cachename
			+ "\">Delete</a>]<br/>");
			if (null != request.getParameter("rmcache")) {
				cache.removeAll();
				response.sendRedirect("/bsp/view/ehcache/list.html?esid="+request.getAttribute("esid")+"&cache=" + cachename);
			}
			for (int i = 0; i < cache.getKeys().size(); i++) {
				if (null != request.getParameter("key")) {
					cache.remove(request.getParameter("key"));
					response.sendRedirect("/bsp/view/ehcache/list.html?cache="
					+ cachename+"&esid="+request.getAttribute("esid")+"");
				}
				out.print(i + 1 + ":"
					+ cache.getKeys().get(i).toString().replace("com.easou.estore.appstore.","")
					+ "      [<a href=\"list.html?cache="
					+ cachename + "&amp;key="
					+ cache.getKeys().get(i).toString()
					+ "&amp;esid="+request.getAttribute("esid")+"\">Delete</a>]<br/>");
			}
		}
	}else{
		Long ran=(Long)request.getAttribute("eaRan");
		out.println("account:<input type='text' name='account"+ran+"' emptyok='false' maxlength='50' size='10' /><br/>");
		out.println("password:<input type='password' name='password"+ran+"' emptyok='false' maxlength='50' size='10' /><br/>");
		out.println("<anchor>submit<go href='list.html?esid="+request.getAttribute("esid")+"' method='post'><postfield name='account' value='$(account"+ran+")' /><postfield name='password' value='$(password"+ran+")' /></go></anchor>");
	}
%>
</body>
</html>
