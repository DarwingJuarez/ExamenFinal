package Clases;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datos {

    Scanner entrada = new Scanner(System.in);
    public int cantalumno = 0;
    public String[] nombre = new String[400];
    public int[] notasp = new int[12000];
    public int[] notasa = new int[12000];
    public int[] notasl = new int[12000];
    public float[] promedio = new float[400];
    public int creditos;
    public File archivo;
    public int a = 1;
    public String nombrefichero, sino;

    public void Nombree() {
        
        System.out.println("*************NOMBRE************");
        System.out.println("Cuantos alumnos desea ingresar:");
        cantalumno = entrada.nextInt();
        entrada.nextLine();
        
        for (var i = a; i < 1 + cantalumno; i++) {
            System.out.println("Nombre Alumno " + i + ":");
            nombre[i] = entrada.nextLine();
            
        }

    }

    public void Nootas() {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("*************NOTAS*************");
        for (int i = a; i < 1 + cantalumno; i++) {
            System.out.println("Ingrese las Notas de " + nombre[i]);
            System.out.println("Programacion");
            notasp[i] = leer.nextInt();
            System.out.println("Algoritmos");
            notasa[i] = leer.nextInt();
            System.out.println("Logica de Sistemas");
            notasl[i] = leer.nextInt();
            

        }
    }

    public void Mostrar() {
        System.out.println("*************MOSTRAR NOTAS*************");
        for (int i = 1; i < 1 + cantalumno; i++) {
            System.out.println("Nombre: " + nombre[i]);
            System.out.println("Programacion: " + notasp[i]);
            System.out.println("Algoritmos: " + notasa[i]);
            System.out.println("Logica de sistemas: " + notasl[i]);
            System.out.println(" ");

            if ((notasp[i] > notasa[i] && notasp[i] > notasl[i])) {
                System.out.println("La nota mas alta de " + nombre[i] + " es:");
                System.out.println("La nota de programacion con: " + notasp[i]);
                System.out.println(" ");

            } else if ((notasa[i] > notasp[i] && notasa[i] > notasl[i])) {
                System.out.println("La nota mas alta de " + nombre[i] + " es:");
                System.out.println("La nota de algoritmos con: " + notasa[i]);
                System.out.println(" ");

            } else {
                System.out.println("La nota mas alta de " + nombre[i] + " es:");
                System.out.println("La nota de Logica en sistemas con: " + notasl[i]);
                System.out.println(" ");

            }
        }
    }

    public void Promedio() {
        System.out.println("*************AÑO*************");
        creditos = 0;
        for (int i = 1; i < 1 + cantalumno; i++) {
            promedio[i] = (notasp[i] + notasl[i] + notasa[i]) / 3;
            System.out.println("El promedio de " + nombre[i] + " es: " + promedio[i]);
            if (promedio[i] > 60) {
                System.out.println(nombre[i] + " ''PROMOVIDO''");
                

            } else {
                System.out.println(nombre[i] + " ''NO PROMOVIDO''");
                
            }
            
            if(notasp[i] >= 61){
                creditos = creditos + 5;
            }
            else
            {
                creditos = creditos + 0;
            }
            if(notasa[i] >= 61){
                creditos = creditos + 5;
            }
            else
            {
                creditos = creditos + 0;
            }
            if(notasl[i] >= 61){
                creditos = creditos + 5;
            }
            else
            {
                creditos = creditos + 0;
            }
            
            if (creditos == 15) {
                System.out.println("Creditos suficientes("+creditos+")");
                System.out.println("FELICIDADES PUEDE INSCRIBIRSE AL SIGUIENTE AÑO");
                System.out.println(" ");

            } else {
                System.out.println("Creditos insuficientes ("+creditos+")");
                System.out.println("NO PUEDE AVANZAR DE AÑO");
                System.out.println(" ");

            }
            creditos = 0;
        }
    }

    public void GuardarDatos() {

        FileWriter escribir;
        PrintWriter mostrar = null;
        String separador;

        try {

            escribir = new FileWriter(archivo, true);
            mostrar = new PrintWriter(escribir);

            mostrar.println(separador = "\n=========================================================================");
            mostrar.println(separador = "| Nombre             | Programacion | Algoritmos | Logica de Sistemas |");

            for (int i = 1; i < 1 + cantalumno; i++) {
                mostrar.println(separador = "|" + nombre[i] + "                " + notasp[i] + "             " + notasa[i] + "             "+notasl[i]);

            }
            mostrar.println(separador = "\n=========================================================================");
            mostrar.close();
            escribir.close();

        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CrearFichero() {
        System.out.println("Desea guardar los datos en un fichero");
        sino = entrada.nextLine();
        if(!"si".equals(sino)){
            System.out.println("Los datos no se guardaran en ningun archivo");   
        }
        else
        {
            System.out.println("Digite el nombre del fichero a crear");
            nombrefichero = entrada.nextLine();
            archivo = new File("C:\\Users\\juare\\Desktop\\Programacion 1\\Laboratorio Examen\\"+nombrefichero+".txt");
            
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                } catch (IOException e) {
                }
            } else {
                System.out.println("El archivo ya existe, los datos");
                System.out.println("se guardaran alli");
            }
        }
        

    }
}
