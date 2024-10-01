package com.sample.spring.tv2;

public class LgTv implements Tv{
	public LgTv() {
		System.out.println("===>LgTv");
	}

	@Override
	public void turnOn() {
		System.out.println("LgTv 전원킨다");
	}

	@Override
	public void turnOff() {
		System.out.println("LgTv 전원끈다");
		
	}

	@Override
	public void soundUp() {
		System.out.println("LgTv 소리킨다");
		
	}

	@Override
	public void soundDown() {
		System.out.println("LgTv 소리끈다");
		
	}
}
