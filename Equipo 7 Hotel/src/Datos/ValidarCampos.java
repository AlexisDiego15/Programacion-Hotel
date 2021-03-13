package Datos;
public class ValidarCampos {
    
    private String error;
    
    public boolean Letras(String cadena, String campo){
        boolean ret = false;
        if(cadena.length() != 0)
            if(!cadena.matches("[0-9]"))
                if(cadena.length() != cadena.indexOf(" ")){
                    error = "Todo bien en " + campo;
                    ret = true;
                }
                else
                    error = "Ingrese " + campo;
            else
                error = "Ingrese solo letras en " + campo;
        else
            error = "Ingrese " + campo;
        return ret;
    }
    
      public boolean Vacio(String cadena, String campo){
        boolean ret = false;
        if(cadena.length() != 0){
            
                    error = "Todo bien en " + campo;
                    ret = true;
        }
                else
                    error = "Ingrese " + campo;

        return ret;
    }
    
    
    public boolean SinEspacios(String cadena, String campo){
        boolean ret = false;
        if(cadena.length() != 0)
            if(cadena.length() != cadena.indexOf(" ")){
                error = "Todo bien en " + campo;
                ret = true;
            }
            else
                error = "Ingrese " + campo;
        else
            error = "Ingrese " + campo;
        return ret;
    }
    
    public boolean Numeros(String cadena, String campo){
        boolean ret = false;
        if(cadena.length() != 0)
            if(cadena.matches("[0-9]*"))
                if(cadena.length() != cadena.indexOf(" ")){
                    error = "Todo bien en " + campo;
                    ret = true;
                }
                else
                    error = "Ingrese " + campo;
            else
                error = "Ingrese solo numeros en " + campo;
        else
            error = "Ingrese " + campo;
        return ret;
    }
    public String err(){
        return error;
    }

}
