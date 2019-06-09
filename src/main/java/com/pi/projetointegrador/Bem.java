package com.pi.projetointegrador;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome_bem;
	private Date dataAquisicao;
	private String categoria;
	private Float vida_util;
	private String bem_usado;
	private Float valorAquisicao;
	private Float taxa_residual;
	private Float turnos;
	private Float tempo_uso;
	private Date dataAtual;
	private Integer periodo;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome_bem() {
		return nome_bem;
	}
	public void setNome_bem(String nome_bem) {
		this.nome_bem = nome_bem;
	}
	public Date getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getVida_util() {
		return vida_util;
	}
	public void setVida_util(Float vida_util) {
		this.vida_util = vida_util;
	}
	public String getBem_usado() {
		return bem_usado;
	}
	public void setBem_usado(String bem_usado) {
		this.bem_usado = bem_usado;
	}
	public Float getValorAquisicao() {
		return valorAquisicao;
	}
	public void setValorAquisicao(Float valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}
	public Float getTaxa_residual() {
		return taxa_residual;
	}
	public void setTaxa_residual(Float taxa_residual) {
		this.taxa_residual = taxa_residual;
	}
	public Float getTurnos() {
		return turnos;
	}
	public void setTurnos(Float turnos) {
		this.turnos = turnos;
	}
	public Float getTempo_uso() {
		return tempo_uso;
	}
	public void setTempo_uso(Float tempo_uso) {
		this.tempo_uso = tempo_uso;
	}
	public Date getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
}