import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Matrix
{
    
    //Declaración de hilos a usar
    private static final int NUMBER_OF_THREADS = 4;
    //Arreglo Bidimensional (Matriz)
    private final int[][] biArrayAsMatrix;
 	
 	//Leer lineas  
 	public static Matrix readMatrix(Scanner sc)
    {
        List<List<Integer>> arrayListAsMatrix = new ArrayList<>();
        
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (line.equals("")) break;
            String[] getNumbers = line.split(" ");
            List<Integer> row = Arrays.stream(getNumbers).filter(Predicate.not(String::isBlank)).map(Integer::parseInt).collect(Collectors.toList());
            arrayListAsMatrix.add(row);
        }
        return new Matrix(arrayListAsMatrix);
    }

	//Creamos una matriz bidimensional con su dimension correspondiente 
    public Matrix(List<List<Integer>> listMatrix) 
    {
        int rows = listMatrix.size();
        int cols = listMatrix.get(0).size();
        this.biArrayAsMatrix = new int[rows][cols];
        
        for (int i = 0; i < rows; i++){
            this.biArrayAsMatrix[i] = listMatrix.get(i).stream().mapToInt(Integer::intValue).toArray(); //REPRESENTAR EL ARAYLIST COMO INT[]
        }
    }
    
    //connstruye una matriz vacía, con las dimensiones especificadas.
    private Matrix(int rows, int columns)
    {
        this.biArrayAsMatrix = new int[rows][columns];
    }

    //Obtiene la representación interna de esta matriz. Es decir, un arreglo bidimensional.
    private int[][] bidimentionalArray()
    {
        return this.biArrayAsMatrix;
    }
    
    //Obtiene el número de filas de esta matriz.
    public int totalRows()
    {
        return this.biArrayAsMatrix.length;
    }

    public int totalColumns()
    {
        return this.biArrayAsMatrix[0].length;
    }
    
    //Suma los elementos presentes en la región indicada de dos matrices representadas por arreglos bidimensionales, y
	//coloca el resultado en las posiciones respectivas en la matriz.
     
    private static void motherSum(int[][] mA, int[][] mB, int[][] newM, int firstA, int finalA, int firstB, int finalB)
    {
        for (int i = firstA; i <= finalA; i++)
        {
            for (int j = firstB; j <= finalB; j++)
            {
                newM[i][j] = mA[i][j] + mB[i][j];
            }
        }
    }
    
    //suma del cuadrante superior izquierdo de dos matrices. 
    private static void firstSum(Matrix mA, Matrix mB, Matrix newM)
    {
        motherSum(mA.bidimentionalArray(),mB.bidimentionalArray(),newM.bidimentionalArray(),
																	0,
																	mA.totalRows() / 2,
																	0,
																	mA.totalColumns() / 2);
    }
    
    //suma del cuadrante superior derecho de dos matrices.
    private static void secondSum(Matrix mA, Matrix mB, Matrix newM)
    {
        motherSum(mA.bidimentionalArray(),mB.bidimentionalArray(),newM.bidimentionalArray(),
																	0,
																	mA.totalRows() / 2,
																	(mA.totalColumns() / 2) + 1,
																	mA.totalColumns() - 1);
    }
    
    //suma del cuadrante inferior izquierdo de dos matrices.
    private static void thirdSum(Matrix mA, Matrix mB, Matrix newM)
    {
        motherSum(mA.bidimentionalArray(),mB.bidimentionalArray(),newM.bidimentionalArray(),
																	(mA.totalRows() / 2) + 1,
																	mA.totalRows() - 1,
																	0,
																	mA.totalColumns() / 2);
    }
    
    //suma del cuadrante inferior derecho de dos matrices.
    private static void FourthSum(Matrix mA, Matrix mB, Matrix newM)
    {
        motherSum(mA.bidimentionalArray(),mB.bidimentionalArray(),newM.bidimentionalArray(),
																	(mA.totalRows() / 2) + 1,
																	mA.totalRows() - 1,
																	(mA.totalColumns() / 2) + 1,
																    mA.totalColumns() - 1);
    }
   
 	//Utiliza 4 hilos para realizar la suma de los 4 cuadrantes.
    public Matrix operator(Matrix matrix)
    {
        
        Matrix newMatrix = new Matrix(this.totalRows(), this.totalColumns());
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        
        threads[0] = new Thread(() -> Matrix.firstSum(this, matrix, newMatrix));
        threads[1] = new Thread(() -> Matrix.secondSum(this, matrix, newMatrix));
        threads[2] = new Thread(() -> Matrix.thirdSum(this, matrix, newMatrix));
        threads[3] = new Thread(() -> Matrix.FourthSum(this, matrix, newMatrix));
        
        threads[0].start();
        threads[1].start();
        threads[2].start();
        threads[3].start();

        try
        {
            threads[0].join();
            threads[1].join();
            threads[2].join();
            threads[3].join();
        }
        catch (InterruptedException e)
        {
        	e.printStackTrace();
        }
        
        return newMatrix;
    }

    //Obtiene la representación de esta matriz como cadena. Cada fila de la matriz se representa como una línea, y los
 	//elementos se encuentran separados por espacios.
     
    @Override
    public String toString()
    {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < this.totalRows(); i++)
        {
            for (int j = 0; j < this.totalColumns(); j++)
            {
                newString.append(this.biArrayAsMatrix[i][j]).append(" ");
            }
            newString.replace(newString.length() - 1, Integer.MAX_VALUE, "\n");
        }
        return newString.toString();
    }

}
