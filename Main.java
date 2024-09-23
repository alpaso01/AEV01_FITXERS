package com.dam.alex;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        String directorio = "";
        Main main = new Main();
        int fecha ;



System.out.println("Introduce un directorio de trabajo");
directorio = teclado.nextLine();

File ruta = new File(directorio);

if (ruta.exists()){
    System.out.println("el directorio existe");

    System.out.println("Nombre : "+ruta.getName());
if (ruta.isFile()){
    System.out.println("es un archivo");
} else if (ruta.isDirectory()) {
    System.out.println("es un directorio");
}
System.out.println("Ubicación : "+ruta.getAbsolutePath());


//saber fecha de la ultima modificación del directorio
fecha = (int) ruta.lastModified();
    Date date = main.FechaModificar(fecha);
    System.out.println("Ultima modificacion : "+date);

    System.out.println("Esta oculto? "+ruta.isHidden());

    if (ruta.isFile()){
        System.out.println("grandaria del fichero en bytes : "+ruta.length() + " bytes");
    } else if (ruta.isDirectory()) {

//recorre la array de tipo file y muestra los archivos del directorio que se pide por pantalla
File[] listaFiles = ruta.listFiles();
for (File archivos : listaFiles){
    System.out.println(archivos.getName());
}

        System.out.println("Espacio disponible : "+ruta.getFreeSpace());
        System.out.println("Total espacio : "+ruta.getTotalSpace());

        System.out.println("QUIERES CREAR UN DIRECTORIO? 1- si // 2- no");
        int si = teclado.nextInt();
        if (si == 1) {
            File dir = new File("nombre_del_directorio");
            if (dir.mkdir()) {

                    File archivo = new File(directorio, "nombre_del_archivo.txt");
                    if (archivo.createNewFile()) {
                        System.out.println("Archivo creado: " + archivo.getName());
                        if (archivo.delete()) {
                            System.out.println("Archivo eliminado: " + archivo.getName());
                        }
                        File nuevoArchivo = new File(directorio, "nuevo_nombre_del_archivo.txt");
                        if (archivo.renameTo(nuevoArchivo)) {
                            System.out.println("Archivo renombrado a: " + nuevoArchivo.getName());
                        }
                    }

            }
        }

    }


}else {
    System.out.println("no existe el directorio de trabajo");
}

    }




    public Date FechaModificar(int fecha){

        return new Date(fecha);
    }
}
