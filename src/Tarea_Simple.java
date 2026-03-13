public class Tarea_Simple implements Tarea {
    private String nombre;

    public Tarea_Simple(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrarTarea(String prefijo) {
        System.out.println(prefijo + "- " + nombre);
    }
}