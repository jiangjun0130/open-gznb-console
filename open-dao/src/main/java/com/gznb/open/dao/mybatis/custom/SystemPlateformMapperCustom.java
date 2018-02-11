package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.SystemPlatform;
import com.gznb.open.domain.custom.SystemPlantformDicCustom;
import com.gznb.open.domain.custom.SystemPlatformCustom;
import com.gznb.open.domain.custom.SystemPlatformDicCatalogCustom;
import com.gznb.open.domain.vo.SystemModuleVo;
import com.gznb.open.domain.vo.SystemPlatformVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemPlateformMapperCustom {

    /**
     * 获取分页数据
     * @param vo
     * @return
     */
    List<SystemPlatformCustom> getPagedData(SystemPlatformVo vo);

    /**
     * 获取记录数
     * @param vo
     * @return
     */
    Integer getRecordCount(SystemPlatformVo vo);
    /**
     * 根据id查询平台数据字典信息
     */
    List<SystemPlatformDicCatalogCustom> getDatadictionaryById(SystemModuleVo vo);

    /**
     * 获取平台字典记录数
     */
    Integer getDicCount(SystemModuleVo vo);
    List<SystemPlantformDicCustom> getDatadictionaryByType(SystemPlantformDicCustom vo);

    /**
     * 添加系统平台，返回主键
     * @param systemPlatform
     * @return
     */
    Integer insertSelectiveCustom(SystemPlatform systemPlatform);
}