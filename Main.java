import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Videojuego> videojuegos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE VIDEOJUEGOS ---");
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Modificar videojuego");
            System.out.println("3. Eliminar videojuego");
            System.out.println("4. Mostrar videojuegos");
            System.out.println("5. Salir");

            opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {
                case 1:
                    agregarVideojuego();
                    break;
                case 2:
                    modificarVideojuego();
                    break;
                case 3:
                    eliminarVideojuego();
                    break;
                case 4:
                    mostrarVideojuegos();
                    break;
                case 5:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void agregarVideojuego() {
        System.out.println("\nAgregar videojuego");
        String nombre = leerTexto("Nombre: ");
        String plataforma = leerTexto("Plataforma: ");
        String genero = leerTexto("Género: ");

        videojuegos.add(new Videojuego(nombre, plataforma, genero));
        System.out.println("Videojuego agregado.");
    }

    private static void modificarVideojuego() {
        if (videojuegos.isEmpty()) {
            System.out.println("No hay videojuegos para modificar.");
            return;
        }

        mostrarVideojuegos();
        int numero = leerEntero("Número del videojuego que quieres modificar: ");

        if (!esNumeroValido(numero)) {
            return;
        }

        Videojuego videojuego = videojuegos.get(numero - 1);
        System.out.println("Escribe los nuevos datos.");
        videojuego.setNombre(leerTexto("Nombre: "));
        videojuego.setPlataforma(leerTexto("Plataforma: "));
        videojuego.setGenero(leerTexto("Género: "));

        System.out.println("Videojuego modificado.");
    }

    private static void eliminarVideojuego() {
        if (videojuegos.isEmpty()) {
            System.out.println("No hay videojuegos para eliminar.");
            return;
        }

        mostrarVideojuegos();
        int numero = leerEntero("Número del videojuego que quieres eliminar: ");

        if (!esNumeroValido(numero)) {
            return;
        }

        Videojuego eliminado = videojuegos.remove(numero - 1);
        System.out.println("Se eliminó: " + eliminado.getNombre());
    }

    private static void mostrarVideojuegos() {
        if (videojuegos.isEmpty()) {
            System.out.println("Todavía no hay videojuegos registrados.");
            return;
        }

        System.out.println("\nLista de videojuegos:");
        for (int i = 0; i < videojuegos.size(); i++) {
            System.out.println((i + 1) + ". " + videojuegos.get(i));
        }
    }

    private static boolean esNumeroValido(int numero) {
        if (numero < 1 || numero > videojuegos.size()) {
            System.out.println("Ese número no corresponde a un videojuego de la lista.");
            return false;
        }
        return true;
    }

    private static String leerTexto(String mensaje) {
        String texto;

        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Este dato no puede quedar vacío.");
            }
        } while (texto.isEmpty());

        return texto;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Escribe un número válido.");
            }
        }
    }
}