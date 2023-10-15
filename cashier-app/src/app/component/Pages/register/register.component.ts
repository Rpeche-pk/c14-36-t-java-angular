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
  users!: any[];

  constructor(
    private userService: UserService,
    private router: Router,
    private fb: FormBuilder
  ) {
    console.log('user: ' + this.user);
  }
  ngOnInit(): void {
    this.user = this.initForm();
    console.log('users: ' + this.userService.getUsers());
    console.log('user: ' + this.user);
    console.log('user: ' + this.userService.deleteUser(1));
    this.getAllData();
  }
  toLogin() {
    this.router.navigate(['login']);
  }

  onSubmit(): void {
    const userData = this.user.value;
    this.userService.addNewUser(userData).subscribe(
      (response) => {
        console.log('Respuesta:', response);
        this.created = true;
      },
      (error) => {
        console.error('Error:', error);
      }
    );
  }


  // initForm(): FormGroup {
  //   return this.fb.group(
  //     // {
  //     //   id:['1'],
  //     //   nombre: ['', [Validators.required, Validators.minLength(3)]],
  //     //   apellido: ['', [Validators.required, Validators.minLength(3)]],
  //     //   dni: ['', [Validators.required, Validators.maxLength(8)]],
  //     //   telefono: ['', [Validators.required]],
  //     //   email: ['', [Validators.email, Validators.required]],
  //     //   fechaNac: ['', [Validators.required]],
  //     //   direccion: ['', [Validators.min(5), Validators.required]],
  //     //   password: ['', [Validators.required]],
  //     //   password2: ['', Validators.required]
  //     // }
  //   }

  getAllData() {
    this.userService.getUsers().subscribe(users => {
      this.users = users;
       console.log(this.users)
    })
  }
  initForm(): FormGroup {
    return this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      password2: ['', [Validators.required, Validators.minLength(8)]],
      nombre: ['', [Validators.required]],
      apellido: ['', [Validators.required]],
      telefono: ['', [Validators.required, Validators.minLength(7)]],
      direccion: ['', [Validators.required]],
      fechaNac: ['', [Validators.required, Validators.maxLength(4)]],
      dni: ['', [Validators.required, Validators.maxLength(8)]]
    });
  }
}