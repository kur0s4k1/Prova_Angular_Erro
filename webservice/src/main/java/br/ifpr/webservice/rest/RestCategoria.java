package br.ifpr.webservice.rest;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpr.webservice.dao.DAOCategoria;
import br.ifpr.webservice.entidade.Categoria;

@CrossOrigin
@RestController
@RequestMapping("/ws/categoria/")
public class RestCategoria {
	@Autowired
	private DAOCategoria dao;
	
	@RequestMapping(method=RequestMethod.POST)
	public void salvar(@RequestBody Categoria categoria) { 
		dao.save(categoria);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Categoria>> buscar() { /* retornando lista de json */
		List<Categoria> lista = dao.findAll();
		ResponseEntity<List<Categoria>> resposta = new ResponseEntity<>(lista, HttpStatus.OK);
		return resposta;
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public void excluir(@PathVariable int id) {
		dao.deleteById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void alterar(@RequestBody Categoria categoria) {
		Categoria categoriaDB = dao.findById(categoria.getId()).get();
		categoriaDB.setNome(categoria.getNome());
		categoriaDB.setDescricao(categoria.getDescricao());
		dao.saveAndFlush(categoriaDB);
		
	}

	
}
