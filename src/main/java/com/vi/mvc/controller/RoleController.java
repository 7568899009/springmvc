package com.vi.mvc.controller;

import com.vi.mvc.entity.Role;
import com.vi.mvc.service.RoleListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/role",produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"})
public class RoleController {
    @Resource(name = "roleListServiceImpl")
    private RoleListService roleListService;

    @RequestMapping(value = "/save", produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"}, method = {RequestMethod.POST})
    public String save(Role role) {
        boolean save = roleListService.save(role);
        return "redirect:/role/list";
    }

    @RequestMapping(value = "/list", produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showList(ModelAndView modelAndView) {
        //设置模型数据
        //@Nullable Map<String, ?> modelMap
        List<Role> roles = roleListService.showList();
        modelAndView.addObject("roleList", roles);
        //设置视图名称
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
    @RequestMapping(value = "/delete", produces = {"text/html;charset=UTF-8", "application/json;charset=UTF-8"}, method = {RequestMethod.DELETE, RequestMethod.POST})
    public void delete(Role role) {
        boolean delete = roleListService.delete(role);
    }

}
