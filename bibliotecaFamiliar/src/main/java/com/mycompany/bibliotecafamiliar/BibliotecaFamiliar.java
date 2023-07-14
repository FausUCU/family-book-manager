/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bibliotecafamiliar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author faust
 */
public class BibliotecaFamiliar {

    public static void main(String[] args) {

        String RutaArchvio="C:/Users/faust/Desktop/BIBLIOTECA.xls";
        String[]Libros=ManejadorArchivosGenerico.leerArchivo(RutaArchvio, true);
        String Primero=Libros[0];
        System.out.println(Primero);
        
    }
}
