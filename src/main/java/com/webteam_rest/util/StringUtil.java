package com.webteam_rest.util;

import java.util.UUID;

public class StringUtil {
	public String getUniqueString() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
