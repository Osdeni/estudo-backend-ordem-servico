package com.ojs.ordemservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableSpringDataWebSupport
public class OrdemServicoApplication {

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

	public static void main(String[] args) {
		SpringApplication.run(OrdemServicoApplication.class, args);
	}

}
