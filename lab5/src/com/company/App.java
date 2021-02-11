package com;

import com.FactoryFacade.FactoryFacade;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class App extends Application {
    private final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.logger.info("Application started!");

        this.logger.info("Loading Main.fxml.");
        FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent mainRoot = FXMLLoader.load();
        MainController mainController = FXMLLoader.getController();
        mainController.setModel(MainModel.getInstance());

        this.logger.info("Loading AdjustSpeed.fxml.");
        FXMLLoader = new FXMLLoader(getClass().getResource("AdjustSpeed.fxml"));
        Parent adjustSpeedRoot = FXMLLoader.load();
        AdjustSpeedController adjustSpeedController = FXMLLoader.getController();
        adjustSpeedController.setModel(MainModel.getInstance());

        mainController.adjustSpeedStage = new Stage();
        mainController.adjustSpeedStage.setTitle("Producer-Consumer Assignment - Adjust Speed");
        mainController.adjustSpeedStage.resizableProperty().setValue(Boolean.FALSE);
        mainController.adjustSpeedStage.setScene(new Scene(adjustSpeedRoot));

        FactoryFacade factoryFacade = new FactoryFacade();

        stage.setTitle("Producer-Consumer Assignment");
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(new Scene(mainRoot));
        stage.setOnCloseRequest(event -> {
            this.logger.info("Closing application.");
            factoryFacade.ShutdownFactory();
            this.logger.info("Tasks shutting down.");
            Platform.exit();
            System.exit(0);
        });
        stage.show();

        factoryFacade.RunFactory();
    }
}
