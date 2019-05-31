package br.ifpr.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpr.webservice.entidade.Categoria;

public interface DAOCategoria extends JpaRepository<Categoria, Integer>{

}
