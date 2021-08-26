package br.com.zup.orange.propostas;

import br.com.zup.orange.propostas.Model.Cartao;
import br.com.zup.orange.propostas.Model.DTO.BloqueioNotificacaoForm;
import br.com.zup.orange.propostas.Model.DTO.CartaoDto;
import br.com.zup.orange.propostas.Model.Proposta;
import br.com.zup.orange.propostas.Model.TesteBanco;
import br.com.zup.orange.propostas.enums.BloqueioEnum;
import br.com.zup.orange.propostas.feign.BloqueiosEndpoint;
import br.com.zup.orange.propostas.feign.CartaoEndpoint;
import br.com.zup.orange.propostas.repository.CartaoRepository;
import br.com.zup.orange.propostas.repository.PropostaRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class PropostasApplication {
	@Autowired
	CartaoEndpoint cartaoEndpoint;
	@Autowired
	PropostaRepository propostaRepository;
	@Autowired
	CartaoRepository cartaoRepository;
	@Autowired
	BloqueiosEndpoint bloqueiosEndpoint;
	public static void main(String[] args) {
		SpringApplication.run(PropostasApplication.class, args);
	}

	@Scheduled(fixedDelay = 180000L)
	void testeScheduled() throws InterruptedException{
		System.out.println(new Date()+"\n");


		List<Proposta> propostas = propostaRepository.getPropostaSemCartao();
		System.out.println(propostas.size());
		for (Proposta proposta:propostas
			 ) {
			CartaoDto cartaoDto = cartaoEndpoint.getCartaoByProposta(proposta.getId());
			Cartao novoCartao = new Cartao(cartaoDto.getId(),cartaoDto.getIdProposta());
			cartaoRepository.save(novoCartao);
			proposta.setIdCartao(cartaoDto.getId());
			propostaRepository.save(proposta);
			System.out.println(cartaoDto.toString());
		}



	}
	@Scheduled(fixedDelay = 60000L)
	void notificarBloqueioCartao() throws InterruptedException{
		System.out.println("RODANDO BLOQUEIOS");
		BloqueioNotificacaoForm bloqueioNotificacaoForm = new BloqueioNotificacaoForm("Proposta");

		List<Cartao> cartoes = cartaoRepository.acharPendentesBloqueio(BloqueioEnum.PENDENTE_VALIDACAO);
		System.out.println(cartoes.size());
		for (Cartao cartao: cartoes) {
			try {
				System.out.println(bloqueiosEndpoint.notificarBloqueio(cartao.getIdInterno(), bloqueioNotificacaoForm));
				System.out.println("Teve Sucesso");
				cartao.setBloqueio(BloqueioEnum.BLOQUEADO);

			}
			catch (Exception e){
				System.out.println("Teve erro no request");
				cartao.setBloqueio(BloqueioEnum.NAO_BLOQUEADO);
			}
			cartaoRepository.save(cartao);
		}

	}

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration{

}