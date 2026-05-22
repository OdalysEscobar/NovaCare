package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.Servicio;
import org.junit.jupiter.api.Test;
import ec.edu.uce.novacare.dominio.TipoServicio;
import static org.junit.jupiter.api.Assertions.*;

class TipoServicioTest {

    @Test
    void constructorConParametros() {
        Servicio[] servicios = new Servicio[2];
        TipoServicio tipo = new TipoServicio("Masajes", "Masaje terapeutico", servicios);

        assertEquals("Masajes", tipo.getNombreTipoServicio());
        assertEquals("Masajes terapeutico", tipo.getDescripcion());
        assertEquals(servicios, tipo.getServicios());

        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void testToString() {
        TipoServicio tipo = new TipoServicio();
        // Usamos los valores iniciales por defecto definidos en el POJO
        String textoEsperado = "TipoServicio{" +
                "nombreTipoServicio='Corte de cabello'" +
                ", descripcion='Corte en capas'" +
                ", servicios=[]" +
                '}';

        assertEquals(textoEsperado, tipo.toString());
        System.out.println("El metodo toString funciona correctamente✅");
    }

    @Test
    void getNombreTipoServicio() {
        Servicio[] servicios = new Servicio[0];
        TipoServicio tipo = new TipoServicio("Faciales", "Limpieza profunda", servicios);

        assertEquals("Faciales", tipo.getNombreTipoServicio());
        System.out.println("El metodo getNombreTipoServicio funciona correctamente✅");
    }

    @Test
    void setNombreTipoServicio() {
        TipoServicio tipo = new TipoServicio();
        tipo.setNombreTipoServicio("Depilacion");

        assertEquals("Depilacion", tipo.getNombreTipoServicio());
        System.out.println("El metodo setNombreTipoServicio funciona correctamente✅");
    }

    @Test
    void setNombreTipoServicioInvalido() {
        TipoServicio tipo = new TipoServicio();
        tipo.setNombreTipoServicio("Depilacion123");

        assertEquals("Corte de cabello", tipo.getNombreTipoServicio());
        System.out.println("El metodo setNombreTipoServicioInvalido funciona correctamente✅");
    }

    @Test
    void getDescripcion() {
        Servicio[] servicios = new Servicio[0];
        TipoServicio tipo = new TipoServicio("Manicura", "Diseno de unas", servicios);

        assertEquals("Diseno de unas", tipo.getDescripcion());
        System.out.println("El metodo getDescripcion funciona correctamente✅");
    }

    @Test
    void setDescripcion() {
        TipoServicio tipo = new TipoServicio();
        tipo.setDescripcion("Hidratacion con mascarilla");

        assertEquals("Hidratacion con mascarilla", tipo.getDescripcion());
        System.out.println("El metodo setDescripcion funciona correctamente✅");
    }

    @Test
    void setDescripcionInvalida() {
        TipoServicio tipo = new TipoServicio();
        tipo.setDescripcion("Capas_2026*");

        assertEquals("Corte en capas", tipo.getDescripcion());
        System.out.println("El metodo setDescripcionInvalida funciona correctamente✅");
    }

    @Test
    void getServicios() {
        TipoServicio tipo = new TipoServicio();
        Servicio[] servicios = new Servicio[3];
        tipo.setServicios(servicios);

        assertEquals(servicios, tipo.getServicios());
        System.out.println("El metodo getServicios funciona correctamente✅");
    }

    @Test
    void setServicios() {
        TipoServicio tipo = new TipoServicio();
        Servicio[] servicios = new Servicio[1];
        tipo.setServicios(servicios);

        assertEquals(servicios, tipo.getServicios());
        System.out.println("El metodo setServicios funciona correctamente✅");
    }
}