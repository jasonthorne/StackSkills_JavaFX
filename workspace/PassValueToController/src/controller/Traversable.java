package controller;

import javafx.scene.Parent;

public interface Traversable {
	
	Parent getRoot(); //get the root of the controller your visiting
	//abstract boolean getHasVisited();
	//abstract void setHasVisited();
	
	//setRoot()
	//setTraversables()
	
	//bi-consumer that takes a list of traversables and target traversable to find, and then calls 
	//Traverse.moveFwrd(Traversable trvsble) 
	//getTraversable()

}
