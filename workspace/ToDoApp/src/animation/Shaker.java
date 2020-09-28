package animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public abstract class Shaker {

	//+++++++++this sohuld prob all be an interface!! :P
	
	//private static TranslateTransition translateTransition; //obj that moves from one pos to the next
	
	/*
	public Shaker(Node node) {
		//instantiate translateTransition, and give it a duration of 50ms, and pass it the node param:
		//translateTransition = new TranslateTransition(Duration.millis(50), node);
		translateTransition.setFromX(0f); //starting x pos (0 float)
		translateTransition.setByX(10f); //end x pos 
		translateTransition.setCycleCount(4); //how many times the animation should happen (cycle)
		translateTransition.setAutoReverse(true); //whethert animation reverses on alternating cycles
	}
	*/
	
	//fire off animation:
	public static void shake(Node node) {
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), node);
		translateTransition.setFromX(0f); //starting x pos (0 float)
		translateTransition.setByX(10f); //end x pos 
		translateTransition.setCycleCount(4); //how many times the animation should happen (cycle)
		translateTransition.setAutoReverse(true); //whethert animation reverses on alternating cycles
		translateTransition.playFromStart(); //Play animation from initial position in forward direction
	}

}
