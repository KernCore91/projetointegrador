package com.pi.projetointegrador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaixaDAO extends CrudRepository<Baixa, Integer>{

}