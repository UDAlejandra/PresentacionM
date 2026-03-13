import java.util.Scanner;
public class GestorDeTareas {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido al Gestor de Tareas con menú numérico");

        System.out.print("Ingrese el nombre de la tarea principal: ");
        String nombrePrincipal = scanner.nextLine();
        Tarea_Compuesta tareaPrincipal = new Tarea_Compuesta(nombrePrincipal);

        menuAgregarTareas(tareaPrincipal);

        System.out.println("\nEstructura final de tareas:");
        tareaPrincipal.mostrarTarea("");
    }

    private static void menuAgregarTareas(Tarea_Compuesta tareaCompuesta) {
        while (true) {
            System.out.println("\nTarea actual: " + tareaCompuesta.getNombre());
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar tarea simple");
            System.out.println("2. Agregar tarea compuesta (subtarea con subtareas)");
            System.out.println("3. Volver (salir de esta tarea)");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de la tarea simple: ");
                    String nombreSimple = scanner.nextLine();
                    tareaCompuesta.agregarTarea(new Tarea_Simple(nombreSimple));
                    System.out.println("Tarea simple agregada.");
                    break;

                case "2":
                    System.out.print("Nombre de la tarea compuesta: ");
                    String nombreCompuesta = scanner.nextLine();
                    Tarea_Compuesta subtareaCompuesta = new Tarea_Compuesta(nombreCompuesta);
                    tareaCompuesta.agregarTarea(subtareaCompuesta);
                    System.out.println("Ahora ingresa subtareas para '" + nombreCompuesta + "'");
                    menuAgregarTareas(subtareaCompuesta); // llamada recursiva para esa subtarea
                    break;

                case "3":
                    // Salir de esta tarea compuesta, volver al nivel anterior
                    return;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}