package cn.apps.controller;


import cn.apps.pojo.DevUser;
import cn.apps.service.DevUserService;
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
 * @Author: SI YU
 * @Description: TODO
 * @DateTime: 2023/6/7 10:27
 **/
@Controller
@RequestMapping(value = "/dev")
public class DevController {
    private Logger logger = Logger.getLogger(DevController.class);
    /**
     * 服务对象
     */
    @Resource
    private DevUserService devUserService;

    ////////////////////////////////////////////////////////////////
//    登录
    ////////////////////////////////////////////////////////////////

    @RequestMapping(value="/toLogin")
    public String toLogin(){
        logger.info("跳转到登录界面");
        return "devlogin";
    }
    @RequestMapping("/login")
    public String doLogin(HttpServletRequest request, HttpSession session, @RequestParam String devCode , @RequestParam String devPassword){
        logger.info("登录方法");
        DevUser user = new DevUser();
        user.setDevCode(devCode);
//        user.setDevPassword(devPassword);
        user = devUserService.queryByUser(user);
        if (user.getDevPassword().equals(devPassword)) {
            logger.info("验证密码正确:登录成功");
            session.setAttribute(Constants.DIV_USER_SESSION,user);
            return "redirect:/dev/toMain";
        }else {
            request.setAttribute("error","用户密码不正确");
            return "redirect:/dev/toLogin";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        logger.info("退出登录:跳转到登录页面");
        return "redirect:/dev/toLogin";
    }
    @RequestMapping("/toMain")
    public String toMain(HttpSession session) {
        if (session.getAttribute(Constants.DIV_USER_SESSION)==null){
            return "redirect:/dev/toLogin";
        }
        logger.info("跳转到主页");
        return "/developer/main";
    }
    ////////////////////////////////////////////////////////////////
//    登录
    ////////////////////////////////////////////////////////////////


}
