package com.foo;

public class Foo {
	static final int A = 1; // public, protected 才可給 Bar 取用
	public static final int B = 2;
	private static final int C = 3;
	int d = 4;
	protected int e = 5;
	public int f = 6;
	private int g = 7;
	
	public void foo(int h) {
		int i = 8;
	}
}
