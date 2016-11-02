package com.beijing.wei.util.string;

import java.util.Random;
import java.util.UUID;

public class UUIDStringUtil {
	public static String getRemodeSixString() {
		int[] arry = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random random = new Random();
		for (int i = 10; i > 1; i--) {
			int index = random.nextInt(i);
			int tmp = arry[index];
			arry[index] = arry[i - 1];
			arry[i - 1] = tmp;
		}
		int result = 0;
		for (int i = 0; i < 6; i++) {
			result = result * 10 + arry[i];
		}
		return String.valueOf(result);
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
