package br.com.zup.orange.propostas.repository;

import br.com.zup.orange.propostas.Model.AvisoViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvisoViagemRepository extends JpaRepository<AvisoViagem,Long> {
}
