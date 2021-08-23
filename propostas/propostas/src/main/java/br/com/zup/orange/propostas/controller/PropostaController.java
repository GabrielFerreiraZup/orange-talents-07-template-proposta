package br.com.zup.orange.propostas.controller;

import br.com.zup.orange.propostas.Model.DTO.PropostaForm;
import br.com.zup.orange.propostas.Model.Proposta;
import br.com.zup.orange.propostas.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PropostaForm propostaForm, UriComponentsBuilder uriComponentsBuilder){
        Proposta novaProposta = propostaForm.converter();
        propostaRepository.save(novaProposta);
        URI uri = uriComponentsBuilder.path("/proposta/{id}").buildAndExpand(novaProposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
