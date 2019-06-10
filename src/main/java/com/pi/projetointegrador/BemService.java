package com.pi.projetointegrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bem")
public class BemService {
	@Autowired
	private BemDAO bemDAO;
	
	//TODO melhorar estes padroes
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<Bem> list(){
		List<Bem> result = new ArrayList<>();
		bemDAO.findAll().forEach(p -> {result.add(p);});
		return result;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public void save(@RequestBody Bem bem) {
		bemDAO.save(bem);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		bemDAO.deleteById(id);
	}
	
	@RequestMapping(value="/calcular", method = RequestMethod.POST)
	public Bem calcular(@PathVariable("id") Integer id, Date dateInf) {
		Bem objBem = new Bem(id);
		Bem b = new Calculo().calcularDepreciacao(objBem, dateInf);
		objBem.setValor_contabil(b.getValor_contabil());
		objBem.setValor_residual(b.getValor_residual());
		objBem.setPeriodo(b.getPeriodo());
		return objBem;
	}
}