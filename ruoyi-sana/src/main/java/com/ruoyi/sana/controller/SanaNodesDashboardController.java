package com.ruoyi.sana.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sana.domain.SanaNodes;
import com.ruoyi.sana.service.SanaDashboardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @describe: TODO
 * @author: tiger.w
 * @date: 2021/10/20 13:11
 */
@Controller
@RequestMapping("/sana/dashboard")
public class SanaNodesDashboardController extends BaseController {
    @Autowired
    private SanaDashboardService sanaDashboardService;

    private String prefix = "sana/dashboard";

    @RequiresPermissions("sana:dashboard:view")
    @GetMapping()
    public String nodes() {
        return prefix + "/nodes";
    }

    /**
     * 查询sana配置列表
     */
    @RequiresPermissions("sana:dashboard:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SanaNodes sanaNodes) {
        startPage();
        List<SanaNodes> list = sanaDashboardService.nodesList(sanaNodes);
        return getDataTable(list);
    }

    @RequiresPermissions("sana:dashboard:view")
    @Log(title = "sana提现", businessType = BusinessType.EXPORT)
    @GetMapping("/withdraw")
    @ResponseBody
    public AjaxResult withdraw(Integer id) {
        String hash = sanaDashboardService.withdraw(id);
        return toAjax(hash != null && hash.contains("hash"));
    }
    @RequiresPermissions("sana:dashboard:view")
    @Log(title = "sana提现", businessType = BusinessType.EXPORT)
    @GetMapping("/withdrawAll")
    @ResponseBody
    public AjaxResult withdrawAll() {
        String hash = sanaDashboardService.withdrawAll();
        return toAjax(true);
    }
}
