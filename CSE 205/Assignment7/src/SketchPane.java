// Assignment #:  7
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Contains the elements and attributes of SketchPane

import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;


public class SketchPane extends BorderPane {
	
	//Task 1: Declare all instance variables listed in UML diagram
	private ArrayList<Shape> shapeList, tempList;
	private Button undoButton, eraseButton;
	private Label fillColorLabel, strokeColorLabel, strokeWidthLabel;
	private ComboBox<String> fillColorCombo, strokeColorCombo, strokeWidthCombo;
	private RadioButton radioButtonLine,radioButtonRectangle, radioButtonCircle;
	private Pane sketchCanvas;
	private Color[] colors;
	private String[] strokeWidth, colorLabels;
	private Color currentStrokeColor, currentFillColor;
	private int currentStrokeWidth;
	private Line line;
	private Circle circle;
	private Rectangle rectangle;
	private double x1, y1;


	//Task 2: Implement the constructor
	public SketchPane() {
		// Colors, labels, and stroke widths that are available to the user
		colors = new Color[] {Color.BLACK, Color.GREY, Color.YELLOW, Color.GOLD, Color.ORANGE, Color.DARKRED, Color.PURPLE, Color.HOTPINK, Color.TEAL, Color.DEEPSKYBLUE, Color.LIME} ;
		colorLabels = new String[] {"black", "grey", "yellow", "gold", "orange", "dark red", "purple", "hot pink", "teal", "deep sky blue", "lime"};
		fillColorLabel = new Label("Fill Color:");
		strokeColorLabel = new Label("Stroke Color:");
		strokeWidthLabel = new Label("Stroke Width:");
		strokeWidth = new String[] {"1", "3", "5", "7", "9", "11", "13"};

		// Initialize arraylist
		shapeList = new ArrayList<>();
		tempList = new ArrayList<>();

		//Instantiate controls:
		// combo boxes
		fillColorCombo = new ComboBox<>();
		strokeColorCombo = new ComboBox<>();
		strokeWidthCombo = new ComboBox<>();

		// radio buttons & toggle group
		radioButtonCircle = new RadioButton();
		radioButtonLine = new RadioButton();
		radioButtonRectangle = new RadioButton();
		ToggleGroup radioButtonGroup = new ToggleGroup();

		// Buttons
		undoButton = new Button();
		eraseButton = new Button();

		// create & register buttons with handler
		undoButton.setText("Undo");
		eraseButton.setText("Erase");
		undoButton.setOnAction(new ButtonHandler());
		eraseButton.setOnAction(new ButtonHandler());

		// create combo box
		fillColorCombo.getItems().addAll(colorLabels);
		strokeColorCombo.getItems().addAll(colorLabels);
		strokeWidthCombo.getItems().addAll(strokeWidth);
		// set combo box default
		fillColorCombo.setValue("black");
		strokeColorCombo.setValue("black");
		strokeWidthCombo.setValue("1");
		// register combo box with it's handler
		fillColorCombo.setOnAction(new ColorHandler());
		strokeColorCombo.setOnAction(new ColorHandler());
		strokeWidthCombo.setOnAction(new WidthHandler());

		// create radio buttons
		radioButtonCircle.setText("Circle");
		radioButtonLine.setText("Line");
		radioButtonRectangle.setText("Rectangle");

		// add radio buttons to toggle group
		radioButtonLine.setToggleGroup(radioButtonGroup);
		radioButtonRectangle.setToggleGroup(radioButtonGroup);
		radioButtonCircle.setToggleGroup(radioButtonGroup);
		radioButtonGroup.selectToggle(radioButtonLine);


		// set up layout
		sketchCanvas = new Pane();
		sketchCanvas.setStyle("-fx-background-color: white;");

		HBox headerHBox, footerHBox;

		// set up HBox header
		headerHBox = new HBox();
		headerHBox.setSpacing(20);
		headerHBox.setMinSize(20,40);
		headerHBox.setAlignment(Pos.CENTER);
		headerHBox.setStyle("-fx-background-color: lightgrey");
		headerHBox.getChildren().addAll(fillColorLabel,fillColorCombo, strokeWidthLabel,strokeWidthCombo, strokeColorLabel, strokeColorCombo);

		// set up HBox footer
		footerHBox = new HBox();
		footerHBox.setSpacing(20);
		footerHBox.setMinSize(20,40);
		footerHBox.setAlignment(Pos.CENTER);
		footerHBox.setStyle("-fx-background-color: lightgrey");
		footerHBox.getChildren().addAll(radioButtonLine,radioButtonRectangle, radioButtonCircle, undoButton, eraseButton);

		// add nodes to Border pane
		this.setCenter(sketchCanvas);
		this.setTop(headerHBox);
		this.setBottom(footerHBox);

		// register pane with mouse handler
		sketchCanvas.addEventHandler(MouseEvent.ANY, new MouseHandler());

		// set default values for other instance variables
		x1 = 0;
		y1 = 0;
		currentFillColor = Color.BLACK;
		currentStrokeColor = Color.BLACK;
		currentStrokeWidth = 1;
    }

	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			// TASK 3: Implement the mouse handler for Circle and Line
			// Rectange Example given!
			if (radioButtonRectangle.isSelected()) {
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					rectangle = new Rectangle();
					rectangle.setX(x1);
					rectangle.setY(y1);
					shapeList.add(rectangle);
					rectangle.setFill(Color.WHITE);
					rectangle.setStroke(Color.BLACK);	
					sketchCanvas.getChildren().add(rectangle);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					if (event.getX() - x1 <0) 
						rectangle.setX(event.getX());
					if (event.getY() - y1 <0) 
						rectangle.setY(event.getY());
					rectangle.setWidth(Math.abs(event.getX() - x1));
					rectangle.setHeight(Math.abs(event.getY() - y1));

				}
				//Mouse is released
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					rectangle.setFill(currentFillColor);
					rectangle.setStroke(currentStrokeColor);
					rectangle.setStrokeWidth(currentStrokeWidth);
				}
			}
			// For Circle
			if (radioButtonCircle.isSelected())
			{
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					circle = new Circle();
					circle.setCenterX(x1);
					circle.setCenterY(y1);
					circle.setFill(Color.WHITE);
					circle.setStroke(Color.BLACK);
					shapeList.add(circle);
					sketchCanvas.getChildren().add(circle);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					circle.setRadius(getDistance(x1,y1, event.getX(), event.getY()));
				}
				//Mouse is released
				else if(event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					circle.setFill(currentFillColor);
					circle.setStroke(currentStrokeColor);
					circle.setStrokeWidth(currentStrokeWidth);
				}
			}
			// Line
			if (radioButtonLine.isSelected())
			{
				// Mouse is pressed
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					line = new Line();
					line.setStartX(x1);
					line.setStartY(y1);
					line.setEndX(x1);
					line.setEndY(y1);
					shapeList.add(line);
					sketchCanvas.getChildren().add(line);
				}
				// Mouse is dragged
				else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
					line.setEndX(event.getX());
					line.setEndY(event.getY());
				}
				// Mouse is released
				else if(event.getEventType() == MouseEvent.MOUSE_RELEASED){
					line.setStroke(currentStrokeColor);
					line.setStrokeWidth(currentStrokeWidth);
				}
			}
		}
	}
		
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 4: Implement the button handler
			// event source is undo button
			if(event.getSource() == undoButton) {
				// if shape list is not empty
				if(!shapeList.isEmpty()){
					shapeList.remove(shapeList.size()-1);
					sketchCanvas.getChildren().remove(sketchCanvas.getChildren().size()-1);
				}
				// if shape list empty
				else{
					shapeList = new ArrayList<>(tempList);
					tempList.clear();
					sketchCanvas.getChildren().addAll(shapeList);
				}
			}
			// event source is erase button
			if(event.getSource() == eraseButton){
				if(!shapeList.isEmpty()) {
					tempList = new ArrayList<>(shapeList);
					shapeList.clear();
					sketchCanvas.getChildren().clear();
				}
			}
		}
	}

	private class ColorHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 5: Implement the color handler
			currentFillColor = colors[fillColorCombo.getSelectionModel().getSelectedIndex()];
			currentStrokeColor = colors[strokeColorCombo.getSelectionModel().getSelectedIndex()];
		}
	}
	
	private class WidthHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event){
			// TASK 6: Implement the stroke width handler
			currentStrokeWidth = Integer.parseInt(strokeWidthCombo.getValue());
		}
	}
	
		
	// Get the Euclidean distance between (x1,y1) and (x2,y2)
    private double getDistance(double x1, double y1, double x2, double y2)  {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}