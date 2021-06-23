package com.qidaiai.controller.system;

import cn.hutool.core.date.DateUtil;
import com.qidaiai.aspectj.annotation.Log;
import com.qidaiai.aspectj.enums.BusinessType;
import com.qidaiai.domain.LoginInfo;
import com.qidaiai.domain.Menu;
import com.qidaiai.constants.Constants;
import com.qidaiai.constants.HttpStatus;
import com.qidaiai.domain.SimpleUser;
import com.qidaiai.dto.LoginBodyDto;
import com.qidaiai.utils.AddressUtils;
import com.qidaiai.utils.IpUtils;
import com.qidaiai.vo.AjaxResult;
import com.qidaiai.vo.MenuTreeVo;
import com.qidaiai.service.LoginInfoService;
import com.qidaiai.service.MenuService;
import com.qidaiai.utils.ShiroSecurityUtils;
import com.qidaiai.vo.ActiverUser;
import eu.bitwalker.useragentutils.UserAgent;
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

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录控制器
 * @author qidaiai
 * @date 2021/06/18
 */
@RestController
@Log4j2
public class LoginController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private LoginInfoService loginInfoService;

    /**
     * 登录方法
     *
     * @return 结果
     */
    @PostMapping("login/doLogin")
    public AjaxResult login(@RequestBody @Validated LoginBodyDto loginBodyDto, HttpServletRequest request){
        AjaxResult ajaxResult = AjaxResult.success();
        String userName = loginBodyDto.getUsername();
        String password = loginBodyDto.getPassword();
        //构造用户名和密码的token
        UsernamePasswordToken token  = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆信息
        LoginInfo loginInfo = createLoginInfo(request);
        loginInfo.setLoginAccount(loginBodyDto.getUsername());
        try {
            subject.login(token);
            Serializable webToken = subject.getSession().getId();
            ajaxResult.put(Constants.TOKEN,webToken);
            loginInfo.setLoginStatus(Constants.LOGIN_SUCCESS);
            loginInfo.setUserName(ShiroSecurityUtils.getCurrentUserName());
            loginInfo.setMsg("登陆成功");
        }catch (Exception e){
            log.info("用户名或密码不正确",e);
            ajaxResult = AjaxResult.error(HttpStatus.ERROR,"用户名或密码不正确");
            loginInfo.setLoginStatus(Constants.LOGIN_ERROR);
            loginInfo.setMsg("用户名或密码不正确");
        }
        loginInfoService.insertLoginInfo(loginInfo);
        return ajaxResult;
    }


    /**
     * 得到用户的登陆信息
     * @param request
     * @return
     */
    private LoginInfo createLoginInfo(HttpServletRequest request) {
        LoginInfo loginInfo=new LoginInfo();
        final UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr(request);
        String address = AddressUtils.getRealAddressByIP(ip);
        loginInfo.setIpAddr(ip);
        loginInfo.setLoginLocation(address);
        // 获取客户端操作系统
        String os = userAgent.getOperatingSystem().getName();
        // 获取客户端浏览器
        String browser = userAgent.getBrowser().getName();
        loginInfo.setOs(os);
        loginInfo.setBrowser(browser);
        loginInfo.setLoginTime(DateUtil.date());
        loginInfo.setLoginType(Constants.LOGIN_TYPE_SYSTEM);
        return loginInfo;
    }

    /**
     * 获取用户信息
     */
    @GetMapping("/login/getInfo")
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
    @Log(title = "修改字典数据",businessType = BusinessType.UPDATE)
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
