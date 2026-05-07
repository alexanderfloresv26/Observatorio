package Observatorio;

import Excepciones.ExcepcionDeLatitudInvalida;
import Excepciones.ExcepcionDeLongitudInvalida;
import Excepciones.ExcepciondeMesInvalido;
import Excepciones.Mes;

import java.util.Comparator;
import java.util.Objects;

/*
Reglas de las posiciones:
1) Los grados no pueden ser mayores a 180
2) Los meses deben ser validos
*/

public class Posicion implements Comparable <Posicion>{
    private String periodoEnLaUbicacion;
    private double longitud;
    private double latitud;
    private double distanciaDeLaTierra;
    private CuerpoCeleste cuerpoCeleste;

    private static Comparator<Posicion> c = new Comparator<Posicion>() {
        public int compare(Posicion o1, Posicion o2) {
            return o1.compareTo(o2);
        }
    };

    public Posicion(String periodoEnLaUbicacion, double longitud, double latitud, double distanciaDeLaTierra, CuerpoCeleste cuerpoCeleste)
            throws ExcepcionDeLatitudInvalida, ExcepcionDeLongitudInvalida, ExcepciondeMesInvalido {
        this.periodoEnLaUbicacion = periodoEnLaUbicacion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.distanciaDeLaTierra = distanciaDeLaTierra;
        this.cuerpoCeleste = cuerpoCeleste;

        verificacionPosicion();
        cuerpoCeleste.agregarPosicion(this);

    }

    public void verificacionPosicion() throws
            ExcepcionDeLatitudInvalida, ExcepcionDeLongitudInvalida,  ExcepciondeMesInvalido {
        if (latitud < -180 || latitud > 180)
            throw new ExcepcionDeLatitudInvalida("La latitud debe estar entre -180 y 180 grados");
        if (longitud > 180 || longitud < -180)
            throw new ExcepcionDeLongitudInvalida("La longitud debe estar entre -180 y 180 grados");
        try {
            Mes.valueOf(periodoEnLaUbicacion.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new ExcepciondeMesInvalido("No existe ese mes");
        }
    }


    public double getLatitud()
    {
        return latitud;
    }

    public double getLongitud()
    {
        return longitud;
    }

    public String getPeriodoEnLaUbicacion()
    {
        return periodoEnLaUbicacion;
    }

    public double getDistanciaDeLaTierra()
    {
        return distanciaDeLaTierra;
    }

    @Override
    public String toString() {
        return "Observatorio.Posicion{" +
                "periodoEnLaUbicacion='" + periodoEnLaUbicacion + '\'' +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                ", distanciaDeLaTierra=" + distanciaDeLaTierra +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Posicion posicion)) return false;
        return Double.compare(longitud, posicion.longitud) == 0 && Double.compare(latitud, posicion.latitud) == 0 &&
                Double.compare(distanciaDeLaTierra, posicion.distanciaDeLaTierra) == 0 && Objects.equals(periodoEnLaUbicacion, posicion.periodoEnLaUbicacion);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(periodoEnLaUbicacion);
        result = 31 * result + Double.hashCode(longitud);
        result = 31 * result + Double.hashCode(latitud);
        result = 31 * result + Double.hashCode(distanciaDeLaTierra);
        return result;
    }

    @Override
    public int compareTo(Posicion o) {
        int r = 0;
        if ((r = this.periodoEnLaUbicacion.compareTo(o.periodoEnLaUbicacion))!=0)
            return r;
        if ((r = Double.compare(this.longitud, o.longitud)) !=0)
            return r;
        if ((r = Double.compare(this.latitud, o.latitud)) !=0)
            return r;
        return Double.compare(this.distanciaDeLaTierra, o.distanciaDeLaTierra);
    }
}
