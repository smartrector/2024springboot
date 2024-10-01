package com.sample.spring.bean1;

import org.springframework.stereotype.Component;

@Component("printerB")
public class PrinterB implements Printer{

	@Override
	public void print(String message) {
		System.out.println("Printer B : " + message);
		
	}
	
}
