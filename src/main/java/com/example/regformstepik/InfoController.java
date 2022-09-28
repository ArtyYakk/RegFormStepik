package com.example.regformstepik;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class InfoController {

    @FXML
    private Label infAge;

    @FXML
    private Label infTopic;

    @FXML
    private Label infCity;

    @FXML
    private Label infCountry;

    @FXML
    private Label infFlat;

    @FXML
    private Label infHeight;

    @FXML
    private Label infHouse;

    @FXML
    private Label infLogin;

    @FXML
    private Label infName;

    @FXML
    private Label infPassword;

    @FXML
    private Label infSex;

    @FXML
    private Label infStreet;

    @FXML
    private Label infSurname;


    public void initialize(){
        infAge.setText(Parameters.age);
        infTopic.setText(Parameters.topic);
        infCity.setText(Parameters.city);
        infCountry.setText(Parameters.country);
        infFlat.setText(Parameters.flat);
        infHeight.setText(Parameters.height);
        infHouse.setText(Parameters.house);
        infLogin.setText(Parameters.login);
        infName.setText(Parameters.name);
        infPassword.setText(Parameters.password);
        infSex.setText(Parameters.sex);
        infStreet.setText(Parameters.street);
        infSurname.setText(Parameters.surname);
    }

}
