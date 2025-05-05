package com.study.accounts.Application.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
@Getter @Setter
public class AccountsContactInfoDto {

    private String message;
    private Map<String, List<String>> contactInfo;
    private List<String> onCallSupport;
}
