package cn.panda.controller;


import cn.panda.dao.UserDao;
import cn.panda.entity.User;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class IndexController {


    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    UserDao userDao;

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


    @RequestMapping("/register.jsp")
    public String registerjsp(Model model){
        model.addAttribute("pageTitle","注册");
        return "register";
    }


    @RequestMapping("/register")
    public String register(Model model,String username,String password,String repeatpassword){

        //字段全部做trim
        username = username.trim();
        password = password.trim();
        repeatpassword = repeatpassword.trim();

        //用户名，密码，重复密码都不为null
        if(null != username && null != password && null != repeatpassword){
            User user = userDao.findByUsernameIs(username);
            if(null == user){   //判断此前用户名没有被注册
                if(password.equals(repeatpassword)){    //两次输入的密码一致





                }
            }
        }

        return "";
    }


    @RequestMapping("/refuse")
    public String refuse(Model model){

        model.addAttribute("pageTitle","没有权限");
        return "refuse";
    }


}
