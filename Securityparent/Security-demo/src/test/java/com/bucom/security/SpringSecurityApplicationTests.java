package com.bucom.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityApplicationTests {
	@Autowired
	WebApplicationContext wac;

	MockMvc mockMvc;

	@Before
	public  void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	//模拟发送请求
	@Test
	public void querySuccess() throws Exception {
		//模拟HTTP请求
		String result=mockMvc.perform(MockMvcRequestBuilders.get("/user")//请求的方法
				//.param("username","cang") //方法参数,方法参数值
				.param("size","15")
				.param("page","3")
				.param("sort","name,desc")
			   .contentType(MediaType.APPLICATION_JSON_UTF8))//请求:是json的utf-8
				.andExpect(MockMvcResultMatchers.status().isOk())//返回状态码为成功(200)
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))//json集合长度为3
				.andReturn().getResponse().getContentAsString();//可以接收响应回来的json传
		System.out.println(result);
	}
	@Test
	public void getSuccess() throws Exception {
		//模拟HTTP请求
		String result=mockMvc.perform(MockMvcRequestBuilders.get("/user/1")//请求的方法
			   .contentType(MediaType.APPLICATION_JSON_UTF8))//请求:是json的utf-8
				.andExpect(MockMvcResultMatchers.status().isOk())//返回状态码为成功(200)
				.andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))//json中要有username要有tom
				.andReturn().getResponse().getContentAsString();//可以接收响应回来的json传
		System.out.println(result);

	}

}
