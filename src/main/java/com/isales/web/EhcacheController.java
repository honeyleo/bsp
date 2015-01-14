package com.isales.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.CacheManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsp.core.web.AppContext;

@Controller
@RequestMapping("ehcache")
public class EhcacheController {
	
	@RequestMapping("list.html")
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		CacheManager cacheManager = AppContext.getBean(CacheManager.class);
		req.setAttribute("ischeck", "1");
		String[] names = cacheManager.getCacheNames();
		System.out.println(names);
		req.setAttribute("cm", cacheManager);
		return "/ehcache-list";
	}
	
	@RequestMapping("/test1")
	@ResponseBody
	public Object test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "廖鹏");
		return map;
	}
}
