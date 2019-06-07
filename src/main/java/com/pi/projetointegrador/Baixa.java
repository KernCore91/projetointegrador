package com.pi.projetointegrador;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Baixa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idBaixa;
	private Integer idPatrimonio;
	private Date dataDaBaixa;
	private Float valorDaBaixa;
	private String motivoDaBaixa;
	private Float g_p;
	private Float da;
	private Float vc;
	public Integer getIdBaixa() {
		return idBaixa;
	}
	public void setIdBaixa(Integer idBaixa) {
		this.idBaixa = idBaixa;
	}
	public Integer getIdPatrimonio() {
		return idPatrimonio;
	}
	public void setIdPatrimonio(Integer idPatrimonio) {
		this.idPatrimonio = idPatrimonio;
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
}
