package net.bsp.manager.service;

import java.util.List;

import net.bsp.manager.model.Menu;

public interface MenuService {
    /**
     * 插入或更新记录
     */
    int save(Menu record);

    /**
     * 根据主键查询记录
     */
    Menu getById(Long id);
    
    /**
     * 根据主键查询记录
     */
    Menu getByIdInCache(Long id);
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByIdSelective(Menu record);
    
    /**
     * 删除节点
     * @param id
     */
    void deleteById(Long id);
    
    List<Menu> findMenuList();

}