package com.javapatterns.chainofresp.filterchain;

public interface Filter {
	  void doFilter(Request request,Response response,FilterChain chain);
}
