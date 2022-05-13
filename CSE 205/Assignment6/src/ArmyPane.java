// Assignment #:  6
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  Contains the elements of the "Create Army" Pane

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ArmyPane extends BorderPane {
	// COMPLETED: contains a list of heroes
	ArrayList<Hero> heroList;
	
	// COMPLETED: Variables containing army Damage, Strength, and Charisma
	int totalDamage;
	int totalStrength;
	int totalCharisma;

	
	// TODO 5. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE Label to display Army information
	// ONE VBox to contain CheckBoxes
	// ONE "Load Heroes/Clear Selection" Button
	// vvvvvv 5. a) vvvvvv (about 3 lines)
	Label armyInfoLabel;
	VBox inputPane;
	Button selectionButton;

	// ^^^^^^ 5. a) ^^^^^^

	public ArmyPane(ArrayList<Hero> heroList) {
		this.heroList = heroList;

		// TODO 5. a) Initialize the instance variables
		// This is where you use the "new" keyword
		// vvvvvv 5. a) vvvvvv (about 3 lines)
		armyInfoLabel = new Label("Select heroes to add to your army");
		inputPane = new VBox();
		selectionButton = new Button("Load Heroes/Clear Selection");
		// ^^^^^^ 5. a) ^^^^^^

		// TODO: 5. b) Bind "Load Heroes/Clear Selection" Button to its handler
		// vvvvvv 5. b) vvvvvv (1 line)
		selectionButton.setOnAction(new LoadHeroesButtonHandler());
		// ^^^^^^ 5. b) ^^^^^^
		
		// TODO: 5. c) Organize components to their positions on BorderPane
		// Remember that THIS class "is"/extends BorderPane, use BorderPane syntax to add components
		// vvvvvv 5. c) vvvvvv (1 line)
		//super(inputPane,armyInfoLabel,null,selectionButton,null);
		this.setTop(armyInfoLabel);
		this.setBottom(selectionButton);
		this.setCenter(inputPane);
		// ^^^^^^ 5. c) ^^^^^^

	}
	
	private class LoadHeroesButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// reset totalDamage, totalStrength totalCharisma
			totalDamage = 0;
			totalStrength = 0;
			totalCharisma = 0;

			// Update Label
			armyInfoLabel.setText("Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma);

			// TODO: 6. Clear the VBox (1 line)
			// vvvvvv 6. a) vvvvvv (1 line)
			inputPane.getChildren().clear();
			// ^^^^^^ 6. a) ^^^^^^

			// TODO: 6. b), c), d)  
			// vvvvvv 6. b), c), d) vvvvvv (about 5-8 lines)
			for(int i = 0; i < heroList.size(); i++)
			{
				// b) Create a new CheckBox from the hero data
				CheckBox heroesCheckBox = new CheckBox(heroList.get(i).toString());
				// c) Bind CheckBox with it's handler
				heroesCheckBox.setOnAction(new CheckBoxHandler(heroList.get(i)));
				// d) add CheckBox to VBox
				inputPane.getChildren().add(heroesCheckBox);

			}
			// ^^^^^^ 6. b), c), d) ^^^^^^

		}
	}

	private class CheckBoxHandler implements EventHandler<ActionEvent> {

		Hero hero;
		
		// When creating a new CheckBoxHandler, pass in a Hero object so it can be accessed later
		public CheckBoxHandler(Hero _hero) {
			this.hero = _hero;
		}

		@Override
		public void handle(ActionEvent event) {
			// TODO: 7. a) Use event.getSource() to get the CheckBox that triggered the event, cast it to CheckBox
			// vvvvvv 7. a) vvvvvv (1 line)
			CheckBox current = (CheckBox) event.getSource();
			// ^^^^^^ 7. a) ^^^^^^
			
			// TODO: 7. b) If the CheckBox was selected, add the current hero scores to totalStrength, 
			// 	totalCharisma, and totalDamge. Otherwise, subtract the current hero scores
			// vvvvvv 7. b) vvvvvv (about 8-12 lines)
			if(current.isSelected()) // if selected
			{
				totalStrength += hero.getStrength();
				totalCharisma += hero.getCharisma();
				totalDamage += hero.getDamage();
			}
			else // if not selected
			{
				totalStrength -= hero.getStrength();
				totalCharisma -= hero.getCharisma();
				totalDamage -= hero.getDamage();
			}
			// ^^^^^^ 7. b) ^^^^^^

			// TODO: 7. c) Set the Label to 
			// "Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma
			// vvvvvv 7. c) vvvvvv (1 line)
			armyInfoLabel.setText("Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma);
			// ^^^^^^ 7. c) ^^^^^^

		}
	}

}
