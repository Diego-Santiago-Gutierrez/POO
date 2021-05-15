import java.awt.*; //Font, FontMetrics, Graphics, Color, Rectangle, Image, BufferedImage, Toolkit, FontMetrics, Dimension
import java.io.*;			   // Event -> ActionEvent, ActionListener, KeyEvent, KeyListener, MouseEvent, MouseListener
import java.awt.event.*;

import javax.swing.*; //JFrame, Timer, JPanel

import java.util.*; // ArrayList, Random

import javax.swing.Timer;

/*
//Pantalla nos permite usar de las interfaces ActionListener y MouseListener
*/
public class Pantalla implements ActionListener, MouseListener
{
	//Creamos un objeto que puede escuchar y accionar
	public static Pantalla flappyBirdMan;

	//Definimos las dimensiones de una imagen
	public final int WIDTH = 800, HEIGHT = 800;

	public CrearPantalla crearPantalla = new CrearPantalla();

	//Creamos a los "objetos" mostrados en la pantalla 
	public Image imgBirdMan = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/graue_bird.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	public Image imgObstacle = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/rectoria.png")); 

	public Rectangle birdMan = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);;
	public ArrayList<Rectangle> columns = new ArrayList<Rectangle>();

	public int gravity, score;
	public int mouseClicked;

	public boolean gameOver, started;

	//Musica
	public Musica fondo = new Musica("resources/Fondo.WAV");
	public Musica muerte = new Musica("resources/Muerte.WAV");
	public Musica tuberia = new Musica("resources/Tuberia.WAV");

	//public List<Integer> puntajes;

	public Pantalla()
	{	
		Timer timer = new Timer(20, this);
		timer.start();

		fondo.run();

		JFrame jframe = new JFrame();
		
		//Creamos el jFrame con sus respectivos componentes
		jframe.add(crearPantalla);
		jframe.setTitle("PROYECTO FINAL - Flappy Bird");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);

		createObstacle(true);
		createObstacle(true);

	}

	public void createObstacle(boolean start)
	{	
		
		Random rand = new Random();;

		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);

		imgObstacle = imgObstacle.getScaledInstance(width, height, Image.SCALE_SMOOTH);	
			
		if (start)
		{	//Mientras empezamos a jugar, creamos dos obstaculos 
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, 
									  HEIGHT - height - 120, width, height));

			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 
									  0, width, HEIGHT - height - space));

		}
		else
		{	//Se cargan estas tuberias una vez despues de empezar el juego, se cargan fuera de pantalla
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 850, 
									  HEIGHT - height - 120, width, height));

			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 
									  0, width, HEIGHT - height - space));
		}
	}

	//Pintamos los obstaculos
	public void screemObstacle(Graphics g, Rectangle column)
	{
		g.setColor(Color.red.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
		g.drawImage(imgObstacle, column.x, column.y, column.width, column.height , Color.cyan, null);
	}

	public void jump()
	{
		if (gameOver)
		{	
			//Restaura los valores iniciales del juego despues de morir
			birdMan = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			columns.clear(); 
			gravity = 0;
			score = 0;

			createObstacle(true);
			createObstacle(true);

			//Ya perdimos, entonces no puedes perder despues de perder
 			gameOver = false;
		}

		//Tenemos que notificar que ya empezamos sino el juego no sirve
		else if (!started)	started = true;

		else if (!gameOver)
		{
			if (gravity > 0) gravity = 0; //Mantener la posicion
			gravity = gravity - 10; //escapar de la gravedad 
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{	
		int obstacleSpeed = 10;
		mouseClicked++;

		if (started)
		{	
			//Las columnas se mueven, reduciendo su posicion en x
			for (int i = 0; i < columns.size(); i++)
			{	
				Rectangle column = columns.get(i);
				column.x -= obstacleSpeed;
			}

			//La gravedad tiene que ser modulada
			if (mouseClicked % 2 == 0 && gravity < 15) gravity += 2;
			
			for (int i = 0; i < columns.size(); i++){
				Rectangle column = columns.get(i);
				//Ha pasado la pantalla, es por ello que removemos del AL
				if (column.x + column.width < 0)
				{
					columns.remove(column); //Removemos del AL
					//Si llega al 0, dejamos de crear el obstaculo
					if (column.y == 0) createObstacle(false);  
				}
			}

			//Caida natural de birdMaN
			birdMan.y += gravity;

			for (Rectangle column : columns)
			{	
				//Pasa un obstaculo, por lo tanto aumentas un punto 
				if (column.y == 0 && birdMan.x + birdMan.width / 2 > column.x + column.width / 2 - 5 &&
				    birdMan.x + birdMan.width / 2 < column.x + column.width / 2 + 5){
					
					tuberia.play();
					score++; 
				}

				//Si choca contra un edificio, muere
				if (column.intersects(birdMan)){
					if(gameOver != true) newFile_write(score);	
					gameOver = true;
					muerte.play();
				}
			}

			//Si coliciona con el cielo o el suelo, muere
			if (birdMan.y > HEIGHT - 120 || birdMan.y < 0){
				muerte.play();
				if(gameOver != true) newFile_write(score);	
				gameOver = true;
			}
		}

		crearPantalla.repaint();
	}

	public void repaint(Graphics g)
	{	
		//Colores de la pantalla
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT); 

		//LuisMiguel
		g.setColor(Color.orange);
		g.fillOval(0, 0, 150, 150);

		//Parte superior Suelo
		g.setColor(Color.GREEN);
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);

		//Suelo
		g.setColor(Color.green);
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);

		//Dibujamos a birdMan
		g.setColor(Color.red);
		g.fillRect(birdMan.x, birdMan.y, birdMan.width, birdMan.height);
		g.drawImage(imgBirdMan, birdMan.x, birdMan.y, Color.cyan, null);

		//Agregamos el obstaculo a la pantalla
		for (Rectangle column : columns) screemObstacle(g, column);

		//Tipo de color y letra a utilizar
		g.setColor(Color.black);
		g.setFont(new Font("Blackadder ITC", 1, 100));

		//El juego no ha empezado, por lo tanto indica 
		if (!started) g.drawString("Click para empezar a jugar", 75, HEIGHT / 2 - 50);
		
		//Si perdemos mostramos un fin del juego
		if (gameOver) g.drawString("Fin del juego" , 150, WIDTH/2);
		
		//Mientras estemos jugando se imprime el score
		if (!gameOver && started) g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
		
	}

	//Creamos un archivo con la ultima puntacion registrada del juego
	public void newFile_write(int score){
		FileWriter fichero = null; 
		PrintWriter pw = null;
		try{
			fichero = new FileWriter("puntaje.txt");
			pw = new PrintWriter(fichero); 
			pw.println("Puntaje de la partida:" + score);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			if(null != fichero) fichero.close();
			} catch(Exception e2){
			e2.printStackTrace();
			}
		}
	}

	//Main
	public static void main(String[] args){	
		try{
		flappyBirdMan = new Pantalla();
		System.out.println("TRY");
	}catch(NullPointerException e){
		System.out.println("OUT");
		e.printStackTrace();
		}
	}

	//Respuesta del mouse
	@Override
	public void mouseClicked(MouseEvent e){
		jump();
	}

	@Override
	public void mousePressed(MouseEvent e){}

	@Override
	public void mouseReleased(MouseEvent e){}

	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}


}

