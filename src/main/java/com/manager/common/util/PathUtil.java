package com.manager.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PathUtil
{
	private static String accessLogDir;

	private static String accessLogDirWindows;

	private static boolean isLinux;

	static
	{
		String os = System.getProperty("os.name");
		if (os != null && os.toUpperCase().indexOf("LINUX") > -1)
		{
			isLinux = true;
		}
		else
		{
			isLinux = false;
		}
	}

	/**
	 * 访问日志路径
	 * 
	 * @param dateStr
	 * @return String
	 */
	public static String getAccessLogPath(String dateStr)
	{
		if (isLinux)
		{
			return accessLogDir + "access_log_" + dateStr + ".txt";
		}
		else
		{
			return accessLogDirWindows + "access_log_" + dateStr + ".txt";
		}
	}


	@Value("#{moduleProperties.getProperty('accessLogDir')}")
	public void setAccessLogDir(String accessLogDir)
	{
		PathUtil.accessLogDir = accessLogDir;
	}

	@Value("#{moduleProperties.getProperty('accessLogDirWindows')}")
	public void setAccessLogDirWindows(String accessLogDirWindows)
	{
		PathUtil.accessLogDirWindows = accessLogDirWindows;
	}


}
