package com.shanezhou.springcloud.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/16 星期日
 */
@RestController
public class MvcController {

    private KeyPair keyPair;

    @RequestMapping("/.well-know/jwks.json")
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

    @Autowired
    public void setKeyPair(KeyPair keyPair) {
        this.keyPair = keyPair;
    }
}
