package com.sample.spring.tv3;

public class TVUser {

	public static void main(String[] args) {
//		LgTv tv = new LgTv();
		
//		Tv tv = new LgTv();

		
		BeanContainer container = new BeanContainer();
		
		
		Tv tv1 = (Tv) container.getBean(args[0]);
		
		tv1.turnOn();
		tv1.turnOff();
		tv1.soundUp();
		tv1.soundDown();

		

	}

}
