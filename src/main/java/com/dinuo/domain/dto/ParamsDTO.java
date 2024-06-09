package com.dinuo.domain.dto;

/**
 * @Author dinuo
 * @Date: 2024/06/06/22:06
 */
public class ParamsDTO {
    private int maxTokens;
    private double topP;
    private double temperature;
    private double presencePenalty;
    private double frequencyPenalty;

    // Constructors
    public ParamsDTO() {
        this.maxTokens = 1000;
        this.topP = 0.5;
        this.temperature = 0.5;
        this.presencePenalty = 0.5;
        this.frequencyPenalty = 0.5;
    }
}