package com.example.lab5;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.SneakyThrows;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class VinputText extends VBox {
    @FXML
    private ImageView iconValidation;

    @FXML
    private TextField userInput;
    @FXML
    private Label fieldName;
    @FXML
    public Button confirm;

    @SneakyThrows()
    public VinputText() {
        Person person_name = new Person();
        Field name_field = person_name.getClass().getDeclaredField("name");
        Regex name_ann = name_field.getDeclaredAnnotation(Regex.class);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vinput-text.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        fxmlLoader.load();
        fieldName.setText("Imie do sprawdzenia.");

        userInput.textProperty().addListener((observable, oldValue, newValue) -> {
            person_name.setName(newValue);
            validateInput(person_name, name_ann);
        });

    }


    @SneakyThrows
    public void validateInput(Person value, Regex annotation) {
        FileInputStream input_0 = new FileInputStream("E:\\School\\Intellij\\lab5\\0.png");
        Image incorrect_image = new Image(input_0);
        FileInputStream input_1 = new FileInputStream("E:\\School\\Intellij\\lab5\\1.png");
        Image correct_image = new Image(input_1);
        iconValidation.setImage(incorrect_image);

        HelloController control = new HelloController();

        if (annotation != null) {
            Validator name_validator = new RegexValidator(annotation);
            name_validator.validate(value.getName());

            if (name_validator.isValid()) {
                iconValidation.setImage(correct_image);
                confirm.setDisable(false);
            } else {
                iconValidation.setImage(incorrect_image);
                confirm.setDisable(true);
                Tooltip tooltip = new Tooltip((name_validator.getMessage()).toString());
                Tooltip.install(iconValidation, tooltip);
            }
        }
        else{
                System.out.println("Nie ma podanego regexa!");
            }

        }


    }

