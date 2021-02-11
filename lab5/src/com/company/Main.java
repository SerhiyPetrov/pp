package com;

import com.Controllers.FactoryFacade.FactoryFacade;

public final class Main {
    public static void main(String[] args) {

        var MainModel = new com.Models.MainModel();
        var MainView =
                new com.Views.MainView(MainModel);
        var MainController =
                new com.Controllers.MainController(MainView, MainModel);
        MainView.setController(MainController);

        MainView.setVisible(true);

        var Factory = new FactoryFacade();
        Factory.RunFactory();
    }
}