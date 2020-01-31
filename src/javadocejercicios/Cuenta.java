/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;
import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class Cuenta {
    private double saldo;
    private int numcuenta;
    private int contra;
    
    public Cuenta(){
        saldo=0.0;
        numcuenta=0;
        contra=0;        
    }
    public Cuenta(double Nsaldo,int Nnumcuenta,int Ncontra){
        saldo=Nsaldo;
        numcuenta=Nnumcuenta;
        contra=Ncontra;
                
    }
    public double getSaldo(){
        return saldo;
    }
     public int getnumcuenta(){
        return numcuenta;
    }
     
     protected void modificar_saldo(double cantidad){
         
         if ((saldo + cantidad)>=0)
            saldo =saldo + cantidad;
         else
             System.out.println("saldo negativo no permitido");
     }
     private int generar_contraseña(){
         return (int)(Math.random()*8999)+1000;
     }
     public void modificar_contraseña(){
         Scanner CS = new Scanner(System.in);
         System.out.println("introduce la contraseña actual");
         
         int contraleida=CS.nextInt();
         
         if (contraleida==contra){
             int nuevacontra=generar_contraseña();
             System.out.println( "la nueva contraseña es:"+ nuevacontra  ); 
             contra=nuevacontra;
         }else{
            System.out.println("error conntraseña no coincide"); 
         }
         
         
     }
     public boolean validar_contraseña(int contraRecibida){
         if (contraRecibida==contra)
             return true;
         else
             return false;
     }
     public void mostrar_datos(int contraRecibida){
         if (validar_contraseña(contraRecibida)){
             System.out.println( "la  Saldo es:"+ saldo  ); 
             System.out.println( "el  número de cuenta es:"+ numcuenta  ); 
             System.out.println( "la  contraseña es:"+ contra  ); 
         }else
             System.out.println( "  contraseña errónea"   ); 
             
        
         
     }
     /*
      public static void main(String[] args) {
        // TODO code application logic here
        Cuenta c1=new Cuenta(1000.0, 12345678,1234 );
        c1.modificar_saldo(-200.0);
        c1.modificar_contraseña();
         Scanner CS = new Scanner(System.in);
         System.out.println("introduce la contraseña actual");
         int contraleida=CS.nextInt();
        c1.mostrar_datos(contraleida);
        
    }
*/


    
}
