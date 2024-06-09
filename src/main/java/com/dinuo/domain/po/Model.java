package com.dinuo.domain.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dinuo
 * @Date: 2024/06/06/20:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    private Long modelId;
    private String modelNameCn;
    private String modelNameEn;

}
