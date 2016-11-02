package com.beijing.wei.util.common;

public class Test {
	public static String getPassword(String boss, String number,
			boolean paramNumber, boolean paramNumaz, boolean paramNumAZ,
			boolean paramNumUnt) {
		char[] array_az = null;// {'q','w','e','r','t','y','u','i','o','p','l','k','j','h','g','f','d','s','a','z','x','c','v','b','n','m'};
		char[] array_AZ = null;// {'Q','W','E','R','T','Y','U','I','O','P','L','K','J','H','G','F','D','S','A','Z','X','C','V','B','N','M'};
		char[] array_number = null;// {0,1,2,3,4,5,6,7,8,9};
		char[] array_Unt = null;// {'~','!','@','#','$','%','^','&','*','(',')','_','+','|','=','\\','-','`'};
		if (paramNumaz) {
			array_az = new char[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i',
					'o', 'p', 'l', 'k', 'j', 'h', 'g', 'f', 'd', 's', 'a', 'z',
					'x', 'c', 'v', 'b', 'n', 'm' };
		}
		if (paramNumAZ) {
			array_AZ = new char[] { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I',
					'O', 'P', 'L', 'K', 'J', 'H', 'G', 'F', 'D', 'S', 'A', 'Z',
					'X', 'C', 'V', 'B', 'N', 'M' };
		}
		if (paramNumber) {
			array_number = new char[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		}
		if (paramNumUnt) {
			array_Unt = new char[] { '~', '!', '@', '#', '$', '%', '^', '&',
					'*', '(', ')', '_', '+', '|', '=', '\\', '-', '`' };
		}

		return null;
	}

	public static void main(String[] args) {

	}
}
