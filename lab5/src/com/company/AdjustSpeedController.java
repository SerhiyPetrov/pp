package com;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class AdjustSpeedController {
    @FXML
    private Slider engineProductionSpeed;
    @FXML
    private Slider bodyProductionSpeed;
    @FXML
    private Slider accessoryProductionSpeed;
    @FXML
    private Slider assemblyProductionSpeed;
    @FXML
    private Slider deliverySpeed;

    private MainModel model;

    public AdjustSpeedController() {
        super();
    }

    public void setModel(MainModel model) {
        this.model = model;

        model.engineProductionSpeedProperty().bind(engineProductionSpeed.valueProperty());
        model.bodyProductionSpeedProperty().bind(bodyProductionSpeed.valueProperty());
        model.accessoryProductionSpeedProperty().bind(accessoryProductionSpeed.valueProperty());
        model.assemblyProductionSpeedProperty().bind(assemblyProductionSpeed.valueProperty());
        model.deliverySpeedProperty().bind(deliverySpeed.valueProperty());
    }
}
