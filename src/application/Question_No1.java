//Student name: Showan Simkhada
//Student ID: 17459655
//Pledge of Honor: I pledge by honor that this program is solely my own work.
package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import java.util.*;


public class Question_No1 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			double width = 400;
			double height = 400;
			int radius = 10;
			int speed = 5;
			
			// creating the size of gobblings between 10 - 20.
			int numgobb = ThreadLocalRandom.current().nextInt(10, 20);
			Pane gamePane = new Pane();
			root.getChildren().add(gamePane);
			
			// creating the timer box and adding to the root
			VBox timerBox = new VBox();
			timerBox.setAlignment(Pos.TOP_LEFT);
			root.getChildren().add(timerBox);
			
			// adding the color to the timer
			Label label = new Label("0");
			label.setFont(Font.font(30));
			label.setTextFill(Color.RED);
			timerBox.getChildren().add(label);
			
			// creating hungry bug
			Circle hungryBug = new Circle(height/4, width/4, radius);
			hungryBug.setFill(Color.YELLOW);
			gamePane.getChildren().add(hungryBug);
			
			// creating the array to store the horizontal and vertical values for the gobblings
			double randomx[] = new double[numgobb];
			double randomy[] = new double[numgobb];
			
			// creating the array to store the gobbling
			Circle gobblings[] = new Circle[numgobb];
			for(int i = 0; i < numgobb; i++) 
			{
				randomx[i] = ThreadLocalRandom.current().nextDouble(5, width-5);
				randomy[i] = ThreadLocalRandom.current().nextDouble(5, height-5);
				gobblings[i] = new Circle(randomx[i], randomy[i], 5);
				gamePane.getChildren().add(gobblings[i]);
			}			
			gamePane.setFocusTraversable(true);
			
			Scene scene = new Scene(root, width, height);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			gamePane.requestFocus();
			
			// creating the timer
			AnimationTimer timer = new AnimationTimer()
					{
						private long startTime = System.currentTimeMillis();
						@Override public void handle(long stamp)
						{
							long present = System.currentTimeMillis();
							double elapseTime = ((present - startTime)/1000.0);
							label.setText(""+(int)elapseTime);
						}
					};
					timer.start();
			
			// setting the keys when it is pressed
			gamePane.setOnKeyPressed(e -> {
				double x = hungryBug.getCenterX();
				double y = hungryBug.getCenterY();
				
				switch(e.getCode())
				{
				case UP:
					if(y > radius)
					{
						hungryBug.setCenterY(y-speed);
					}
					break;
				case DOWN:
					if(y < width-radius)
					{
						hungryBug.setCenterY(y+speed);
					}
					break;
				case LEFT:
					if(x > radius)
					{
						hungryBug.setCenterX(x-speed);
					}
					break;
				case RIGHT:
					if(x < width-radius)
					{
						hungryBug.setCenterX(x+speed);
					}
					break;
				default:
					break;
				}
				
				for (int i = 0; i < numgobb; i++)
					{
						if(isOverlap(hungryBug, gobblings[i]))
							{
								gamePane.getChildren().remove(gobblings[i]);
							}						
					}				
				
				// creating the list which contains the gobbling when removed 
				List<Node> overLaps = new LinkedList<>();
				// adding both gobblings and hungrybug to the all
				ObservableList<Node> all = gamePane.getChildren();
				for(Node n : all)
				{
					Circle d = (Circle) n;
					// if the condition is true add the gobbling to overLaps
					if(isOverlap(hungryBug, d))
					{
						overLaps.add(d);
					}
				}
				
				// when there is only onne left that is (hungrybug) then time will be stopped
				if(all.size() == 1)
				{
					timer.stop();
				}
				
			});		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isOverlap(Circle c1, Circle c2)
	{
		// getting the center of the two circle and storing it to the variables
		double x1 = c1.getCenterX();
		double y1 = c1.getCenterY();
		double x2 = c2.getCenterX();
		double y2 = c2.getCenterY();
		double comp1 = Math.pow(Math.abs(x2-x1), 2);
		double comp2 = Math.pow(Math.abs(y2-y1), 2);
		double distance = Math.sqrt(comp1 + comp2);
		// if distance is less or equal to the sum of the radius of both circle the overlap is true
		boolean overlap = distance <= c1.getRadius() + c2.getRadius() && distance > 0;
		return overlap;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
