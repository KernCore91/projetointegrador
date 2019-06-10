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
	private Date dataAtual;
	private Integer periodo;
	private String categoria;
	private Float vida_util;
	private String bem_usado;
	private Float tempo_uso;
	private Float turnos;
	private Float taxa_residual;

//	calculo
	private Float resta_VidaUtil;
	private Float metade_VidaUtil;
	private Float vidadmissivel;
	private Float taxaDepreciacao;
	private Float valorAquisicao;
	private Float valor_residual;
	private Float valor_depreciado;
	private Float valor_contabil;
	private Integer depreciacao;

//	baixa
	private Date dataDaBaixa;
	private Float valorDaBaixa;
	private Long idBaixa;
	private String motivoDaBaixa;
	private Float g_p;
	private Float da;
	private Float vc;

	public Bem() {
		super();
	}

	public Bem(String nome_bem, Date dataAquisicao, String categoria, Float vida_util, String bem_usado,
			Float tempo_uso, Float turnos, Float taxa_residual, Float valorAquisicao) {
		super();
		this.nome_bem = nome_bem;
		this.dataAquisicao = dataAquisicao;
		this.categoria = categoria;
		this.vida_util = vida_util;
		this.bem_usado = bem_usado;
		this.tempo_uso = tempo_uso;
		this.turnos = turnos;
		this.taxa_residual = taxa_residual;
		this.valorAquisicao = valorAquisicao;
	}

	public Bem(Integer id) {
		super();
		this.id = id;
	}

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
	public Float getTempo_uso() {
		return tempo_uso;
	}
	public void setTempo_uso(Float tempo_uso) {
		this.tempo_uso = tempo_uso;
	}
	public Float getTurnos() {
		return turnos;
	}
	public void setTurnos(Float turnos) {
		this.turnos = turnos;
	}
	public Float getTaxa_residual() {
		return taxa_residual;
	}
	public void setTaxa_residual(Float taxa_residual) {
		this.taxa_residual = taxa_residual;
	}
	public Float getResta_VidaUtil() {
		return resta_VidaUtil;
	}
	public void setResta_VidaUtil(Float resta_VidaUtil) {
		this.resta_VidaUtil = resta_VidaUtil;
	}
	public Float getMetade_VidaUtil() {
		return metade_VidaUtil;
	}
	public void setMetade_VidaUtil(Float metade_VidaUtil) {
		this.metade_VidaUtil = metade_VidaUtil;
	}
	public Float getVidadmissivel() {
		return vidadmissivel;
	}
	public void setVidadmissivel(Float vidadmissivel) {
		this.vidadmissivel = vidadmissivel;
	}
	public Float getTaxaDepreciacao() {
		return taxaDepreciacao;
	}
	public void setTaxaDepreciacao(Float taxaDepreciacao) {
		this.taxaDepreciacao = taxaDepreciacao;
	}
	public Float getValoraquisicao() {
		return valorAquisicao;
	}
	public void setValoraquisicao(Float valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}
	public Float getValor_residual() {
		return valor_residual;
	}
	public void setValor_residual(Float valor_residual) {
		this.valor_residual = valor_residual;
	}
	public Float getValor_depreciado() {
		return valor_depreciado;
	}
	public void setValor_depreciado(Float valor_depreciado) {
		this.valor_depreciado = valor_depreciado;
	}
	public Float getValor_contabil() {
		return valor_contabil;
	}
	public void setValor_contabil(Float valor_contabil) {
		this.valor_contabil = valor_contabil;
	}
	public Integer getDepreciacao() {
		return depreciacao;
	}
	public void setDepreciacao(Integer depreciacao) {
		this.depreciacao = depreciacao;
	}
	public Date getDataDaBaixa() {
		return dataDaBaixa;
	}
	public void setDataDaBaixa(Date dataDaBaixa) {
		this.dataDaBaixa = dataDaBaixa;
	}
	public Float getValorDaBaixa() {
		return valorDaBaixa;
	}
	public void setValorDaBaixa(Float valorDaBaixa) {
		this.valorDaBaixa = valorDaBaixa;
	}
	public Long getIdBaixa() {
		return idBaixa;
	}
	public void setIdBaixa(Long idBaixa) {
		this.idBaixa = idBaixa;
	}
	public String getMotivoDaBaixa() {
		return motivoDaBaixa;
	}
	public void setMotivoDaBaixa(String motivoDaBaixa) {
		this.motivoDaBaixa = motivoDaBaixa;
	}
	public Float getG_p() {
		return g_p;
	}
	public void setG_p(Float g_p) {
		this.g_p = g_p;
	}
	public Float getDa() {
		return da;
	}
	public void setDa(Float da) {
		this.da = da;
	}
	public Float getVc() {
		return vc;
	}
	public void setVc(Float vc) {
		this.vc = vc;
	}
}