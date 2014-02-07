package net.bsp.manager.web.system;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bsp.common.Constants;
import net.bsp.common.exception.AdminException;
import net.bsp.common.util.DwzJsonUtil;
import net.bsp.common.util.RequestUtil;
import net.bsp.manager.model.Menu;
import net.bsp.manager.service.MenuService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/manager/system/menu")
public class MenuController implements Constants {

    @Resource
    private MenuService menuService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request) throws AdminException {
//        Integer typeId=RequestUtil.getInteger(request, "type");
        List<Menu> menus=menuService.findMenuList();
        request.setAttribute("menus", menus);
        return "/manager/system/menu/menu_list";
    }

    @RequestMapping("/goedit")
    public String goEditor(HttpServletRequest request, HttpServletResponse response) throws AdminException {
        Long id=RequestUtil.getLong(request, "id");
        if(null != id) {
            Menu menu=menuService.getById(id);
            request.setAttribute("menu", menu);
        }
        return "/manager/system/menu/menu_edit";
    }

    @RequestMapping("/goselect")
    public String goSelect(HttpServletRequest request, HttpServletResponse response) throws AdminException {
//        Integer typeId=RequestUtil.getInteger(request, "type");
        List<Menu> menus=menuService.findMenuList();
        request.setAttribute("menus", menus);
        return "/manager/system/menu/menu_select";
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request) throws AdminException {
        Long id=RequestUtil.getLong(request, "id");
        String name=RequestUtil.getString(request, "name");
        Integer type=RequestUtil.getInteger(request, "type");
        Long parentId=RequestUtil.getLong(request, "parentId");
        String lcode=RequestUtil.getString(request, "parentIdPath");
        Integer orderNo=RequestUtil.getInteger(request, "orderNo");
        String url=RequestUtil.getString(request, "url");
        String remark=RequestUtil.getString(request, "remark");
        Integer onMenu = RequestUtil.getInteger(request, "onMenu");
        Menu record=new Menu();
        record.setId(id);
        record.setName(name);
        record.setType(type);
        record.setParentId(parentId);
        record.setParentIdPath(lcode);
        record.setOrderNo(orderNo);
        record.setRemark(remark);
        record.setUrl(url);
        record.setState(1);
        record.setOnMenu(onMenu);
        menuService.save(record);
        return new ModelAndView(JSON_VIEW, JSON_ROOT, DwzJsonUtil.getOkStatusMsg("更新成功"));
    }

    @RequestMapping("/del")
    public String deleteTreeNode(HttpServletRequest request) throws AdminException {
        List<Long> menuIds=RequestUtil.getLongs(request, "treecheckbox");
        if(null == menuIds || menuIds.isEmpty()) {
            throw new AdminException("请选择要删除的节点！");
        }
        for(Long menuId: menuIds) {
            menuService.deleteById(menuId);
        }
        return list(request);
    }
}
