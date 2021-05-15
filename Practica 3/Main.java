import java.util.*;
import java.util.Calendar;

//clase Persona
class Persona{
    //Atributos
    private String nombre;
    private String aPeterno;
    private String aMaterno;
    private String cumple;
    private Integer edad=0;

        //Constructor vacio
        public Persona() {
            this.nombre = new String();
            this.aPeterno = new String();
            this.aMaterno = new String();
            this.cumple = new String();
            this.edad = new Integer();
        }

        //Constructor 
        public Persona(String informacionCompleta){
            String  [] informacionPartida = informacionCompleta.split(",");

            this.nombre = informacionPartida[0];
            this.aPeterno = informacionPartida[1];
            this.aMaterno = informacionPartida[2];
            this.cumple = informacionPartida[3];
            this.edad = calcularEdad();
        }

    public String nombreCompleto(){
        String nc;
        nc=this.nombre.concat(" "+this.aPeterno).concat(" "+this.aMaterno);
        return (nc);
    }

    public Integer calcularEdad(){
            Integer edad;
            String cumple = this.cumple;
            String[] partes = cumple.split("/");
            String dia = partes[0];
            String mes = partes[1];
            String anio = partes[2];
            Integer anioEntero = Integer.valueOf(anio);
            Calendar cal = Calendar.getInstance();
            int anioActual = cal.get(Calendar.YEAR);
            edad = anioActual - anioEntero;

            return edad;
    }

    public  String calcularRFC(){
            char p1, p3, p4;
            int sizeAPD, sizeND, sizeAMD=0, i;
            String p2 = new String();
            String rfc = new String();
            String cumple = this.cumple;
            String paterno = this.aMaterno;
            String materno = this.aMaterno;
            String nombre = this.nombre;
            String [] partes=cumple.split("/");
            String dia = partes[0];
            String mes = partes [1];
            String anio = partes [2];

            String aPaternoDividido [] = paterno.split(" ");
            sizeAPD = aPaternoDividido.length;
            p1 = aPaternoDividido[sizeAPD-1].charAt(0);
            String ultimaPalbraAP = aPaternoDividido[sizeAMD - 1];
            for( i=1; i < ultimaPalbraAP.length() ; i++){
                char c = ultimaPalbraAP.charAt(i);
                if ((c=='A')||(c=='E')||(c=='I')||(c=='U')||(c=='U')){
                    p2 = Character.toString(c);
                    break;
                }
            }
            String aMaternoDividido[] = materno.split(" ");
            sizeAMD = aMaternoDividido.length;
            p3=aMaternoDividido[sizeAMD-1].charAt(0);

            String nombreDividido[] = nombre.split(" ");
            sizeND = nombreDividido.length;
            if(nombreDividido[0] == "MARIA" || nombreDividido[0] == "JOSE"){
                p4=nombreDividido[sizeND-1].charAt(0);
            } else{
                p4=nombreDividido[0].charAt(0);
            }
            String letrasRFC = Character.toString(p1)+p2+Character.toString(p3)+Character.toString(p4);
            rfc = rfc.concat(letrasRFC).concat(anio.substring(2,4)).concat((mes).concat(dia));
            return(rfc);
    }
}

class Main {
    public static void main(String[] args)
    {   
        
        String entrada = " "; //Creamos un String que se llama entrada, que serán los datos que se irán almacenando 
        int mayor30=0, menor30=0, i=0, j=0; //Inicializamos variables; 
        ArrayList <Persona> personas = new ArrayList(); //Creamos nuestro arrayList que recibirá de objetos a la clase Persona 

        Scanner sc = new Scanner(System.in); //leer datos

        while(sc.hasNext()){ //Mientras sc encuentre un siguente
            entrada = entrada.concat(sc.nextLine()+"\n"); //Cada renglon del input ", , , , " \n ", , , , " Usando entrada es que unimos lo que valla encontrando en las lineas y se le agrega su salto
            j++; //Con esto se cuenta el numero de elementos que estan dentro de la lista 
        }
        String [] partesPersonas = entrada.split("\n"); //Tenemos una division de las cadenas que el programa encontró y las separamos para tener un string propio

        for( i = 0; i < j; i++){ //Se hace un recorrido de 0 al tamanio del arreglo 
            Persona persona = new Persona(partesPersonas[i]); //Con el arrayList Persona persona se le agraga los Strings ya particulares de cada persona
            personas.add(persona);
        }

        for (i=0; i < personas.size() ; i++) {
            //System.out.println(personas.get(i).calcularEdad());
            if (personas.get(i).edad > 40){
                mayor30++;
            }   
            else{
                menor30++;
            }
        }
        System.out.println("MAYORES A 40: "+mayor30);
        System.out.println("MENORES A 40: "+menor30);
    }
}
