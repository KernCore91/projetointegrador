package com.pi.projetointegrador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BemDAO extends CrudRepository<Bem, Integer>{

}