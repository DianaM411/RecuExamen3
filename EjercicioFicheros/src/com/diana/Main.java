package com.diana;

import java.io.File;
import java.util.Scanner;

public class Main {

    //#################################################################
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        try {
            //declaramos las variables



            //pedimos el archivo a leer
            System.out.println("Introduzca el nombre de archivo");
            String rutaRelativa = lector.nextLine();
            String pwd = System.getProperty("user.dir");//ruta directorio actual de trabajo
            String rutaAbsoluta = pwd + File.separator + rutaRelativa;// File.separator funciona para Windows y Linux

            File ficheroALeer = new File(rutaAbsoluta);
            Scanner sc = new Scanner(ficheroALeer);//leemos el fichero




            sc.close();

        } catch (Exception e) {//manejamos excepciones
            e.printStackTrace();
        } finally {
            lector.close();//cerramos el scanner
        }
    }
}


