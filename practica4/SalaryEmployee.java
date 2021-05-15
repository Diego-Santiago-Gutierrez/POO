package practica06.practica6; 
//Creamos clase hija llamada SalaryEmployee que hereda de Employee

public class SalaryEmployee extends Employee{
//Declaramos atributo 
private double salary;

	//Constructores 
	public SalaryEmployee(double salary, int id){
		super(id); //Llamar al constructor del padre 
		this.salary=salary; //Construye Salary en el hijo
	}	

	//Getter de SalaryEmplouee para tener el salario 
	public double getSalary(){
		return salary; //Retorna Double de Salary 
	}
	//Setter de Salaryemployee
	public void setSalary(double s){
		this.salary = s; //establecemos this is salary  como el nuevo parametro recibido
	}

	//Calculamos los impuestos de SalaryEmployee
	//Con el metodo monthlyPaymentTax
	public double monthlyPaymentTax(){
	double ns=salary; 

		if(ns>10000){
			ns=ns-(ns*(0.3));
		} else {
			ns = ns-(ns*(0.2));
		}
		return ns;
	}

	//Metodo para calcular el salario mensual
	public double monthlyPayment(){
		return salary; 
	}
}
