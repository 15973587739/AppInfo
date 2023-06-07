package cn.apps.controller;


import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/6/7 10:27
 **/
@Controller
@RequestMapping(value = "/dev")
public class DevController {
    private Logger logger = Logger.getLogger(DevController.class);

    @RequestMapping(value="/toLogin")
    public String toLogin(){
        logger.info("跳转到登录界面");
        return "devlogin";
    }
}
