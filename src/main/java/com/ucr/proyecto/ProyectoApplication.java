package com.ucr.proyecto;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.domain.Issue;
import com.ucr.proyecto.service.ClientService;
import com.ucr.proyecto.service.IssueService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.security.Provider;
import java.util.Date;



@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

}
