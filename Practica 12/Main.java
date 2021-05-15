import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        Matrix mA = Matrix.readMatrix(scanner);
        Matrix mB = Matrix.readMatrix(scanner);
        
        Matrix newM = mA.operator(mB);
        System.out.println(newM);
    }
}
