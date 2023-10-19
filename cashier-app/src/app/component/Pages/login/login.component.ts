import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/User.interface';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  created: boolean = false;
  user!: FormGroup<User | any>;
  users!: User[];
  token!:any;
  username!: string ;
  password!: string;

  constructor(
    // private userService: UserService,
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.user = this.initForm().value;
  
      }


  login(): void {
    this.authService.login(this.username, this.password, this.token).subscribe(
      (response) => {
        console.log(response);
        // Puedes manejar la respuesta aquí
      },
      (error) => {
        console.error(error);
        // Puedes manejar errores aquí
      }
    );
  }



  // async onSubmit() {
  //   // const userData:any = this.user.value;
  //   const response: any = await this.userService.loginUser(this.user.value);

  //   if (!response.error) {
  //     console.log(response);
  //   }
  //   // this.userService.loginUser(userData).subscribe(
  //   //   (response:any) => {

  //   //     console.log(response);
  //   //     if(!response.error){

  //   //     }
  //   //     localStorage.setItem('token', response.token)!
  //   //     console.log(response);
  //   // this.created = true;
  //   // this.router.navigate(['/user']);
  //   //   },
  //   //   (error) => {
  //   //     console.error('Error:', error);
  //   //   }
  //   // );
  // }
  toRegist() {
    this.router.navigate(['register']);
  }
  
  // login() {
  //   /* logica de auth */
  //   this.router.navigate(['user']);
  // }
  initForm(): FormGroup {
    return this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }
}
