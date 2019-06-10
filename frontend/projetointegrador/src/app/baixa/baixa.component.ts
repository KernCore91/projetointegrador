import { Component, OnInit } from '@angular/core';
import { BaixaRestService } from '../baixa-rest.service';
import { BemComponent } from '../bem/bem.component';

@Component({
  selector: 'p-baixa',
  templateUrl: './baixa.component.html',
  styleUrls: ['./baixa.component.css']
})
export class BaixaComponent implements OnInit {
	
	bem: any;
	baixa = { idBem: '', dataDaBaixa: '', valorDaBaixa: '', motivoDaBaixa: '', Valor_contabil: '', Valor_residual: '', Periodo: '' };
	baixas: any;

	constructor(private baixaRest: BaixaRestService) { }

	ngOnInit() {
		this.list();
	}

	list() {
		this.baixaRest.list().subscribe(w => { this.baixas = w });
	}

	delete(baixa) {
		this.baixaRest.delete(baixa.idBaixa).subscribe(p => { this.list() });
	}

    save() {
    this.baixaRest.save(this.baixa).subscribe(p => {
      this.list();
      this.baixa = { idBem: '', dataDaBaixa: '', valorDaBaixa: '', motivoDaBaixa: '', Valor_contabil: '', Valor_residual: '', Periodo: '' };
    });
    }

    calcular(idBem) {
		this.baixaRest.calcular(this.baixa.idBem).subscribe(p => { this.calcular(idBem) });
	}
}