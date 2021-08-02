package com.day.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // --> servlet api 2.5 까지는 <filter> 로 추가된다. (3.0 이상부터는 어노테이션으로 대체)
public class MyFilter implements Filter {

    public MyFilter() {
        System.out.println("MyFilter 객체 생성됨");
    }

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFilter의 init() 호출됨");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter의 doFilter() 호출됨");
		request.setCharacterEncoding("utf-8"); // 인코딩, 암호화, 인증처리를 한다.

		chain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("MyFilter의 destroy() 호출됨");
		// TODO Auto-generated method stub
	}

}
