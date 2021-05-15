package practica06.practica6; 

public class Payroll{

	ArrayList <Employee> Employees = new ArrayList<Employee>(); //Creamos nuestro arreglo que recibe objetos 
																//Que son de objeto Employee y se el arreglo es employess
																//Con su instansiacion 

	//Constructor de la clase PayRoll, recibe un string, trabaja con los datos
	public Payroll(ArrayList <String> empleados){ //Recibe como parametro el string del empleado tipo arrayLIST objeto String
		
		int id=0; 
		for(String em : empleados ){
			String[] arrEmpleado=em.split(",");
			if(arrEmpleado[2].equals("S")){ //Si el empleado es igual a un trabajador SALARIADO
				String name=arrEmpleado[1]; 
				double salary = Double.valueOf(arrEmpleado[3]); //3? tmb linea 128
				id = id+1; //Cada usuario registrado tendra un ID diferente
				Employee emS = new SalaryEmployee(salary, id); //el polimorfismo wow
				Employees.add(emS);
			} else{
				String name = arrEmpleado[0]; 
				int wh = Integer.valueOf(arrEmpleado[3]); //?
				double hf = Double.valueOf(arrEmpleado[4]);
				id=id+1;
				Employee emH = new HourlyEmployee(wh, hf, id); 
				Employees.add(emH); 
			}

		}
	}

	public ArrayList <Employee> getList(){
		return this.Employees;
	}

	//Metodo calcula el pago total con el impuesto ya hacia los trabajadores 
	// regresa una suma tipo doble y se recorre la lista verificando
	//si se trata de un trabajador asalariado o de horas y llamara el metodo correspondeitne para obtener los datos 
	public double monthlyPayrollTax(){
		double suma = 0 ; 
		for(Employee e: this.Employees){
			if (e instanceof SalaryEmployee){ 
				SalaryEmployee se = (SalaryEmployee) e; 
				suma = suma + (se.monthlyPaymentTax());
			}else{
				if(e instanceof HourlyEmployee){
					HourlyEmployee he = (HourlyEmployee) e;  
					suma = suma+(he.monthlyPaymentTax());
				}
			} 
		}
	return suma; 
	}

	public double monthlyPayroll(){
		double suma = 0; 
		for(Employee e: this.Employees){
			if(e instanceof SalaryEmployee){ 
				SalaryEmployee se = (SalaryEmployee) e;
				suma = suma + (se.monthlyPayment());
			} else {
				if(e instanceof HourlyEmployee){
					HourlyEmployee he = (HourlyEmployee) e; 
					suma=suma +(he.monthlyPayment());
				} 
			}
		}
		return suma; 
	}

	//Sube el porcentaje del salario, dado a un empleado en particular 
	//Recibe dos parametros, un entero id que pertenecen a algun empleado  y double con el porcentaje 
	//Recorre la lista de los empleados, revisando si  del tipo salaryemployee o del tipo HE
	//CON EL RESULLADO, SE CREA el objeto corrrespondiente 
	public void increasePayroll(int id, double percenager){
		double ns=0;
		double s=0; 

		int wh=0; 
		double hourFee=0; 

		for(Employee e : this.Employees){
			if(e.getEmployeeID() == id){
				if(e instanceof SalaryEmployee){
					
					SalaryEmployee se = (SalaryEmployee) e; 
					s= se.getSalary();  
					ns = ((s*percenager) + s);
					se.setSalary(ns); 
					e = (Employee) se; 
				
				}else{
					if(e instanceof HourlyEmployee){
					
					HourlyEmployee he = (HourlyEmployee) e; 

					wh= he.getWorkedHours();  
					hourFee= he.getHourFee(); 

					s=wh*hourFee; 
					s = ((s*percenager) + s);
					he.setWorkedHours(1);
					he.setHourFee(s); 
					e = (Employee) he; 

					} 

				}
			}
		}
	}

	public int extraHours(){
		int cont=0; 
		for(Employee e: this.Employees){
			if(e instanceof HourlyEmployee){
				HourlyEmployee he = (HourlyEmployee) e; 
				if(he.getWorkedHours()>=40){
					cont = cont+1;
				}
			}
		} 
	return cont;
	}

}
