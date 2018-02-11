package com.gznb.open.core.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;

/**
 * 抽象controller基类
 *
 * Created by jj02 on 2017/3/7.
 */
public abstract class AbstractController<T>{

    protected Logger logger = null;

    /**
     * 实例化子类对应的logger
     */
    public AbstractController() {
        try {
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
            logger = LoggerFactory.getLogger(clazz);
        } catch (Exception e) {
            logger = LoggerFactory.getLogger(AbstractController.class);
            logger.error("BaseController获取子类类型异常！", e);
            throw new RuntimeException("BaseController获取子类类型异常！", e);
        }
    }

}
