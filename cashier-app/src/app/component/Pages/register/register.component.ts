import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/User.interface';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  created: boolean = false;
  user!: FormGroup;

  constructor(
    private userService: UserService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.initForm();
    console.log('user: ' + this.user);
  }
  ngOnInit(): void {
    console.log(
     'users: ' + this.userService.getUsers()    );
  }
  toLogin() {
    this.router.navigate(['login']);
  }

  onSubmit(): void {
    const userData = this.user.value;
    console.log('userData' + userData);

    this.userService.addNewUser(userData).subscribe((res) => {
      console.log('Respuesta: ' + res);
      this.created = true;
    },
      (err) => {
        console.error('Error( ', err + ')');
      }
    );
  }


  initForm(): FormGroup {
    return this.fb.group(
      {
        nombre: ['', [Validators.required, Validators.minLength(3)]],
        apellido: ['', [Validators.required, Validators.minLength(3)]],
        dni: ['', [Validators.required, Validators.maxLength(8)]],
        telefono: ['', [Validators.required]],
        email: ['', [Validators.email, Validators.required]],
        fechaNac: ['', [Validators.required]],
        direccion: ['', [Validators.min(5), Validators.required]],
        password: ['', [Validators.required]],
        password2: ['', Validators.required]
      }
    )
  }
}