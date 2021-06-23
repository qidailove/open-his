package com.qidaiai.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 构造菜单返回给前台的vo
 * @author qidaiai
 * @date 2021/06/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTreeVo {

    private String id;

    private String serPath;

    private boolean show = true;

    public MenuTreeVo(String id, String serPath){
        this.id = id;
        this.serPath = serPath;
    }
}
