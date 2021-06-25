package com.qidaiai.service;

import com.qidaiai.domain.User;
import com.qidaiai.dto.UserDto;
import com.qidaiai.vo.DataGridView;

import java.util.List;

public interface UserService{

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    User queryUserByPhone(String phone);

    /**
     * 根据用户id查询用户
     * @param userId 用户编号
     * @return
     */
    User getOne(Long userId);

    /**
     * 分页查询用户
     * @param userDto
     * @return
     */
    DataGridView listUserForPage(UserDto userDto);

    /**
     * 添加用户
     * @param userDto
     * @return
     */
    int addUser(UserDto userDto);

    /**
     * 修改用户
     * @param userDto
     * @return
     */
    int updateUser(UserDto userDto);

    /**
     * 删除用户
     * @param userIds
     * @return
     */
    int deleteUserByIds(Long[] userIds);

    /**
     * 查询所有可用的用户
     * @return
     */
    List<User> getAllUsers();

    /**
     * 重置用户密码
     * @param userIds
     */
    void resetPassWord(Long[] userIds);

    /**
     * 根据部门ID和用户ID查询用户信息，如果用户ID和部门ID为空，那么就查询所有需要班的医生信息
     * @param userId
     * @param deptId
     * @return
     */
    List<User> queryUsersNeedScheduling(Long userId, Long deptId);

}
