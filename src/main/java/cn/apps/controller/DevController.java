package cn.apps.controller;


import cn.apps.pojo.*;
import cn.apps.service.*;
import cn.apps.utils.Constants;
import cn.apps.utils.Pager;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private DataDictionaryService dictionaryService;
    @Resource
    private AppCategoryService categoryService;
    @Resource
    private AppVersionService versionService;

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
            logger.info("用户密码不正确:登录失败");
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

    /**********************************************************************************************************************************/

    ////////////////////////////////////////////////////////////////
//    列表查询
    ////////////////////////////////////////////////////////////////

    @RequestMapping("/flatform/app/list")
    public String list(Model model,
                       String querySoftwareName, Integer queryFlatformId,Integer queryStatus,
                       Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3,
                       @RequestParam(defaultValue = "1")Integer pageIndex){
        logger.info("查询列表");
        List<AppInfo> appInfos = null;
        List<DataDictionary> flatFormList = null;
        List<DataDictionary> statusList = null;
        List<AppCategory> categoryLevel1List = null;
        try {
            int pageSize = Constants.pageSize;
            int totalCount = appInfoService.queryCountByLimit(querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);
            if (totalCount < 0){
                totalCount = 1;
            }
            Pager page = new Pager(totalCount, pageSize,pageIndex);

            int totalPageCount = page.getPageCount();
            if (pageIndex > totalPageCount){
                pageIndex = totalPageCount;
                throw  new RuntimeException("页码不正确");
            }
            appInfos = appInfoService.queryAllByLimit(querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,pageIndex,pageSize);
            model.addAttribute("appInfoList",appInfos);
            flatFormList = dictionaryService.queryType("APP_FLATFORM");
            model.addAttribute("flatFormList",flatFormList);
            statusList = dictionaryService.queryType("APP_STATUS");
            model.addAttribute("statusList",statusList);
            categoryLevel1List = categoryService.queryParent(1);
            model.addAttribute("categoryLevel1List",categoryLevel1List);
            model.addAttribute("pageIndex", pageIndex);
            model.addAttribute("totalPageCount", totalPageCount);
            model.addAttribute("totalCount", totalCount);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表接口访问失败");
            return "redirect:/Error";
        }
        return "developer/appinfolist";
    }

    @ResponseBody
    @GetMapping("/flatform/app/categoryList/{queryCategoryLevel}")
    public Object view(@PathVariable Integer queryCategoryLevel){
        logger.info("单查询列表id = "+queryCategoryLevel);
        List<AppCategory> categoryLevelList = null;
        try {
            categoryLevelList = categoryService.queryParent(queryCategoryLevel);
            logger.info("查询到集合信息"+categoryLevelList);
        }catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return categoryLevelList;
    }

    @GetMapping("flatform/app/appview/{appinfoid}")
    public String view(@PathVariable Integer appinfoid,
                       Model model){
        logger.info("查询应用Id"+appinfoid);
        AppInfo appInfos = null;
        appInfos = appInfoService.queryById(appinfoid);
        model.addAttribute("appInfo", appInfos);
        if(appInfos.getFlatformId()!=null){
            logger.info("拿到 = "+appinfoid+"/"+appInfos.getFlatformId());
            logger.info("查询版本Id"+appInfos.getFlatformId());
            List<AppVersion> appVersionList = null;
            appVersionList = versionService.queryVersionInfo(appInfos.getFlatformId(),appinfoid);
            model.addAttribute("appVersionList",appVersionList);
        }
        return "developer/appinfoview";
    }

    @GetMapping("/flatform/app/appVersionAdd/{appinfoid}")
    public String appVersionAdd(@PathVariable Integer appinfoid,
                                @RequestParam(required = false) Integer versionid,
                                Model model){
        logger.info("查询应用Id"+appinfoid);
        AppInfo appInfos = null;
        appInfos = appInfoService.queryById(appinfoid);
        model.addAttribute("appInfo", appInfos);
        if(versionid!=null){
            logger.info("拿到 = "+appinfoid+"/"+versionid);
            logger.info("查询版本Id"+versionid);
            List<AppVersion> appVersionList = null;
            appVersionList = versionService.queryVersionInfo(versionid,appinfoid);
            model.addAttribute("appVersionList",appVersionList);
        }
        return "developer/appversionadd";
    }



    ////////////////////////////////////////////////////////////////
//    列表查询
    ////////////////////////////////////////////////////////////////


/**********************************************************************************************************************************/



    ////////////////////////////////////////////////////////////////
//    信息添加
    ////////////////////////////////////////////////////////////////

    @PostMapping("/flatform/app/addVersionSave")
    public String add(AppVersion appVersion){
        logger.info("添加版本信息");
        if (versionService.insert(appVersion)>0){
            return "developer/appversionadd";
        }
        return "developer/appversionadd";
    }

    ////////////////////////////////////////////////////////////////
//    信息添加
    ////////////////////////////////////////////////////////////////


/**********************************************************************************************************************************/


    ////////////////////////////////////////////////////////////////
//    状态更新
    ////////////////////////////////////////////////////////////////












    ////////////////////////////////////////////////////////////////
//    状态更新
    ////////////////////////////////////////////////////////////////


/**********************************************************************************************************************************/


    ////////////////////////////////////////////////////////////////
//    信息删除
    ////////////////////////////////////////////////////////////////

    @RequestMapping("/delapp/{appinfoid}")
    @ResponseBody
    public String delete(@PathVariable Integer appinfoid) {
        logger.info("删除用户");
        logger.info("验证用户:"+appinfoid+"是否存在");
        if(StringUtils.isEmpty(appinfoid)){
            return "false";
        }else {
            AppVersion version = versionService.queryVersion(null,appinfoid);
            if (version != null) {
                return "notexist";
            }else {
                if (appInfoService.deleteById(appinfoid)>0){
                    return "true";
                }else {
                    return "false";
                }
            }
        }
    }











    ////////////////////////////////////////////////////////////////
//    信息删除
    ////////////////////////////////////////////////////////////////


/**********************************************************************************************************************************/



}
