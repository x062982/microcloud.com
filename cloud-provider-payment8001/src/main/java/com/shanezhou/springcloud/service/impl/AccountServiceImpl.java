package com.shanezhou.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shanezhou.springcloud.dao.AccountMapper;
import com.shanezhou.springcloud.entity.AccountEntity;
import com.shanezhou.springcloud.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author ZhouWX
 * @since 2020-09-24
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountMapper")
    private AccountMapper mapper;

    @Override
    public Long saveAccount(AccountEntity entity) {
        long id = Long.valueOf(mapper.insert(entity));
        if (id > 0) {
            id = entity.getId();
        }
        return id;
    }

    @Override
    public Integer updAccountById(AccountEntity entity) {
        return mapper.updateById(entity);
    }

    @Override
    public Integer delAccountById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    public AccountEntity getAccountById(Long id) {
       return mapper.selectById(id);
    }

    @Override
    public List<AccountEntity> getAccounts() {
        return mapper.selectList(null);
    }

    @Override
    public AccountEntity getAccountByName(String name) {
        return mapper.selectOne(new QueryWrapper<AccountEntity>()
                .eq("NAME", name).eq("ROWNUM", 1));
    }
}

