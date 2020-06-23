package com.aulonline.cursomc.repositories;

import com.aulonline.cursomc.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
