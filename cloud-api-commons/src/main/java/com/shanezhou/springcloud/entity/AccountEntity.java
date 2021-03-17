package com.shanezhou.springcloud.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ShaneZhou
 * @since 2020/9/23 周三
 */
@Data
@KeySequence("SEQ_ACCOUNT_ID")
@TableName("PRACTICE_ACCOUNT")
public class AccountEntity implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;

    /**
     * 用户名
     */
    @TableField("NAME")
    private String name;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 角色
     */
    @TableField("ROLE_ID")
    private Long roleId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return simpleGrantedAuthorities;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
