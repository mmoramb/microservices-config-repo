package com.example.springzuulmicroservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class AuthHeaderFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		if (request.getAttribute("AUTH_HEADER") == null) {
			String sessionId = UUID.randomUUID().toString();
			ctx.addZuulRequestHeader("AUTH_HEADER", sessionId);
		}
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
