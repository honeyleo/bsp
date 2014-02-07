package net.bsp.manager.service.impl;

import java.util.List;

import net.bsp.manager.dao.RoleDefaultMenuDAO;
import net.bsp.manager.model.Menu;
import net.bsp.manager.model.Role;
import net.bsp.manager.model.RoleDefaultMenu;
import net.bsp.manager.service.RoleDefaultMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDefaultMenuServiceImpl implements RoleDefaultMenuService {

    @Autowired
    private RoleDefaultMenuDAO roleDefaultMenuDAO;
    
    @Override
    public List<Menu> getMenuListByRoleId(Long roleId) {
        return roleDefaultMenuDAO.selectMenuListByRoleId(roleId);
    }

    @Override
    public void add(RoleDefaultMenu record) {
        roleDefaultMenuDAO.insert(record);
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        roleDefaultMenuDAO.deleteByRoleId(roleId);
    }

    @Override
    public void deleteByMenuId(Long menuId) {
        roleDefaultMenuDAO.deleteByMenuId(menuId);
    }

    @Override
    public void saveDefaultMenus(Role role, List<Long> menuIds) {
        this.deleteByRoleId(role.getId());
        RoleDefaultMenu record=new RoleDefaultMenu();
        record.setRoleId(role.getId());
        for(Long mid:menuIds){
            record.setMenuId(mid);
            this.add(record);
        }
    }

}
