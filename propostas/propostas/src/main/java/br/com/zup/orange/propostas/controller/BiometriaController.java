package br.com.zup.orange.propostas.controller;


import br.com.zup.orange.propostas.Model.Biometria;
import br.com.zup.orange.propostas.Model.Cartao;
import br.com.zup.orange.propostas.Model.DTO.BiometriaDto;
import br.com.zup.orange.propostas.repository.BiometriaRepository;
import br.com.zup.orange.propostas.repository.CartaoRepository;
import br.com.zup.orange.propostas.services.BiometriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    @Autowired
    BiometriaRepository biometriaRepository;
    @Autowired
    CartaoRepository cartaoRepository;
    @Autowired
    BiometriaService biometriaService;

    @PostMapping("/{id}")
    public ResponseEntity cadastrarBiometria(@RequestBody BiometriaDto biometriaDto, @PathVariable Long id, UriComponentsBuilder uriComponentsBuilder){

        return biometriaService.cadastrarBiometria(biometriaRepository,cartaoRepository,biometriaDto.getBiometria(),id,uriComponentsBuilder);

    }
}
