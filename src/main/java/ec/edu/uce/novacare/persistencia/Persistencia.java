package ec.edu.uce.novacare.persistencia;

import ec.edu.uce.novacare.dominio.Usuario;
import ec.edu.uce.novacare.dominio.Cita;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    //ARCHIVO USUARIOS

    private static final String ARCHIVO_USUARIOS = "src/main/resources/usuarios.dat";

    public static void guardarUsuarios(List<Usuario> usuarios) {

        try (FileOutputStream fos = new FileOutputStream(ARCHIVO_USUARIOS);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(usuarios);

        } catch (IOException e) {
            System.err.println("Error al guardar los usuarios: " + e.getMessage());
        }

    }

    public static List<Usuario> cargarUsuarios() {

        File archivo = new File(ARCHIVO_USUARIOS);

        // Si el archivo todavía no existe, devolvemos una lista vacía
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (List<Usuario>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // ARCHIVO CITAS

    private static final String ARCHIVO_CITAS = "src/main/resources/citas.dat";

    public static void guardarCitas(List<Cita> citas) {
        try (FileOutputStream fos = new FileOutputStream(ARCHIVO_CITAS);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(citas);
        } catch (IOException e) {
            System.err.println("Error al guardar las citas: " + e.getMessage());
        }

    }

    public static List<Cita> cargarCitas() {

        File archivo = new File(ARCHIVO_CITAS);

        // Si el archivo todavía no existe, devolvemos una lista vacía
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (List<Cita>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los citas: " + e.getMessage());
            return new ArrayList<>();
        }
    }


}
