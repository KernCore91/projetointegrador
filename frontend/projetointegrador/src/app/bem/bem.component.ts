import { Component, OnInit } from '@angular/core';
import { BemRestService } from '../bem-rest.service';

@Component({
  selector: 'p-bem',
  templateUrl: './bem.component.html',
  styleUrls: ['./bem.component.css']
})
export class BemComponent implements OnInit {

  bem = { nome: '', cb: 0.0, data_aq: '', usado: '', anos_usado: '', turno: '', vida: '', vr: '', vendido: '', data_vd: '', valor_vd: '', da: '', i: '', n: '', valor_contabil: '' };
  bens: any;

  constructor(private bemRest: BemRestService) { }

  ngOnInit() {
    this.list();
  }

  save() {
    this.bemRest.save(this.bem).subscribe(p => {
      this.list();
      this.bem = { nome: '', cb: 0.0, data_aq: '', usado: '', anos_usado: '', turno: '', vida: '', vr: '', vendido: '', data_vd: '', valor_vd: '', da: '', i: '', n: '', valor_contabil: '' };
    });
  }

  list() {
    this.bemRest.list().subscribe(p => { this.bem = p });
  }

  edit(p) {
    this.bem = p;
  }

  delete(bemp) {
    this.bemRest.delete(bemp.id).subscribe(p => {this.list()});
  }
}