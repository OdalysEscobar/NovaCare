package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.Cliente;
import java.io.*;

public class TestClienteSerializable {

    public static void main(String[] args) {
        // Nombre del archivo binario donde guardaremos el objeto
        String rutaArchivo = "cliente.dat";

        System.out.println("--- INICIANDO PRUEBA DE SERIALIZACIÓN ---");
        exportarCliente(rutaArchivo);
        importarCliente(rutaArchivo);
    }

    // 1. Proceso de Serialización: Guardar el objeto en el disco
    private static void exportarCliente(String archivo) {
        // Creamos un objeto Cliente con datos de prueba
        Cliente cliente1 = new Cliente("Carlos", "Mendizábal", "clave123", "carlos@uce.com", "0991234567");

        // Try-with-resources: se encarga de cerrar los flujos automáticamente
        try (FileOutputStream fos = new FileOutputStream(archivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // El método mágico que toma el objeto y lo transforma en bytes
            oos.writeObject(cliente1);
            System.out.println("✅ Cliente serializado y guardado con éxito en: " + archivo);

        } catch (IOException ioe) {
            System.err.println("❌ Error al guardar el cliente: " + ioe.getMessage());
        }
    }

    // 2. Proceso de Deserialización: Leer los bytes y reconstruir el objeto en la RAM
    private static void importarCliente(String archivo) {
        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Leemos los bytes y hacemos un CASCO (Casting) al tipo de objeto original (Cliente)
            Cliente clienteLeido = (Cliente) ois.readObject();

            System.out.println("✅ Cliente recuperado de forma exitosa del archivo:");
            System.out.println(clienteLeido);

        } catch (FileNotFoundException fne) {
            System.err.println("❌ El archivo no existe: " + fne.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("❌ No se encontró la clase Cliente en el sistema: " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println("❌ Error de lectura/escritura (I/O Exception): " + ioe.getMessage());
        }
    }
}