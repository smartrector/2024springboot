package com.sample.spring.tv2;

public class SamsungTv implements Tv {
	public SamsungTv() {
		System.out.println("===>SamsungTv");
	}
	
	@Override
	public void turnOn() {
		System.out.println("SamsungTv 전원킨다");
	}
	
	@Override
	public void turnOff() {
		System.out.println("SamsungTv 전원끈다");
	}

	@Override
	public void soundUp() {
		System.out.println("SamsungTv 전원킨다");
		
	}

	@Override
	public void soundDown() {
		System.out.println("SamsungTv 전원끈다");
		
	}
}
