package br.com.zup.orange.propostas.repository;

import br.com.zup.orange.propostas.Model.Biometria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiometriaRepository extends JpaRepository<Biometria,Long> {
}
