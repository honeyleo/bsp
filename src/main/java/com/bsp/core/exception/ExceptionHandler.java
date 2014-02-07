package com.bsp.core.exception;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver
{

	private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex)
	{
		String msg = ex.getMessage();
		if (msg != null)
		{
			String tmp = "AdminException:";
			int ind = msg.indexOf(tmp);
			if (ind > 0)
			{
				msg = msg.substring(ind + tmp.length());
			}
			logger.error(msg, ex);
		}
		else
		{
			ex.printStackTrace();
		}
		handlerError(request, response, msg);
		return null;
	}

	public static void handlerError(HttpServletRequest request, HttpServletResponse response, String msg)
	{
		if (response.isCommitted())
		{
			return;
		}

		response.setCharacterEncoding("UTF-8");
		response.setStatus(200);
		response.setContentType("text/html; charset=UTF-8");

		StringBuilder buf = new StringBuilder();
		String servletPath = request.getServletPath();
		if (servletPath.contains("/service"))
		{
		    response.setContentType("application/json; charset=UTF-8");
			buf.append("{\"ret\":\"10000\",");
			buf.append("\"message\":\"").append(msg).append("\"");
			buf.append("}");
		}
		else
		{
		    response.setContentType("text/html; charset=UTF-8");
			buf.append("<html><head><title>错误-wPay支付平台</title><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'></head>");
			buf.append("<body>出错了！<br/><span style='color:red'>").append(msg).append("</span><br/><br/>");
			buf.append("<input type='button' onclick='window.history.back()' value='返回'/></body></html>");
		}
		try
		{
			OutputStream out = response.getOutputStream();
			out.write(buf.toString().getBytes("UTF-8"));
			out.flush();
			out.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
