package com.qidaiai.controller.system;

import com.qidaiai.domain.Menu;
import com.qidaiai.hiscommons.constants.Constants;
import com.qidaiai.hiscommons.constants.HttpStatus;
import com.qidaiai.hiscommons.domain.SimpleUser;
import com.qidaiai.hiscommons.dto.LoginBodyDto;
import com.qidaiai.hiscommons.vo.AjaxResult;
import com.qidaiai.hiscommons.vo.MenuTreeVo;
import com.qidaiai.service.MenuService;
import com.qidaiai.vo.ActiverUser;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
public class LoginController {

    @Autowired
    private MenuService menuService;

    /**
     * 登录方法
     *
     * @return 结果
     */
    @PostMapping("login/doLogin")
    public AjaxResult login(@RequestBody @Validated LoginBodyDto loginBodyDto, HttpServletRequest request){
        AjaxResult ajaxResult = AjaxResult.success();
        String userName = loginBodyDto.getUserName();
        String password = loginBodyDto.getPassword();
        //构造用户名和密码的token
        UsernamePasswordToken token  = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            Serializable webToken = subject.getSession().getId();
            ajaxResult.put(Constants.TOKEN,webToken);
        }catch (Exception e){
            log.info("用户名或密码不正确",e);
            ajaxResult = AjaxResult.error(HttpStatus.ERROR,"用户名或密码不正确");
        }
        return ajaxResult;
    }


    /**
     * 获取用户信息
     */
    @PostMapping("/login/getInfo")
    public AjaxResult getInfo(){
        Subject subject = SecurityUtils.getSubject();
        ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("username",activerUser.getUser().getUserName());
        ajaxResult.put("picture",activerUser.getUser().getPicture());
        ajaxResult.put("roles",activerUser.getRoles());
        ajaxResult.put("permissions",activerUser.getPermissions());
        return ajaxResult;
    }

    /**
     * 用户退出
     */
    @PostMapping("login/logout")
    public AjaxResult logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return AjaxResult.success("用户退出成功");
    }


    /**
     * 获取应该显示的菜单信息
     * @return
     */
    @GetMapping("login/getMenus")
    public AjaxResult getMenus(){
        Subject subject = SecurityUtils.getSubject();
        ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
        boolean isAdmin = activerUser.getUser().getUserType().equals(Constants.USER_ADMIN);
        SimpleUser simpleUser = null;
        if (!isAdmin){
            simpleUser = new SimpleUser(activerUser.getUser().getUserId(),activerUser.getUser().getUserName());
        }
        List<Menu> menus = menuService.selectMenuTree(isAdmin, simpleUser);
        List<MenuTreeVo> menuTreeVos = new ArrayList<>();
        for (Menu menu : menus){
            menuTreeVos.add(new MenuTreeVo(menu.getMenuId().toString(),menu.getPath()));
        }
        return AjaxResult.success(menuTreeVos);
    }
}
