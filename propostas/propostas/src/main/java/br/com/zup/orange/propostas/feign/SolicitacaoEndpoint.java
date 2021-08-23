package br.com.zup.orange.propostas.feign;

import br.com.zup.orange.propostas.Model.DTO.SolicitacaoDto;
import br.com.zup.orange.propostas.Model.DTO.SolicitacaoForm;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "estado proposta", url = "http://localhost:9999/api/solicitacao")
public interface SolicitacaoEndpoint {

    @GetMapping
    SolicitacaoDto getSolicitacao(SolicitacaoForm solicitacaoForm);
}
