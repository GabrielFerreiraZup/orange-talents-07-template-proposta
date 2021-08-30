package br.com.zup.orange.propostas.controller;


import br.com.zup.orange.propostas.Model.Cartao;
import br.com.zup.orange.propostas.Model.Carteira;
import br.com.zup.orange.propostas.Model.DTO.ApiPaypallDto;
import br.com.zup.orange.propostas.Model.DTO.CarteiraForm;
import br.com.zup.orange.propostas.feign.ApiPayPallEndpoint;
import br.com.zup.orange.propostas.repository.CartaoRepository;
import br.com.zup.orange.propostas.repository.CarteiraRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    ApiPayPallEndpoint apiPayPallEndpoint;
    @Autowired
    CartaoRepository cartaoRepository;
    @Autowired
    CarteiraRepository carteiraRepository;

    @PostMapping(value = "/{id}")



    public ResponseEntity cadastrarCarteira(@PathVariable String id, @RequestBody @Valid CarteiraForm carteiraForm, UriComponentsBuilder uriComponentsBuilderi){
        //checar entendimento do enunciado talvez de refatorar
        //fazer com service
        System.out.println(carteiraForm.getEmail());
        System.out.println(carteiraForm.getCarteira());


        Optional<Cartao> cartaoOpt = cartaoRepository.findByIdInterno(id);
        if(cartaoOpt.isEmpty()) return ResponseEntity.notFound().build();

        try{
            ApiPaypallDto apiPaypallDto = apiPayPallEndpoint.cadastrarCarteiraPaypall(id,carteiraForm);
            for (Carteira carteira:cartaoOpt.get().getCarteiras()) {
                System.out.println("Já existe essa carteira");
                if (carteira.getCarteira() == carteiraForm.getCarteira()) return  ResponseEntity.badRequest().build();

            }
            Carteira novaCarteira = new Carteira(carteiraForm.getEmail(),carteiraForm.getCarteira(),apiPaypallDto.getResultado(),apiPaypallDto.getId());
            carteiraRepository.save(novaCarteira);
            System.out.println(cartaoOpt.get().getCarteiras().size());
            cartaoOpt.get().getCarteiras().add(novaCarteira);
            //cartaoOpt.get().setCarteiras(novaCarteiras);
            cartaoRepository.save(cartaoOpt.get());
            System.out.println(cartaoOpt.get().getCarteiras().size());
            URI uri = uriComponentsBuilderi.path("/carteira/{id}").buildAndExpand(novaCarteira.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        catch (FeignException.UnprocessableEntity e){
            return ResponseEntity.unprocessableEntity().build();
        }


    }

}
