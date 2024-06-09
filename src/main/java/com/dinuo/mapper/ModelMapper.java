package com.dinuo.mapper;

import com.dinuo.domain.po.Model;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author dinuo
 * @Date: 2024/06/06/20:10
 */
@Mapper
public interface ModelMapper {

    Page<Model> pageQuery();

    Model selectById(Long modelId);
}
