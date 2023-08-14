package com.appleyk;

import com.appleyk.demoController.CalNumSumController;
import com.appleyk.entity.SumNumDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CalNumTest {
    @Autowired
    private WebApplicationContext context;
    @Autowired
    protected ObjectMapper objectMapper;


    @Test
    public void calNum() throws Exception {
        SumNumDto sumNumDto = new SumNumDto();
        sumNumDto.setNum2(12);
        sumNumDto.setNum1(34);

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/add")
                .characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON)
                .accept(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8))
                .content(objectMapper.writeValueAsString(sumNumDto));
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn();
        System.out.println(result.getResponse());
    }


}
