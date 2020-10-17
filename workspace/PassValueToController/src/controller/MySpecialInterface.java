package controller;

import javafx.scene.Parent;

public interface MySpecialInterface {
	
	///void addToFrameController(); //change this!!
	
	
	Parent getRoot(); //get the root of the controller your visiting
	
	boolean getHasVisited();
	void setHasVisited();
	

}
