import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { emailValidator } from 'src/app/CustomValidator/customValidator';
import { User } from 'src/app/interfaces/User.interface';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  user!: FormGroup<User | any>;
  eyeStatus = false;

  constructor(
    private userService: UserService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.user = this.initForm();
  }

  login() {
    const userData: User = this.user.value;
    this.userService.loginUser(userData).subscribe(
      (response) => {
        if (response.message == 'Authenticación correcta') {
          localStorage.setItem("token", response.token)
          this.router.navigate(['/user']);
        }
        console.log(response);

      },
      (error) => {
        console.error(error);
      }
    );
  }

  toRegist() {
    this.router.navigate(['register']);
  }

  initForm(): FormGroup {
    return this.fb.group({
      email: ['', [Validators.required, emailValidator]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }
  validateField(fieldName: string) {
    this.user.get(fieldName)?.updateValueAndValidity();
  }
}
