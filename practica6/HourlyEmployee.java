package practica6; 

/**
 * Clase HourlyEmployee que establece y obtiene sus horas trabajadas, incremento, obtiene su pago
 * Pago por mes pago, con sus incrementos e impuestos del salario 	
 * @author Diego Santiago Gutierrez 
 * @version 11/11/2020/A
 * @see Employee
 */

public class HourlyEmployee extends Employee{

public int workedHours; 
public double hourFee;

	/** 
	* Metodo que establece las horas y el hourfee  
	* @param wh horas trabajadas 
	* @param hf hourfee del trabajador 
	* @param id id del trabajador 
	*/
	public HourlyEmployee(int wh, double hf, int id){ 
		super(id);
		this.workedHours=wh; 
		this.hourFee=hf; 
	}//cierre de atributos

	/** 
	* Metodo que obtiene las horasfee
	* @return hourFee 
	*/
	public double getHourFee(){
		return hourFee; 
	}//Cierre del metodo

	/** 
	* Metodo que obtiene las horas trabajadas 
	* @return workedHours 
	*/
	public int getWorkedHours(){
		return workedHours; 
	}//Cierre del metodo

	/** 
	* Metodo que establece las horas fee  
	* @param hourFee horas trabajadas 
	*/
	public void setHourFee(double hourFee){
		this.hourFee = hourFee;
	}//Cierre del metodo

	/** 
	* Metodo que establece las horas trabajadas  
	* @param workedHours horas trabajadas 
	*/
	public void setWorkedHours(int workedHours){
		this.workedHours = workedHours;
	}

	/** 
	* Metodo que calcula paymentTax 
	* @return salary 
	*/
	public double monthlyPaymentTax(){
		double salary; 
		salary= (workedHours*hourFee); 
		salary = salary - (salary * (0.1));
		return salary; 
	}//Cierre del metodo

	/** 
	* Metodo que obtiene ell pago mensual 
	* @return salary2 
	*/  
	public double monthlyPayment (){
		double salary2; 
		salary2=(workedHours*hourFee); 
		return salary2; 
	}//Cierre del metodo

}//Cierre de clase

