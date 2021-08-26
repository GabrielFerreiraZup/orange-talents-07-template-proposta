package br.com.zup.orange.propostas.feign;


import br.com.zup.orange.propostas.Model.DTO.BloqueioNotificacaoForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name= "avisoBloqueio", url = "http://localhost:8888/api/cartoes")
public interface BloqueiosEndpoint {

    @PostMapping(value = "/{id}/bloqueios")
    ResponseEntity notificarBloqueio(@PathVariable String id, BloqueioNotificacaoForm bloqueioNotificacaoForm);
}
