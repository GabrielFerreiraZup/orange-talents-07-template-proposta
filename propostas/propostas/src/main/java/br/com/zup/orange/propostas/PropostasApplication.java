package br.com.zup.orange.propostas;

import br.com.zup.orange.propostas.Model.TesteBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@SpringBootApplication
@EnableFeignClients
public class PropostasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropostasApplication.class, args);
	}


}
