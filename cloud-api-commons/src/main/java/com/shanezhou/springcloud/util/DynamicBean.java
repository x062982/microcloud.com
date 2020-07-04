package com.shanezhou.springcloud.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author ZhouWX
 * @createDate 2020/7/3
 */
@Data
@AllArgsConstructor
public class DynamicBean implements Serializable {

    private Object object = null;   // 动态生成的类
    private BeanMap beanMap = null; // 存放属性以及属性类型

    public DynamicBean() {
        super();
    }

    @SuppressWarnings("DynamicBean创建错误")
    public DynamicBean(Map propertyMap) {
        this.object = generateBean(propertyMap);
        this.beanMap = BeanMap.create(this.object);
    }

    public void setValue(Object key, Object value) {
        this.beanMap.put(key,value);
    }

    public Object getValue(Object key) {
        return this.beanMap.get(key);
    }

    public Object getObject() {
        return this.object;
    }

    @SuppressWarnings("DynamicBean创建错误")
    private Object generateBean(Map propertyMap) {
        BeanGenerator generator = new BeanGenerator();
        Set keys = propertyMap.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            generator.addProperty(key, (Class)propertyMap.get(key));
        }
        return generator.create();
    }



}
