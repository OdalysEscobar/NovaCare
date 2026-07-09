package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Recordatorio;

import java.util.ArrayList;
import java.util.List;

public class RecordatorioDAOMemoriaImpl implements DAO{
    private Cita cita;
    private List<Recordatorio> recordatorios;

    public RecordatorioDAOMemoriaImpl(){
        recordatorios = new ArrayList<>();
    }
    public RecordatorioDAOMemoriaImpl (Cita cita){
        this.cita=cita;
    }

    @Override
    public boolean nuevo(Object objeto) {

        if(objeto instanceof Recordatorio){

            Recordatorio recordatorio = (Recordatorio)objeto;

            recordatorios.add(recordatorio);

            return true;
        }

        return false;
    }

    @Override
    public boolean editar(int pos, Object objeto) {

        if(pos >= 0 && pos < recordatorios.size()){

            if(objeto instanceof Recordatorio){

                Recordatorio recordatorio = (Recordatorio)objeto;

                recordatorios.set(pos, recordatorio);

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(int pos) {

        if(pos >= 0 && pos < recordatorios.size()){

            recordatorios.remove(pos);

            return true;
        }
        return false;
    }

    @Override
    public Object buscarPorId(int id) {

        for(Recordatorio recordatorio : recordatorios){

            if(recordatorio.getId() == id){

                return recordatorio;

            }
        }

        return null;
    }

    @Override
    public List listarTodos() {
        return recordatorios;
    }

    @Override
    public boolean existe(Object objeto) {

        if(objeto instanceof Recordatorio){

            Recordatorio recordatorio = (Recordatorio)objeto;

            for(Recordatorio r : recordatorios){

                if(r.equals(recordatorio)){
                    return true;
                }

            }

        }
        return false;
    }
}
