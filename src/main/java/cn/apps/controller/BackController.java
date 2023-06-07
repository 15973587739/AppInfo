package cn.apps.controller;

import cn.apps.pojo.AppInfo;
import cn.apps.pojo.BackendUser;
import cn.apps.pojo.DataDictionary;
import cn.apps.pojo.DevUser;
import cn.apps.service.AppInfoService;
import cn.apps.service.BackendUserService;
import cn.apps.service.DataDictionaryService;
import cn.apps.utils.Constants;
import cn.apps.utils.Pager;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private DataDictionaryService dictionaryService;

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
            logger.info("用户密码不正确:登录失败");
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

/**********************************************************************************************************************************/

    ////////////////////////////////////////////////////////////////
//    列表查询
    ////////////////////////////////////////////////////////////////

    @RequestMapping("/backend/app/list")
    public String list(Model model,
                       String querySoftwareName, Integer queryFlatformId,
                       Integer queryCategoryLevel1,Integer queryCategoryLevel2,Integer queryCategoryLevel3,
                       @RequestParam(defaultValue = "1")Integer pageIndex){
        logger.info("查询列表");
        List<AppInfo> appInfos = null;
        List<DataDictionary> flatFormList = null;
        try {
            int pageSize = Constants.pageSize;
            int totalCount = appInfoService.queryCountByLimit(querySoftwareName,null,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);
            if (totalCount < 0){
                totalCount = 1;
            }
            Pager page = new Pager(totalCount, pageSize,pageIndex);

            int totalPageCount = page.getPageCount();
            if (pageIndex > totalPageCount){
                pageIndex = totalPageCount;
                throw  new RuntimeException("页码不正确");
            }
            appInfos = appInfoService.queryAllByLimit(querySoftwareName,null,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,pageIndex,pageSize);
            model.addAttribute("appInfoList",appInfos);
            flatFormList = dictionaryService.queryType("APP_FLATFORM");
            model.addAttribute("flatFormList",flatFormList);
            model.addAttribute("pageIndex", pageIndex);
            model.addAttribute("totalPageCount", totalPageCount);
            model.addAttribute("totalCount", totalCount);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表接口访问失败");
            return "redirect:/sysError";
        }
        return "backend/applist";
    }
}
