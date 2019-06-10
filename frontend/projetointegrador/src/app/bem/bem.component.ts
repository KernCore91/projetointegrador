import { Component, OnInit } from '@angular/core';
import { BemRestService } from '../bem-rest.service';

@Component({
  selector: 'p-bem',
  templateUrl: './bem.component.html',
  styleUrls: ['./bem.component.css']
})
export class BemComponent implements OnInit {

	bem = {nome_bem: '', dataAquisicao: '', categoria: '', vida_util: '',
		bem_usado: '', valorAquisicao: '', taxa_residual:'', turnos: '', tempo_uso: ''};
	bems: any;

  constructor(private bemRest: BemRestService) { }

  ngOnInit() {
	this.list();
  }

  save() {
	this.bemRest.save(this.bem).subscribe(p => {
		this.list();
	  this.bem = { nome_bem: '', dataAquisicao: '', categoria: '', vida_util: '',
		bem_usado: '', valorAquisicao: '', taxa_residual:'', turnos: '', tempo_uso: ''};
	});
  }

  list() {
	this.bemRest.list().subscribe(p => { this.bem = p });
  }

  edit(p) {
	this.bem = p;
  }

  delete(bem) {
	this.bemRest.delete(bem.id).subscribe(p => {this.list()});
  }
}