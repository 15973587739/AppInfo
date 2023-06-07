package cn.apps.controller;

import cn.apps.pojo.BackendUser;
import cn.apps.pojo.DevUser;
import cn.apps.service.BackendUserService;
import cn.apps.utils.Constants;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/6/7 10:31
 **/
@Controller
@RequestMapping(value = "/manager")
public class BackController {
    private Logger logger = Logger.getLogger(BackController.class);

    /**
     * 服务对象
     */
    @Resource
    private BackendUserService backendUserService;

    ////////////////////////////////////////////////////////////////
//    登录
    ////////////////////////////////////////////////////////////////

    @RequestMapping(value="/toLogin")
    public String toLogin(){
        logger.info("跳转到登录界面");
        return "backendlogin";
    }
    @RequestMapping("/login")
    public String doLogin(HttpServletRequest request, HttpSession session, @RequestParam String userCode , @RequestParam String userPassword){
        logger.info("登录方法");
        BackendUser user = new BackendUser();
        user.setUserCode(userCode);
//        user.setDevPassword(devPassword);
        user = backendUserService.queryByUser(user);
        if (user.getUserPassword().equals(userPassword)) {
            session.setAttribute(Constants.USER_SESSION,user);
            return "redirect:/manager/toMain";
        }else {
            request.setAttribute("error","用户密码不正确");
            return "redirect:/manager/toLogin";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        logger.info("退出登录:跳转到登录页面");
        return "redirect:/manager/toLogin";
    }
    @RequestMapping("/toMain")
    public String toMain(HttpSession session) {
        if (session.getAttribute(Constants.USER_SESSION)==null){
            return "redirect:/manager/toLogin";
        }
        logger.info("跳转到主页");
        return "/backend/main";
    }

    ////////////////////////////////////////////////////////////////
//    登录
    ////////////////////////////////////////////////////////////////

}
