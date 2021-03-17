package com.shanezhou.springcloud.controller;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.shanezhou.springcloud.Exception.APIException;
import com.shanezhou.springcloud.dto.AccountVO;
import com.shanezhou.springcloud.dto.ResultVO;
import com.shanezhou.springcloud.entity.AccountEntity;
import com.shanezhou.springcloud.entity.CommonResult;
import com.shanezhou.springcloud.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaneZhou
 * @since 2020/9/24 周四
 */
@RestController
@RequestMapping("/account")
@Validated
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/accounts")
    public List<AccountVO> getAllAccounts() {
        List<AccountEntity> accountEntities = accountService.getAccounts();
        List<AccountVO> accountVOList = new ArrayList<>();
        accountEntities.forEach(entity -> {
            accountVOList.add(convertVO(entity));
        });
        return accountVOList;
    }

    @GetMapping("/account/name")
    public AccountVO getAccountByName(@RequestParam @NotNull(message = "用户名不能为空!") String name) {
        AccountEntity accountEntity = accountService.getAccountByName(name);
        if (accountEntity == null) {
            throw new APIException(name + "不存在");
        }
        return convertVO(accountEntity);
    }

    @GetMapping("/account/{id}")
    public AccountVO getAccount(@PathVariable("id") @Valid Long id) {

        AccountEntity accountEntity = accountService.getAccountById(id);
        if (accountEntity == null) {
            throw new APIException("编号：【" + id + "】不存在");
        }
        return convertVO(accountEntity);
    }

    @PostMapping("/account")
    public AccountVO registerAccount(@RequestBody @Valid AccountVO accountVO) {
        String password = accountVO.getPassword();
        Long id = accountService.saveAccount(convertEntity(accountVO));
        if (id == 0) {
            throw new APIException("创建失败");
        }
        accountVO.setId(id);
        return accountVO;
    }

    public AccountVO convertVO(AccountEntity entity) {
        AccountVO vo = new AccountVO();
        if (entity != null) {
            vo.setId(entity.getId());
            vo.setName(entity.getName());
            //vo.setPassword(entity.getPassword());
            vo.setRoleId(entity.getRoleId());
        }
        return vo;
    }


    public AccountEntity convertEntity(AccountVO vo) {
        AccountEntity entity = new AccountEntity();
        if (vo != null) {
            entity.setId(vo.getId());
            entity.setName(vo.getName());
            entity.setPassword(vo.getPassword());
            entity.setRoleId(vo.getRoleId());
        }
        return entity;
    }
}
