package application;

import java.sql.SQLException;

import javax.swing.GroupLayout.Alignment;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.Text;
import javafx.scene.control.*;


public class Main extends Application {
	@Override

	//////First Stage
	public void start(Stage stagelogin) {

		GridPane grid1 = new GridPane();
		Model model = new Model();
		TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        username.setMaxSize(300, 300);
        password.setMaxSize(300, 325);
        username.setMinHeight(45); password.setMinHeight(45);
        Button login, clear;
        login = new Button(); clear = new Button();
        login.setText("Login"); clear.setText("Clear");
        login.setStyle("fx-text-fill: White;"
	    	        + "-fx-font-family: Arial Narrow;"
	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);"
	    	        + "-fx-Text-fill: white;");
        clear.setStyle("fx-text-fill: White; "
    	        + "-fx-font-family: Arial Narrow; "
    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);"
    	        + "-fx-Text-fill: white;");
        login.setMaxSize(200,200); clear.setMaxSize(200,200);
        Text status, herit;
        status = new Text();
        status.setText("");
        status.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        herit = new Text(); herit.setText("ADMIN LOGIN");
        herit.setStyle("-fx-font-size: 25px;"
        		+ "-fx-font-family: Arial Black;"
        		+ "-fx-fill: #818181;"
        		+ "-fx-effect: innershadow(three-pass-box, rgba(0,0,0,0.7), 6,0.0,0,2);"
        		+ "-fx-font-weight: bold");
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15));
        pane.setHgap(12);
        pane.setVgap(12);
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: gold");
        HBox vb = new HBox();
        vb.setSpacing(75);
        vb.getChildren().addAll(login, clear);
        pane.add(username, 1, 1); pane.add(herit, 1, 0);
        pane.add(password, 1, 2);
        pane.add(vb, 1, 3);
        Scene scene = new Scene(pane, 400, 250);
        stagelogin.setScene(scene);
        stagelogin.setTitle("Herit Grading System: Log in");
        stagelogin.setResizable(false);
        stagelogin.show();

	    if(model.isDBconnected()){
	    	status.setText("Connected");

	    }else{status.setText("not Connected");
	    }

	    login.setOnAction(e ->{
	    	try{
	    		if(model.isLogin(username.getText(),password.getText() )){
	    			//Second Stage
	    			Stage grading = new Stage();
	    			status.setText("Welcome");
	    			BorderPane border = new BorderPane();
	    	        border.setStyle("-fx-border-color: white");
	    	        GridPane grid = new GridPane();
	    	        grid.setPadding(new Insets(15));
	    	        grid.setHgap(10);
	    	        grid.setVgap(10);
	    	        grid.setAlignment(Pos.CENTER);
	    	        //grid.getStylesheets().add(GradingSystemReloaded.class.getResource("gradingsystemreloaded.css").toExternalForm());
	    	        grid.setStyle("-fx-background-color :gold;" + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);");
	    	        StackPane stackpane = new StackPane();
	    	        stackpane.setLayoutX(5);
	    	        stackpane.setLayoutY(5);
	    	        stackpane.setAlignment(Pos.TOP_CENTER);
	    	        //Creating the Menus
	    	        Menu menu1, menu2, menu3, menu4, menu5;
	    	        menu1 = new Menu("File"); menu2 = new Menu("Actions"); menu3 = new Menu("Views");
	    	        menu4 = new Menu("Windows"); menu5 = new Menu("Help");
	    	        MenuBar menubar = new MenuBar(menu1, menu2, menu3, menu4, menu5);
	    	        menubar.setStyle("-fx-background-color: white");
	    	        //menubar.setStyle("-fx-background-color: Black");
	    	        border.setCenter(menubar);
	    	        //Creating the ChoiceBox Section
	    	        //checkBox for course
	    	       ChoiceBox choice1 = new ChoiceBox();
	    	       choice1.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       ChoiceBox choice2 = new ChoiceBox();
	    	       choice2.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       ChoiceBox choice3 = new ChoiceBox();
	    	       choice3.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       ChoiceBox choice4 = new ChoiceBox();
	    	       choice4.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       ChoiceBox choice5 = new ChoiceBox();
	    	       choice5.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       ChoiceBox choice6 = new ChoiceBox();
	    	       choice6.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       ChoiceBox choice7 = new ChoiceBox();
	    	       choice7.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       ChoiceBox choice8 = new ChoiceBox();
	    	       choice8.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       ChoiceBox choice9 = new ChoiceBox();
	    	       choice9.getItems().addAll("COSC 301","COSC 302","COSC 303","COSC 304","COSC 305", "COSC 306",
	    	        "COSC 307", "COSC 308", "COSC 309");
	    	       Label label0, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
	    	       label0 = new Label("Course"); label1 = new Label("Course Unit"); label2 = new Label("CA"); label3 = new Label("Exam Score");
	    	       label4 = new Label("Total"); label5 = new Label("Grade"); label6 = new Label("GP"); label7 = new Label("TGC"); label8 = new Label("TCU");
	    	       label9 = new Label("TTGC"); label10 = new Label("GPA");
	    	       label0.setStyle("-fx-fill: #818181");
	    	       //Creating the Text
	    	       Text txt = new Text();
	    	       txt.setText("HERIT GRADING SYSTEM");
	    	       txt.setStyle("-fx-font-size: 32px; -fx-font-family: Arial Black; -fx-fill: #818181;"
	    	               + "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
	    	       //Creating the Textfields
	    	       //for the course unit
	    	       TextField txtcu1, txtcu2, txtcu3, txtcu4, txtcu5, txtcu6, txtcu7, txtcu8, txtcu9;
	    	       txtcu1 = new TextField(); txtcu2 = new TextField(); txtcu3 = new TextField(); txtcu4 = new TextField(); txtcu5 = new TextField();
	    	       txtcu6 = new TextField(); txtcu7 = new TextField(); txtcu8 = new TextField(); txtcu9 = new TextField();
	    	       //for the CA
	    	        TextField txtca1, txtca2, txtca3, txtca4, txtca5, txtca6, txtca7, txtca8, txtca9;
	    	       txtca1 = new TextField(); txtca2 = new TextField(); txtca3 = new TextField(); txtca4 = new TextField(); txtca5 = new TextField();
	    	       txtca6 = new TextField(); txtca7 = new TextField(); txtca8 = new TextField(); txtca9 = new TextField();
	    	       //for the Exam Score
	    	       TextField txtes1, txtes2, txtes3, txtes4, txtes5, txtes6, txtes7, txtes8, txtes9;
	    	       txtes1 = new TextField(); txtes2 = new TextField(); txtes3 = new TextField(); txtes4 = new TextField(); txtes5 = new TextField();
	    	       txtes6 = new TextField(); txtes7 = new TextField(); txtes8 = new TextField(); txtes9 = new TextField();
	    	       //for Total
	    	       TextField txttot1, txttot2, txttot3, txttot4, txttot5, txttot6, txttot7, txttot8, txttot9;
	    	       txttot1 = new TextField(); txttot2 = new TextField(); txttot3 = new TextField(); txttot4 = new TextField(); txttot5 = new TextField();
	    	       txttot6 = new TextField(); txttot7 = new TextField(); txttot8 = new TextField(); txttot9 = new TextField();
	    	       txttot1.setEditable(false); txttot2.setEditable(false); txttot3.setEditable(false); txttot4.setEditable(false); txttot5.setEditable(false);
	    	       txttot6.setEditable(false); txttot7.setEditable(false); txttot8.setEditable(false); txttot9.setEditable(false);
	    	       //for GRADE
	    	        TextField txtgr1, txtgr2, txtgr3, txtgr4, txtgr5, txtgr6, txtgr7, txtgr8, txtgr9;
	    	       txtgr1 = new TextField(); txtgr2 = new TextField(); txtgr3 = new TextField(); txtgr4 = new TextField(); txtgr5 = new TextField();
	    	       txtgr6 = new TextField(); txtgr7 = new TextField(); txtgr8 = new TextField(); txtgr9 = new TextField();
	    	       txtgr1.setEditable(false); txtgr2.setEditable(false); txtgr3.setEditable(false); txtgr4.setEditable(false); txtgr5.setEditable(false);
	    	       txtgr6.setEditable(false); txtgr7.setEditable(false); txtgr8.setEditable(false); txtgr9.setEditable(false);
	    	       //for GP
	    	       TextField txtgp1, txtgp2, txtgp3, txtgp4, txtgp5, txtgp6, txtgp7, txtgp8, txtgp9;
	    	       txtgp1 = new TextField(); txtgp2 = new TextField(); txtgp3 = new TextField(); txtgp4 = new TextField(); txtgp5 = new TextField();
	    	       txtgp6 = new TextField(); txtgp7 = new TextField(); txtgp8 = new TextField(); txtgp9 = new TextField();
	    	       txtgp1.setEditable(false); txtgp2.setEditable(false); txtgp3.setEditable(false); txtgp4.setEditable(false); txtgp5.setEditable(false);
	    	       txtgp6.setEditable(false); txtgp7.setEditable(false); txtgp8.setEditable(false); txtgp9.setEditable(false);
	    	       //for TGC
	    	       TextField txttgc1, txttgc2, txttgc3, txttgc4, txttgc5, txttgc6, txttgc7, txttgc8, txttgc9;
	    	       txttgc1 = new TextField(); txttgc2 = new TextField(); txttgc3 = new TextField(); txttgc4 = new TextField(); txttgc5 = new TextField();
	    	       txttgc6 = new TextField(); txttgc7 = new TextField(); txttgc8 = new TextField(); txttgc9 = new TextField();
	    	       txttgc1.setEditable(false); txttgc2.setEditable(false); txttgc3.setEditable(false); txttgc4.setEditable(false); txttgc5.setEditable(false);
	    	       txttgc6.setEditable(false); txttgc7.setEditable(false); txttgc8.setEditable(false); txttgc9.setEditable(false);

	    	       //for tcu, ttgc, gpa
	    	       TextField txtcu, txtgc, txtgpa;
	    	       txtcu = new TextField(); txtgc = new TextField(); txtgpa = new TextField();
	    	       txtcu.setEditable(false); txtgc.setEditable(false); txtgpa.setEditable(false);
	    	       //Creating the buttons
	    	       Button calculate, clear1, close, cgpa;
	    	       close = new Button(); close.setText("CLOSE"); close.setMaxSize(150,30);
	    	       calculate = new Button(); calculate.setText("CALCULATE"); clear1 = new Button(); clear.setText("Clear");
	    	       calculate = new Button(); calculate.setText("CALCULATE"); clear1 = new Button(); clear.setText("CLEAR");
	    	       cgpa = new Button(); cgpa.setText("Calculate CGPA"); cgpa.setMaxSize(150, 30); cgpa.setStyle("fx-text-fill: White; "
	    	        + "-fx-font-family: Arial Narrow; "
	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);");
	    	       calculate.setMaxSize(150,30); clear.setMaxSize(150,30);
	    	       calculate.setStyle(
	    	          "fx-text-fill: White; "
	    	        + "-fx-font-family: Arial Narrow; "
	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);"
	    	        + "-fx-Text-fill: white;"
	    	       );
	    	       clear.setStyle("fx-text-fill: White; "
	    	        + "-fx-font-family: Arial Narrow; "
	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1); -fx-Text-fill: white;");
	    	       close.setStyle("fx-text-fill: White; "
	    	        + "-fx-font-family: Arial Narrow; "
	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1); -fx-Text-fill: white;");
	    	       stackpane.getChildren().add(txt);
	    	       //Buttons actions
	    	       calculate.setOnAction(z -> {
	    	              //For CA                                                 //For Exam Score
	    	           Integer ca1 = Integer.valueOf(txtca1.getText());     Integer es1 = Integer.valueOf(txtes1.getText());
	    	           Integer ca2 = Integer.valueOf(txtca2.getText());     Integer es2 = Integer.valueOf(txtes2.getText());
	    	           Integer ca3 = Integer.valueOf(txtca3.getText());     Integer es3 = Integer.valueOf(txtes3.getText());
	    	           Integer ca4 = Integer.valueOf(txtca4.getText());     Integer es4 = Integer.valueOf(txtes4.getText());
	    	           Integer ca5 = Integer.valueOf(txtca5.getText());     Integer es5 = Integer.valueOf(txtes5.getText());
	    	           Integer ca6 = Integer.valueOf(txtca6.getText());     Integer es6 = Integer.valueOf(txtes6.getText());
	    	           Integer ca7 = Integer.valueOf(txtca7.getText());     Integer es7 = Integer.valueOf(txtes7.getText());
	    	           Integer ca8 = Integer.valueOf(txtca8.getText());     Integer es8 = Integer.valueOf(txtes8.getText());
	    	           Integer ca9 = Integer.valueOf(txtca9.getText());     Integer es9 = Integer.valueOf(txtes9.getText());
	    	           Integer tot1 = ca1 + es1;                            txttot1.setText(tot1.toString());
	    	           Integer tot2 = ca2 + es2;                            txttot2.setText(tot2.toString());
	    	           Integer tot3 = ca3 + es3;                            txttot3.setText(tot3.toString());
	    	           Integer tot4 = ca4 + es4;                            txttot4.setText(tot4.toString());
	    	           Integer tot5 = ca5 + es5;                            txttot5.setText(tot5.toString());
	    	           Integer tot6 = ca6 + es6;                            txttot6.setText(tot6.toString());
	    	           Integer tot7 = ca7 + es7;                            txttot7.setText(tot7.toString());
	    	           Integer tot8 = ca8 + es8;                            txttot8.setText(tot8.toString());
	    	           Integer tot9 = ca9 + es9;                            txttot9.setText(tot9.toString());
	    	           // for Grades
	    	           Integer gp1 = Integer.valueOf(txttot1.getText());
	    	           Integer gp2 = Integer.valueOf(txttot2.getText());
	    	           Integer gp3 = Integer.valueOf(txttot3.getText());
	    	           Integer gp4 = Integer.valueOf(txttot4.getText());
	    	           Integer gp5 = Integer.valueOf(txttot5.getText());
	    	           Integer gp6 = Integer.valueOf(txttot6.getText());
	    	           Integer gp7 = Integer.valueOf(txttot7.getText());
	    	           Integer gp8 = Integer.valueOf(txttot8.getText());
	    	           Integer gp9 = Integer.valueOf(txttot9.getText());

	    	           if(gp1 >= 70 && gp1 <= 100){txtgr1.setText("A");} else if(gp1 >=60 && gp1 <= 69){txtgr1.setText("B");}
	    	           else if(gp1 >=50 && gp1 <=59){txtgr1.setText("C");} else if(gp1 >=40 && gp1 <=49){txtgr1.setText("D");}
	    	           else{txtgr1.setText("F");}
	    	            if(gp2 >= 70 && gp2 <= 100){txtgr2.setText("A");} else if(gp2 >=60 && gp2 <= 69){txtgr2.setText("B");}
	    	           else if(gp2 >=50 && gp2 <=59){txtgr2.setText("C");} else if(gp2 >=40 && gp2 <=49){txtgr2.setText("D");}
	    	           else{txtgr2.setText("F");}
	    	            if(gp3 >= 70 && gp3 <= 100){txtgr3.setText("A");} else if(gp3 >=60 && gp3 <= 69){txtgr3.setText("B");}
	    	           else if(gp3 >=50 && gp3 <=59){txtgr3.setText("C");} else if(gp3 >=40 && gp3 <=49){txtgr3.setText("D");}
	    	           else{txtgr3.setText("F");}
	    	            if(gp4 >= 70 && gp4 <= 100){txtgr4.setText("A");} else if(gp4 >=60 && gp4 <= 69){txtgr4.setText("B");}
	    	           else if(gp4 >=50 && gp4 <=59){txtgr4.setText("C");} else if(gp4 >=40 && gp4 <=49){txtgr4.setText("D");}
	    	           else{txtgr4.setText("F");}
	    	            if(gp5 >= 70 && gp5 <= 100){txtgr5.setText("A");} else if(gp5 >=60 && gp5 <= 69){txtgr5.setText("B");}
	    	           else if(gp5 >=50 && gp5 <=59){txtgr5.setText("C");} else if(gp5 >=40 && gp5 <=49){txtgr5.setText("D");}
	    	           else{txtgr5.setText("F");}
	    	            if(gp6 >= 70 && gp6 <= 100){txtgr6.setText("A");} else if(gp6 >=60 && gp6 <= 69){txtgr6.setText("B");}
	    	           else if(gp6 >=50 && gp6 <=59){txtgr6.setText("C");} else if(gp6 >=40 && gp6 <=49){txtgr6.setText("D");}
	    	           else{txtgr6.setText("F");}
	    	            if(gp7 >= 70 && gp7 <= 100){txtgr7.setText("A");} else if(gp7 >=60 && gp7 <= 69){txtgr7.setText("B");}
	    	           else if(gp7 >=50 && gp7 <=59){txtgr7.setText("C");} else if(gp7 >=40 && gp7 <=49){txtgr7.setText("D");}
	    	           else{txtgr7.setText("F");}
	    	            if(gp8 >= 70 && gp8 <= 100){txtgr8.setText("A");} else if(gp8 >=60 && gp8 <= 69){txtgr8.setText("B");}
	    	           else if(gp8 >=50 && gp8 <=59){txtgr8.setText("C");} else if(gp8 >=40 && gp8 <=49){txtgr8.setText("D");}
	    	           else{txtgr8.setText("F");}
	    	            if(gp9 >= 70 && gp9 <= 100){txtgr9.setText("A");} else if(gp9 >=60 && gp9 <= 69){txtgr9.setText("B");}
	    	           else if(gp9 >=50 && gp9 <=59){txtgr9.setText("C");} else if(gp9 >=40 && gp9 <=49){txtgr9.setText("D");}
	    	           else{txtgr9.setText("F");}
	    	            //Calculations for For the GP
	    	            double  no1, no2, no3, no4, no5;
	    	            no1 = 5.0; no2 = 4.0; no3 = 3.0; no4 = 2.0; no5 = 0.0;
	    	            String gr1 = String.valueOf(txtgr1.getText());
	    	            String gr2 = String.valueOf(txtgr2.getText());
	    	            String gr3 = String.valueOf(txtgr3.getText());
	    	            String gr4 = String.valueOf(txtgr4.getText());
	    	            String gr5 = String.valueOf(txtgr5.getText());
	    	            String gr6 = String.valueOf(txtgr6.getText());
	    	            String gr7 = String.valueOf(txtgr7.getText());
	    	            String gr8 = String.valueOf(txtgr8.getText());
	    	            String gr9 = String.valueOf(txtgr9.getText());
	    	            switch (gr1)
	    	            {case "A":{txtgp1.setText(String.valueOf(no1)); break;}
	    	            case "B":{txtgp1.setText(String.valueOf(no2)); break;}
	    	            case "C":{txtgp1.setText(String.valueOf(no3)); break;}
	    	            case "D":{txtgp1.setText(String.valueOf(no4)); break;}
	    	            case "F":{txtgp1.setText(String.valueOf(no5)); break;}
	    	            default: txtgp1.isDisabled();}
	    	            switch (gr2)
	    	            {case "A":{txtgp2.setText(String.valueOf(no1));} break;
	    	            case "B":{txtgp2.setText(String.valueOf(no2));} break;
	    	            case "C":{txtgp2.setText(String.valueOf(no3));} break;
	    	            case "D":{txtgp2.setText(String.valueOf(no4));} break;
	    	            case "F":{txtgp2.setText(String.valueOf(no5));} break;
	    	            default: txtgp2.isDisable();}
	    	            switch (gr3)
	    	            {case "A":{txtgp3.setText(String.valueOf(no1));} break;
	    	            case "B":{txtgp3.setText(String.valueOf(no2));} break;
	    	            case "C":{txtgp3.setText(String.valueOf(no3));} break;
	    	            case "D":{txtgp3.setText(String.valueOf(no4));} break;
	    	            case "F":{txtgp3.setText(String.valueOf(no5));} break;
	    	            default: txtgp3.isDisable();}
	    	            switch (gr4)
	    	            {case "A":{txtgp4.setText(String.valueOf(no1));} break;
	    	            case "B":{txtgp4.setText(String.valueOf(no2));} break;
	    	            case "C":{txtgp4.setText(String.valueOf(no3));} break;
	    	            case "D":{txtgp4.setText(String.valueOf(no4));} break;
	    	            case "F":{txtgp4.setText(String.valueOf(no5));} break;
	    	            default: txtgp4.isDisable();}
	    	            switch (gr5)
	    	            {case "A":{txtgp5.setText(String.valueOf(no1));} break;
	    	            case "B":{txtgp5.setText(String.valueOf(no2));} break;
	    	            case "C":{txtgp5.setText(String.valueOf(no3));} break;
	    	            case "D":{txtgp5.setText(String.valueOf(no4));} break;
	    	            case "F":{txtgp5.setText(String.valueOf(no5));} break;
	    	            default: txtgp5.isDisable();}
	    	            switch (gr6)
	    	            {case "A":{txtgp6.setText(String.valueOf(no1));} break;
	    	            case "B":{txtgp6.setText(String.valueOf(no2));} break;
	    	            case "C":{txtgp6.setText(String.valueOf(no3));} break;
	    	            case "D":{txtgp6.setText(String.valueOf(no4));} break;
	    	            case "F":{txtgp6.setText(String.valueOf(no5));} break;
	    	            default: txtgp6.isDisable();}
	    	            switch (gr7)
	    	            {case "A":{txtgp7.setText(String.valueOf(no1));} break;
	    	            case "B":{txtgp7.setText(String.valueOf(no2));} break;
	    	            case "C":{txtgp7.setText(String.valueOf(no3));} break;
	    	            case "D":{txtgp7.setText(String.valueOf(no4));} break;
	    	            case "F":{txtgp7.setText(String.valueOf(no5));} break;
	    	            default: txtgp7.isDisable();}
	    	            switch (gr8)
	    	            {case "A":{txtgp8.setText(String.valueOf(no1));} break;
	    	            case "B":{txtgp8.setText(String.valueOf(no2));} break;
	    	            case "C":{txtgp8.setText(String.valueOf(no3));} break;
	    	            case "D":{txtgp8.setText(String.valueOf(no4));} break;
	    	            case "F":{txtgp8.setText(String.valueOf(no5));} break;
	    	            default: txtgp8.isDisable();}
	    	            switch (gr9)
	    	            {case "A":{txtgp9.setText(String.valueOf(no1));} break;
	    	            case "B":{txtgp9.setText(String.valueOf(no2));} break;
	    	            case "C":{txtgp9.setText(String.valueOf(no3));} break;
	    	            case "D":{txtgp9.setText(String.valueOf(no4));} break;
	    	            case "F":{txtgp9.setText(String.valueOf(no5));} break;
	    	            default: txtgp9.isDisable();}
	    	            //for TGC                                                        // For Course Unit
	    	            Double tgc1 = Double.valueOf(txtgp1.getText());           Integer cu1 = Integer.valueOf(txtcu1.getText());
	    	            Double tgc2 = Double.valueOf(txtgp2.getText());           Integer cu2 = Integer.valueOf(txtcu2.getText());
	    	            Double tgc3 = Double.valueOf(txtgp3.getText());           Integer cu3 = Integer.valueOf(txtcu3.getText());
	    	            Double tgc4 = Double.valueOf(txtgp4.getText());           Integer cu4 = Integer.valueOf(txtcu4.getText());
	    	            Double tgc5 = Double.valueOf(txtgp5.getText());           Integer cu5 = Integer.valueOf(txtcu5.getText());
	    	            Double tgc6 = Double.valueOf(txtgp6.getText());           Integer cu6 = Integer.valueOf(txtcu6.getText());
	    	            Double tgc7 = Double.valueOf(txtgp7.getText());           Integer cu7 = Integer.valueOf(txtcu7.getText());
	    	            Double tgc8 = Double.valueOf(txtgp8.getText());           Integer cu8 = Integer.valueOf(txtcu8.getText());
	    	            Double tgc9 = Double.valueOf(txtgp9.getText());           Integer cu9 = Integer.valueOf(txtcu9.getText());
	    	            Double tp1 = tgc1 * cu1;
	    	            Double tp2 = tgc2 * cu2;
	    	            Double tp3 = tgc3 * cu3;
	    	            Double tp4 = tgc4 * cu4;
	    	            Double tp5 = tgc5 * cu5;
	    	            Double tp6 = tgc6 * cu6;
	    	            Double tp7 = tgc7 * cu7;
	    	            Double tp8 = tgc8 * cu8;
	    	            Double tp9 = tgc9 * cu9;
	    	            txttgc1.setText(tp1.toString());
	    	            txttgc2.setText(tp2.toString());
	    	            txttgc3.setText(tp3.toString());
	    	            txttgc4.setText(tp4.toString());
	    	            txttgc5.setText(tp5.toString());
	    	            txttgc6.setText(tp6.toString());
	    	            txttgc7.setText(tp7.toString());
	    	            txttgc8.setText(tp8.toString());
	    	            txttgc9.setText(tp9.toString());
	    	            Double gc1 = Double.valueOf(txttgc1.getText());
	    	            Double gc2 = Double.valueOf(txttgc2.getText());
	    	            Double gc3 = Double.valueOf(txttgc3.getText());
	    	            Double gc4 = Double.valueOf(txttgc4.getText());
	    	            Double gc5 = Double.valueOf(txttgc5.getText());
	    	            Double gc6 = Double.valueOf(txttgc6.getText());
	    	            Double gc7 = Double.valueOf(txttgc7.getText());
	    	            Double gc8 = Double.valueOf(txttgc8.getText());
	    	            Double gc9 = Double.valueOf(txttgc9.getText());
	    	            Double tott = gc1 + gc2 + gc3 + gc4 + gc5 + gc6 + gc7 + gc8 + gc9;
	    	            txtgc.setText(tott.toString());
	    	            //For Total course unit
	    	            Integer  cs1 = Integer.valueOf(txtcu1.getText());
	    	            Integer  cs2 = Integer.valueOf(txtcu2.getText());
	    	            Integer  cs3 = Integer.valueOf(txtcu3.getText());
	    	            Integer  cs4 = Integer.valueOf(txtcu4.getText());
	    	            Integer  cs5 = Integer.valueOf(txtcu5.getText());
	    	            Integer  cs6 = Integer.valueOf(txtcu6.getText());
	    	            Integer  cs7 = Integer.valueOf(txtcu7.getText());
	    	            Integer  cs8 = Integer.valueOf(txtcu8.getText());
	    	            Integer  cs9 = Integer.valueOf(txtcu9.getText());
	    	            Integer totcu = cs1 + cs2 + cs3 + cs4 + cs5 + cs6 + cs7 + cs8 + cs9;
	    	            txtcu.setText(totcu.toString());
	    	            //For GPA
	    	            Double gm1 = Double.valueOf(txtgc.getText());
	    	            Double gm2 = Double.valueOf(txtcu.getText());
	    	            Double gpa = gm1 / gm2;
	    	            txtgpa.setText(gpa.toString());
	    	       });
	    	       grid.add(label0, 2,2); grid.add(label1, 3, 2); grid.add(label2, 4, 2); grid.add(label3,5,2);
	    	       grid.add(label4, 6, 2); grid.add(label5, 7, 2); grid.add(label6, 8,2); grid.add(label7, 9, 2);
	    	       grid.add(choice1, 2, 3); grid.add(choice2, 2, 4); grid.add(choice3,2 ,5); grid.add(choice4, 2, 6);
	    	       grid.add(choice5, 2, 7);
	    	       grid.add(choice6, 2,8); grid.add(choice7, 2, 9); grid.add(choice8, 2, 10 ); grid.add(choice9, 2, 11);
	    	       //arrangement of the textfields in their different gridpane cells
	    	       grid.add(txtcu1, 3,3); grid.add(txtcu2, 3,4); grid.add(txtcu3, 3,5); grid.add(txtcu4, 3,6);  grid.add(txtcu5, 3,7);
	    	       grid.add(txtcu6, 3,8); grid.add(txtcu7, 3,9); grid.add(txtcu8, 3,10); grid.add(txtcu9, 3,11);
	    	       // for CA
	    	       grid.add(txtca1, 4, 3); grid.add(txtca2, 4, 4); grid.add(txtca3, 4, 5); grid.add(txtca4, 4, 6); grid.add(txtca5, 4, 7);
	    	       grid.add(txtca6, 4, 8); grid.add(txtca7, 4, 9); grid.add(txtca8, 4, 10); grid.add(txtca9, 4, 11);
	    	       // for Exam Score
	    	       grid.add(txtes1, 5, 3); grid.add(txtes2, 5, 4); grid.add(txtes3, 5, 5); grid.add(txtes4, 5, 6); grid.add(txtes5, 5, 7);
	    	       grid.add(txtes6, 5, 8); grid.add(txtes7, 5, 9); grid.add(txtes8, 5, 10); grid.add(txtes9, 5, 11);
	    	       //For total
	    	       grid.add(txttot1, 6, 3); grid.add(txttot2, 6, 4); grid.add(txttot3, 6, 5); grid.add(txttot4, 6, 6); grid.add(txttot5, 6, 7);
	    	       grid.add(txttot6, 6, 8); grid.add(txttot7, 6, 9); grid.add(txttot8, 6, 10); grid.add(txttot9, 6, 11);
	    	       // for Grade
	    	       grid.add(txtgr1, 7, 3); grid.add(txtgr2, 7, 4); grid.add(txtgr3, 7, 5); grid.add(txtgr4, 7, 6); grid.add(txtgr5, 7, 7);
	    	       grid.add(txtgr6, 7, 8); grid.add(txtgr7, 7, 9); grid.add(txtgr8, 7, 10); grid.add(txtgr9, 7, 11);
	    	       // for GP
	    	       grid.add(txtgp1, 8,3); grid.add(txtgp2, 8,4); grid.add(txtgp3, 8,5); grid.add(txtgp4, 8,6); grid.add(txtgp5, 8,7);
	    	       grid.add(txtgp6, 8,8); grid.add(txtgp7, 8,9); grid.add(txtgp8, 8,10); grid.add(txtgp9, 8,11);
	    	       //for TGC
	    	       grid.add(txttgc1, 9, 3); grid.add(txttgc2, 9, 4); grid.add(txttgc3, 9, 5); grid.add(txttgc4, 9, 6); grid.add(txttgc5, 9, 7);
	    	       grid.add(txttgc6, 9, 8); grid.add(txttgc7, 9, 9); grid.add(txttgc8, 9, 10); grid.add(txttgc9, 9, 11);
	    	       grid.add(label8, 2, 14); grid.add(label9, 2, 15); grid.add(label10, 2, 16); grid.add(txtcu, 3, 14); grid.add(txtgc,3, 15 );
	    	       grid.add(txtgpa, 3, 16); grid.add(calculate, 6, 14); grid.add(clear, 7, 14); grid.add(close, 8, 14);
	    	       grid.add(cgpa, 9, 14);
	    	       //grid.add(txt,6, 0 );
	    	       border.setCenter(grid);
	    	       border.setTop(menubar);
	    	       stackpane.getChildren().add(border);
	    	       //Close Button Action
	    	       close.setOnAction(f ->{
	    	          HBox hb = new HBox();
	    	          VBox vb1 = new VBox();
	    	          Label lab = new Label(); lab.setText("Are You Sure You Want To Exit ?");
	    	          Button yes, no; yes = new Button(); yes.setText("Yes");
	    	          yes.setStyle("-fx-background-color: red");
	    	          no = new Button(); no.setText("No");
	    	          no.setStyle("-fx-background-color: green");
	    	          vb1.getChildren().addAll(lab, hb);
	    	          vb1.setAlignment(Pos.CENTER);
	    	          vb1.setSpacing(5);
	    	          vb1.setStyle("fx-background-color: Gold");
	    	          hb.getChildren().addAll(yes, no);
	    	          hb.setAlignment(Pos.CENTER);
	    	          hb.setSpacing(35);
	    	          hb.setStyle("fx-background-color: white");
	    	          Scene scene1 = new Scene(vb1, 300,100);



	    	          //exit Stage
	    	          Stage stage = new Stage();
	    	          stage.setScene(scene1);
	    	          stage.setTitle("Herit Grading System-Exit");
	    	          stage.initModality(Modality.APPLICATION_MODAL);
	    	          stage.setMaxWidth(250);
	    	          stage.sizeToScene();
	    	          stage.setResizable(false);
	    	          stage.show();
	    	          yes.setOnAction(y ->{
	    	              grading.close();
	    	              stage.close();});
	    	          no.setOnAction(c ->{
	    	             stage.close();
	    	          });
	    	       });
	    	       clear.setOnAction(d ->{
	    	           txtcu1.clear();txtcu2.clear();txtcu3.clear();txtcu4.clear();txtcu5.clear();txtcu6.clear();txtcu7.clear();txtcu8.clear();
	    	           txtcu9.clear();txtca1.clear();txtca2.clear();txtca3.clear();txtca4.clear();txtca5.clear();txtca6.clear();txtca7.clear();
	    	           txtca8.clear();txtca9.clear();txtes1.clear();txtes2.clear();txtes3.clear();txtes4.clear();txtes5.clear();txtes6.clear();
	    	           txtes7.clear();txtes8.clear();txtes9.clear();txttot1.clear();txttot2.clear();txttot3.clear();txttot4.clear();txttot5.clear();
	    	           txttot6.clear();txttot7.clear();txttot8.clear();txttot9.clear();txtgr1.clear();txtgr2.clear();txtgr3.clear();txtgr4.clear();
	    	           txtgr5.clear();txtgr6.clear();txtgr7.clear();txtgr8.clear();txtgr9.clear();txtgp1.clear();txtgp2.clear();txtgp3.clear();
	    	           txtgp4.clear();txtgp5.clear();txtgp6.clear();txtgp7.clear();txtgp8.clear();txtgp9.clear();txttgc1.clear();txttgc2.clear();
	    	           txttgc3.clear();txttgc4.clear();txttgc5.clear();txttgc6.clear();txttgc7.clear();txttgc8.clear();txttgc9.clear();
	    	           txtcu.clear();txtgc.clear();txtgpa.clear();
	    	       });

	    	       // Creating the scene and inserting the stackPane into the scene
	    	       Scene scene1 = new Scene(stackpane, (Color.KHAKI));

	    	       grading.setScene(scene1);
	    	       grading.setTitle("Herit Grading System");
	    	       grading.show();
                   stagelogin.close();
                   //for CGPA
                   cgpa.setOnAction(v ->{
                	   Button level100, level200, level300, level400;
                	   level100 = new Button("100 Level"); level100.setStyle("fx-text-fill: White; "
	    	        + "-fx-font-family: Arial Narrow; "
	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);");
                	   level200 = new Button("200 Level"); level200.setStyle("fx-text-fill: White; "
	    	        + "-fx-font-family: Arial Narrow; "
	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);");
                	   level300 = new Button("300 Level"); level300.setStyle("fx-text-fill: White; "
	    	        + "-fx-font-family: Arial Narrow; "
	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);");
                	   level400 = new Button("300 Level");
                	   level400.setMaxSize(300, 70);
                	   level400.setStyle("fx-text-fill: White; "
           	    	        + "-fx-font-family: Arial Narrow; "
           	    	        + "-fx-font-weight: bold; -fx-background-color: linear-gradient(#61c2b1,#2A5058); "
           	    	        + "-fx-effect: dropshadow(three-pass-box , rgba(0,0,0,0.6), 5,0.0,0,1);");
                       level100.setMaxHeight(500); level100.setMaxWidth(400);
                	   GridPane gipi = new GridPane();
                	   gipi.setPadding(new Insets(49));
                	   gipi.setStyle("-fx-background-color: gold");
                	   gipi.setAlignment(Pos.CENTER);
                	   gipi.setHgap(50);
                	   gipi.setVgap(50);
                	   gipi.add(level100, 2, 2); gipi.add(level200, 5, 2); gipi.add(level300, 9, 2);
                	   gipi.add(level400, 5, 8);
                	   Scene cipa = new Scene(gipi, 500, 300);

                	   ////CGPA STAGE
                	   Stage calcgpa = new Stage();
                	   calcgpa.setScene(cipa);
                       calcgpa.setTitle("Herit Grading System: CGPA");
                       calcgpa.show();
                       grading.close();
                   });

	    		}else{
	    			pane.add(status, 1,4);
	    			status.setText("Incorrect");
	    			status.setFill(Color.RED);
	    		}
	    	}catch(SQLException e1){
	    		status.setText("Incorrect");
	    		e1.printStackTrace();
	    	}
	    });
	    clear.setOnAction(f ->{
	    	username.clear();
	    	password.clear();
	    });


	}

public static void main(String[] args) {
	launch(args);
}
}