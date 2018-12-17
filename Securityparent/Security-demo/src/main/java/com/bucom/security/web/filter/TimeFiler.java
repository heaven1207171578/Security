package com.bucom.security.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
//@Component
public class TimeFiler implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    System.out.println("time filter start");
    long start = System.currentTimeMillis();
    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("time filter 耗时:"+(System.currentTimeMillis() - start));
    System.out.println("time filter end");
  }

  @Override
  public void destroy() {}
}
