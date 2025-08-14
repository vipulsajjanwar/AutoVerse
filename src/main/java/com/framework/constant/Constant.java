package com.framework.constant;

import com.framework.config.ReadConfig;

public class Constant {

	private static ReadConfig readconfig = new ReadConfig("");
	
	public static final long  PAGE_LOAD_TIMEOUT = Integer.parseInt(readconfig.pageLoadTimeout());
}
