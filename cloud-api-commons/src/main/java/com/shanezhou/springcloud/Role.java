package com.shanezhou.springcloud;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/13 星期四
 */
@TableName("ROLE")
@KeySequence("SEQ_ROLE_ID")
@Data
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @TableId(type = IdType.INPUT)
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
