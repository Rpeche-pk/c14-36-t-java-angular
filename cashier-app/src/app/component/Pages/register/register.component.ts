import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/User.interface';
import { UserService } from 'src/app/services/user.service';
import {
  birthValidator,
  dniValidator,
  emailValidator,
  locateValidator,
  passValidator,
  phoneValidator,
  repeatPassValidator,
  textValidator,
} from 'src/app/CustomValidator/customValidator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  eyeStatus = false;
  eyeStatus2 = false;

  repeatPass = false;
  created: boolean = false;
  user!: FormGroup<User | any>;
  // users!: User[];

  constructor(
    private userService: UserService,
    private router: Router,
    private fb: FormBuilder
  ) {}
  ngOnInit(): void {
    this.user = this.initForm();
    // this.getAllData();
  }
  toLogin() {
    this.router.navigate(['login']);
  }

  onSubmit(): void {
    const userData: any = this.user.value;
    this.userService.addNewUser(userData).subscribe(
      (response: any) => {
        const message: string = response.data.message;
        if (message == 'Se registró correctamente') {
          this.router.navigate(['/login']);
        }
        console.log(message);

        this.created = true;
      },
      (error) => {
        console.error('Error:', error);
      }
    );
  }

  // getAllData() {
  //   this.userService.getUsers().subscribe(users => {
  //     this.users = users;
  //     console.log(this.users)
  //   })
  // }
  initForm(): FormGroup {
    return this.fb.group({
      email: ['', [Validators.required, emailValidator]],
      password: ['', [Validators.required, passValidator]],
      password2: ['', [Validators.required, repeatPassValidator]],
      name: ['', [Validators.required, textValidator]],
      lastName: ['', [Validators.required, textValidator]],
      phone: ['', [Validators.required, phoneValidator]],
      address: ['', [Validators.required, locateValidator]],
      birthDate: ['', [Validators.required, birthValidator]],
      dni: ['', [Validators.required, dniValidator]],
    });
  }
  validateField(fieldName: string) {
    this.user.get(fieldName)?.updateValueAndValidity();
  }

}
