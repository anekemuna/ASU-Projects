// Assignment 12: Arizona State University CSE205
//         Name: Munachimso Aneke
//    StudentID: 1215028815
//      Lecture: TTh 9am
//  Description: Handles the animation


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class WaveDisplayPane extends Pane {

	// Task #1: implement instance variables, constructor, and methods
	// as outlined in the UML diagram and assignment description
	private Timeline timeline;
	private int time;
	private int waveLength;
	private int waveAmplitude;
	private int paneWidth;
	private Color color;

	// WaveDisplayPane constructor
	public WaveDisplayPane(int width, Color newColor)
	{
		// instantiating instance variables
		waveAmplitude = 100;
		waveLength = 50;
		paneWidth = width;
		color = newColor;
		time = 0;

		// set pane style
		this.setStyle("-fx-background-color: white; -fx-border-color: black");

		// initiate KeyFrame
		KeyFrame keyFrame = new KeyFrame(new Duration(500), new WaveHandler());

		// create timeline object, setRate(), play timeline
		timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		setRate(20);
		timeline.play();

	}

	// resume(): plays an animation
	public void resume()
	{
		timeline.play();
	}

	// suspend(): pauses an animation and sets time to 0
	public void suspend()
	{
		timeline.pause();
		time = 0;
	}

	// changeColor(): sets a new Color for the wave
	public void changeColor(Color c)
	{
		color = c;
	}

	// clearPane(): removes all waves, suspend animation
	public void clearPane()
	{
		this.getChildren().clear();
		timeline.stop();
	}

	// setWaveLength(): set wave length
	public void setWaveLength(int waveLength1)
	{
		waveLength = waveLength1;
	}

	// setWaveAmplitude(): set wave amplitude
	public void setWaveAmplitude(int waveAmplitude1)
	{
		waveAmplitude = waveAmplitude1;
	}

	// setRate(): set rate
	public void setRate(int rate)
	{
		timeline.setRate(rate);
	}


	// defines an event listener to draw a new point
	private class WaveHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			time++;
			int x = (waveLength * time) / 314;
			int y = (int) (waveAmplitude * Math.sin((0.0174533) * time) + 115);

			if (x < paneWidth) {
				Circle dot = new Circle(x, y, 2);
				dot.setFill(color);
				getChildren().add(dot);
			} else suspend();
		}
	}
}
