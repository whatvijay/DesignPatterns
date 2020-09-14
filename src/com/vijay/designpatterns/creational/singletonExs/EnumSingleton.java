package com.vijay.designpatterns.creational.singletonExs;

public enum EnumSingleton {

	INSTANCE;
	
	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
