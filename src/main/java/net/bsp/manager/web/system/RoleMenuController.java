package net.bsp.manager.web.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bsp.common.Constants;
import net.bsp.common.exception.AdminException;
import net.bsp.common.util.DwzJsonUtil;
import net.bsp.common.util.RequestUtil;
import net.bsp.manager.model.Menu;
import net.bsp.manager.model.Role;
import net.bsp.manager.service.MenuService;
import net.bsp.manager.service.RoleDefaultMenuService;
import net.bsp.manager.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manager/system/role_menu")
public class RoleMenuController implements Constants
{

    @Autowired
	private MenuService menuService;

    @Autowired
	private RoleService roleService;
	
    @Autowired
	private RoleDefaultMenuService roleDefaultMenuService;

	@RequestMapping("/list")
	public String listSystemMenus(HttpServletRequest request, HttpServletResponse response) throws AdminException
	{
		Long roleId = RequestUtil.getLong(request, "roleId");
		Role role=roleService.getById(roleId);
		if (null == role)
		{
			throw new AdminException("角色不存在！");
		}
		
		List<Menu> menus = menuService.findMenuList();
		List<Menu> roleMenus = roleDefaultMenuService.getMenuListByRoleId(roleId);
		List<Long> roleMenuIds = new ArrayList<Long>();
		for (Menu menu : roleMenus)
		{
		    roleMenuIds.add(menu.getId());
		}
		request.setAttribute("menus", menus);
		request.setAttribute("roleMenuIds", roleMenuIds);
		return "/manager/system/role/role_menu_list";
	}

	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request) throws AdminException
	{
		Long roleId = RequestUtil.getLong(request, "roleId");
		List<Long> menuIds = RequestUtil.getLongs(request, "treecheckbox");
		if (null == roleId || roleId <= 0)
		{
			throw new AdminException("非法操作！");
		}
		if (null == menuIds || menuIds.isEmpty())
        {
            throw new AdminException("请选择要保存的节点！");
        }
		Role role = roleService.getById(roleId);
		if (null == role)
		{
			throw new AdminException("用户不存在！");
		}
		roleDefaultMenuService.saveDefaultMenus(role, menuIds); // 更新权限菜单
		return new ModelAndView(JSON_VIEW, JSON_ROOT, DwzJsonUtil.getOkStatusMsg(null));
	}
}
