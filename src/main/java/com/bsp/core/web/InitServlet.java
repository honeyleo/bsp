package com.bsp.core.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 系统初始化完成时调用初始化一些应用的工作
 * @author liaopeng2008@gmail.com
 * @since 2011-12-20
 */
@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {
	
	private final static Logger log = LoggerFactory.getLogger(InitServlet.class.getName());
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		log.info("systemt init finished......");
	}
	
}
