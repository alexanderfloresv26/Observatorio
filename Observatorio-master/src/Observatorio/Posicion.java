package Observatorio;

import java.util.Comparator;
import java.util.Objects;

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

    public Posicion(String periodoEnLaUbicacion, double longitud, double latitud, double distanciaDeLaTierra, CuerpoCeleste cuerpoCeleste) {
        this.periodoEnLaUbicacion = periodoEnLaUbicacion;
        this.longitud = longitud;
        this.latitud = latitud;
        this.distanciaDeLaTierra = distanciaDeLaTierra;
        this.cuerpoCeleste = cuerpoCeleste;

        cuerpoCeleste.agregarPosicion(this);
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
