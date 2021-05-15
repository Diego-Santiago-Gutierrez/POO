import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 


public class Musica extends Thread{
	Clip clip;
	AudioInputStream audioInputStream;
	String filePath;
	Long currentFrame;


	public Musica(String filePath){
		super(filePath);
		this.filePath = filePath;
		try{
			audioInputStream = AudioSystem.getAudioInputStream(new File(this.filePath).getAbsoluteFile()); 
			clip = AudioSystem.getClip();	
			clip.open(audioInputStream);

		}
		catch(Exception e){
			System.out.println("Checa la ubicacion."); 

		}

	}
	//Objeto instanciado hasta el infinito
	public void play()  
    { 
        if(this.filePath.equals("resources/Fondo.WAV")){
				clip.loop(Clip.LOOP_CONTINUOUSLY);
		}

		if (this.filePath.equals("resources/Muerte.WAV")) {
				clip.start();
			}	
		
		if (this.filePath.equals("resources/Tuberia.WAV")) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}	
        //clip.start(); //Esto reproduce la musica 
          
    }
   
    public void run(){
    	play();
    }   
}   