// export interface User {
//     id?: any|undefined;
//     nombre: string|undefined;
//     apellido: string;
//     dni: string;
//     telefono: string;
//     email: string;
//     fechaNac: string;
//     direccion: string;
//     password: string;
//     password2: string;
// }

export interface User {
    id: number;
    email: string;
    password: string;
    nombre: string;
    apellido: string;
    telefono: string;
    direccion: string;
    codigoPostal: string;
    dni: string;
  }