package com.diana;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");// para limitar el precio final a solo 2 decimales

    //#################################################################
    //funcion que calcula la suma de un arraylist de valores(incidencias)
    public static double sumaIncidencias(ArrayList lista) {
        double sum = 0;
        try {
            for (int i = 0; i < lista.size(); i++)
                sum += Double.valueOf((String) lista.get(i));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Double.parseDouble(df.format(sum));
    }


    //#################################################################
    //funcion que lee los datos de un archivo y guarda cada columna en un arraylist, despues suma todos los valores
    public static void leerDatos(String nombreArchivo) throws FileNotFoundException {
        Scanner lector = new Scanner(System.in);
        try {
            String rutaRelativa = "Bomberos" + File.separator + nombreArchivo;
            String pwd = System.getProperty("user.dir");//ruta directorio actual de trabajo
            String rutaAbsoluta = pwd + File.separator + rutaRelativa;// File.separator funciona para Windows y Linux

            File ficheroALeer = new File(rutaAbsoluta);
            Scanner sc = new Scanner(ficheroALeer);//leemos el fichero

            ArrayList<String> listaFuego = new ArrayList<String>();
            ArrayList<String> listaConstr = new ArrayList<String>();
            ArrayList<String> listaSalva = new ArrayList<String>();
            ArrayList<String> listaAgua = new ArrayList<String>();
            ArrayList<String> listaDiversos = new ArrayList<String>();
            ArrayList<String> listaSinInterv = new ArrayList<String>();
            ArrayList<String> listaServVarios = new ArrayList<String>();


            do {//vamos a leer el documento linea por linea
                String linea = sc.nextLine();
                String parte[] = linea.split(";");//dividimos cada linea en 3 partes separadas por ;
                //almacenamos todas las incidencias en arraylists
                listaFuego.add(parte[3]);
                listaConstr.add(parte[4]);
                listaSalva.add(parte[5]);
                listaAgua.add(parte[6]);
                listaDiversos.add(parte[7]);
                listaSinInterv.add(parte[8]);
                listaServVarios.add(parte[9]);
            }
            while (sc.hasNextLine());
            sc.close();

            double totalFuego = sumaIncidencias(listaFuego);
            double totalConstr = sumaIncidencias(listaConstr);
            double totalSalva = sumaIncidencias(listaSalva);
            double totalAgua = sumaIncidencias(listaAgua);
            double totalDiversos = sumaIncidencias(listaDiversos);
            double totalSinInterv = sumaIncidencias(listaSinInterv);
            double totalServVarios = sumaIncidencias(listaServVarios);

            //guardamos todos estos en un array y lo devolvemos


        } catch (Exception e) {//manejamos excepciones
            e.printStackTrace();
        } finally {
            lector.close();//cerramos el scanner
        }

    }

    //#################################################################
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        try {
            //declaramos las variables
            String archivo2017 = "2017.csv";
            String archivo2018 = "2018.csv";
            String archivo2019 = "2019.csv";
            String archivo2020 = "2020.csv";
            String archivo2021 = "2021.csv";
            String archivo2022 = "2022.csv";

            












        } catch (Exception e) {//manejamos excepciones
            e.printStackTrace();
        } finally {
            lector.close();//cerramos el scanner
        }
    }
}


