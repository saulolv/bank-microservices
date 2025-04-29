package com.study.accounts.Application.dto;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;

@ConfigurationProperties(prefix = "accounts")
public record AccountsContactInfoDto(String message, String description, HashMap<String, String> contact, List<String> onCallSupport) {
}
