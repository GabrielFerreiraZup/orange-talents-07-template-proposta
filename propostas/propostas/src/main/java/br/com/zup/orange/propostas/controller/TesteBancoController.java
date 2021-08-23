package br.com.zup.orange.propostas.controller;


import br.com.zup.orange.propostas.Model.TesteBanco;
import br.com.zup.orange.propostas.repository.TesteBancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/teste")
public class TesteBancoController {

    @Autowired
    TesteBancoRepository testeBancoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(){
        TesteBanco testeBanco = new TesteBanco("teste");
        testeBancoRepository.save(testeBanco);
        return ResponseEntity.ok().build();
    }
}
