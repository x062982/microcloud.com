package com.shanezhou.springcloud.service;

import com.shanezhou.springcloud.entity.AccountEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* <p>
* 账户表 服务类
* </p>
*
* @author ZhouWX
* @since 2020-09-24
*/
public interface IAccountService {

    /**
    * 插入一条记录进账户表
    * @param entity    账户表实体对象
    * @return 返回插入的主键id 0：失败；> 0：成功
    */
    Long saveAccount( AccountEntity entity);
    /**
    *  根据id更新账户表的信息
    * @param entity    账户表实体对象
    * @return 0：失败；1：成功
    */
    Integer updAccountById(AccountEntity entity);

    /**
    *  根据id删除一个账户表的信息
    * @param id    编号
    * @return 0：失败；1：成功
    */
    Integer delAccountById(Long id);

    /**
    * 根据id查询一个账户表的信息
    * @param id 编号
    * @return 一个账户表的信息
    */
    AccountEntity getAccountById(Long id);

    /**
    * 获取所有的账户表的信息
    * @return 所有的账户表的信息
    */
    List<AccountEntity> getAccounts();

    /**
     * 根据名称获取账户信息
     * @param name  用户名
     * @return
     */
    AccountEntity getAccountByName(String name);
}
