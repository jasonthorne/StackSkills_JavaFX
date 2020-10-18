package controller;

import javafx.scene.Parent;

//public interface Visitable {
public abstract class Visitable {
	
	abstract Parent getRoot(); //get the root of the controller your visiting
	abstract boolean getHasVisited();
	abstract void setHasVisited();

}
