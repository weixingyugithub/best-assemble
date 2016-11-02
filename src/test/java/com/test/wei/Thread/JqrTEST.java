package com.test.wei.Thread;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JqrTEST {
	
	@Test
	public void save(){
		System.out.println("aaa");
	}
	
	@Test
	public void add(){
		System.out.println("bb");
	}
	
	@Before
	public void before(){
		System.out.println("before");
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
}
