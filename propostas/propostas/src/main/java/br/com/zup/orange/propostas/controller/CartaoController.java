package br.com.zup.orange.propostas.controller;


import br.com.zup.orange.propostas.Model.Cartao;
import br.com.zup.orange.propostas.enums.BloqueioEnum;
import br.com.zup.orange.propostas.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @PostMapping("/bloqueio/{id}")
    public ResponseEntity bloquearCartao(@RequestHeader Map<String, String> mapHeader, HttpServletRequest request, @PathVariable Long id){
        System.out.println(mapHeader.get("user-agent"));
        System.out.println(request.getRemoteAddr());
        //Poder de refatorar -> colocar pegando o ip do x-forward-m e caso vazio retornar 400
        //talvez em refatorcao fazer isso em service
        if(id == null) return ResponseEntity.badRequest().build();
        Optional<Cartao> cartaoOpt = cartaoRepository.findById(id);
        if(cartaoOpt.isEmpty()) return ResponseEntity.notFound().build();
        if(cartaoOpt.get().getBloqueio() == BloqueioEnum.BLOQUEADO) return ResponseEntity.unprocessableEntity().build();
        cartaoOpt.get().setBloqueio(BloqueioEnum.PENDENTE_VALIDACAO);
        cartaoOpt.get().setHoraBloqueio(LocalDateTime.now());
        cartaoOpt.get().setIpCliente(request.getRemoteAddr());
        cartaoOpt.get().setUserAgentCliente(mapHeader.get("user-agent"));
        cartaoRepository.save(cartaoOpt.get());
        return ResponseEntity.ok().build();
    }

}
