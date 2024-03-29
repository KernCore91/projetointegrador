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
@RequestMapping(value = "/baixa")
public class BaixaService {
	@Autowired
	private BaixaDAO baixaDAO;
	
	//TODO melhorar estes padroes
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<Baixa> list(){
		List<Baixa> result = new ArrayList<>();
		baixaDAO.findAll().forEach(p -> {result.add(p);});
		return result;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public void save(@RequestBody Baixa baixa) {
		baixaDAO.save(baixa);
	}
	
	@RequestMapping(value="/delete/{idBaixa}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idBaixa") Integer idBaixa) {
		baixaDAO.deleteById(idBaixa);
	}
	
	@RequestMapping(value="/calcular", method = RequestMethod.POST)
	public Bem calcular(@PathVariable("idBem") Integer id, Date dateInf) {
		Bem objBem = new Bem(id);
		Baixa baixa = new Baixa(objBem.getId());
		new Calculo().calcularDepreciacao(objBem, baixa, dateInf);
		baixa.setValor_contabil(baixa.getValor_residual());
		baixa.setValor_residual(baixa.getValor_residual());
		baixa.setPeriodo(baixa.getPeriodo());
		baixaDAO.save(baixa);
		return objBem;
	}
}