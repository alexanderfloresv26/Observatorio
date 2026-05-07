package Observatorio;

import java.util.Comparator;
import java.util.Objects;

public class Desplazamiento implements Comparable <Desplazamiento>
{
    private Posicion posicionInicial;
    private Posicion posicionFinal;
    private CuerpoCeleste cuerpoCeleste;

    private static Comparator<Desplazamiento> c = new Comparator<Desplazamiento>() {
        public int compare(Desplazamiento o1, Desplazamiento o2) {
            return o1.compareTo(o2);
        }
    };

    public Desplazamiento(Posicion posicionInicial, Posicion posicionFinal, CuerpoCeleste cuerpoCeleste)
    {
        this.posicionInicial = posicionInicial;
        this.posicionFinal = posicionFinal;
        this.cuerpoCeleste = cuerpoCeleste;

        cuerpoCeleste.agregarDesplazamiento(this);
    }

    public double calcularDistanciaDesplazada()
    {
        return Math.sqrt(Math.pow(posicionFinal.getLongitud() - posicionInicial.getLongitud(), 2) +
                Math.pow(posicionFinal.getLatitud() - posicionInicial.getLatitud(), 2));
    }

    public Posicion getPosicionInicial()
    {
        return posicionInicial;
    }

    public Posicion getPosicionFinal()
    {
        return posicionFinal;
    }

    @Override
    public String toString() {
        return "Observatorio.Desplazamiento{" +
                "posicionInicial=" + posicionInicial +
                ", posicionFinal=" + posicionFinal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Desplazamiento that)) return false;
        return Objects.equals(posicionInicial, that.posicionInicial) && Objects.equals(posicionFinal, that.posicionFinal);
    }

    @Override
    public int hashCode() {
        int result = posicionInicial.hashCode();
        result = 31 * result + posicionFinal.hashCode();
        return result;
    }

    @Override
    public int compareTo(Desplazamiento o) {
        int r = 0;

        if ((r=this.posicionInicial.compareTo(o.posicionInicial)) !=0)
            return r;
        return this.posicionFinal.compareTo(o.posicionFinal);
    }
}
