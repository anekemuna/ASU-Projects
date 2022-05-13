// Assignment 12: Arizona State University CSE205
//         Name: Munachimso Aneke
//    StudentID: 1215028815
//      Lecture: TTh 9am
//  Description: Handles all the control events (handlers and listeners) of the program

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import javafx.scene.control.ColorPicker;

import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class WaveControlPane extends Pane {

	private WaveDisplayPane wavePane;
	private int width, height;
	private Color color;
	private ColorPicker picker;

	// ******************************************************************
	// Task #2a: add instance variables for sliders, buttons, and labels
	// ******************************************************************
	Button startButton, stopButton, clearButton, surpriseButton;
	Slider speedSlide, widthSlide, heightSlide;
	Label speedLabel, widthLabel, heightLabel;


	// constructor to create all components, set their handler/listener,
	// and arrange them using layout panes.
	public WaveControlPane(int h, int w, Color initialColor) {
		this.color = initialColor;
		this.width = (int) (h * 0.68);
		this.height = w - 10;

		// creates a pane to display waves with the specified color
		wavePane = new WaveDisplayPane(width, color);
		wavePane.setMinSize(width, height);
		wavePane.setMaxSize(width, height);

		// create a color picker with the specified initial color
		picker = new ColorPicker(color);
		picker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		// ************************************************************************
		// Task #2b: create 4 buttons and resize them to the width of the VBox pane,
		// then add them to the VBox buttonPane instantiated below.
		// *************************************************************************
		startButton = new Button("Start");
		startButton.setMaxWidth(Double.MAX_VALUE);
		stopButton = new Button("Stop");
		stopButton.setMaxWidth(Double.MAX_VALUE);
		clearButton = new Button("Clear");
		clearButton.setMaxWidth(Double.MAX_VALUE);
		surpriseButton = new Button("Surprise!");
		surpriseButton.setMaxWidth(Double.MAX_VALUE);

		VBox buttonPane = new VBox(startButton, stopButton, clearButton, surpriseButton, picker);
		
		buttonPane.setPrefSize(100, 100);
		buttonPane.setAlignment(Pos.CENTER);

		
		// ************************************************************************
		// Task #2c: create 3 sliders and 3 labels and add them to the VBox panes
		// instantiated below. 
		// *************************************************************************
		// create VERTICAL sliders, and turn on ticks and labels
		speedSlide = new Slider(5, 100, 20);
		speedSlide.setOrientation(Orientation.VERTICAL);
		speedSlide.setMinorTickCount(5);
		speedSlide.setMajorTickUnit(10);
		speedSlide.setShowTickLabels(true);
		speedSlide.setShowTickMarks(true);

		widthSlide = new Slider(5, 100, 50);
		widthSlide.setOrientation(Orientation.VERTICAL);
		widthSlide.setMinorTickCount(5);
		widthSlide.setMajorTickUnit(10);
		widthSlide.setShowTickLabels(true);
		widthSlide.setShowTickMarks(true);

		heightSlide = new Slider(5, 100, 100);
		heightSlide.setOrientation(Orientation.VERTICAL);
		heightSlide.setMinorTickCount(5);
		heightSlide.setMajorTickUnit(10);
		heightSlide.setShowTickLabels(true);
		heightSlide.setShowTickMarks(true);

		// create labels
		speedLabel = new Label("Speed");
		widthLabel = new Label("Width");
		heightLabel = new Label("Height");

		// add labels and sliders to VBox
		VBox speedSliderPane = new VBox(speedLabel, speedSlide);
		VBox waveLengthSliderPane = new VBox(widthLabel, widthSlide);
		VBox waveAmplitudeSliderPane = new VBox(heightLabel, heightSlide);

		TilePane sliderPane = new TilePane();
		sliderPane.setPrefColumns(3);
		sliderPane.setPadding(new Insets(5, 5, 5, 5));
		sliderPane.setAlignment(Pos.CENTER);
		sliderPane.getChildren().addAll(speedSliderPane, waveLengthSliderPane, waveAmplitudeSliderPane);

		HBox controls = new HBox(buttonPane, sliderPane);
		controls.setAlignment(Pos.CENTER);

		BorderPane controlsAndWaves = new BorderPane();
		controlsAndWaves.setLeft(controls);
		controlsAndWaves.setCenter(wavePane);

		this.getChildren().add(controlsAndWaves);

		// ************************************************************************
		// Task #2d: Register the buttons, sliders, and color picker with the
		// appropriate handler object 
		// *************************************************************************
		startButton.setOnAction(new ButtonHandler());
		stopButton.setOnAction(new ButtonHandler());
		clearButton.setOnAction(new ButtonHandler());
		surpriseButton.setOnAction(new ButtonHandler());

		speedSlide.valueProperty().addListener(new SpeedHandler());
		widthSlide.valueProperty().addListener(new WaveLengthHandler());
		heightSlide.valueProperty().addListener(new WaveAmplitudeHandler());

		picker.setOnAction(new ColorHandler());
	}

	// ************************************************************************
	// Task #3: Implement event handlers for the four buttons (task #3a), 
	// the color picker (task #3b), the speed slider (task #3c), and the
	// sliders for wave amplitude and length (tasks #3d, #3e)
	// *************************************************************************

	// Task 3a: ButtonHandler class
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			if(event.getSource()== startButton)
			{
				wavePane.resume();
			}
			else if(event.getSource() == stopButton)
			{
				wavePane.suspend();
			}
			else if(event.getSource() == clearButton)
			{
				wavePane.clearPane();
			}
			else if(event.getSource() == surpriseButton)
			{
				// stop animation
				wavePane.suspend();

				// generate random values
				int speed = 5 + (int) (Math.random() * 96);
				int amplitude = 5 + (int) (Math.random() * 96);
				int waveLength = 5 + (int) (Math.random() * 96);
				int r = (int) (Math.random() * 256);
				int g = (int) (Math.random() * 256);
				int b = (int) (Math.random() * 256);

				// set random values
				wavePane.setRate(speed);
				wavePane.setWaveAmplitude(amplitude);
				wavePane.setWaveLength(waveLength);
				Color newColor = Color.rgb(r, g, b);
				wavePane.changeColor(newColor);

				// update slides
				speedSlide.setValue(speed);
				heightSlide.setValue(amplitude);
				widthSlide.setValue(waveLength);

				//update color picker
				picker.setValue(newColor);

				// resume animation
				wavePane.resume();
			}

		}
	}

	// Task 3b: ColorHandler class
	private class ColorHandler implements EventHandler <ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			wavePane.changeColor(picker.getValue());
		}
	}

	// Task 3c: SpeedHandler class
	private class SpeedHandler implements ChangeListener <Number>
	{
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
		{
			wavePane.setRate((newValue.intValue()));
		}
	}

	// Task 3d: WaveLengthHandler class
	private class WaveLengthHandler implements ChangeListener <Number>
	{
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
		{
			wavePane.suspend();
			wavePane.setWaveLength((newValue.intValue()));
		}
	}

	// Task 3e: WaveAmplitudeHandler class
	private class WaveAmplitudeHandler implements ChangeListener <Number>
	{
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
		{
			wavePane.suspend();
			wavePane.setWaveAmplitude((newValue.intValue()));
		}
	}









}
