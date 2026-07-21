package ec.edu.uce.novacare.persistencia;

import ec.edu.uce.novacare.dominio.TipoServicio;
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

        try (FileInputStream fis = new FileInputStream(ARCHIVO_USUARIOS);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            List<Usuario> usuarios = (List<Usuario>) ois.readObject();

            int mayor = 0;

            for (Usuario usuario : usuarios) {
                if (usuario.getCodigo() > mayor) {
                    mayor = usuario.getCodigo();
                }
            }

            Usuario.setContador(mayor);

            return usuarios;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    //ARCHIVO TIPO DE SERVICIOS
    private static final String ARCHIVO_SERVICIOS = "src/main/resources/servicios.dat";
    public static void guardarServicios(
            List<TipoServicio> tipoServicios) {

        try (FileOutputStream fos =
                     new FileOutputStream(ARCHIVO_SERVICIOS);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {

            oos.writeObject(tipoServicios);

        } catch (IOException e) {
            System.err.println(
                    "Error al guardar los servicios: " + e.getMessage()
            );
        }
    }

    public static List<TipoServicio> cargarServicios() {

        File archivo = new File(ARCHIVO_SERVICIOS);

        if (!archivo.exists() || archivo.length() == 0) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (List<TipoServicio>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println(
                    "Error al cargar los servicios: " + e.getMessage()
            );
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
