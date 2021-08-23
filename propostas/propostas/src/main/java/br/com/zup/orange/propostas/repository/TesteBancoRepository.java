package br.com.zup.orange.propostas.repository;

import br.com.zup.orange.propostas.Model.TesteBanco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteBancoRepository  extends JpaRepository<TesteBanco,Long> {
}
