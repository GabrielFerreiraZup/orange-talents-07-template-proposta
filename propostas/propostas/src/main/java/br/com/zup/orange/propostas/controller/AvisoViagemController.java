package br.com.zup.orange.propostas.controller;


import br.com.zup.orange.propostas.Model.AvisoViagem;
import br.com.zup.orange.propostas.Model.Cartao;
import br.com.zup.orange.propostas.Model.DTO.AvisoViagemForm;
import br.com.zup.orange.propostas.feign.AvisoViagemEndpoint;
import br.com.zup.orange.propostas.repository.AvisoViagemRepository;
import br.com.zup.orange.propostas.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/avisoviagem")
public class AvisoViagemController {

    @Autowired
    AvisoViagemRepository avisoViagemRepository;
    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    AvisoViagemEndpoint avisoViagemEndpoint;

    @PostMapping("/{id}")
    public ResponseEntity cadastroAvisoViagem(@PathVariable String id, @RequestBody @Valid AvisoViagemForm avisoViagemForm, HttpServletRequest request,@RequestHeader Map<String, String> mapHeader){

        //possiveis refatoracoes modificar o recebimento do ip do cliente
        
        //fazer essa parte com service
        Optional<Cartao> cartaoOpt = cartaoRepository.findByIdInterno(id);
        if(cartaoOpt.isEmpty()) return ResponseEntity.notFound().build();

        try{
            avisoViagemEndpoint.notificarNovaViagem(id,avisoViagemForm);
            System.out.println(avisoViagemForm.getTerminoViagem());
            AvisoViagem novaViagem = new AvisoViagem(
                    cartaoOpt.get(),
                    avisoViagemForm.getDestino(),
                    avisoViagemForm.getTerminoViagem(),
                    request.getRemoteAddr(),
                    mapHeader.get("user-agent")
            );

            avisoViagemRepository.save(novaViagem);

            return ResponseEntity.ok().build();


        }
        catch (Exception e){

            return ResponseEntity.badRequest().build();
        }

    }

}
