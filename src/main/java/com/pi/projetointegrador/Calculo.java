package com.pi.projetointegrador;

import java.util.Calendar;
import java.util.Date;

import com.pi.projetointegrador.Bem;

public class Calculo {
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
		
		if (dataAtual == null){
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

			//Caso o bem for adiquirido até o dia 15 do mês, inclui-se o mês da compra
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
		b.setValor_residual((b.getValoraquisicao() * b.getTaxa_residual()) / 100);
		/// se o bem for usado ou não
		if (b.getBem_usado() == "Não") {
			b.setVidadmissivel(b.getVida_util());
		}
		else {
			b.setMetade_VidaUtil(b.getVida_util() / 2);
			b.setResta_VidaUtil(b.getVida_util() - b.getTempo_uso());

			if (b.getVida_util() < b.getTempo_uso() || b.getMetade_VidaUtil() > b.getResta_VidaUtil()) {
				b.setVidadmissivel(b.getMetade_VidaUtil());
			}
			else {
				b.setVidadmissivel(b.getResta_VidaUtil());
			}
		}

		if (b.getVidadmissivel() <= 1 || b.getValoraquisicao() <= 326.61) {
			b.setValor_depreciado((float) 0);
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
			b.setTaxaDepreciacao((100 / b.getVidadmissivel()) * calcTurno);

			/* valor depreciado no periodo*/
			b.setValor_depreciado(((b.getValoraquisicao() - b.getValor_residual()) * (b.getTaxaDepreciacao() / 100) / 12) * periodo); // b.getPeriodo());
		}
		/* valor contábil do bem até esse periodo*/
		b.setValor_contabil(b.getValoraquisicao() - b.getValor_depreciado());

		/*caso a depreciação ultrapasse o valor residual*/
		if (b.getValor_depreciado() >= (b.getValoraquisicao() - b.getValor_residual())) {
			b.setValor_contabil(b.getValor_residual());
			b.setValor_depreciado(b.getValoraquisicao());
		}
		return b;
	}


	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}
}
