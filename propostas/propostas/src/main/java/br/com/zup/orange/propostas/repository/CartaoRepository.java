package br.com.zup.orange.propostas.repository;

import br.com.zup.orange.propostas.Model.Cartao;
import br.com.zup.orange.propostas.enums.BloqueioEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao,Long> {
    @Query(value = "Select c from Cartao c where c.bloqueio = :bloqueio ")
    List<Cartao> acharPendentesBloqueio(BloqueioEnum bloqueio);
}
