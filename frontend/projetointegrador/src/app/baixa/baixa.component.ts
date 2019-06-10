import { Component, OnInit } from '@angular/core';
import { BaixaRestService } from '../baixa-rest.service';

@Component({
  selector: 'p-baixa',
  templateUrl: './baixa.component.html',
  styleUrls: ['./baixa.component.css']
})
export class BaixaComponent implements OnInit {

	baixa = { idBem: '', dataDaBaixa: '', valorDaBaixa: '', motivoDaBaixa: '', g_p: '', da: '', vc: '' };
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
      this.baixa = { idBem: '', dataDaBaixa: '', valorDaBaixa: '', motivoDaBaixa: '', g_p: '', da: '', vc: '' };
    });
    }
}