package com.vi.mvc.controller;

import com.vi.mvc.entity.Role;
import com.vi.mvc.entity.User;
import com.vi.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user",produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"})
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @RequestMapping(value = "/list", produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showList(ModelAndView modelAndView) {
        List<User> users = userService.showList();
        modelAndView.addObject("userList", users);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
    @RequestMapping(value = "/saveUI", produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView saveUI(ModelAndView modelAndView) {
        List<Role> roles = userService.showUI();
        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }
    @RequestMapping(value = "/save", produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"}, method = { RequestMethod.POST})
    public String save(User user,Long rolesId[]) {
        userService.save(user,rolesId);
        return "redirect:/user/list";
    }
    @RequestMapping(value = "/delete/{id}", produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"}, method = { RequestMethod.GET,RequestMethod.POST})
    public String delete(@PathVariable(value = "id",required = true) Long userId) {
        userService.deleteUser(userId);
        return "redirect:/user/list";
    }
    @RequestMapping(value = "/login", produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"}, method = { RequestMethod.POST})
    public String Login(User user, HttpSession httpSession, HttpServletRequest request) {
        User users = userService.login(user);
        if (users != null) {
            httpSession.setAttribute("users", users);
            return "redirect:/user/list";
        } else {
            return "redirect:/login.jsp";
        }

    }

}
