package com.bucom.security.web.config;

import com.bucom.security.web.Interceptor.TimeInterceptor;
import com.bucom.security.web.filter.TimeFiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
  @Bean//此方法可以使用第三方过滤器的配置,和spring中web.xml配置是一样的
  public FilterRegistrationBean timefilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    TimeFiler timeFiler = new TimeFiler();
    filterRegistrationBean.setFilter(timeFiler);
    List<String> urls = new ArrayList<>(); // 设置拦截的路径 /*是所有
    urls.add("/*");
    filterRegistrationBean.setUrlPatterns(urls);

    return filterRegistrationBean;
  }
    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
