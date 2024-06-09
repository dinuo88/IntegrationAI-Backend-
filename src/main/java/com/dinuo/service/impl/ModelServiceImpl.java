package com.dinuo.service.impl;

import com.dinuo.domain.po.Model;
import com.dinuo.domain.vo.PageBean;
import com.dinuo.mapper.ModelMapper;
import com.dinuo.service.ModelService1;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author dinuo
 * @Date: 2024/06/06/20:02
 */
@Service
@Slf4j
public class ModelServiceImpl implements ModelService1 {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PageBean query() {
        PageHelper.startPage(1,3);
        Page<Model> page = modelMapper.pageQuery();
        log.info("查阅成功");
        return new PageBean(page.getTotal(),page.getResult());
    }
}
