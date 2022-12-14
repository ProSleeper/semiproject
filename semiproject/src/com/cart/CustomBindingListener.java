package com.cart;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

class CustomBindingListener implements HttpSessionBindingListener { 
	
	
	@Override
    public void valueBound(HttpSessionBindingEvent event) { 
// 세션이 생겼을 할 내용 
  SessionChecker.setNowUser(1); 
  System.out.println("BOUND as " + event.getName() + " to " + event.getSession().getId()); 
    } 
	
	@Override
    public void valueUnbound(HttpSessionBindingEvent event) { 
// 세션이 종료되었을때 
  SessionChecker.setNowUser(-1); 
        System.out.println("UNBOUND as " + event.getName() + " to " + event.getSession().getId()); 
    } 
} 