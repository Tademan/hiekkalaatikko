/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hienojuttu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Taavi
 */
public class FXMLDocumentController implements Initializable {


    @FXML
    private VBox slomoKontrol;
    @FXML
    private Label label;
    @FXML
    private Label slomoLabel;
    @FXML
    private Slider slomoSlider;
     @FXML
    private Slider kokoSlider;
    @FXML
    private MenuItem restrat;
    @FXML
    private Canvas canvas;
    @FXML
    private CheckBox pause;
    @FXML
    private RadioButton vesi;
    @FXML
    private RadioButton maa;
    @FXML
    private RadioButton hiekka;
    @FXML
    private RadioButton ilma;

    private MyMap map;
    public int slomo;
    private MyMap.NodeType materiaali = MyMap.NodeType.SAND;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.map = new MyMap(500, 500,0);
        System.out.println("hoi");
    }

    public MyMap getMap() {
        return this.map;
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public void kello() {
        if (!pause.selectedProperty().get()) {
            int slomoRaja = (int)slomoSlider.getValue();
            this.slomo++;
            if (this.slomo > slomoRaja) {
                map.simuloi();
                this.slomo = 0;
            }
        }
        this.label.setText(this.materiaali.toString());
        GraphicsContext piirturi = canvas.getGraphicsContext2D();
        piirturi.setFill(Color.BLACK);
        piirturi.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        canvas.setOnMouseDragged((event) -> {
            int koko = (int)kokoSlider.getValue();
            
            for (int i = -koko; i <= koko; i++) {
                for (int j = -koko; j <= koko; j++) {

                    map.setNode((int) event.getX() + i, (int) event.getY() + j, materiaali);
                }
            }

        });
        

        for (int i = 0; i < map.leveys; i++) {
            for (int j = 0; j < map.korkeus; j++) {
                if (map.getNode(i, j) == MyMap.NodeType.SAND) {
                    piirturi.setFill(Color.DARKGOLDENROD);
                    piirturi.fillOval(i, j, 1, 1);
                }
                if (map.getNode(i, j) == MyMap.NodeType.WATER) {
                    piirturi.setFill(Color.BLUE);
                    piirturi.fillOval(i, j, 1, 1);
                }
                if (map.getNode(i, j) == MyMap.NodeType.STONE) {
                    piirturi.setFill(Color.DARKGRAY);
                    piirturi.fillOval(i, j, 1, 1);
                }
                if (map.getNode(i, j) == MyMap.NodeType.AIR) {
                    piirturi.setFill(Color.WHITE);
                    piirturi.fillOval(i, j, 1, 1);
                }
                if (map.getNode(i, j) == MyMap.NodeType.HELIUM) {
                    piirturi.setFill(Color.DARKTURQUOISE);
                    piirturi.fillOval(i, j, 1, 1);
                }
                if (map.getNode(i, j) == MyMap.NodeType.HYDROGEN) {
                    piirturi.setFill(Color.GREENYELLOW);
                    piirturi.fillOval(i, j, 1, 1);
                }
                if (map.getNode(i, j) == MyMap.NodeType.FIRE) {
                    piirturi.setFill(Color.RED);
                    piirturi.fillOval(i, j, 1, 1);
                }
                

            }
        }

    }

    @FXML
    private void handleRestartAction(ActionEvent event) {
        this.map = new MyMap(500, 500,0);

    }

    @FXML
    private void handleVesi(ActionEvent event) {
        this.materiaali = MyMap.NodeType.WATER;
    }

    @FXML
    private void handleMaa(ActionEvent event) {
        materiaali = MyMap.NodeType.STONE;
    }

    @FXML
    private void handleHiekka(ActionEvent event) {
        materiaali = MyMap.NodeType.SAND;
    }

    @FXML
    private void handleIlma(ActionEvent event) {
        materiaali = MyMap.NodeType.AIR;
    }
    @FXML
    private void handleHelium(ActionEvent event) {
        materiaali = MyMap.NodeType.HELIUM;
    }
    @FXML
    private void handleHydrogen(ActionEvent event) {
        materiaali = MyMap.NodeType.HYDROGEN;
    }
    @FXML
    private void handleFire(ActionEvent event) {
        materiaali = MyMap.NodeType.FIRE;
    }
    
    
    @FXML
    private void handleVesiButton(ActionEvent event) {
        this.map = new MyMap(500,500,3,MyMap.NodeType.WATER);
    }

    @FXML
    private void handleMaaButton(ActionEvent event) {
        this.map = new MyMap(500,500,3,MyMap.NodeType.STONE);
    }

    @FXML
    private void handleHiekkaButton(ActionEvent event) {
       this.map = new MyMap(500,500,3,MyMap.NodeType.SAND);
    }

    @FXML
    private void handleIlmaButton(ActionEvent event) {
       this.map = new MyMap(500,500,3,MyMap.NodeType.AIR);
    }
    @FXML
    private void handleHeliumButton(ActionEvent event) {
        this.map = new MyMap(500,500,3,MyMap.NodeType.HELIUM);
    }
    @FXML
    private void handleHydrogenButton(ActionEvent event) {
        this.map = new MyMap(500,500,3,MyMap.NodeType.HYDROGEN);
    }
    @FXML
    private void handleFireButton(ActionEvent event) {
        this.map = new MyMap(500,500,3,MyMap.NodeType.FIRE);
    }

    @FXML
    private void handlePause(ActionEvent event) {

    }
    @FXML
    private void handleRandom(ActionEvent event) {
        this.map = new MyMap(500,500,1);
    }
    
    

}
