package practica06.practica6; 

//Hija hourlyEmployee que herera de Employee
public class HourlyEmployee extends Employee{
	//Atribuyos de la clase
	private int workedHours; 
	private double hourFee;

	//Constructor de hourlyEmployee 
	public HourlyEmployee(int wh, double hf, int id){ 
		super(id);
		this.workedHours=wh; 
		this.hourFee=hf; 
	}

	//Obtener HoraFee
	public double getHourFee(){
		return hourFee; 
	}
	//Obtener HOras trabajadas
	public int getWorkedHours(){
		return workedHours; 
	}

	//Establecer las horasFee
	public void setHourFee(double hourFee){
		this.hourFee = hourFee;
	}

	//Estableces horas trabajadas
	public void setWorkedHours(int workedHours){
		this.workedHours = workedHours;
	}

	//Metodo que ceunta los impuestos con el impuesto 
	public double monthlyPaymentTax(){
		double salary; 
		salary= (workedHours*hourFee); 
		salary = salary - (salary * (0.1));
		return salary; 
	}

	//Metodo que cuenta el pago por el mes  sin impuestos  
	public double monthlyPayment (){
		double salary2; 
		salary2=(workedHours*hourFee); 
		return salary2; 

	}

}