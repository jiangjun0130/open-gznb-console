package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.SystemInterface;
import com.gznb.open.domain.custom.SystemInterfaceCustom;
import com.gznb.open.domain.vo.SystemInterfaceVo;
import java.util.List;

public interface SystemInterfaceMapperCustom {

    /**
     * 获取分页数据
     * @param vo
     * @return
     */
    List<SystemInterfaceCustom> getPagedData(SystemInterfaceVo vo);

    /**
     * 获取记录数
     * @param vo
     * @return
     */
    Integer getRecordCount(SystemInterfaceVo vo);

    /**
     * 根据id获取接口信息
     * @param id
     * @return
     */
    SystemInterfaceCustom getDataById(Integer id);

    /**
     * 返回插入数据库后的主键id
     * @param record
     * @return
     */
    int insertSelective(SystemInterface record);

}