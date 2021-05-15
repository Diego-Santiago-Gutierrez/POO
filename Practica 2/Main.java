import java.util.Scanner; 
import java.util.Calendar; 

class Persona{

	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private String fecha;

	//CREAMOS NUESTRO CONSTRUCTOR VACIO
	public Persona(){
		this.nombre=new String();
		this.aPaterno=new String(); 
		this.aMaterno=new String(); 
		this.nombre=new String(); 
	}
	//CREAMOS NUESTRO CONSTRUCTOR DIRECTO 
	//LEER LO QUE ESTA DIRECTO DE ALPHAGRADER
	public Persona(String nombre, String paterno, String materno, String fecha){
		this.nombre=new String(nombre);
		this.aPaterno=new String(paterno);
		this.aMaterno=new String(materno);
		this.fecha=new String(fecha);
	}	

	//CREAMOS NUESTRO PRIMER METODO DE NOMBRE COMPLETO QUE GUARDARa LO QUE ES EL NOMBRE+APELLIDOPA+APELLIDOMA Y REGRESA ESTA FUNCION UN nC
	public String nombreCompleto(){ 
		String nC; 
		nC=this.nombre.concat(" ").concat(this.aPaterno).concat(" ").concat(this.aMaterno);
		return(nC); 
	}

	public String RFC(){

	char p1, p3, p4;
	char p2=0; 
	String res, realP; 
	String[] a;
	String[] z;
	String inconveniente = "DE LA";
	String inconveniente2 = " ";  
	Integer k; 
	//Transformar los 3 artributos a mayusculas 
	nombre=nombre.toUpperCase(); 
	aPaterno=aPaterno.toUpperCase(); 
	aMaterno=aMaterno.toUpperCase(); 

		//incluir la condicion de si el apellido paterno es compuesto se deshace de la DE LA 
		//char art posicion que yo diga
		//LENGHT CANTIDAD DE CARACTERES 
		a=aPaterno.split(" ");
		//System.out.println(a[0]);
		//System.out.println(a[1]);
		//Sy}stem.out.println(a[2]);
		//if (apellido1.equals(apellido2)) {
		boolean encontro = aPaterno.contains(inconveniente); 
		p1=aPaterno.charAt(0);

		if(encontro==true){
			//System.out.println("si se encontro DE LA ");
			p1=a[2].charAt(0);
				for (int i=0; i<a[2].length() ; i++ ) {
					if((a[2].charAt(i) =='A')||(a[2].charAt(i) =='E')||(a[2].charAt(i) =='I')||(a[2].charAt(i) =='O')||(a[2].charAt(i) =='U')){
						p2=a[2].charAt(i); 
					break; 	
					}
				}
		}
		else{
			//System.out.println("no se encontro DE LA ");
			//aPaterno=aPaterno.toUpperCase();
			p1=aPaterno.charAt(0);
			//a[0]=a[0].toUpperCase();
					for (int i=1; i<a[0].length() ; i++ ) {
						if((a[0].charAt(i) =='A')||(a[0].charAt(i) =='E')||(a[0].charAt(i) =='I')||(a[0].charAt(i) =='O')||(a[0].charAt(i) =='U')){
							p2=a[0].charAt(i); 
							//System.out.println(p2);
						break; 	
						}
					}
			}

		//incluir la condicion de si el apellido paterno es compuesto se deshace de la DE LA 
		p3=aMaterno.charAt(0);
		//incluir si las condiciones de si nombre es complejo se desecha

		z=nombre.split(" ");

		boolean encontro2= nombre.contains(inconveniente2);

		if(encontro2==true){
			//System.out.println(z[(z.length - 1)]);
			p4=z[(z.length - 1)].charAt(0);
			/*for(int j=0; j==z[(z.length() - 1)]; j++ ){
					p4=z[j].charAt(0);	
					break; return p4=z[j].charAt(0); 
			}*/
		}

		else{
			p4=z[0].charAt(0);	
		}

	//LE DA LO QUE SEA, UTILIZA LA CLASE STRING Y REGRESA UN STRING
	res=String.valueOf(p1)+String.valueOf(p2)+String.valueOf(p3)+String.valueOf(p4);
	return(res);
	}

	public int edad() {
	Calendar c = Calendar.getInstance(); 
	String[] d;
	Integer edadN, yearN; 
	//String formato; 
		d=fecha.split("/");
		//System.out.println(d[0]);
		//System.out.println(d[1]);
		//System.out.println(d[2]);
		edadN = Integer.valueOf(d[2]); //EN mi caso 19 -> 16/01/2001 2001-2020=19

		return (c.get(Calendar.YEAR) - edadN); //toma año del sistema	}
	}

		public int numeros() {
	Calendar c = Calendar.getInstance(); 
	String[] n;
	String  formato, formato1, formato3, real; 
	//String formato; 
		n=fecha.split("/");

		//System.out.println(n[2]);
		formato1=n[2].substring(2,4);

		formato = (formato1 + n[1] + n[0]); //EN mi caso 19 -> 16/01/2001 2001-2020=19
	
		return (Integer.valueOf(formato)); //toma año del sistema	}
	}

}

class Main
{
	public static void main(String[] args)
	{
		String n, ap, am, nc, f, rfcN; 
		int edadNac, formatoN;
		Scanner sc=new Scanner(System.in); 
		//esto lee las lineas
		n=sc.nextLine(); 
		ap=sc.nextLine(); 
		am=sc.nextLine(); 
		f=sc.nextLine(); 
		Persona persona=new Persona(n, ap, am, f);
		
		nc=persona.nombreCompleto(); //llamamos el metodo que hace la union de nombre completo
		edadNac=persona.edad();  //Llamamos el metodo que calcula la edad 
		nc=nc.toUpperCase(); //Imprimos el nombre completo en mayusculas 

		formatoN=persona.numeros();

		System.out.println(nc); //hacemos la llamada de nombre completo 
		System.out.println(edadNac); //Llammamos el metodo que calcula la edad 
		rfcN=persona.RFC(); //Calculamos el RFC con el metodo 
		System.out.println(rfcN+formatoN); //Imprimimos el metodo 
	}
}
