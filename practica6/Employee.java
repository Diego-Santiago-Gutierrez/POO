package practica6; 

/**
 * Clase Employee que establece y obtiene su id 	
 * @author Diego Santiago Gutierrez
 * @version 11/11/2020/A
 */

public class Employee{ //Clase empleados 

public int employeeID; 
public String name; 

	/** 
	* Metodo Setter  
	* @param id id el dato que recibe employee
	*/
	public Employee(int id){
		this.employeeID = id; 
	} //Cierro del metodo 
	
	/** 
	* Metodo get EMPLOYEEID 
	* @return employeeID obtienes el id del empleado 
	*/
	public int getEmployeeID(){
		return employeeID;
	} //Cierre del metodo
	
	/** 
	* Metodo set de employeeID
	* @param idNumber el numero id con el cual se reconcerá al trabajador 
	*/
	public void setEmployeeID(int idNumber){
		this.employeeID = idNumber;
	} //Cierre del metodo
}	//Cierre de clase 	
