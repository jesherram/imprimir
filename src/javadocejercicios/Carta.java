/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadocejercicios;

import java.util.Scanner;

/**
 * @author jesushera
 * @see Mano
 * 
 */



public class Carta {
    private String palo;
    private int numero;
    
    /**
     * Constructor por defecto inicializa palo vacío y número en 0.
     */
    public Carta(){
        palo="";
        numero=0;
    }
    
    /**
     * Constructor por parámetros.
     * @param nPalo Palo de la carta (corazones, rombos, picas, tréboles).
     * @param nNumero Número de la carta (Del 1 al 13).
     */
    public Carta(String nPalo, int nNumero){
        Scanner sc= new Scanner(System.in);
        palo=nPalo;
        numero=nNumero;
        
        while(!(palo.equals("corazones") || palo.equals("rombos") ||palo.equals("picas") ||palo.equals("tréboles"))){
            System.out.println("Introduce un palo correcto: ");
            palo=sc.nextLine();
        }
        while(numero<1 && numero>13){
            System.out.println("Introduce un número correcto: ");
            numero=sc.nextInt();
        }
    }
    
    
    /**
     * Devuelve cadena con el palo de carta (corazones, rombos, picas o tréboles).
     * @return Palo de la carta.
     */
    public String getPalo(){
        return palo;
    }
    
    /**
     * Devuelve el número de la carta (de 1 a 13).
     * @return Número de la carta.
     */
    public int getNumero(){
        return numero;
    }
    
    /**
     * Modifica o añade el palo.
     * @param nPalo Palo a introducir.
     */
    public void setPalo(String nPalo){
        Scanner sc= new Scanner(System.in);
        palo=nPalo;
        
        while(!(palo.equals("corazones") || palo.equals("rombos") ||palo.equals("picas") ||palo.equals("tréboles"))){
            System.out.println("Introduce un palo correcto: ");
            palo=sc.nextLine();
        }
    }
    
    /**
     * Modifica o añade el número de carta entre 1 y 13 pidiéndolo por teclado.
     * @param nNumero Nuevo número para la carta.
     */
    public void setNumero(int nNumero){
        Scanner sc= new Scanner(System.in);
        numero=nNumero;
        
        while(numero<1 && numero>13){
            System.out.println("Introduce un número correcto: ");
            numero=sc.nextInt();
        }
    }
    
    /**
     * Muestra la carta con su número y palo, si el número es 11, 12 o 13 mostrará Jota, Reina o Rey respectivamente.
     */
    public void mostrarCarta(){
        String cadNum="";
        if(numero>=11){
            switch(numero){
                case 11:
                    cadNum="Jota";
                    break;
                case 12:
                    cadNum="Reina";
                    break;
                case 13:
                    cadNum="Rey";
                    break;
            }
            System.out.println(cadNum + " de " + palo);
        }else{
            System.out.println(numero + " de " + palo);
        }
        
        
    }
    
    /**
     *  Compara dos cartas, primero el número más grande y los palos ganan en el orden de: corazones, rombos, picas, tréboles.
     * @param otraCarta Carta a comparar.
     * @return Verdadero o falso si la primera carta gana o no a la segunda respectivamente.
     */
    public boolean cartaGanadora(Carta otraCarta){
        if(this.numero>=otraCarta.numero){
            if(this.numero>otraCarta.numero){//Que sea mayor en número
                return true;
            }else{//Que sea igual
                if(this.palo.equals(otraCarta.palo)){//Misma carta y mismo palo
                    return true;
                }else{ //Mismo num distinto palo
                    
                    if(this.palo.compareTo(otraCarta.palo)<0){ //La primera está antes alfabéticamente y ya que están c, r, p,t 
                        return true;
                    }else{ //Segunda primera alfabéticamente
                        return false;
                    }
                }
            }
        }else{//Que sea menor
            return false;
        }
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String [] args){
        Carta carta1=new Carta("corazones",11);
        carta1.mostrarCarta();
        
        Carta carta2=new Carta("rombos",11);
        
        carta2.mostrarCarta();
        
        
        System.out.println(carta1.cartaGanadora(carta2));
        
    }
}
