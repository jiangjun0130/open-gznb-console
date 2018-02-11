package com.gznb.open.dao.mybatis.custom;

import com.gznb.open.domain.SystemEncryptWithBLOBs;
import com.gznb.open.domain.custom.SystemEncryptCustom;
import com.gznb.open.domain.vo.api.SysPlatformEncryptVo;
import java.util.List;

/**
 * Created by zhenglin on 2017/10/25.
 */
public interface SystemEncryptMapperCustom {

    /**
     * 批量插入
     * @param recordList
     * @return
     * @throws Exception
     */
    int insertBatch(List<SystemEncryptWithBLOBs> recordList);

    /**
     * 获取业务系统公钥信息
     * @param vo
     * @return
     */
    SystemEncryptCustom getSysPlatformPrivateEncrypt(SysPlatformEncryptVo vo);
}
