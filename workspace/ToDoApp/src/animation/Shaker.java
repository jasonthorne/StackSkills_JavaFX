package animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shaker {
	
	private TranslateTransition translateTransition; //obj that moves from one pos to the next
	
	public Shaker(Node node) {
		//instantiate translateTransition, and give it a duration of 50ms, and pass it the node param:
		translateTransition = new TranslateTransition(Duration.millis(50), node);
		translateTransition.setFromX(0f); //starting x pos (0 float)
		translateTransition.setByX(10f); //end x pos 
		translateTransition.setCycleCount(2); //how many times the animation should happen (cycle)
		translateTransition.setAutoReverse(true); //whethert animation reverses on alternating cycles
	}
	
	//fire off animation:
	public void shake() {
		translateTransition.playFromStart(); //Play animation from initial position in forward direction
	}

}
