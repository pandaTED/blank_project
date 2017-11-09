package cn.panda.controller;


import cn.panda.config.CustomException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
@RequestMapping("")
public class IndexController {


    Logger logger = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping("")
    public String index(Model model, HttpServletRequest request){

        model.addAttribute("pageTitle","首页");
        return "index";
    }


    @RequestMapping(value = "/login.jsp")
    public ModelAndView login(HttpServletRequest request,Model model) throws Exception {

        ModelAndView mv = new ModelAndView("login");

        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        String errMsg = "";

        if (exceptionClassName != null) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                logger.info("UnknownAccountException -- > 账号不存在");
                errMsg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                logger.info("IncorrectCredentialsException -- > 密码不正确");
                errMsg = "密码不正确";
            } else if ("kaptchaValidateFailed".equals(exceptionClassName)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                errMsg = "验证码错误";
            } else {
                logger.info("else -- >" + exceptionClassName);
            }
        }

        mv.getModel().put("errMsg",errMsg);
        mv.getModel().put("pageTitle","首页");

        return mv;
    }


    @RequestMapping("/refuse")
    public String refuse(Model model){

        model.addAttribute("pageTitle","没有权限");
        return "refuse";
    }


}
