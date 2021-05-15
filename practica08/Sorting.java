public class Sorting
{

public static void selectionSort (Comparable[] list){ //Recive un arreglo tipo comparable 

int min;
Comparable temp; 												//Creamos una variable tipo <Comparable> temporal 
	for (int index = 0; index < list.length-1; index++){		//Irá de 0 al tamaño de la lista-1 
		min = index;											//La variable Min se igualará a index cada iteracion 
		for (int scan = index+1; scan < list.length; scan++)	//Recorremos la lista con scan  
			if (list[scan].compareTo(list[min]) < 0)			//Si list[scan] es comparado conl list[min] y esto da <0 
																//Significa que list[Scan] < list[min]
				min = scan;										//Min es un auxiliar, toma el valor de Scan		
		
																//Swampeamos 
				temp = list[min];								//Guardamos en temp el valor de list[min] 
				list[min] = list[index];						//Estará en la posicion de list[index]
				list[index] = temp;								//Y list[index] en la posicion que se encontraba list[Min]
	}
}


public static void insertionSort (Comparable[] list){					//Recibe un arreglo objeto Comparable llamada list
	for (int index = 0; index < list.length; index++){					//Recorre la lista 
		Comparable key = list[index];									//Creamos una variable tipo Comparable que será 
																		//El valor en el que se encuentre el recorrido
		int position = index;											//Creamos una variable entera para comparar
																		//Mueve los valores más grandes a la derecha 									
		while (position > 0 && key.compareTo(list[position-1]) < 0){	//list[index] < list[position-1] 	
			list[position] = list[position-1];							
			position--;
		}
		list[position] = key;
	}
}

}