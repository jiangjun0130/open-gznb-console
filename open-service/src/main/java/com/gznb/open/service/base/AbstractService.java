package com.gznb.open.service.base;

import com.gznb.open.domain.vo.base.BaseQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;

/**
 * 抽象服务基类
 *
 * Created by jj02 on 2017/3/7.
 */
public abstract class AbstractService<T> {

    protected Logger logger = null;

    public AbstractService(){
        try {
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
            logger = LoggerFactory.getLogger(clazz);
        }catch (Exception e){
            throw new RuntimeException("AbstractService获取子类类型异常！");
        }
    }

    /**
     * 计算startIndex
     * @param vo
     * @return
     */
    public BaseQueryVo calculateStartIndex(BaseQueryVo vo){
        int startIndex = (vo.getPageBean().getCurrentPage() - 1)
                * vo.getPageBean().getPageSize();
        vo.getPageBean().setStartIndex(startIndex);
        return vo;
    }

}
