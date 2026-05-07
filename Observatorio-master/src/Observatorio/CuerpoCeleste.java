package Observatorio;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class CuerpoCeleste implements Comparable <CuerpoCeleste> {
    private String nombre;
    private String composicion;
    private List<Posicion> posiciones;
    private List<Desplazamiento> desplazamientos;

    private static Comparator <CuerpoCeleste> c = new Comparator<CuerpoCeleste>() {
        public int compare(CuerpoCeleste o1, CuerpoCeleste o2) {
            return o1.compareTo(o2);
        }
    };

    public CuerpoCeleste(String nombre, String composicion) {
        this.nombre = nombre;
        this.composicion = composicion;
        this.posiciones = new ArrayList<>();
        this.desplazamientos = new ArrayList<>();
    }

    public void agregarPosicion(Posicion posicion) {
        this.posiciones.add(posicion);
    }

    public void agregarDesplazamiento(Desplazamiento desplazamiento) {
        this.desplazamientos.add(desplazamiento);
    }

    public List <Posicion> getPosiciones()
    {
        return posiciones;
    }

    public List <Desplazamiento> getDesplazamientos ()
    {
        return desplazamientos;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getComposicion()
    {
        return composicion;
    }

    @Override
    public String toString() {
        return "Observatorio.CuerpoCeleste{" +
                "nombre='" + nombre + '\'' +
                ", composicion='" + composicion + '\'' +
                ", posiciones=" + posiciones +
                ", desplazamientos=" + desplazamientos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CuerpoCeleste that)) return false;
        return Objects.equals(nombre, that.nombre) && Objects.equals(composicion, that.composicion) &&
                Objects.equals(posiciones, that.posiciones) && Objects.equals(desplazamientos, that.desplazamientos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nombre);
        result = 31 * result + Objects.hashCode(composicion);
        result = 31 * result + Objects.hashCode(posiciones);
        result = 31 * result + Objects.hashCode(desplazamientos);
        return result;
    }

    @Override
    public int compareTo(CuerpoCeleste o) {
        int r = 0;
        if ((r=this.nombre.compareTo(o.nombre))!=0)
            return r;
        return this.composicion.compareTo(o.composicion);
    }
}
