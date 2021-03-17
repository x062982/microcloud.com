package com.shanezhou.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanezhou.springcloud.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
* 账户表 Mapper 接口
* </p>
*
* @author ZhouWX
* @since 2020-09-24
*/
@Mapper
public interface AccountMapper extends BaseMapper<AccountEntity> {

}
