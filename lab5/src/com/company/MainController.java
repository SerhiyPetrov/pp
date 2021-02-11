package com;

import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    private MainModel model;

    public Stage adjustSpeedStage;

    @FXML
    private Pane animationPane;

    @FXML
    private ImageView engineImage;
    @FXML
    private ImageView bodyImage;
    @FXML
    private ImageView accessoriesImage;
    @FXML
    private ImageView carImage;
    @FXML
    private ImageView dealerImage;

    @FXML
    private Label enginesInStock;
    @FXML
    private Label bodiesInStock;
    @FXML
    private Label accessoriesInStock;
    @FXML
    private Label assembliesInStock;

    @FXML
    private Label enginesInTotal;
    @FXML
    private Label bodiesInTotal;
    @FXML
    private Label accessoriesInTotal;
    @FXML
    private Label assembliesInTotal;
    @FXML
    private Label deliveredInTotal;
    @FXML
    private Label soldInTotal;

    public MainController() {
        super();
    }

    public void setModel(MainModel model) {
        this.model = model;

        enginesInStock.textProperty().bind(model.enginesInStockProperty().asString());
        model.enginesInStockProperty().addListener(this::onEnginesInStockChanged);
        bodiesInStock.textProperty().bind(model.bodiesInStockProperty().asString());
        model.bodiesInStockProperty().addListener(this::onBodiesInStockChanged);
        accessoriesInStock.textProperty().bind(model.accessoriesInStockProperty().asString());
        model.accessoriesInStockProperty().addListener(this::onAccessoriesInStockChanged);
        assembliesInStock.textProperty().bind(model.assembliesInStockProperty().asString());
        model.assembliesInStockProperty().addListener(this::onAssembliesInStockChanged);
        model.deliveredInStockProperty().addListener(this::onDeliveredInStockChanged);

        enginesInTotal.textProperty().bind(model.enginesInTotalProperty().asString());
        bodiesInTotal.textProperty().bind(model.bodiesInTotalProperty().asString());
        accessoriesInTotal.textProperty().bind(model.accessoriesInTotalProperty().asString());
        assembliesInTotal.textProperty().bind(model.assembliesInTotalProperty().asString());
        deliveredInTotal.textProperty().bind(model.deliveredInTotalProperty().asString());
        soldInTotal.textProperty().bind(model.soldInTotalProperty().asString());
        model.soldInTotalProperty().addListener(this::onSoldInTotalChanged);
    }

    public void onOpenAdjustSpeedStage() throws IOException {
        if (adjustSpeedStage != null) {
            this.logger.info("Request to open adjust speed stage.");
            adjustSpeedStage.show();
        }
    }

    private void playImageTransition(Image image, double fromX, double fromY, double toX, double toY, double speed) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        animationPane.getChildren().add(imageView);

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(speed));
        transition.setFromX(fromX);
        transition.setFromY(fromY);
        transition.setToX(toX);
        transition.setToY(toY);
        transition.setNode(imageView);
        transition.play();

        transition.onFinishedProperty().set(actionEvent -> {
            animationPane.getChildren().remove(imageView);
        });
    }

    private void onEnginesInStockChanged(
            ObservableValue<? extends Number> property,
            Number oldValue,
            Number newValue) {
        if (newValue.intValue() - oldValue.intValue() > 0)
            playImageTransition(
                    engineImage.getImage(),
                    engineImage.getLayoutX(),
                    engineImage.getLayoutY(),
                    carImage.getLayoutX(),
                    carImage.getLayoutY(),
                    0.5);
    }

    private void onBodiesInStockChanged(
            ObservableValue<? extends Number> property,
            Number oldValue,
            Number newValue) {
        if (newValue.intValue() - oldValue.intValue() > 0)
            playImageTransition(
                    bodyImage.getImage(),
                    bodyImage.getLayoutX(),
                    bodyImage.getLayoutY(),
                    carImage.getLayoutX(),
                    carImage.getLayoutY(),
                    0.5);
    }

    private void onAccessoriesInStockChanged(
            ObservableValue<? extends Number> property,
            Number oldValue,
            Number newValue) {
        if (newValue.intValue() - oldValue.intValue() > 0)
            playImageTransition(
                    accessoriesImage.getImage(),
                    accessoriesImage.getLayoutX(),
                    accessoriesImage.getLayoutY(),
                    carImage.getLayoutX(),
                    carImage.getLayoutY(),
                    0.5);
    }

    private void onAssembliesInStockChanged(
            ObservableValue<? extends Number> property,
            Number oldValue,
            Number newValue) {
        if (newValue.intValue() - oldValue.intValue() > 0)
            carImage.opacityProperty().set(1);

        if (newValue.intValue() == 0)
            carImage.opacityProperty().set(0.2);
    }

    private void onDeliveredInStockChanged(
            ObservableValue<? extends Number> property,
            Number oldValue,
            Number newValue) {
        if (newValue.intValue() - oldValue.intValue() > 0)
            playImageTransition(
                    carImage.getImage(),
                    carImage.getLayoutX(),
                    carImage.getLayoutY(),
                    dealerImage.getLayoutX(),
                    dealerImage.getLayoutY(),
                    0.5);
    }

    private void onSoldInTotalChanged(
            ObservableValue<? extends Number> property,
            Number oldValue,
            Number newValue) {

    }
}
