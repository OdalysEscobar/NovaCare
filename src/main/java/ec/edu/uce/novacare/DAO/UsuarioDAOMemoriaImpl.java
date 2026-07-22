package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.persistencia.Persistencia;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Usuario;

import java.util.List;

public class UsuarioDAOMemoriaImpl implements UsuarioDAO{

    private static List<Usuario> usuarios = Persistencia.cargarUsuarios();

    private CentroDeBelleza centro = CentroDeBelleza.getCentro();

    public UsuarioDAOMemoriaImpl() {
        centro.setUsuarios(usuarios);
    }

    private boolean validarDuplicado(Object o){
        if (!(o instanceof Usuario)) {
            return false;
        }

        Usuario usuario = (Usuario)o;

        for (Usuario u:usuarios){
            if (u!=null && u.equals(usuario)){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean nuevo(Usuario nuevoUsuario){

        if(nuevoUsuario == null){
            return false;
        }

        if(!validarDuplicado(nuevoUsuario)) {
            usuarios.add(nuevoUsuario);
            Persistencia.guardarUsuarios(usuarios);
            return true;
        }

        return false;
    }

    @Override
    public boolean editar(Usuario nuevo, String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getCorreo().equals(correo)){
                usuario.setNombre(nuevo.getNombre());
                usuario.setApellido(nuevo.getApellido());
                usuario.setCorreo(nuevo.getCorreo());
                usuario.setContrasena(nuevo.getContrasena());
                if (usuario instanceof Cliente && nuevo instanceof Cliente) {
                    ((Cliente) usuario).setNumeroDeTelefono(
                            ((Cliente) nuevo).getNumeroDeTelefono());
                }
                Persistencia.guardarUsuarios(usuarios);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean eliminar(String correo) {
        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getCorreo().equals(correo)) {

                usuarios.remove(i);

                Persistencia.guardarUsuarios(usuarios);

                return true;
            }
        }

        return false;
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        if (correo == null){
            return null;
        }
        for (Usuario u:usuarios){
            if (u.getCorreo().equals(correo)){
                return u;
            }
        }

        return null;
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
    }


}
