package com.linfeiyang.shop.config.security;

public interface PasswordEncoder {

    String encode(String clearText);

    boolean validate(String clearText, String encodeText);
}
