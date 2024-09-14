import { TipoDocumento } from "./profesor";

export interface TutorSuccess {
   estado: boolean;
   message: string;
   data: Usuario;

}



 export interface Usuario {
   id: number;
   email: string;
   nombre: string;
   tipoDocumento: TipoDocumento
   dni: string;
   apellido: string;
   telefono: string;
   institucion: string;
   rol: 'ADMINISTRADOR' | 'PROFESOR' | 'ESTUDIANTE' | 'TUTOR'; // Asumido a partir de la migración
   activo: boolean;
   estudiante: number[];
 }
