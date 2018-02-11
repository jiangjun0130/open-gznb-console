package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.BusSystemAccess;
import com.gznb.open.domain.custom.BusSystemAccessCustom;
import com.gznb.open.domain.vo.BusSystemAccessVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kl09 on 2017/6/30.
 */
public interface BusSystemAccessMapperCustom {
    /**
     * 查询该用户的所有接入信息
     *
     * @param vo 查询条件以及分页
     * @return 接入记录集合
     */
    List<BusSystemAccessCustom> getPagedData(BusSystemAccessVo vo);

    /**
     * 查询总记录数
     *
     * @param busSystemAccessVo
     * @return
     */
    Integer getRecordCount(BusSystemAccessVo busSystemAccessVo);
}
