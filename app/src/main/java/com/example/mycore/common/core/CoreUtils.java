package com.example.mycore.common.core;

import android.view.LayoutInflater;

import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public class CoreUtils {
    public static <T> Class<T> getGenericSuperclass(Class<?> clazz, int position) {
        return (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[position];
    }

    public static <T extends ViewBinding> T getViewBinding(Class<?> clazz, LayoutInflater inflater, int genericClassIndex) {
        try {
            Class<T> bindingClass = getGenericSuperclass(clazz, genericClassIndex);
            Method method = bindingClass.getMethod("inflate", LayoutInflater.class);
            return (T) method.invoke(null, inflater);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
