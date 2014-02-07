package net.bsp.manager.dao;

import java.util.List;

import net.bsp.manager.model.Criteria;
import net.bsp.manager.model.Role;

public interface RoleDAO {
    /**
     * 根据条件查询记录总数
     */
    int countByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Role record);

    /**
     * 根据条件查询记录集
     */
    List<Role> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    Role selectByPrimaryKey(Long id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Role record);

}