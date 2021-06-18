package com.qidaiai.vo;

import com.qidaiai.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 用户权限角色数据传输类
 * @author qidaiai
 * @date 2021/06/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser implements Serializable {

    private User user;

    private List<String> roles = Collections.EMPTY_LIST;//角色

    private List<String> permissions = Collections.EMPTY_LIST;//权限

}
