package com.ruoyi.sana.service;

import com.ruoyi.sana.domain.SanaNodes;
import com.ruoyi.sana.rmi.SanaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: TODO
 * @author: tiger.w
 * @date: 2021/10/20 13:14
 */
@Service
public class SanaDashboardService {
    @Autowired
    private ISanaNodesService sanaNodesService;
    @Autowired
    private SanaApi sanaApi;
    public List<SanaNodes> nodesList(SanaNodes sanaNodes){
        List<SanaNodes> nodes = sanaNodesService.selectSanaNodesList(sanaNodes);
        for(SanaNodes node : nodes){
            node.setMineStatus(sanaApi.status(node.getDebugApiEndpoint()));
        }
        return nodes;
    }

    public String withdraw(Integer id){
        SanaNodes node =    sanaNodesService.selectSanaNodesById(id.longValue());
        String hash = sanaApi.withdraw(node.getDebugApiEndpoint());
        return  hash;
    }

    public String withdrawAll(){
        List<SanaNodes> nodes = sanaNodesService.selectSanaNodesList(null);
        for(SanaNodes node : nodes){
            withdraw(node.getId().intValue());
        }
        return  "";
    }
}
