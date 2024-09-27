package com.wvs.ocr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OcrServiceApplication {

	public static void main(String[] args) {
		System.setProperty("jna.library.path", "/usr/local/opt/tesseract/lib");
		SpringApplication.run(OcrServiceApplication.class, args);
	}

}
