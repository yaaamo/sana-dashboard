package com.ruoyi.test;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dtflys.forest.springboot.annotation.ForestScan;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@Configuration
@RunWith(SpringRunner.class)
@SpringBootTest
@ForestScan(basePackages = "com.ruoyi.sana.rmi")

public class BaseTest {


    @Before
    public void setUp() throws Exception {

    }

    protected void json(Object o) {
        System.out.println(JSON.toJSONString(o, true));
    }

    protected <T> Page initPage(){
        Page<T> page = new Page<>();
        page.setSize(10L);
        page.setCurrent(1L);
        return page;
    }

}
