package br.ifpr.webservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpr.webservice.dao.DAOCidade;
import br.ifpr.webservice.entidade.Cidade;
import br.ifpr.webservice.entidade.Estado;

@CrossOrigin
@RestController
@RequestMapping("/ws/cidade/")
public class RestCidade {

		@Autowired //pedindo pro tomcat criar o DAO e injetar
		private DAOCidade dao;
		
		@RequestMapping(method=RequestMethod.POST)
		public void salvar(@RequestBody Cidade cidade) { 
			dao.save(cidade);		
		}
		
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<List<Cidade>> buscar() { /* retornando lista de json */
			List<Cidade> lista = dao.findAll();
			ResponseEntity<List<Cidade>> resposta = new ResponseEntity<>(lista, HttpStatus.OK);
			return resposta;
		}
		
		@RequestMapping(value="{id}", method=RequestMethod.DELETE)
		public void excluir(@PathVariable int id) {
			dao.deleteById(id);
		}
		
		@RequestMapping(method=RequestMethod.PUT)
		public void alterar(@RequestBody Cidade cidade) {
			Cidade cidadeBD = dao.findById(cidade.getId()).get();
			cidadeBD.setNome(cidade.getNome());
			cidadeBD.setEstado(cidade.getEstado());
			dao.saveAndFlush(cidadeBD);
			
		}
	}


