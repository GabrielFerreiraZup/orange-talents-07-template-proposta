package br.com.zup.orange.propostas.repository;

import br.com.zup.orange.propostas.Model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Long> {
    Optional<Proposta> findByCpfOuCnpjHash(String cpfOuCnpjHash);

    @Query(value = "Select p from Proposta p where p.idCartao = null" )
    List<Proposta> getPropostaSemCartao();

}

