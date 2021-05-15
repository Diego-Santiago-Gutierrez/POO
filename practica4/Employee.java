package practica06.practica6; 

//Clase empleados 
public class Employee{

	//Atributos de Employee
	private int employeeID; 
	private String name; 

	//Constructor Id
	public Employee(int id){
		this.employeeID = id; 
	}
	//Getter id
	public int getEmployeeID(){
		return employeeID;
	}
	//Setter id
	public void setEmployeeID(int idNumber){
		this.employeeID = idNumber;
	}
	
} 