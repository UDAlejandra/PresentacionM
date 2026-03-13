import java.util.ArrayList;
import java.util.List;

public class Tarea_Compuesta implements Tarea {
    private String nombre;
    private List<Tarea> subtareas = new ArrayList<>();

    public Tarea_Compuesta(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void agregarTarea(Tarea tarea) {
        subtareas.add(tarea);
    }

    @Override
    public void mostrarTarea(String prefijo) {
        System.out.println(prefijo + "+ " + nombre);
        for (Tarea tarea : subtareas) {
            tarea.mostrarTarea(prefijo + "  ");
        }
    }
}