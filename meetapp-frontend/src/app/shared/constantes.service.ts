import { Injectable } from '@angular/core';
import { Usuario } from '../components/perfil/model/usuario';

@Injectable()
export class ConstantesService {
  tokenExists: boolean = false;
  imgUserBase64Init: string = 'data:image/png;base64,';
  imgMeetupBase64Init: string = 'data:image/jpeg;base64,';
  imgUsuarioLogueado: string = '';
  genericError: string = 'Ocurrió un error inesperado';
  notFoundError: string = 'El recurso solicitado no se encontró';
  unauthorizedError: string = 'No tiene permiso para acceder a esta página';
  registerError: string = 'Error al registrar el usuario';
  loginError: string = 'Email o contraseña incorrectos';
  noValidImgFileError: string = 'Formato de la imagen no válido';
  botonAsistencia: string = '¡Asisto!';
  botonNoAsistencia: string = 'No asisto';
}
