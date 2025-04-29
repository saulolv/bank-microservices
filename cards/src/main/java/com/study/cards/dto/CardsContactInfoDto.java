package com.study.cards.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;

@ConfigurationProperties(prefix = "cards")
public record CardsContactInfoDto(String message, String description, HashMap<String, String> contact, List<String> onCallSupport) {
}
