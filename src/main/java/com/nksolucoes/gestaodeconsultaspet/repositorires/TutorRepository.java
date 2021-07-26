package com.nksolucoes.gestaodeconsultaspet.repositorires;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nksolucoes.gestaodeconsultaspet.domain.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Integer> {

}
