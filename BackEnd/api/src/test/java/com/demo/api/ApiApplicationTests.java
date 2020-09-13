package com.demo.api;

import com.demo.api.controllers.ItemController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {


    @Autowired
    private ItemController itemController;

    @Test
    void contextLoads() {

        assertThat(itemController).isNotNull();

    }

}
