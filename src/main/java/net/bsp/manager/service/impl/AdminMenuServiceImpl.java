package net.bsp.manager.service.impl;

import java.util.List;

import net.bsp.manager.dao.AdminMenuDAO;
import net.bsp.manager.model.Admin;
import net.bsp.manager.model.AdminMenu;
import net.bsp.manager.model.Menu;
import net.bsp.manager.service.AdminMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMenuServiceImpl implements AdminMenuService
{
	@Autowired
	private AdminMenuDAO adminMenuDAO;

    @Override
    public List<Menu> getMeneListByAdminId(Long adminId) {
        return adminMenuDAO.selectMenuListByAdminId(adminId);
    }

    @Override
    public void add(Long adminId, Long menuId) {
        AdminMenu record=new AdminMenu();
        record.setAdminId(adminId);
        record.setMenuId(menuId);
        adminMenuDAO.insert(record);
    }

    @Override
    public void deleteByAdminId(Long adminId) {
        adminMenuDAO.deleteByAdminId(adminId);
    }

    @Override
    public void deleteByMenuId(Long menuId) {
        adminMenuDAO.deleteByMenuId(menuId);
    }

    @Override
    public void saveAdminMenus(Admin admin, List<Long> menuIds) {
        this.deleteByAdminId(admin.getId());
        for(Long menuId:menuIds){
            this.add(admin.getId(), menuId);
        }
    }

    @Override
    public void addAdminDefaultMenu(Long adminId, Long roleId) {
        adminMenuDAO.insertAdminDefaultMenu(adminId, roleId);        
    }
	
}
