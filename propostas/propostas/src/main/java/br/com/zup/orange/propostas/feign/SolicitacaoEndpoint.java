package br.com.zup.orange.propostas.feign;


import br.com.zup.orange.propostas.Model.DTO.SolicitacaoDto;
import br.com.zup.orange.propostas.Model.DTO.SolicitacaoForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name ="solicitacao", url = "http://localhost:9999/api/solicitacao")
public interface SolicitacaoEndpoint {

    @PostMapping
    SolicitacaoDto getSolicitacao(SolicitacaoForm solicitacaoForm);
}
