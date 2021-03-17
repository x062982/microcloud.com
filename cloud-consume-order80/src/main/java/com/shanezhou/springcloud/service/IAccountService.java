//package com.shanezhou.springcloud.service;
//
//import com.shanezhou.springcloud.dto.AccountVO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.validation.Valid;
//
///**
// * @author ShaneZhou
// * @since 2020/9/27 周日
// */
//@FeignClient("CLOUD-PROVIDER-PAYMENT")
//@Service("accountService")
//public interface IAccountService {
//
//    @GetMapping("/account/name")
//    AccountVO getAccountByName(@RequestParam String name);
//}
