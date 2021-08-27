package br.com.zup.orange.propostas.feign;


import br.com.zup.orange.propostas.Model.DTO.AvisoViagemForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "avisoViagem",url = "http://localhost:8888/api/cartoes")
public interface AvisoViagemEndpoint {

    @PostMapping(value = "/{id}/avisos")
    ResponseEntity notificarNovaViagem(@PathVariable String id, AvisoViagemForm avisoViagemForm);
}
