package Clase3;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main (String args []){
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        int numero1 = input.nextInt();

        System.out.println("Ingrese otro numero");
        int numero2 = input.nextInt();

        int multiplica = retornaMultiplicacion(numero1, numero2);
        System.out.println("La multiplicacion de los numeros es " + multiplica);

    }
    //Método que reciba dos enteros y retorne la multiplicación de la misma.
    public static int retornaMultiplicacion(int num1, int num2){
        return num1 * num2;


    }

}
