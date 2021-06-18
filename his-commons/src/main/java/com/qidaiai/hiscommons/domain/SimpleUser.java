package com.qidaiai.hiscommons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户对象传输类
 * @author qidaiai
 * @date 2021/06/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUser implements Serializable {

    private Serializable userId;

    private String userName;
}
