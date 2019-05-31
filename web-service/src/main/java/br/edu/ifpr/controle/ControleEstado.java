package br.edu.ifpr.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entidade.Estado;
import repositorio.DAOEstado;


@CrossOrigin
@RestController
@RequestMapping("ws/estado")
public class ControleEstado {
	
//	@RequestBody
//	@PathVariable()
//	@RequestBody
//	
	@Autowired
	private DAOEstado dao;
	
	
    public ResponseEntity<List<Estado>> listAll() { 
        return new ResponseEntity<List<Estado>>(dao.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Estado> get(Integer id) {
        return new ResponseEntity<Estado>(dao.findById(id).get(), HttpStatus.OK);
    }
    
	
    public void create(Estado estado) { 
    	dao.save(estado);
    }
     
    public ResponseEntity<Estado> update(Integer id, Estado estado) {
        Estado currentEstado = dao.findById(id).get();
        
        currentEstado.setNome(estado.getNome());
        currentEstado.setSigla(estado.getSigla());
        currentEstado.setStatus(estado.getStatus());
        
        dao.saveAndFlush(currentEstado);
        return new ResponseEntity<Estado>(currentEstado, HttpStatus.OK);
    }
    public ResponseEntity<String> delete(Integer id) {
        dao.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}

