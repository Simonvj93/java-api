package com.example.javaapi;

import org.junit.runner.RunWith;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
// @SpringBootTest(
//     webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//     classes = JavaapiApplication.class)
// @AutoConfigureMockMvc
// @TestPropertySource(
//     locations = "classpath:application-integrationtest.properties"
// )
@SpringBootTest
public class WatchControllerTest {

    @Autowired
    private WatchController watchController;

    @Test
    public void contextLoads()
    throws Exception {
        assertThat(watchController).isNotNull();
    }

}

