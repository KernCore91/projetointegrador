package com.pi.projetointegrador;

import java.util.Calendar;
import java.util.Date;

import com.pi.projetointegrador.Bem;

public class Calculo {
	private Float resta_VidaUtil;
	private Float metade_VidaUtil;
	private Float vidadmissivel;
	private Float taxaDepreciacao;
	private Float valor_residual;
	private Float valor_depreciado;
	private Float valor_contabil;
	private Integer depreciacao;
	private Bem bem = new Bem();

	public int calcularPeriodo(Bem b, Date dataAtual) {
		int periodoDepreciado;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(b.getDataAquisicao().getTime()));
		Calendar calendarAtual = Calendar.getInstance();
		calendarAtual.setTime(new Date());
		int diaAquisicao = calendar.get(Calendar.DAY_OF_MONTH);
		int mesAquisicao = calendar.get(Calendar.MONTH) + 1;
		int anoAquisicao = calendar.get(Calendar.YEAR);
		int diaAtual = 0;
		int mesAtual = 0;
		int anoAtual = 0;

		//-------------------
		if (dataAtual == null) {
			//Usando a data do sistema
		    diaAtual = calendarAtual.get(Calendar.DAY_OF_MONTH);
		    mesAtual = calendarAtual.get(Calendar.MONTH) + 1;
		    anoAtual = calendarAtual.get(Calendar.YEAR);
		}
		else {
			//Usando a data passada como parâmetro
			calendarAtual.setTime(new Date(dataAtual.getTime()));
			diaAtual = calendarAtual.get(Calendar.DAY_OF_MONTH);
		    mesAtual = calendarAtual.get(Calendar.MONTH) + 1;
		    anoAtual = calendarAtual.get(Calendar.YEAR);
		}
		periodoDepreciado = (anoAtual - anoAquisicao) * 12;

		if (periodoDepreciado > 0) {
			mesAquisicao = 12 - mesAquisicao;
			/*Caso o bem for adiquirido até o dia 15 do mês, inclui-se o mês da compra*/
			if (diaAquisicao <= 15) {
				mesAquisicao += 1;
			}
		}

		/* Se o bem for vendido até o dia 15 do mês, não conta o mês da venda */
		if (diaAtual < 15) {
			mesAtual -= 1;
		}
		if (periodoDepreciado < 12) {
			periodoDepreciado = mesAquisicao - mesAtual;
			if (periodoDepreciado < 0) {
				periodoDepreciado *= -1;
			}
		}
		else {
			if (periodoDepreciado == 12) {
				periodoDepreciado = mesAquisicao + mesAtual;
			}
			else {
				periodoDepreciado += (mesAquisicao + mesAtual) - 12;
			}
		}
		if (periodoDepreciado > b.getVida_util() * 12) {
			periodoDepreciado = (int) (b.getVida_util() * 12);
		}
		return periodoDepreciado;
	}

	/*Calcular Depreciação*/
	public Bem calcularDepreciacao(Bem b, Date dataInf) {
		float calcTurno;
		int periodo = this.calcularPeriodo(b, dataInf);
		b.setPeriodo(periodo);
		setValor_residual((b.getValorAquisicao() * b.getTaxa_residual()) / 100);
		/// se o bem for usado ou não
		if (b.getBem_usado() == "Não") {
			setVidadmissivel(b.getVida_util());
		}
		else {
			setMetade_VidaUtil(b.getVida_util() / 2);
			setResta_VidaUtil(b.getVida_util() - b.getTempo_uso());
			//
			if (b.getVida_util() < b.getTempo_uso() || getMetade_VidaUtil() > getResta_VidaUtil()) {
				setVidadmissivel(getMetade_VidaUtil());
			}
			else {
				setVidadmissivel(getResta_VidaUtil());
			}
		}
		if (getVidadmissivel() <= 1 || b.getValorAquisicao() <= 326.61) {
			setValor_depreciado((float) 0);
		}
		else {
			/* Depreciação acelerada*/
			if (b.getTurnos() == 1) {
				calcTurno = 1;
			}
			else {
				if (b.getTurnos() == 2) {
					calcTurno = (float) 1.5;
				}
				else {
					calcTurno = 2;
				}
			}
			/* taxa de depreciação*/
			setTaxaDepreciacao((100 / getVidadmissivel()) * calcTurno);
			/* valor depreciado no periodo*/
			setValor_depreciado(((b.getValorAquisicao() - getValor_residual()) * (getTaxaDepreciacao() / 100) / 12) * periodo);
		}
		/* valor contábil do bem até esse periodo*/
		setValor_contabil(b.getValorAquisicao() - getValor_depreciado());

		/*caso a depreciação ultrapasse o valor residual*/
		if (getValor_depreciado() >= (b.getValorAquisicao() - getValor_residual())) {
			setValor_contabil(getValor_residual());
			setValor_depreciado(b.getValorAquisicao());
		}
		return b;
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

	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}
}
