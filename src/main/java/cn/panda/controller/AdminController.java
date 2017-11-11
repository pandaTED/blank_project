package cn.panda.controller;

import cn.panda.dao.SysPermissionDao;
import cn.panda.dao.SysRoleDao;
import cn.panda.dao.UserDao;
import cn.panda.entity.SysPermission;
import cn.panda.entity.SysRole;
import cn.panda.entity.User;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {


    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource
    SysPermissionDao sysPermissionDao;

    @Resource
    SysRoleDao sysRoleDao;

    @Resource
    UserDao userDao;

    /**
     * 角色管理
     * @param model
     * @return
     */
    @RequestMapping("/role.jsp")
        public String rolejsp(Model model){

            model.addAttribute("pageTitle","岗位设置");

                //privilegeList
            List<SysPermission> sysPermissions = sysPermissionDao.findAll();
            model.addAttribute("sysPermissions",sysPermissions);


                //RoleList
            List<SysRole> sysRoleList = sysRoleDao.findAll();
            model.addAttribute("sysRoleList",sysRoleList);


            return "/baseadmin/role";

        }


        @RequestMapping("/role/add")
        public String roleadd(Model model, SysRole role, Long[] privilegeId){

            List<Long> privilegeIsList = Arrays.asList(privilegeId);
            List<SysPermission> sysPermissions = sysPermissionDao.findAllById(privilegeIsList);

            role.setAvailable(true);
            role.setPermissions(sysPermissions);

            sysRoleDao.save(role);

            return "redirect:/admin/role.jsp";
        }



    /**
     * 用户管理
     * @param model
     * @return
     */

    @RequiresRoles("超级管理员")
    @RequestMapping("/user.jsp")
        public  String userjsp(Model model){

            List<User> userList = userDao.findAll();
            model.addAttribute("userList",userList);

            List<SysRole> sysRoleList = sysRoleDao.findAll();
            model.addAttribute("sysRoleList",sysRoleList);

            return "/baseadmin/user";
        }


    /**
     * 权限管理
     * @param model
     * @return
     */
    @RequestMapping("/privilege.jsp")
        public String privilegejsp(Model model){


        List<SysPermission> sysPermissions = sysPermissionDao.findAll();
        model.addAttribute("sysPermissions",sysPermissions);


            return "/baseadmin/privilege";
        }


        @RequestMapping("/privilege/add")
        public String privilegeadd(Model model, SysPermission sysPermission){


            sysPermission.setAvailable(true);
            sysPermissionDao.save(sysPermission);

            return "redirect:/admin/privilege.jsp";
        }

}
