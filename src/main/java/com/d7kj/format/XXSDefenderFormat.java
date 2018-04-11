package com.d7kj.format;

import org.apache.commons.lang.StringEscapeUtils;
import org.beetl.core.Format;

/// 防止XSS攻击
public class XXSDefenderFormat implements Format {

	@Override
	public Object format(Object data, String pattern) {
		if(data instanceof String) {
			String js = (String)data;
			String str = StringEscapeUtils.escapeJavaScript(js);
			return str;
		}
		return data;
	}
}
