package br.com.zup.orange.propostas.repository;

import br.com.zup.orange.propostas.Model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira,Long> {
}
