export interface JwtPayload {

      sub: string;
      nombre?: string;  // Propiedad opcional
      role?: string;
      exp?: number;
      id?: number;

}
