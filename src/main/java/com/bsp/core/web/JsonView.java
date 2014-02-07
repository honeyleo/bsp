package com.bsp.core.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.alibaba.fastjson.JSON;


/**
 * 自定义JSON输出格式
 * 
 * 
 */
public class JsonView extends AbstractView
{

	private static final String jsonContentType = "application/json; charset=UTF-8";

	public static final String JSON_ROOT = "data";
	
	public static final JsonView JSON_VIEW = new JsonView();
	/**
	 * 该View对应的输出类型
	 */
	public String getContentType()
	{
		return jsonContentType;
	}

	/**
	 * 输出JSON数据
	 * 
	 * @param response
	 * @param message JSON字符串
	 */
	public static void writeJSONData(HttpServletResponse response, String message)
	{
		response.setContentType(jsonContentType);
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			out.println(message);
			out.flush();
		}
		catch (IOException e)
		{
		}
		finally
		{
			if (out != null)
			{
				out.close();
				out = null;
			}
		}
	}

	@Override
	protected void renderMergedOutputModel(@SuppressWarnings("rawtypes") Map model, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		Object res = model.get(JSON_ROOT);
		String jsonStr = JSON.toJSONString(res);
		writeJSONData(response, jsonStr);
	}

}
