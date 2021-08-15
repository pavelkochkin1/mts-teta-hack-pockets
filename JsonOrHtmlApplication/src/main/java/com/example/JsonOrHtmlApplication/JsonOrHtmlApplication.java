package com.example.JsonOrHtmlApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;

@SpringBootApplication
public class JsonOrHtmlApplication {
	public static void main(String[] args)  {
		SpringApplication.run(JsonOrHtmlApplication.class, args);
	}
}
