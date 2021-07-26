package com.nksolucoes.gestaodeconsultaspet.repositorires;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nksolucoes.gestaodeconsultaspet.domain.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
