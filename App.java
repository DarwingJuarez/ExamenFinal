package Clases;

import java.util.Scanner;

/**
 *
 * @author juare
 */
public class App {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Datos op = new Datos();

        int num = 0;
        int opcion;
        
        op.CrearFichero();
        do {
            System.out.println("*********MENU*********");
            System.out.println("1. Ingresar Nombre");
            System.out.println("2. Ingresar Notas");
            System.out.println("3. Mostrar Notas");
            System.out.println("4. Promedio");
            System.out.println("0. Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    op.Nombree();
                    
                    break;

                case 2:
                    op.Nootas();
                    
                    break;

                case 3:
                    op.Mostrar();
                    break;

                case 4:
                    System.out.println("*******PROMEDIO*******");
                    op.Promedio();
                    op.GuardarDatos();
                    break;

            }
            
        } while (opcion != 0);
        
    }

}
