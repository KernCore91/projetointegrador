import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { Router, RouterLink, NavigationStart } from '@angular/router';

@Component({
  selector: 'p-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  formularioUsuario: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router,){
    this.formularioUsuario = this.formBuilder.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
    })
  }

  ngOnInit() {

  }

  fazerLogin(){

    let usuario = this.formularioUsuario.value;

    if (usuario.email === "jordy@contato" && usuario.password === "123"){
      this.router.navigate(['/bem']);

    } else {
      alert("Login incorreto, tente novamente.");

    }
  }
}
