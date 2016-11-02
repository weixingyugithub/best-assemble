package com.beijing.wei.util.common;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalNumber {
	 private static final AtomicInteger uniqueId = new AtomicInteger(0);

     private static final ThreadLocal < Integer > uniqueNum = 
         new ThreadLocal < Integer > () {
             @Override protected Integer initialValue() {
                 return uniqueId.getAndIncrement();
         }
     };
 
     public static int getCurrentThreadId() {
         return uniqueId.get();
     }

	
	public static void main(String[] args) {
//		System.out.println(uniqueId.getAndIncrement());
//		System.out.println(uniqueId.getAndIncrement());
		System.out.println(uniqueId.getAndIncrement());
//		System.out.println(uniqueId.getAndIncrement());
		
		System.out.println(uniqueNum.get());
		System.out.println(uniqueNum.get());
		System.out.println(uniqueNum.get());
		System.out.println(uniqueNum.get());
		System.out.println(uniqueNum.get());
		
		System.out.println(Long.MAX_VALUE);
	}
}
