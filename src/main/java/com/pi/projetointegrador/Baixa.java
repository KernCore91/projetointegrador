package com.pi.projetointegrador;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Baixa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idBaixa;
	@JoinColumn(name="idBem")
	private Integer idBem;
	private Date dataDaBaixa;
	private Float valorDaBaixa;
	private String motivoDaBaixa;
	private Float g_p;
	private Float da;
	private Float vc;
	
//	calculo
	private Float resta_VidaUtil;
	private Float metade_VidaUtil;
	private Float vidadmissivel;
	private Float taxaDepreciacao;
	private Float valor_residual;
	private Float valor_depreciado;
	private Float valor_contabil;
	private Integer depreciacao;
	private Integer periodo;
	
	public Baixa(Integer idBem) {
		super();
		this.idBem = idBem;
	}

	public Baixa(Integer idBem, Date dataDaBaixa, Float valorDaBaixa, String motivoDaBaixa, Float g_p, Float da,
			Float vc) {
		super();
		this.idBem = idBem;
		this.dataDaBaixa = dataDaBaixa;
		this.valorDaBaixa = valorDaBaixa;
		this.motivoDaBaixa = motivoDaBaixa;
		this.g_p = g_p;
		this.da = da;
		this.vc = vc;
	}
	public Integer getIdBaixa() {
		return idBaixa;
	}
	public void setIdBaixa(Integer idBaixa) {
		this.idBaixa = idBaixa;
	}
	public Integer getIdBem() {
		return idBem;
	}
	public void setIdBem(Integer idBem) {
		this.idBem = idBem;
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

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
}
