package brains;

import java.util.List;
import java.lang.Math;
import edu.unlam.snake.brain.Brain;
import edu.unlam.snake.engine.Direction;
import edu.unlam.snake.engine.Point;



public class MyBrain extends Brain {
	private List<Point>fruits;
	private List<Point>snake;
	private List<List<Point>> enemies;
	private List<Point> obstacles;
	// Pueden agregarse todos los atributos necesarios
	
	public MyBrain() {
		super("s");
	}

	/**
	 * Retorna el prÃ³ximo movimiento que debe hacer la serpiente.
	 * @param head, la posiciÃ³n de la cabeza
	 * @param previous, la direcciÃ³n en la que venÃ­a moviÃ©ndose
	 */
	public Direction getDirection(Point head, Direction previous) {
		this.fruits = info.getFruits();
		this.snake = info.getSnake();
		this.enemies = info.getEnemies();
		this.obstacles = info.getObstacles();	
		return moveSnake(head,previous);
	}
	
	private double distance(Point p, Point g){
		return Math.hypot(Math.abs(p.getX() - g.getX()), Math.abs(p.getY() - g.getY()));
	}
	
	private Point findCloserFruit(Point head){
		Point min = new Point();
		for (Point i:fruits){
			if (distance(i,head) < distance(min,head)){
				min = i;
			}
		}	
		return min;
	}
	
	private Direction moveSnake(Point head, Direction prev){
		Point obj = findCloserFruit(head);
		Direction move = null;
		Point l = new Point(head.getX()-1, head.getY());
		Point r = new Point(head.getX()+1, head.getY());
		Point u = new Point(head.getX(), head.getY()-1);
		Point d = new Point(head.getX(), head.getY()+1);
		System.out.println(head);
		System.out.println(obj);
		
		if(obj.getX() < head.getX()){
			if (!this.obstacles.contains(l)){
				move = Direction.LEFT;
			}else if (obj.getY()<head.getY()&&!this.obstacles.contains(u)){
				move = Direction.UP;
			}else if (obj.getY()>head.getY()&&!this.obstacles.contains(d)){
				move = Direction.DOWN;
				} 
			}	
		else if(obj.getX() > head.getX()){
			if(!this.obstacles.contains(r)){
				move = Direction.RIGHT;
			}else if (obj.getY()<head.getY()&&!this.obstacles.contains(u)){
				move = Direction.UP;
			}else if (obj.getY()>head.getY()&&!this.obstacles.contains(d)){
				move = Direction.DOWN;
				}
		}else{
			}if (obj.getY()<head.getY()&&!this.obstacles.contains(u)){
				move = Direction.UP;
			}else if (obj.getY()>head.getY()&&!this.obstacles.contains(d)){
				move = Direction.DOWN;
			}
		return move;
	}
}




