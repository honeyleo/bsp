package com.manager.web.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.manager.common.Constants;
import com.manager.common.exception.AdminException;
import com.manager.common.util.DwzJsonUtil;
import com.manager.common.util.MessageDigestUtil;
import com.manager.common.util.RequestUtil;
import com.manager.common.web.Funcs;
import com.manager.model.Admin;
import com.manager.model.LoginAccount;
import com.manager.model.Menu;
import com.manager.model.type.StateType;
import com.manager.service.AdminMenuService;
import com.manager.service.AdminService;
import com.manager.service.MenuService;

@Controller
@RequestMapping("/manager")
public class AdminLoginController implements Constants {

    private static final String ADMIN_LOGIN = "/manager/common/login_admin";

    private static final String INDEX = "/manager/common/index";

    private static final String LOGIN_DIALOG = "/manager/common/login_dialog";
    

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMenuService adminMenuService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request) throws AdminException {
        LoginAccount account = Funcs.getSessionLoginAccount(request.getSession());
        List<Menu> menus = adminMenuService.getMeneListByAdminId(account.getUser().getId());
        account.setMenus(menus);
        request.setAttribute("menus", menus);
        return INDEX;
    }

    @RequestMapping("/adm_login")
    public String login() throws AdminException {
        return ADMIN_LOGIN;
    }

    @RequestMapping("/dologin")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws AdminException {
        try {
            doLogin(request, response);
        } catch (AdminException ex) {
            String errorMsg = ex.getMessage();
            if (RequestUtil.isAjax(request)) {
                return new ModelAndView(JSON_VIEW, JSON_ROOT,
                        DwzJsonUtil.getErrorStatusMsg(errorMsg));
            } else {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("loginErrInfo", errorMsg);
                return new ModelAndView(ADMIN_LOGIN, "model", model);
            }
        }
        if (RequestUtil.isAjax(request)) {
            return new ModelAndView(JSON_VIEW, JSON_ROOT,
                    DwzJsonUtil.getOkStatusMsg(null));
        } else {
            return new ModelAndView(new RedirectView(request.getContextPath() + "/manager/index"), "model", null);
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws AdminException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            password = MessageDigestUtil.getSHA256(password).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == username || username.trim().length() == 0
                || null == password || password.length() == 0) {
            throw new AdminException("请填写用户名和密码！");
        }
        LoginAccount account = getAdminLoginUser(username);
        Admin user = account.getUser();
        if (user == null) {
            throw new AdminException("查无此用户！");
        }
        if (user.getState().equals(StateType.INACTIVE)) {
            throw new AdminException("该用户已停用！");
        }
        if (!password.equals(user.getPassword())) {
            throw new AdminException("密码不正确！");
        }
        request.getSession().setAttribute(SESSION_LOGIN_USER, account);
    }
    
    private LoginAccount getAdminLoginUser(String username){
        Admin admin = adminService.findByUsername(username);
        if(admin == null){
            return null;
        }
        LoginAccount account = new LoginAccount();
        Admin user = new Admin();
        user.setId(admin.getId());
        user.setUsername(admin.getUsername());
        user.setPassword(admin.getPassword());
        user.setRealName(admin.getRealName());
        user.setEmail(admin.getEmail());
        user.setRoleId(admin.getRoleId());
        user.setState(admin.getState());
        user.setOperatorId(admin.getOperatorId());
        account.setUser(user);

        return account;
    }

    @RequestMapping("/login_dialog")
    public String loginDialog(HttpServletRequest request, HttpSession session) {
    	LoginAccount user = Funcs.getSessionLoginAccount(request.getSession());
        if(user != null){
            request.setAttribute("userType", 1);
        }
        return LOGIN_DIALOG;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(SESSION_LOGIN_USER);
        session.invalidate();
        return ADMIN_LOGIN;
    }
    

}
