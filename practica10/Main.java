import java.util.InputMismatchException;
import java.util.Scanner;
import ArrrayList<> 

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        Conversiones comparable = new Conversiones();        
        
        try{
            int numero = scan.nextInt();
            System.out.println(comparable.decToHex(numero));
            
        } catch(InputMismatchException ex){
            String numero =  scan.nextLine();
            try{
                System.out.println(comparable.hexToDec(numero));
            } catch(InvalidHexException e){
                System.out.println(e.getMessage());
            } catch(Exception e){
                System.out.println(e.getMessage());
            }

        } catch(NegativeValueEnteredException e){
            System.out.println(e.getMessage());
        }
        scan.close();
    }
}
