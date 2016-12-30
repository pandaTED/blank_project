package cn.panda.controller;

import cn.panda.entity.User;
import com.alibaba.fastjson.JSON;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/6 0006.
 */


@Controller
@RequestMapping("")
public class Hello {

        @RequestMapping("")
        public  String index(Model model){

            String pageTitle = "Hello";

            model.addAttribute("pageTitle",pageTitle);

            return "index";
        }


        @RequestMapping("/user/")
        public @ResponseBody Object getUserError(){


            HashMap<String,Object> map = new HashMap<>();

            Error error = new Error();

            error.setErrCode("432");
            error.setErrmessage("没有传入有效的ID");

            map.put("code","fail");
            map.put("error",error);

            return map;
        }

        @RequestMapping("/user/{id}")
        public @ResponseBody Object getUser(@PathVariable String id){

            System.out.println("成功发起了请求！");

            HashMap<String,Object> map = new HashMap<>();


            if(null != id && id.trim().length()>0){
                User user = new User();

                user.setId(Long.parseLong(id));
                user.setAge(12);
                user.setAddDate(new DateTime(2016,9,20,12,30,23).toDate());
                user.setUsername("panda");
                user.setEmail("zhuyunpeng@gmail.com");
                user.setIsDelete(0);

                map.put("code","success");
                map.put("user",user);

            }else{
                Error error = new Error();

                error.setErrCode("432");
                error.setErrmessage("没有传入有效的ID");

                map.put("code","fail");
                map.put("error",error);

            }

            return map;
        }



    class Error{
        String errCode;
        String errmessage;

        //toString
        @Override
        public String toString() {
            return "Error{" +
                    "errCode='" + errCode + '\'' +
                    ", errmessage='" + errmessage + '\'' +
                    '}';
        }

        //getter and setter

        public String getErrCode() {
            return errCode;
        }

        public void setErrCode(String errCode) {
            this.errCode = errCode;
        }

        public String getErrmessage() {
            return errmessage;
        }

        public void setErrmessage(String errmessage) {
            this.errmessage = errmessage;
        }
    }





}
