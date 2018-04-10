package com.d7kj.util;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.stereotype.Component;

@Component
public class SimpleFunction implements Function {

	@Override
	public String call(Object[] paras, Context ctx) {
		Object o = paras[0];
		if(o != null) {
			try {
				ctx.byteWriter.writeString(o.toString());
			}catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
		return "";
	}

}
