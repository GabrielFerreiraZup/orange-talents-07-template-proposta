package br.com.zup.orange.propostas.repository;

import br.com.zup.orange.propostas.Model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Long> {
    Optional<Proposta> findByCpfOuCnpj(String cpfOuCnpj);
}
