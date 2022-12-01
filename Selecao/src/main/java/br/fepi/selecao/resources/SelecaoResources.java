package br.fepi.selecao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fepi.selecao.domain.Selecao;
import br.fepi.selecao.repository.SelecaoRepository;

@RestController
@RequestMapping(value = "/selecao")
public class SelecaoResources {
	
	@Autowired
	private SelecaoRepository selecaoRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Selecao> listar() {
	
	return selecaoRepository.findAll();
	
	}
	
	@RequestMapping (value = "/{id}", method = RequestMethod.GET)
	public Selecao buscaId(@PathVariable ("id") Long id) {
		
		return selecaoRepository.findById(id).orElse(null);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void inserir(@RequestBody Selecao selecao) {
		
		selecaoRepository.save(selecao);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable ("id") Long id) {
		
		selecaoRepository.deleteById(id);
	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void alterar(@RequestBody Selecao selecao ,@PathVariable ("id") Long id) {
		
		selecao.setId(id);
		selecaoRepository.save(selecao);
		
	}
}
