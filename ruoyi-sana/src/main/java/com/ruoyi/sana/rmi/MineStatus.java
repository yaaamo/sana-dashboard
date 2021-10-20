package com.ruoyi.sana.rmi;

import lombok.Data;

/**
 * @describe: TODO
 * @author: tiger.w
 * @date: 2021/10/20 12:01
 */
//除以7个0
@Data
public class MineStatus {
    private boolean work = false;
    private boolean freeze = false;
    //Received rewards
    private String reward;
    //Unclaimed awards
    private String pending;
    //过期时间，秒
    private String expire;
    //Amount of SANA deposits
    private String deposit;

}
