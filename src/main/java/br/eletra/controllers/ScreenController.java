package br.eletra.controllers;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;

public class ScreenController {

    @FXML
    private ComboBox<String> comboBoxLinhas;

    @FXML
    private TitledPane titledPaneModelos;

    @FXML
    private TitledPane titledPaneLinhas;

    // Construtor sem argumentos
    public ScreenController() {
    }

    @FXML
    public void initialize() {
        // Criar uma lista com os modelos "Cronos" e "Ares"
        ObservableList<String> modelos = FXCollections.observableArrayList(
                "Cronos",
                "Ares"
        );

        // Adicionar os modelos ao ComboBox
        comboBoxLinhas.setItems(modelos);
    }
}