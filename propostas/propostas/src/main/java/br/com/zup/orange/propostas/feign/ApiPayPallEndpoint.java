package br.com.zup.orange.propostas.feign;


import br.com.zup.orange.propostas.Model.Carteira;
import br.com.zup.orange.propostas.Model.DTO.ApiPaypallDto;
import br.com.zup.orange.propostas.Model.DTO.CarteiraForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "apiPayPall", url = "http://localhost:8888/api/cartoes")
public interface ApiPayPallEndpoint {

    @PostMapping(value = "/{id}/carteiras")
    ApiPaypallDto cadastrarCarteiraPaypall(@PathVariable String id, CarteiraForm carteiraForm);

}
