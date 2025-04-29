package com.study.loans.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;

@ConfigurationProperties(prefix = "loans")
public record LoansContactInfoDto(String message, String description, HashMap<String, String> contact, List<String> onCallSupport) {
}
