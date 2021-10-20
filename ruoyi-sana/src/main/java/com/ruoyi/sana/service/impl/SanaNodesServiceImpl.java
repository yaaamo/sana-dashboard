package com.ruoyi.sana.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.sana.mapper.SanaNodesMapper;
import com.ruoyi.sana.domain.SanaNodes;
import com.ruoyi.sana.service.ISanaNodesService;
import com.ruoyi.common.core.text.Convert;

/**
 * sana配置Service业务层处理
 * 
 * @author tiger.w
 * @date 2021-10-20
 */
@Service
public class SanaNodesServiceImpl implements ISanaNodesService 
{
    @Autowired
    private SanaNodesMapper sanaNodesMapper;

    /**
     * 查询sana配置
     * 
     * @param id sana配置主键
     * @return sana配置
     */
    @Override
    public SanaNodes selectSanaNodesById(Long id)
    {
        return sanaNodesMapper.selectSanaNodesById(id);
    }

    /**
     * 查询sana配置列表
     * 
     * @param sanaNodes sana配置
     * @return sana配置
     */
    @Override
    public List<SanaNodes> selectSanaNodesList(SanaNodes sanaNodes)
    {
        return sanaNodesMapper.selectSanaNodesList(sanaNodes);
    }

    /**
     * 新增sana配置
     * 
     * @param sanaNodes sana配置
     * @return 结果
     */
    @Override
    public int insertSanaNodes(SanaNodes sanaNodes)
    {
        sanaNodes.setCreateTime(DateUtils.getNowDate());
        return sanaNodesMapper.insertSanaNodes(sanaNodes);
    }

    /**
     * 修改sana配置
     * 
     * @param sanaNodes sana配置
     * @return 结果
     */
    @Override
    public int updateSanaNodes(SanaNodes sanaNodes)
    {
        return sanaNodesMapper.updateSanaNodes(sanaNodes);
    }

    /**
     * 批量删除sana配置
     * 
     * @param ids 需要删除的sana配置主键
     * @return 结果
     */
    @Override
    public int deleteSanaNodesByIds(String ids)
    {
        return sanaNodesMapper.deleteSanaNodesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除sana配置信息
     * 
     * @param id sana配置主键
     * @return 结果
     */
    @Override
    public int deleteSanaNodesById(Long id)
    {
        return sanaNodesMapper.deleteSanaNodesById(id);
    }
}
