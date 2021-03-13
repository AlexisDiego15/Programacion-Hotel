package Datos;

public class Calendario {
    
    int diainicial, diafinal, regreso=1;
    
    public int validacion(int dia_i, int mes_i, int anio_i, int dia_f, int mes_f, int anio_f) {
        if(anio_i==2019){
            if(mes_i>0 && mes_i<13){
                if(mes_i==1||mes_i==3||mes_i==5||mes_i==7||mes_i==8||mes_i==10||mes_i==12){
                    if(dia_i>0 && dia_i<32){
                        if(mes_i==1){
                            diainicial = dia_i-1;
                        }else if(mes_i==3){
                            diainicial = dia_i + 31+28-1;
                        }else if(mes_i==5){
                            diainicial = dia_i + 31+28+31+30-1;
                        }else if(mes_i==7){
                            diainicial = dia_i + 31+28+31+30+31+30-1;
                        }else if(mes_i==8){
                            diainicial = dia_i + 31+28+31+30+31+30+31-1;
                        }else if(mes_i==10){
                            diainicial = dia_i + 31+28+31+30+31+30+31+31+30-1;
                        }else if(mes_i==12){
                            diainicial = dia_i + 31+28+31+30+31+30+31+31+30+31+30-1;
                        }
                    }else{
                        System.out.println("Ese dia no existe");
                        regreso=0;
                    }               
                }else if (mes_i==4||mes_i==6||mes_i==9||mes_i==11){
                    if(dia_i>0 && dia_i<31){
                        if(mes_i==4){
                            diainicial = dia_i + 31+28+31-1;
                        }else if(mes_i==6){
                            diainicial = dia_i + 31+28+31+30+31-1;
                        }else if(mes_i==9){
                            diainicial = dia_i + 31+28+31+30+31+30+31+31-1;
                        }else if(mes_i==11){
                            diainicial = dia_i + 31+28+31+30+31+30+31+31+30+31-1;
                        }  
                    }else{
                        System.out.println("Ese dia no existe");
                        regreso=0;
                    }
                }else if(mes_i==2){
                    if(dia_i>0 && dia_i<29){
                        diainicial = dia_i+31;    
                    }else{
                        System.out.println("Ese dia no existe");
                        regreso=0;
                    }
                }
                }else{
                    System.out.println("Escribe un mes de llegada correcto");
                    regreso=0;
            }
        }
        if(anio_i==2020){
            if(mes_i>0 && mes_i<13){
                if(mes_i==1||mes_i==3||mes_i==5||mes_i==7||mes_i==8||mes_i==10||mes_i==12){
                    if(dia_i>0 && dia_i<32){
                        if(mes_i==1){
                            diainicial = 365+dia_i-1;
                        }else if(mes_i==3){
                            diainicial = 366+dia_i + 31+28-1;
                        }else if(mes_i==5){
                            diainicial = 366+dia_i + 31+28+31+30-1;
                        }else if(mes_i==7){
                            diainicial = 366+dia_i + 31+28+31+30+31+30-1;
                        }else if(mes_i==8){
                            diainicial = 366+dia_i + 31+28+31+30+31+30+31-1;
                        }else if(mes_i==10){
                            diainicial = 366+dia_i + 31+28+31+30+31+30+31+31+30-1;
                        }else if(mes_i==12){
                            diainicial = 366+dia_i + 31+28+31+30+31+30+31+31+30+31+30-1;
                        }
                    }else{
                        System.out.println("Ese dia no existe");
                        regreso=0;
                    }               
                }else if (mes_i==4||mes_i==6||mes_i==9||mes_i==11){
                    if(dia_i>0 && dia_i<31){
                        if(mes_i==4){
                            diainicial = 366+dia_i + 31+28+31-1;
                        }else if(mes_i==6){
                            diainicial = 366+dia_i + 31+28+31+30+31-1;
                        }else if(mes_i==9){
                            diainicial = 366+dia_i + 31+28+31+30+31+30+31+31-1;
                        }else if(mes_i==11){
                            diainicial = 366+dia_i + 31+28+31+30+31+30+31+31+30+31-1;
                        }  
                    }else{
                        System.out.println("Ese dia no existe");
                        regreso=0;
                    }
                }else if(mes_i==2){
                    if(dia_i>0 && dia_i<30){
                        diainicial = 365+dia_i+31;    
                    }else{
                        System.out.println("Ese dia no existe");
                        regreso=0;
                    }
                }
                }else{
                    System.out.println("Escribe un mes de llegada correcto");
                    regreso=0;
            }
        }
        if(anio_f==2019){
        if(mes_f>0 && mes_f<13){
            if(mes_f==1||mes_f==3||mes_f==5||mes_f==7||mes_f==8||mes_f==10||mes_f==12){
                if(dia_f>0 && dia_f<32){
                    if(mes_f==1){
                        diafinal = dia_f-1;
                    }else if(mes_f==3){
                        diafinal = dia_f + 31+28-1;
                    }else if(mes_f==5){
                        diafinal = dia_f + 31+28+31+30-1;
                    }else if(mes_f==7){
                        diafinal = dia_f + 31+28+31+30+31+30-1;
                    }else if(mes_f==8){
                        diafinal = dia_f + 31+28+31+30+31+30+31-1;
                    }else if(mes_f==10){
                        diafinal = dia_f + 31+28+31+30+31+30+31+31+30-1;
                    }else if(mes_f==12){
                        diafinal = dia_f + 31+28+31+30+31+30+31+31+30+31+30-1;
                    }
                }else{
                    System.out.println("Ese dia no existe");
                    regreso=0;
                }               
            }else if (mes_f==4||mes_f==6||mes_f==9||mes_f==11){
                if(dia_f>0 && dia_f<31){
                    if(mes_f==4){
                        diafinal = dia_f + 31+28+31-1;
                    }else if(mes_f==6){
                        diafinal = dia_f + 31+28+31+30+31-1;
                    }else if(mes_f==9){
                        diafinal = dia_f + 31+28+31+30+31+30+31+31-1;
                    }else if(mes_f==11){
                        diafinal = dia_f + 31+28+31+30+31+30+31+31+30+31-1;
                    }  
                }else{
                    System.out.println("Ese dia no existe");
                    regreso=0;
                }
            }else if(mes_f==2){
                if(dia_f>0 && dia_f<29){
                    diafinal = dia_f+31;                    
                }else{
                    System.out.println("Ese dia no existe");
                    regreso=0;
            }
            }
        }else{
            System.out.println("Escribe un mes de salida correcto");
            regreso=0;
            }
        }
        if(anio_f==2020){
        if(mes_f>0 && mes_f<13){
            if(mes_f==1||mes_f==3||mes_f==5||mes_f==7||mes_f==8||mes_f==10||mes_f==12){
                if(dia_f>0 && dia_f<32){
                    if(mes_f==1){
                        diafinal = 365+dia_f-1;
                    }else if(mes_f==3){
                        diafinal = 366+dia_f + 31+28-1;
                    }else if(mes_f==5){
                        diafinal = 366+dia_f + 31+28+31+30-1;
                    }else if(mes_f==7){
                        diafinal = 366+dia_f + 31+28+31+30+31+30-1;
                    }else if(mes_f==8){
                        diafinal = 366+dia_f + 31+28+31+30+31+30+31-1;
                    }else if(mes_f==10){
                        diafinal = 366+dia_f + 31+28+31+30+31+30+31+31+30-1;
                    }else if(mes_f==12){
                        diafinal = 366+dia_f + 31+28+31+30+31+30+31+31+30+31+30-1;
                    }
                }else{
                    System.out.println("Ese dia no existe");
                    regreso=0;
                }               
            }else if (mes_f==4||mes_f==6||mes_f==9||mes_f==11){
                if(dia_f>0 && dia_f<31){
                    if(mes_f==4){
                        diafinal = 366+dia_f + 31+28+31-1;
                    }else if(mes_f==6){
                        diafinal = 366+dia_f + 31+28+31+30+31-1;
                    }else if(mes_f==9){
                        diafinal = 366+dia_f + 31+28+31+30+31+30+31+31-1;
                    }else if(mes_f==11){
                        diafinal = 366+dia_f + 31+28+31+30+31+30+31+31+30+31-1;
                    }  
                }else{
                    System.out.println("Ese dia no existe");
                    regreso=0;
                }
            }else if(mes_f==2){
                if(dia_f>0 && dia_f<30){
                    diafinal = 365+dia_f+31;                    
                }else{
                    System.out.println("Ese dia no existe");
                    regreso=0;
            }
            }
        }else{
            System.out.println("Escribe un mes de salida correcto");
            regreso=0;
            }
        }
        
        if(diafinal<diainicial){
            regreso=0;    
        }         
        return regreso;
    }

    public int fechas(int entrada, int salida){
        int valido=0;
        if(diainicial<diafinal){
            valido=1;
        }
        return valido;
    }

    public int entrada(){
        return diainicial;
    }
    public int salida(){
        return diafinal;
    }
}
