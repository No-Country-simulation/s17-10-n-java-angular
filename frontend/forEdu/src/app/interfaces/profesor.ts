export interface Profesor {


      email: string,
      nombre:string,
      apellido: string,
      dni: string,
      tipoDocumento: TipoDocumento,
      telefono:string ,
      contrasena: string,
      institucion: string,
      "materia": Materia
}


export type TipoDocumento = 'PASAPORTE' | 'DNI' | 'OTROS';
export type Materia = 'MATEMATICAS' | 'CIENCIAS' | 'LENGUAJE' | 'HISTORIA';




