package com.dianome.reclamacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dianome.reclamacoes.models.ReclamacoesModel;

@Repository
public interface ReclamacoesRepository extends JpaRepository<ReclamacoesModel, Integer>{

}
