export interface Person {
    
    id: number;
    nombre: string;
    apellido: string;
    fechaNacimiento: string;
    documento: string;
    n: string;
    sexo: string;
    tipo: 'estudiante' | 'profesor' | 'administrador' | 'padres';
    grado?: string;
    seccion?: string;
    turno?: string;
    
  
/*SOLO ESTUDIANTES*/
    codigoalumno?: string;
    legajo?: number;

/*SOLO PROFESORES*/
    asignatura?: string;
   
  }
  
