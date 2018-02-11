package com.gznb.open.domain.custom;

import com.gznb.open.domain.BusSystemApplyRecord;
import com.gznb.open.domain.BusinessPlatform;
import com.gznb.open.domain.BusinessPlatformMerchant;
import com.gznb.open.domain.vo.BusSystemApplyRecordVo;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 业务系统——我的应用
 * Created by kl09 on 2017/6/30.
 */
public class BusinessPlatformCustom extends BusinessPlatform implements Serializable {

    /**
     * 已申请接口记录
     */
    private List<BusSystemApplyRecordCustom> busSystemApplyRecords;

    /**
     * 商户集合
     */
    private List<BusinessPlatformMerchant> merchants;

    /**
     * 系统平台集合
     */
    private List<SystemPlatformWithEntry> systemPlatforms;

    public List<BusSystemApplyRecordCustom> getBusSystemApplyRecords() {
        return busSystemApplyRecords;
    }

    public void setBusSystemApplyRecords(List<BusSystemApplyRecordCustom> busSystemApplyRecords) {
        this.busSystemApplyRecords = busSystemApplyRecords;
    }

    public List<BusinessPlatformMerchant> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<BusinessPlatformMerchant> merchants) {
        this.merchants = merchants;
    }

    public List<SystemPlatformWithEntry> getSystemPlatforms() {
        return systemPlatforms;
    }

    public void setSystemPlatforms(List<SystemPlatformWithEntry> systemPlatforms) {
        this.systemPlatforms = systemPlatforms;
    }
}
