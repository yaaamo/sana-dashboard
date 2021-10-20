package com.ruoyi.test;

import com.alibaba.fastjson.JSON;
import com.dtflys.forest.Forest;
import com.ruoyi.sana.rmi.MineStatus;
import com.ruoyi.sana.rmi.SanaApi;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @describe: TODO
 * @author: tiger.w
 * @date: 2021/10/20 11:53
 */
public class RmiTest extends BaseTest{
    @Autowired
    private SanaApi sanaApi;
    /**
     * 提现 /mine/withdraw
     * 状态 /mine/status
     * /mine/cashdeposit
     * /mine/unfreeze
     */

    @Test
    public  void status(){
        MineStatus status = sanaApi.status("http://120.79.4.84:3653");
        System.out.println(JSON.toJSONString(status,true));
    }
}
