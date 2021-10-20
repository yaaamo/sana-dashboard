package com.ruoyi.sana.domain;

import com.ruoyi.sana.rmi.MineStatus;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * sana配置对象 sana_nodes
 * 
 * @author tiger.w
 * @date 2021-10-20
 */
@Data
public class SanaNodes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** Dashboard Authrization */
    @Excel(name = "Dashboard Authrization")
    private String dashboardAuth;

    /** api endpoint */
    @Excel(name = "api endpoint")
    private String apiEndpoint;

    /** debug api endpoint */
    @Excel(name = "debug api endpoint")
    private String debugApiEndpoint;

    private MineStatus mineStatus;
}
