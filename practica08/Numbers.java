import java.util.Scanner;

public class Numbers
{
// calling static method 
// without instantiating Student class

public static void main (String[] args){
	Integer [] intList; //Creamos un arreglo de Integers
	Integer size;		//Será el tamañ del arreglo a ordenar 
	Scanner scan = new Scanner(System.in); //Creamos objeto tipo Scan para recibir informacion

	System.out.println("How many whole numbers do you want to order? ");
	size = scan.nextInt(); 	     //Leemos para decidir
	intList = new Integer[size]; //El tamaño de la lista  

	System.out.println("---Insert numbers---"); 
	for (Integer i = 0; i < size; i++)	//Recorre de 0 a el tamaño del arreglo 
		intList[i] = scan.nextInt();	//En la posicion i se almacenará el valor
	
	Sorting.insertionSort(intList);		//Llamamos de la clase Sorting al metodo selectionSort  
										//Como parametro un Integer porque solo compara objetos  


	System.out.println("---SORTED NUMBERS---");	
	for (Integer i = 0; i < size; i++)
		System.out.print(intList[i] + "\n"); //Imprime el arreglo elemento por elemento 
	}
}