package br.com.zup.orange.propostas.controller;

import br.com.zup.orange.propostas.Model.DTO.PropostaDto;
import br.com.zup.orange.propostas.Model.DTO.PropostaForm;
import br.com.zup.orange.propostas.Model.DTO.SolicitacaoDto;
import br.com.zup.orange.propostas.Model.DTO.SolicitacaoForm;
import br.com.zup.orange.propostas.Model.Proposta;
import br.com.zup.orange.propostas.feign.SolicitacaoEndpoint;
import br.com.zup.orange.propostas.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private WebClient client = WebClient.create();
    private String urlApiSolicitacao = "http://localhost:9999/api/solicitacao";
    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private SolicitacaoEndpoint solicitacaoEndpoint;

    @Autowired
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PropostaForm propostaForm, UriComponentsBuilder uriComponentsBuilder){
        //validacao proposta igual
        Optional<Proposta> optionalProposta = propostaRepository.findByCpfOuCnpj(propostaForm.getCpfOuCnpj());
        if(optionalProposta.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        Proposta novaProposta = propostaForm.converter();
        em.persist(novaProposta);
        SolicitacaoForm solicitacaoForm = new SolicitacaoForm(novaProposta.getCpfOuCnpj(),novaProposta.getNome(),novaProposta.getId().toString());
        SolicitacaoDto response = solicitacaoEndpoint.getSolicitacao(solicitacaoForm);
        System.out.println(response.getResultadoSolicitacao());
        novaProposta.setRestricao(response.getResultadoSolicitacao());
        em.persist(novaProposta);
        URI uri = uriComponentsBuilder.path("/proposta/{id}").buildAndExpand(novaProposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaDto> informacoesProposta(@PathVariable Long id){
        Optional<Proposta> propostaOpt = propostaRepository.findById(id);
        if (propostaOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new PropostaDto(propostaOpt.get()));
    }
}
