package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.persistencia.Persistencia;

import java.util.ArrayList;
import java.util.List;

public class CitaDAOMemoriaImpl implements DAO {

    private Agenda agenda = CentroDeBelleza.getCentro().getAgenda();

    public CitaDAOMemoriaImpl() {
        agenda.setCitas(Persistencia.cargarCitas());
    }

    @Override
    public boolean nuevo(Object objeto) {
        if (objeto != null && objeto instanceof Cita) {
            Cita nuevaCita = (Cita) objeto;

            if (!existe(nuevaCita)) {
                // Asumiendo que agenda.getCitas() devuelve una estructura de lista modificable (List)
                agenda.getCitas().add(nuevaCita);
                Persistencia.guardarCitas(agenda.getCitas());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean editar(int pos, Object objeto) {

        if (objeto != null && objeto instanceof Cita) {
            Cita nuevaCita = (Cita) objeto;
            try {

                Cita citaOriginal = agenda.getCitas().get(pos);

                citaOriginal.setFecha(nuevaCita.getFecha());
                citaOriginal.setHora(nuevaCita.getHora());
                citaOriginal.setCliente(nuevaCita.getCliente());
                citaOriginal.setServicio(nuevaCita.getServicio());
                Persistencia.guardarCitas(agenda.getCitas());

                return true;

            } catch (IndexOutOfBoundsException ex) {

                System.out.println("No existe la cita.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean eliminar(int pos) {
        try {

            agenda.getCitas().remove(pos);
            Persistencia.guardarCitas(agenda.getCitas());
            return true;

        } catch (IndexOutOfBoundsException ex) {

            System.out.println("No existe la cita.");
            return false;
        }
    }

    @Override
    public Object buscarPorId(int id) {
        try {
            return agenda.getCitas().get(id);

        } catch (IndexOutOfBoundsException ex) {

            System.out.println("No existe la cita.");
            return null;
        }
    }

    @Override
    public List listarTodos() {
        return agenda.getCitas();
    }

    @Override
    public boolean existe(Object objeto) {
        if (objeto != null && objeto instanceof Cita) {
            Cita cita = (Cita) objeto;

            for (Cita c : agenda.getCitas()) {
                // Validamos que compartan los mismos datos críticos (puedes ajustarlo si usan un ID específico)
                if (c != null && c.getFecha() != null && cita.getFecha() != null
                        && c.getFecha().equals(cita.getFecha())
                        && c.getHora() != null && cita.getHora() != null
                        && c.getHora().equals(cita.getHora())) {
                    return true;
                }
            }
        }
        return false;
    }

//    private boolean validarDuplicado(Object o){
//        if (!(o instanceof Cita)) {
//            return false;
//        }
//
//        Cita cita = (Cita)o;
//
//        for (Cita c: agenda.getCitas()){
//            if (c!=null && c.equals(cita)){
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean nuevo(Cita nuevaCita) {
//        if(nuevaCita == null){
//            return false;
//        }
//
//        if(!validarDuplicado(nuevaCita)) {
//            agenda.getCitas().add(nuevaCita);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean editar(Cita cita, int id) {
//        for (Cita  c: agenda.getCitas()){
//            if (c!=null && c.getId() == id){
//                c.setFecha(cita.getFecha());
//                c.setHora(cita.getHora());
//                c.setCliente(cita.getCliente());
//                c.setServicio(cita.getServicio());
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean eliminar(int id) {
//
//        for (int i = 0; i < agenda.getCitas().size(); i++) {
//
//            if (agenda.getCitas().get(i).getId() == id) {
//
//                agenda.getCitas().remove(i);
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public List<Cita> buscarPorFecha(String fecha) {
//        List<Cita> citasEncontradas = new ArrayList<>();
//
//        if (fecha == null || fecha.trim().isEmpty()) {
//            return citasEncontradas;
//        }
//
//        for (Cita cita : agenda.getCitas()) {
//
//            if (cita != null &&
//                    cita.getFecha() != null &&
//                    cita.getFecha().equals(fecha)) {
//
//                citasEncontradas.add(cita);
//            }
//        }
//
//        return citasEncontradas;
//
//    }
//
//    @Override
//    public List<Cita> listar() {
//        return agenda.getCitas();
//    }
}
