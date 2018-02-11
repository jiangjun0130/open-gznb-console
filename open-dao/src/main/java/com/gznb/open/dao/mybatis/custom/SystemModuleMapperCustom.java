package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.custom.SystemModuleCustom;
import com.gznb.open.domain.vo.SystemModuleVo;
import java.util.List;

public interface SystemModuleMapperCustom {

    /**
     * 获取分页数据
     * @param vo
     * @return
     */
    List<SystemModuleCustom> getPagedData(SystemModuleVo vo);

    /**
     * 获取记录数
     * @param vo
     * @return
     */
    Integer getRecordCount(SystemModuleVo vo);

    /**
     * 根据平台标识获取对应模块列表下接口列表信息
     * @param platformId
     * @return
     */
    List<SystemModuleCustom> queryModuleAndInterfaceListByPlatformId(Integer platformId);

}