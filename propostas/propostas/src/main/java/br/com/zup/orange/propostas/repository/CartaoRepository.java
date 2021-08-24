package br.com.zup.orange.propostas.repository;

import br.com.zup.orange.propostas.Model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao,Long> {
}
