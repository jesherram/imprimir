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
public class Cajero {
    public  static void  pintamenu(){
        System.out.println("CAJERO AUTOMÁTICO");
        System.out.println(" -----------");
        System.out.println("1.Consultar/Modificar Datos personales");
        System.out.println("2.Ingresar Nomina");
        System.out.println("3.Consultar Datos Bancarios");
        System.out.println("4.Sacar Dinero");
        System.out.println("5.Modificar Contraseña");
        System.out.println("6.Salir");
   
                       

    }
     public static void main(String[] args) {
        // TODO code application logic here
        /*
        Cuenta c1=new Cuenta(1000.0, 12345678,1234 );
        c1.modificar_saldo(-200.0);
        c1.modificar_contraseña();
         Scanner CS = new Scanner(System.in);
         System.out.println("introduce la contraseña actual");
         int contraleida=CS.nextInt();
        c1.mostrar_datos(contraleida);
*/
        //public Cliente(int nDni, double nSueldo, double nSaldo){
        Cliente c1=new Cliente(987654,1200.0,15000.0);
        boolean salir=false;
        do{
            pintamenu();            
             Scanner CS = new Scanner(System.in);
             int opcion =CS.nextInt();
             
             switch(opcion){
                 case 1:
                     System.out.println(c1.getDni()+" "+c1.getSueldo());
                     System.out.println("cambiar datos personales ? pulsa s");
                     char opcionCambiar =CS.next().charAt(0);
                     if (opcionCambiar=='s'){
                         System.out.println("introduce dni");
                         c1.setDni(CS.nextInt());
                         System.out.println("introduce sueldo");
                         c1.setSueldo(CS.nextDouble());                         
                     }
                     break;
                     
                 case 2:
                     c1.ingresar_nómina();
                     break;
                 case 3:
                    //CS = new Scanner(System.in);
                    System.out.println("introduce la contraseña actual");         
                    int contraleida=CS.nextInt();
                    if (c1.cuentaCliente.validar_contraseña(contraleida)){
                        c1.cuentaCliente.mostrar_datos(contraleida);
                    }
                     break;
                 case 4:
                    System.out.println("introduce cantidad a retirar");         
                    double retirar=CS.nextDouble();
                    retirar=-1*retirar;
                    c1.cuentaCliente.modificar_saldo(retirar);
                     break;
                 case 5:
                     c1.cuentaCliente.modificar_contraseña();
                     break;
                 case 6:
                     salir=true;
                     break;
             }
             
        }while (!salir);
        
        
    }
}
