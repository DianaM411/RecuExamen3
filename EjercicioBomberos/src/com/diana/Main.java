package com.diana;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");// para limitar el precio final a solo 2 decimales

    public static String totalIncidenciasPorAno(String datos){
        ArrayList<String> todosAnosFuego = new ArrayList<String>();
        ArrayList<String> todosAnosConstr = new ArrayList<String>();
        ArrayList<String> todosAnosSalva = new ArrayList<String>();
        ArrayList<String> todosAnosAgua = new ArrayList<String>();
        ArrayList<String> todosAnosDiversos = new ArrayList<String>();
        ArrayList<String> todosAnosSinInterv = new ArrayList<String>();
        ArrayList<String> todosAnosServVarios = new ArrayList<String>();
        String parte[] = datos.split(" ");
        todosAnosFuego.add(parte[0]);
        todosAnosConstr.add(parte[1]);
        todosAnosSalva.add(parte[2]);
        todosAnosAgua.add(parte[3]);
        todosAnosDiversos.add(parte[4]);
        todosAnosSinInterv.add(parte[5]);
        todosAnosServVarios.add(parte[6]);

        double totalFuego = sumaIncidencias(todosAnosFuego);
        double totalConstr = sumaIncidencias(todosAnosConstr);
        double totalSalva = sumaIncidencias(todosAnosSalva);
        double totalAgua = sumaIncidencias(todosAnosAgua);
        double totalDiversos = sumaIncidencias(todosAnosDiversos);
        double totalSinInterv = sumaIncidencias(todosAnosSinInterv);
        double totalServVarios = sumaIncidencias(todosAnosServVarios);

        //guardamos todos estos en un String y lo devolvemos
        String resultado = String.valueOf(totalFuego) + String.valueOf(totalConstr)+String.valueOf(totalSalva)+String.valueOf(totalAgua)+String.valueOf(totalDiversos)+String.valueOf(totalSinInterv)+String.valueOf(totalServVarios);
        return resultado;

    }
    //#################################################################
    //funcion que calcula la suma de un arraylist de valores(incidencias)
    public static double sumaIncidencias(ArrayList lista) {
        double sum = 0;
        try {
            for (int i = 1; i < lista.size(); i++)// empiezo en la segunda posicion porque la primera es el titulo
                sum += Double.valueOf((String) lista.get(i));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Double.parseDouble(df.format(sum));
    }


    //#################################################################
    //funcion que lee los datos de un archivo y guarda cada columna en un arraylist, despues suma todos los valores
    public static String leerDatos(String nombreArchivo) throws FileNotFoundException {
        Scanner lector = new Scanner(System.in);
        String resultado = "";
        try {
            String rutaRelativa = "Bomberos" + File.separator + nombreArchivo;
            String pwd = System.getProperty("user.dir");//ruta directorio actual de trabajo
            String rutaAbsoluta = pwd + File.separator + rutaRelativa;// File.separator funciona para Windows y Linux

            ArrayList<String> listaFuego = new ArrayList<String>();
            ArrayList<String> listaConstr = new ArrayList<String>();
            ArrayList<String> listaSalva = new ArrayList<String>();
            ArrayList<String> listaAgua = new ArrayList<String>();
            ArrayList<String> listaDiversos = new ArrayList<String>();
            ArrayList<String> listaSinInterv = new ArrayList<String>();
            ArrayList<String> listaServVarios = new ArrayList<String>();

            File ficheroALeer = new File(rutaAbsoluta);
            Scanner sc = new Scanner(ficheroALeer);//leemos el fichero


            while (sc.hasNextLine()) {
                //vamos a leer el documento linea por linea
                try {
                    String linea = sc.nextLine();
                    String parte[] = linea.split(";");//dividimos cada linea en partes separadas por ;
                    //almacenamos todas las incidencias en arraylists
                    listaFuego.add(parte[3]);
                    listaConstr.add(parte[4]);
                    listaSalva.add(parte[5]);
                    listaAgua.add(parte[6]);
                    listaDiversos.add(parte[7]);
                    listaSinInterv.add(parte[8]);
                    listaServVarios.add(parte[9]);
                } catch (Exception e) {//manejamos excepciones
                    e.printStackTrace();
                }
            }

            sc.close();

            double totalFuego = sumaIncidencias(listaFuego);
            double totalConstr = sumaIncidencias(listaConstr);
            double totalSalva = sumaIncidencias(listaSalva);
            double totalAgua = sumaIncidencias(listaAgua);
            double totalDiversos = sumaIncidencias(listaDiversos);
            double totalSinInterv = sumaIncidencias(listaSinInterv);
            double totalServVarios = sumaIncidencias(listaServVarios);

            //guardamos todos estos en un String y lo devolvemos
            resultado = String.valueOf(totalFuego) + String.valueOf(totalConstr)+String.valueOf(totalSalva)+String.valueOf(totalAgua)+String.valueOf(totalDiversos)+String.valueOf(totalSinInterv)+String.valueOf(totalServVarios);

        } catch (Exception ex) {//manejamos excepciones
            ex.printStackTrace();
        } finally {
            lector.close();//cerramos el scanner
        }
            return resultado;
    }

    //#################################################################
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        try {
            //nombres de archivos
            String archivo2017 = "2017.csv";
            String archivo2018 = "2018.csv";
            String archivo2019 = "2019.csv";
            String archivo2020 = "2020.csv";
            String archivo2021 = "2021.csv";
            String archivo2022 = "2022.csv";


            ArrayList<String> todosAnosFuego = new ArrayList<String>();
            ArrayList<String> todosAnosConstr = new ArrayList<String>();
            ArrayList<String> todosAnosSalva = new ArrayList<String>();
            ArrayList<String> todosAnosAgua = new ArrayList<String>();
            ArrayList<String> todosAnosDiversos = new ArrayList<String>();
            ArrayList<String> todosAnosSinInterv = new ArrayList<String>();
            ArrayList<String> todosAnosServVarios = new ArrayList<String>();

            //Cada string contiene el numero total de cada tipo de incidencia del ano
            String datos2017 = leerDatos(archivo2017);
            String datos2018 = leerDatos(archivo2018);
            String datos2019 = leerDatos(archivo2019);
            String datos2020 = leerDatos(archivo2020);
            String datos2021 = leerDatos(archivo2021);
            String datos2022 = leerDatos(archivo2022);

            //dividimos el String del 2017
            String parte[] = datos2017.split(" ");
            todosAnosFuego.add(parte[0]);
            todosAnosConstr.add(parte[1]);
            todosAnosSalva.add(parte[2]);
            todosAnosAgua.add(parte[3]);
            todosAnosDiversos.add(parte[4]);
            todosAnosSinInterv.add(parte[5]);
            todosAnosServVarios.add(parte[6]);

        } catch (Exception e) {//manejamos excepciones
            e.printStackTrace();
        } finally {
            lector.close();//cerramos el scanner
        }
    }
}


