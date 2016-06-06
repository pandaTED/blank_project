package cn.panda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/6/6 0006.
 */


@Controller
@RequestMapping("/")
public class Hello {

        @RequestMapping("/")
        public String index(Model model){

            String pageTitle = "Hello";

            String dog = "world";

            model.addAttribute("pageTitle",pageTitle);
            model.addAttribute("dog",dog);
            return "index";
        }


}
