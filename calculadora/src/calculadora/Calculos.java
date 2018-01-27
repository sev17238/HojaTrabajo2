
package calculadora;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Guillermo Sandoval
 * @author Diego Sevilla
 */
public class Calculos implements Calculadora{
    
    
    public Calculos(){
        
    }
    /**
     * Con este metodo se puede leer cada linea de un archivo de texto asi como cada letra de 
     * cada linea del arcivo.
     * @param ee
     * @return 
     */
    @Override
    public double Operar(String ee){
        double result = 0;
        StackVector<String> vector = new StackVector<String>(); 
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;  
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("src\\Texto\\datos.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
         // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
            //System.out.println(linea);           
                for(int i =1;i<linea.length();i++){
                    String caracter = linea.substring((i-1), i);                                       
                    
                    if(caracter.contentEquals("1")||caracter.contentEquals("2")||caracter.contentEquals("3")
                      ||caracter.contentEquals("4")||caracter.contentEquals("5")||caracter.contentEquals("6")
                      ||caracter.contentEquals("7")||caracter.contentEquals("8")||caracter.contentEquals("9")){
                        vector.push(caracter);
                    }else if(caracter.contentEquals("+")){
                        int num1 = Integer.parseInt(vector.pop());
                        int num2 = Integer.parseInt(vector.pop());
                        result = suma(num1,num2);
                        vector.push(Double.toString(result));
                    }else if(caracter.contentEquals("-")){
                        int num1 = Integer.parseInt(vector.pop());
                        int num2 = Integer.parseInt(vector.pop());
                        result = resta(num1,num2);
                        vector.push(Double.toString(result));
                    }else if(caracter.contentEquals("*")){
                        
                    }else if(caracter.contentEquals("/")){
                        
                    }else{
                        System.out.println(caracter);
                    }            
                }
                  
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
        
        return result;
        
    }
    
    private double suma(double a,double b){
        double result = a + b;
        return result;
    }
    private double resta(double a,double b){
        double result = a - b;
        return result;
    }
    private double producto(double a,double b){
        double result = a * b;
        return result;
    }
    private double division(double a,double b){
        double result = a/b;
        return result;
    }
    
    
    
}
