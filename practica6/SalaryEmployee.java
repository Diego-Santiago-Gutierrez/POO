package practica6; 

/**
 * Clase SalaryEmployee que establece y obtiene sus horas trabajadas, incremento, obtiene su pago
 * Pago por mes pago, con sus incrementos e impuestos del salario 	
 * @author Diego Santiago Gutierrez 
 * @version 11/11/2020/A
 * @see Employee
 */

public class SalaryEmployee extends Employee{

public double salary;

	/** 
	* Metodo que establece las horas y el hourfee  
	* @param salary salario ya fijo de un trabajador  
	* @param id id del trabajador 
	*/ 
	public SalaryEmployee(double salary, int id){
		super(id); //Llamar al constructor del padre 
		this.salary=salary; //Construye Salary en el hijo
	}//Cierre del metodo 	

	/** 
	* Metodo getter de SalaryEmplouee para tener el salario
	* @return salary  
	*/
	public double getSalary(){
		return salary; //Retorna Double de Salary 
	}//Cierre del metodo 

	/** 
	* Metodo que establece el salario  
	* @param s salario ya fijo de un trabajador   
	*/ 
	public void setSalary(double s){
		this.salary = s; //establecemos this is salary  como el nuevo parametro recibido
	}//Cierre del metodo

	/** 
	* Metodo monyhlyPayment que si el salario es mayor a 10,000 aplicara un impuesto
	* @return ns  
	*/
	public double monthlyPaymentTax(){
	double ns=salary; 

		if(ns>10000){
			ns=ns-(ns*(0.3));
		} else {
			ns = ns-(ns*(0.2));
		}
		return ns;
	}//Cierre del metodo 

	/** 
	* Metodo que establece el pago mensual del trabajador asalariado 
	* @return salary  
	*/
	public double monthlyPayment(){
		return salary; 
	}//Cierre del metodo 
}//Cierre de la clase 

