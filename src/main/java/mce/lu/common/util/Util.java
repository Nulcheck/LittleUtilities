package mce.lu.common.util;

import java.lang.reflect.Field;
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

	public static void setMethod(Class<?> clazz, String methodName, boolean bool) {
		try {
			Field classField = clazz.getField(methodName);
			classField.setBoolean(clazz, bool);
		} catch (NoSuchFieldException err) {
			err.printStackTrace();
		} catch (IllegalAccessException err) {
			err.printStackTrace();
		}
	}
	
	public static void setMethod(Class<?> clazz, String methodName, int integer) {
		try {
			Field classField = clazz.getField(methodName);
			classField.setInt(clazz, integer);
		} catch (NoSuchFieldException err) {
			err.printStackTrace();
		} catch (IllegalAccessException err) {
			err.printStackTrace();
		}
	}
}
