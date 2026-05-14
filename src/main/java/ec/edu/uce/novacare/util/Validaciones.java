package ec.edu.uce.novacare.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

    public static boolean validarLetras(String info){
        Pattern pattern = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
        Matcher matcher = pattern.matcher(info);
        return matcher.matches();
    }

    public static boolean validarCorreo (String correo){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher= pattern.matcher(correo);
        return matcher.matches();
    }

    public static boolean validarContrasena (String numeros){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(numeros);
        return matcher.matches();
    }

}
