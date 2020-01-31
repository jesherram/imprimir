/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author ismael
 */
import java.util.Scanner;

public class Cliente {
    private int dni;
    private double sueldo;
    protected Cuenta cuentaCliente;
    //private static int  numeroscuenta=1;
    
    public Cliente(int nDni, double nSueldo, double nSaldo){
        dni=nDni;
        sueldo=nSueldo;
        //Cuenta(double Nsaldo,int Nnumcuenta,int Ncontra){
        cuentaCliente=new Cuenta(nSaldo,nDni,nDni);
        
    }
    public Cliente(){
        dni=0;
        sueldo=0.0;
        cuentaCliente=new Cuenta();
      
    }
    public double getSueldo(){
        return sueldo;
    }
     public int getDni(){
        return dni;
    }
      public void setSueldo(double nSueldo ){
        if (nSueldo>0)
          sueldo=nSueldo;
    }   
      public void setDni(int nDni ){
          if(nDni>=10000000 && nDni<=99999999 )
                dni=nDni;
    }
      
    
    public void ingresar_nómina(){
        cuentaCliente.modificar_saldo(sueldo);
    }
    public void sacar_dinero( int dniRecibido, int contraRecibida){
        
        if (dniRecibido==dni && cuentaCliente.validar_contraseña(contraRecibida)){
            Scanner CS = new Scanner(System.in);
            System.out.println("introduce la cantidad a sacar");
            double cantidadScar = CS.nextDouble();
            cantidadScar=-1*cantidadScar;//sacar no ingresar
            cuentaCliente.modificar_saldo(cantidadScar);
            
            
            
        }
        
    }

    
    
    
}
