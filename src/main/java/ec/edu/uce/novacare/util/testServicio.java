package ec.edu.uce.novacare.util;

import ec.edu.uce.novacare.dominio.Servicio;
public class testServicio {

    public static void main(String[] args) {

        System.out.println("===TEST SERVICIO==");
        Servicio servicio=new Servicio("Corte de cabello", 45,true);

        //TIPO SERVICIO
        System.out.println("Prueba tipo servicio:");

        if("Corte de cabello".equals(servicio.getTipoServicio())){
            System.out.println("PASÓ ✔");
        }else{
            System.out.println("FALLÓ ❌");
        }

        //DURACIÓN
        System.out.println("Duración:");

        if (servicio.getDuracion()==45){
            System.out.println("PASÓ ✔");
        }else{
            System.out.println("FALLÓ ❌");
        }

        //DISPONIBILIDAD
        System.out.println("Disponibilidad: ");

        if (servicio.isDispoinibilidad()){
            System.out.println("PASÓ ✔");
        }else{
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DEL SERVICIO:");
        System.out.println(servicio);
    }
}
