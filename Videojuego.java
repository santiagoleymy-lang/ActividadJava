public class Videojuego {
    private String nombre;
    private String plataforma;
    private String genero;

    public Videojuego(String nombre, String plataforma, String genero) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + " | Plataforma: " + plataforma
                + " | Género: " + genero;
    }
}