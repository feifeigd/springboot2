package com.d7kj.format;

// import org.apache.commons.lang3.StringEscapeUtils;
import org.beetl.core.Format;
import org.apache.commons.text.StringEscapeUtils;

/// 防止XSS攻击
public class XXSDefenderFormat implements Format {

	// 使用
	// ${"<script>alert(8)</script>", xss}
	@Override
	public Object format(Object data, String pattern) {
		if(data instanceof String) {
			String js = (String)data;
			//String str = StringEscapeUtils.escapeJavaScript(js);
			String str = StringEscapeUtils.escapeEcmaScript(js);
			return str;
		}
		return data;
	}
}
