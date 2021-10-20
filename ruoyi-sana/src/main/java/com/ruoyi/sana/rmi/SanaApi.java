package com.ruoyi.sana.rmi;

import com.dtflys.forest.Forest;
import org.springframework.stereotype.Service;

/**
 * @describe: TODO
 * @author: tiger.w
 * @date: 2021/10/20 12:54
 */
@Service
public class SanaApi {
    /**
     * 提现 /mine/withdraw
     * 状态 /mine/status
     * /mine/cashdeposit
     * /mine/unfreeze
     */


    public String withdraw(String url) {
        return Forest.post(url + "/mine/withdraw").executeAsString();
    }

    public MineStatus status(String url) {
        MineStatus status = Forest.get(url + "/mine/status").execute(MineStatus.class);
        return status;
    }
    public String unfreeze(String url) {
        return Forest.get(url + "/mine/unfreeze").executeAsString();
    }

    public String cashdeposit(String url) {
        return Forest.get(url + "/mine/cashdeposit").executeAsString();
    }
}
