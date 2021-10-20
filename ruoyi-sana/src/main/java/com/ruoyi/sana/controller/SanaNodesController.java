package com.ruoyi.sana.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sana.domain.SanaNodes;
import com.ruoyi.sana.service.ISanaNodesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * sana配置Controller
 * 
 * @author tiger.w
 * @date 2021-10-20
 */
@Controller
@RequestMapping("/sana/nodes")
public class SanaNodesController extends BaseController
{
    private String prefix = "sana/nodes";

    @Autowired
    private ISanaNodesService sanaNodesService;

    @RequiresPermissions("sana:nodes:view")
    @GetMapping()
    public String nodes()
    {
        return prefix + "/nodes";
    }

    /**
     * 查询sana配置列表
     */
    @RequiresPermissions("sana:nodes:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SanaNodes sanaNodes)
    {
        startPage();
        List<SanaNodes> list = sanaNodesService.selectSanaNodesList(sanaNodes);
        return getDataTable(list);
    }

    /**
     * 导出sana配置列表
     */
    @RequiresPermissions("sana:nodes:export")
    @Log(title = "sana配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SanaNodes sanaNodes)
    {
        List<SanaNodes> list = sanaNodesService.selectSanaNodesList(sanaNodes);
        ExcelUtil<SanaNodes> util = new ExcelUtil<SanaNodes>(SanaNodes.class);
        return util.exportExcel(list, "sana配置数据");
    }

    /**
     * 新增sana配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存sana配置
     */
    @RequiresPermissions("sana:nodes:add")
    @Log(title = "sana配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SanaNodes sanaNodes)
    {
        return toAjax(sanaNodesService.insertSanaNodes(sanaNodes));
    }

    /**
     * 修改sana配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SanaNodes sanaNodes = sanaNodesService.selectSanaNodesById(id);
        mmap.put("sanaNodes", sanaNodes);
        return prefix + "/edit";
    }

    /**
     * 修改保存sana配置
     */
    @RequiresPermissions("sana:nodes:edit")
    @Log(title = "sana配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SanaNodes sanaNodes)
    {
        return toAjax(sanaNodesService.updateSanaNodes(sanaNodes));
    }

    /**
     * 删除sana配置
     */
    @RequiresPermissions("sana:nodes:remove")
    @Log(title = "sana配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sanaNodesService.deleteSanaNodesByIds(ids));
    }
}
