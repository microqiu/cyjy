package com.linfeiyang.shop.config.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5KeyEncoder implements PasswordEncoder {

    private String passKey = "chaoyangjiuye";

    @Override
    public String encode(String clearText) {
        return DigestUtils.md5Hex(clearText + passKey);
    }

    @Override
    public boolean validate(String clearText, String encodeText) {
        return encodeText != null && encodeText.trim().length() != 0 && DigestUtils.md5Hex(clearText + passKey).equals(encodeText);
    }

}
