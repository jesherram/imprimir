/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadocejercicios;

import java.util.Scanner;

/**
 * @author jesushera
 * @see Carta
 */

public class Mano {
    
    int numeroCartas;
    Carta[] cartas;
    
    /**
     * Constructor por defecto.
     */
    public Mano(){
        numeroCartas=3;
        cartas=new Carta[numeroCartas];
        for(int i=0;i<this.numeroCartas;i++){
             cartas[i]=new Carta();
        } 
        
        
    }
    
    /**
     * Constructor por parámetros.
     * @param nNumeroC Número de cartas que tiene la mano.
     */
    public Mano(int nNumeroC){
        numeroCartas=nNumeroC;
        cartas=new Carta[numeroCartas];
        
        for(int i=0;i<this.cartas.length;i++){
             cartas[i]=new Carta();
        } 
    }
    
    /**
     * 
     * @return Devuelve número cartas mano.
     */
    public int getNumCartas(){
        return numeroCartas;
    }
    
    /**
     * 
     * @param posicionCarta Posición de 0 a tamaño de mano menos 1
     * @return Carta de la mano en dicha posición.
     */
    public Carta getCarta(int posicionCarta){
        if (posicionCarta<cartas.length && posicionCarta>=0)
            return cartas[posicionCarta];
        else
           return new Carta();
                                
                    
    }
    /**
     * Muestra la carta utilizando {@link Ejercicios2.Carta#mostrarCarta}
     * @param posicion Posición desde 0
     */
    public void mostrarCarta(int posicion){
        cartas[posicion].mostrarCarta();
    }
    
    
    /**
     * Cambiar o poner un valor a una carta dada su posición.
     * @param pos Posición de la carta .
     * @param nNum Número carta. {@link Ejercicios2.Carta#setNumero}
     * @param nPalo Palo carta. {@link Ejercicios2.Carta#setPalo}
     */
    
    public void setCarta(int pos,int nNum,String nPalo){
        cartas[pos].setNumero(nNum);
        cartas[pos].setPalo(nPalo);
    }
    
    
    /**
     * Modifica la carta pidiendo por teclado su número y palo.
     * @param pos Posición de carta.
     */
    
    public void modificarCarta(int pos){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un número: ");
        cartas[pos].setNumero(sc.nextInt());
        System.out.println("Introduce un palo");
        cartas[pos].setPalo(sc.nextLine());
    }
    
    
    
    /**
     * Imprime qué Mano gana la partida utilizando {@link Ejercicios2.Carta#cartaGanadora}.
     * @param otraMano Objeto mano.
     */
    public void manoGanadora(Mano otraMano){
        int ganadora=0;
        int longitud=0;
        if (this.cartas.length<otraMano.cartas.length)
            longitud=this.cartas.length;
        else
             longitud=otraMano.cartas.length;
            
            
        for(int i=0;i<longitud;i++){
            
         if (this.cartas[i].getNumero()!= otraMano.cartas[i].getNumero() || !this.cartas[i].getPalo().equals(otraMano.cartas[i].getPalo()))
            if(this.cartas[i].cartaGanadora(otraMano.cartas[i])) 
                ganadora++;
            else
                ganadora--;
                
           }
        
        if (ganadora==0)
             System.out.println("Empate");
         else
                if (ganadora>0)
                     System.out.println("Mano 1 ganadora");            
                else{ //Mano 2 ganadora
                     System.out.println("Mano 2 ganadora");
                    
         }
    }
    
    public static void main(String [] args){
         Mano mano1=new Mano();
         Mano mano2=new Mano();
         
         mano1.setCarta(0, 2, "corazones");
         mano1.setCarta(1, 1, "corazones");
         mano1.setCarta(2, 1, "corazones");
         
         mano2.setCarta(0, 7, "corazones");
         mano2.setCarta(1, 2, "corazones");
         mano2.setCarta(2, 1, "corazones");
         
         mano1.manoGanadora(mano2);
         
    }
}
