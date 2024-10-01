package com.sample.spring.tv2;

public class TVUser {

	public static void main(String[] args) {
//		LgTv tv = new LgTv();
		
		Tv tv = new LgTv();
		
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();

		

	}

}
