package br.eletra.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.*;

public class ScreenController {

    @FXML
    private TitledPane titledPaneModelos;

    @FXML
    private TreeView<String> treeView;

    @FXML
    private ComboBox<String> comboBoxLinhas;

    @FXML
    private Accordion accordion;

    // Mapa para armazenar os modelos por linha e subcategoria
    private final Map<String, Map<String, List<String>>> modelosPorLinha = new HashMap<>();

    // Construtor sem argumentos
    public ScreenController() {
    }

    @FXML
    public void initialize() {
        titledPaneModelos.setDisable(true);

        // Criar uma lista com as opções de linha
        ObservableList<String> linhas = FXCollections.observableArrayList(
                "Cronos",
                "Ares"
        );

        // Adicionar as opções de linha ao ComboBox
        comboBoxLinhas.setItems(linhas);

        // Adicionar um listener para detectar a seleção da linha
        comboBoxLinhas.setOnAction(event -> handleSelecaoLinha());

        // Inicializar os modelos para cada linha e subcategoria
        inicializarModelosPorLinha();
    }

    // Método para lidar com a seleção de linha no ComboBox
    @FXML
    private void handleSelecaoLinha() {
        String linhaSelecionada = comboBoxLinhas.getValue();
        if (linhaSelecionada != null) {
            titledPaneModelos.setDisable(false); // Habilita o TitledPane de Modelos
            exibirModelos(linhaSelecionada); // Exibe os modelos correspondentes à linha selecionada
        }
    }

    // Inicializar os modelos para cada linha e subcategoria
    private void inicializarModelosPorLinha() {
        // Modelos para a linha Cronos
        Map<String, List<String>> modelosCronos = new LinkedHashMap<>();
        List<String> modelosCronosOld = new ArrayList<>();
        modelosCronosOld.add("Cronos 6001-A");
        modelosCronosOld.add("Cronos 6003");
        modelosCronosOld.add("Cronos 7023");
        modelosCronos.put("Cronos Old", modelosCronosOld);

        List<String> modelosCronosL = new ArrayList<>();
        modelosCronosL.add("Cronos 6021L");
        modelosCronosL.add("Cronos 7023L");
        modelosCronos.put("Cronos L", modelosCronosL);

        List<String> modelosCronosNG = new ArrayList<>();
        modelosCronosNG.add("Cronos 6001‑NG");
        modelosCronosNG.add("Cronos 6003‑NG");
        modelosCronosNG.add("Cronos 6021‑NG");
        modelosCronosNG.add("Cronos 6031‑NG");
        modelosCronosNG.add("Cronos 7021‑NG");
        modelosCronosNG.add("Cronos 7023‑NG");
        modelosCronos.put("Cronos-NG", modelosCronosNG);

        // Modelos para a linha Ares
        Map<String, List<String>> modelosAres = new LinkedHashMap<>();
        List<String> modelosAresTB = new ArrayList<>();
        modelosAresTB.add("Ares 7021");
        modelosAresTB.add("Ares 7031");
        modelosAresTB.add("Ares 7023");
        modelosAres.put("Ares TB", modelosAresTB);

        List<String> modeloAresTHS = new ArrayList<>();
        modeloAresTHS.add("Ares 8023 15");
        modeloAresTHS.add("Ares 8023 200");
        modeloAresTHS.add("Ares 8023 2,5");
        modelosAres.put("Ares THS", modeloAresTHS);

        modelosPorLinha.put("Cronos", modelosCronos);
        modelosPorLinha.put("Ares", modelosAres);
    }

    // Exibir os modelos correspondentes à linha selecionada
    private void exibirModelos(String linhaSelecionada) {
        if (linhaSelecionada != null) {
            Map<String, List<String>> subcategorias = modelosPorLinha.get(linhaSelecionada);
            if (subcategorias != null) {
                TreeItem<String> rootItem = new TreeItem<>(linhaSelecionada);
                for (String subcategoria : subcategorias.keySet()) {
                    TreeItem<String> subcategoriaItem = new TreeItem<>(subcategoria);
                    List<String> modelos = subcategorias.get(subcategoria);
                    for (String modelo : modelos) {
                        subcategoriaItem.getChildren().add(new TreeItem<>(modelo));
                    }
                    rootItem.getChildren().add(subcategoriaItem);
                }
                treeView.setRoot(rootItem);
                expandirModelos(); // Chamada para expandir o TitledPane de Modelos
            }
        }
    }

    // Método para expandir o TitledPane de Modelos
    private void expandirModelos() {
        titledPaneModelos.setExpanded(true);
        accordion.setExpandedPane(accordion.getPanes().get(1)); // Índice 1 corresponde ao TitledPane de Modelos
    }
}