package com.dinuo.enums;

/**
 * @Author dinuo
 * @Date: 2024/06/06/21:26
 */
public enum ModelTypeEnum {

    /**
     * 文心一言
     */
    ErnieBot("文心一言", "ErnieBot"),

    /**
     * 讯飞星火
     */
    SparkDesk("讯飞星火", "SparkDesk"),

    /**
     * 智谱清言
     */
    ChatGlm("智谱清言", "ChatGlm"),

    /**
     * 通义千问
     */
    QianWen("通义千问", "QianWen"),

    /**
     * 通义法睿
     */
    FaRui("通义法睿", "FaRui"),

    ;

    /**
     * 模型名称（中文）
     */
    final String name;

    /**
     * 模型名称（英文）
     */
    final String enName;

    ModelTypeEnum(String name, String enName) {
        this.name = name;
        this.enName = enName;
    }

}
