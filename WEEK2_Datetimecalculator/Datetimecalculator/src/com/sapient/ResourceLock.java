package com.sapient;

public class ResourceLock {

	public static volatile int flag=0; /* Input lock in main's hand*/
	public static volatile int flag1=0; /*Output lock in main's hand*/
}
