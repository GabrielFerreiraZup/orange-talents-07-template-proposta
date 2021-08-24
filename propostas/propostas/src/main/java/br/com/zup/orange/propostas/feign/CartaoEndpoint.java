package br.com.zup.orange.propostas.feign;


import br.com.zup.orange.propostas.Model.DTO.CartaoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "cartao", url = "http://localhost:8888/api")
public interface CartaoEndpoint {

    @GetMapping(value = "/cartoes?idProposta={id}")
    CartaoDto getCartaoByProposta(@PathVariable Long id);
}
