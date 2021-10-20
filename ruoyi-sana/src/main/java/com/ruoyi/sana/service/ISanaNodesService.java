package com.ruoyi.sana.service;

import java.util.List;
import com.ruoyi.sana.domain.SanaNodes;

/**
 * sana配置Service接口
 * 
 * @author tiger.w
 * @date 2021-10-20
 */
public interface ISanaNodesService 
{
    /**
     * 查询sana配置
     * 
     * @param id sana配置主键
     * @return sana配置
     */
    public SanaNodes selectSanaNodesById(Long id);

    /**
     * 查询sana配置列表
     * 
     * @param sanaNodes sana配置
     * @return sana配置集合
     */
    public List<SanaNodes> selectSanaNodesList(SanaNodes sanaNodes);

    /**
     * 新增sana配置
     * 
     * @param sanaNodes sana配置
     * @return 结果
     */
    public int insertSanaNodes(SanaNodes sanaNodes);

    /**
     * 修改sana配置
     * 
     * @param sanaNodes sana配置
     * @return 结果
     */
    public int updateSanaNodes(SanaNodes sanaNodes);

    /**
     * 批量删除sana配置
     * 
     * @param ids 需要删除的sana配置主键集合
     * @return 结果
     */
    public int deleteSanaNodesByIds(String ids);

    /**
     * 删除sana配置信息
     * 
     * @param id sana配置主键
     * @return 结果
     */
    public int deleteSanaNodesById(Long id);
}
