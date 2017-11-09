package cn.panda.config;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class CustomerFormAuthenticationFilter extends FormAuthenticationFilter {


    Logger logger = LoggerFactory.getLogger(CustomerFormAuthenticationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        logger.info("onAccessDenied-------------------------------->{}","这里拦截登陆的form表单");

        HttpServletRequest request1 = (HttpServletRequest) request;

        String username = request1.getParameter("username");
        String password = request1.getParameter("password");


        logger.info("username--------------->{}",username);
        logger.info("password--------------->{}",password);

        return super.onAccessDenied(request, response);
    }
}
