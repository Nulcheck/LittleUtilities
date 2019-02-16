package mce.lu.common.util;

import java.lang.reflect.Method;

public class Util {
	public static boolean doesMethodExist(Class<?> clazz, String methodName) {
		boolean result = false;
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.getName().equals(methodName)) {
				result = true;
				break;
			}
		}
		return result;
	}
}
