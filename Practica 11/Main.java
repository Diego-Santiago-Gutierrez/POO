import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Conversiones c = new Conversiones();        
        Scanner lectura = new Scanner(System.in);
        String fileName = lectura.nextLine(); 
        ArrayList<String> input = new ArrayList();
        
        try{
            String archivo; 
            BufferedReader data = new BufferedReader(new FileReader(fileName));
            while((archivo=data.readLine()) != null)
                {
                    input.add(archivo);
                }
            Scanner scanner = new Scanner(new File(fileName));
            try{
                for(int i= 0; i < input.size() ; i++){
                    int numero = scanner.nextInt();
                    System.out.println(c.decToHex(numero));
                    data.close(); 
                }
               
            }catch(InputMismatchException ex){ //Si lee algo que no es un entero, lanza eso 
                for(int j =0; j<input.size(); j++ ){
                    String numero2 =  scanner.nextLine();
                    try{
                        System.out.println(c.hexToDec(numero2));
                    } catch(InvalidHexException e){
                        System.out.println(e.getMessage());
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }catch(NegativeValueEnteredException e){ //Si es un numero negativo 
            System.out.println(e.getMessage());
            }
    } catch(java.io.IOException e){e.printStackTrace();}
        lectura.close();
    }    
}
