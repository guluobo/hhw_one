package com.hwhongdb.file.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FillBeanUtil {

	public static <T> T fillBean(HttpServletRequest request,Class<T> clazz){
		try {
			T bean = clazz.newInstance();
			BeanUtils.copyProperties(bean, request.getParameterMap());
			return bean;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> void setProperty(T bean,String name,String value) {
		try {
			BeanUtils.copyProperty(bean, name, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
