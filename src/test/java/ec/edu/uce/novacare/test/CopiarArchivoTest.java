package ec.edu.uce.novacare.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;

public class CopiarArchivoTest {

    public static void main(String[] args) {

        System.out.println("Buffer");
        // Uso de BufferedReader y BufferedWriter para leer texto usando memoria caché (RAM)
        try(BufferedReader bufInput = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufOutput = new BufferedWriter(new FileWriter(args[1])))
        {
            String line = "";
            while ((line = bufInput.readLine()) != null){
                bufOutput.write(line);
                bufOutput.newLine();
            }
            bufOutput.flush(); // Fuerza a escribir lo que quede en memoria al archivo físico
            System.out.println("Archivo copiado correctamente.");

        }catch (FileNotFoundException fne){
            System.err.println("Archivo no encontrado:" + fne);
        }catch (IOException ioe){
            System.err.println("IO exception: " + ioe);
        }

        System.out.println("\n\nReader y Writer");
        // Uso de FileReader y FileWriter para leer caracteres planos (texto Unicode) uno por uno
        try(FileReader fis = new FileReader(args[0]);
            FileWriter fos = new FileWriter(args[1]))
        {
            int lectura;
            int contador  = 0;
            while ((lectura = fis.read()) != -1){
                fos.write(lectura);
                contador++;
            }
            System.out.println("Escritura: " + contador);

        }catch (FileNotFoundException fne){
            System.err.println("Archivo no encontrado:" + fne);
        }catch (IOException ioe){
            System.err.println("IO exception: " + ioe);
        }

        System.out.println("\n\nInputStream y OutputStream");
        // Uso de FileInputStream y FileOutputStream para leer bloques de bytes puros (imágenes, objetos, etc.)
        byte[] b = new byte[128];
        int bLongitud = b.length;

        try(FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1])){
            System.out.println("Bytes disponibles: " + fis.available());

            int contador = 0;
            int lectura = 0;

            while ((lectura = fis.read(b)) != -1){
                if (lectura < bLongitud){
                    fos.write(b, 0, lectura);
                } else{
                    fos.write(b);
                }
                contador += lectura;
            }
            System.out.println("Escritura: " + contador);

        }catch (FileNotFoundException fne){
            System.err.println("Archivo no encontrado:" + fne);
        }catch (IOException ioe){
            System.err.println("IO exception: " + ioe);
        }
    }

}
