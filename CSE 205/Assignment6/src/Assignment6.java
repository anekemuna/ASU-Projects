// Assignment #:  6
//         Name:  Munachimso Aneke
//   Student ID:  1215028815
//      Lecture:  TTh 9:00am (CSE 205)
//  Description:  The Assignment6 class creates a TabPane Pane with
//                two tabs, one for adding Heroes and one for
//                creating an Army

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Assignment6 extends Application {
    private TabPane tabPane;
    private HeroPane heroPane;
    private ArmyPane armyPane;
    private ArrayList<Hero> heroList;
    public static final int WINSIZE_X = 950, WINSIZE_Y = 600;


    public void start(Stage stage) {
        StackPane root = new StackPane();

        // heroList to be used in all tabs
        Hero defaultUnicorn = new Hero("Aliz", "Unicorn", 20, 80, 60);
        heroList = new ArrayList<Hero>();
        heroList.add(defaultUnicorn);
        heroPane = new HeroPane(heroList);
        armyPane = new ArmyPane(heroList);


        tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("Add Hero");
        tab1.setContent(heroPane);

        Tab tab2 = new Tab();
        tab2.setText("Create Army");
        tab2.setContent(armyPane);

        tabPane.getSelectionModel().select(0);
        tabPane.getTabs().addAll(tab1, tab2);

        root.getChildren().add(tabPane);

        Scene scene = new Scene(root, WINSIZE_X, WINSIZE_Y);
        stage.setTitle("Create your army!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}