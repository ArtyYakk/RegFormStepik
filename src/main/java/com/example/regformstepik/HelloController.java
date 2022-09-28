package com.example.regformstepik;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController{
    @FXML
    private Label ageLabel;

    @FXML
    private Slider ageSlider;

    @FXML
    private ComboBox<String> city;
    @FXML
    private CheckBox writeYourCity;
    boolean visibility = false;
    ObservableList<String> cities;

    @FXML
    private ComboBox<String> country;
    String ctry = "";

    @FXML
    private TextField flat;

    @FXML
    private Spinner<Integer> height;

    @FXML
    private TextField house;

    @FXML
    private TextField login;

    @FXML
    private TextField name;

    @FXML
    private TextField otherCity;

    @FXML
    private PasswordField passOne;

    @FXML
    private PasswordField passTwo;
    @FXML
    private Label warning;

    @FXML
    private Button registerButton;

    @FXML
    private RadioButton sexM;

    @FXML
    private RadioButton sexW;

    @FXML
    private TextField street;

    @FXML
    private TextField surname;

    @FXML
    private TextArea topic;


    public void initialize(){
        passOne.setOnAction(event -> {
            System.out.println("dsafsadf");
        });

        writeYourCity.setOnAction(event -> {
            otherCity.setDisable(visibility);
            city.setDisable(!visibility);
            visibility = !visibility;
            System.out.println(visibility);
        });

        ObservableList<String> countries = FXCollections.observableArrayList(
                "Россия","США","Япония", "Финляндия"
        );
        country.setItems(countries);

        country.setOnAction(event -> {
            ctry = country.getValue();
            switch (ctry){
                case "Россия":
                    cities = FXCollections.observableArrayList(
                            "Питер", "Москва", "Иваново", "Ярославль");
                    break;
                case "США":
                    cities = FXCollections.observableArrayList(
                            "Вашингтон", "Нью-Йорк", "Сиэтл", "Чикаго");
                    break;
                case "Япония":
                    cities = FXCollections.observableArrayList(
                            "Токио", "Хиросима", "Нагасаки", "Киото");
                    break;
                case "Финляндия":
                    cities = FXCollections.observableArrayList(
                            "Хельсинки", "Тампере", "Куопио", "Турку");
                    break;
            }
            city.setItems(cities);

        });

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.
                IntegerSpinnerValueFactory(0,250,175);
        height.setValueFactory(valueFactory);

        ToggleGroup radioGroup = new ToggleGroup();
        sexM.setToggleGroup(radioGroup);
        sexW.setToggleGroup(radioGroup);
        ageSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ageLabel.setText(String.valueOf((int)ageSlider.getValue()));
            }
        });


        registerButton.setOnAction(event -> {
            if (passOne.getText().equals(passTwo.getText())){
                Parameters.name = name.getText().trim();
                Parameters.surname = surname.getText().trim();
                Parameters.age = ageLabel.getText().trim();
                Parameters.sex = String.valueOf(radioGroup.getSelectedToggle()).substring(
                        String.valueOf(radioGroup.getSelectedToggle()).indexOf("'")+1,
                        String.valueOf(radioGroup.getSelectedToggle()).lastIndexOf("'")
                );
                Parameters.height = String.valueOf(height.getValue());

                Parameters.country = country.getValue();

                if(visibility) Parameters.city = otherCity.getText();
                else Parameters.city = city.getValue();

                Parameters.street = street.getText().trim();
                Parameters.house = house.getText().trim();
                Parameters.flat = flat.getText().trim();

                char[] preTopic = topic.getText().trim().toCharArray();
                int iter = 0;
                for (char letter : preTopic){
                    if(iter == 35){
                        iter = 0;
                        Parameters.topic += "\n";
                    }
                    Parameters.topic += letter;
                    iter++;
                }

                Parameters.login = login.getText().trim();
                Parameters.password = passOne.getText().trim(); //Логика паролей

                openNewScene("/com/example/regformstepik/info.fxml");
            } else warning.setText("Пароли не совпадают!");


        });

    }

    public void openNewScene(String window){
        registerButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("fxml loader issue");
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
