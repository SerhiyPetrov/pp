package com;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public final class MainModel {
    private static volatile MainModel instance;

    private final IntegerProperty enginesInStock = new SimpleIntegerProperty();
    private final IntegerProperty bodiesInStock = new SimpleIntegerProperty();
    private final IntegerProperty accessoriesInStock = new SimpleIntegerProperty();
    private final IntegerProperty assembliesInStock = new SimpleIntegerProperty();
    private final IntegerProperty deliveredInStock = new SimpleIntegerProperty();
    private final IntegerProperty enginesInTotal = new SimpleIntegerProperty();
    private final IntegerProperty bodiesInTotal = new SimpleIntegerProperty();
    private final IntegerProperty accessoriesInTotal = new SimpleIntegerProperty();
    private final IntegerProperty assembliesInTotal = new SimpleIntegerProperty();
    private final IntegerProperty deliveredInTotal = new SimpleIntegerProperty();
    private final IntegerProperty soldInTotal = new SimpleIntegerProperty();

    private final IntegerProperty engineProductionSpeed = new SimpleIntegerProperty();
    private final IntegerProperty bodyProductionSpeed = new SimpleIntegerProperty();
    private final IntegerProperty accessoryProductionSpeed = new SimpleIntegerProperty();
    private final IntegerProperty assemblyProductionSpeed = new SimpleIntegerProperty();
    private final IntegerProperty deliverySpeed = new SimpleIntegerProperty();

    private MainModel() {

    }

    public static MainModel getInstance() {
        MainModel result = instance;
        if (result != null) {
            return result;
        }
        synchronized(MainModel.class) {
            if (instance == null) {
                instance = new MainModel();
            }
            return instance;
        }
    }

    public int getEnginesInStock() {
        return enginesInStock.get();
    }

    public IntegerProperty enginesInStockProperty() {
        return enginesInStock;
    }

    public int getBodiesInStock() {
        return bodiesInStock.get();
    }

    public IntegerProperty bodiesInStockProperty() {
        return bodiesInStock;
    }

    public int getAccessoriesInStock() {
        return accessoriesInStock.get();
    }

    public IntegerProperty accessoriesInStockProperty() {
        return accessoriesInStock;
    }

    public int getAssembliesInStock() {
        return assembliesInStock.get();
    }

    public IntegerProperty assembliesInStockProperty() {
        return assembliesInStock;
    }

    public int getDeliveredInStock() {
        return deliveredInStock.get();
    }

    public IntegerProperty deliveredInStockProperty() {
        return deliveredInStock;
    }

    public int getEnginesInTotal() {
        return enginesInTotal.get();
    }

    public IntegerProperty enginesInTotalProperty() {
        return enginesInTotal;
    }

    public int getBodiesInTotal() {
        return bodiesInTotal.get();
    }

    public IntegerProperty bodiesInTotalProperty() {
        return bodiesInTotal;
    }

    public int getAccessoriesInTotal() {
        return accessoriesInTotal.get();
    }

    public IntegerProperty accessoriesInTotalProperty() {
        return accessoriesInTotal;
    }

    public int getAssembliesInTotal() {
        return assembliesInTotal.get();
    }

    public IntegerProperty assembliesInTotalProperty() {
        return assembliesInTotal;
    }

    public int getDeliveredInTotal() {
        return deliveredInTotal.get();
    }

    public IntegerProperty deliveredInTotalProperty() {
        return deliveredInTotal;
    }

    public int getSoldInTotal() {
        return soldInTotal.get();
    }

    public IntegerProperty soldInTotalProperty() {
        return soldInTotal;
    }

    public int getEngineProductionSpeed() {
        return engineProductionSpeed.get();
    }

    public IntegerProperty engineProductionSpeedProperty() {
        return engineProductionSpeed;
    }

    public int getBodyProductionSpeed() {
        return bodyProductionSpeed.get();
    }

    public IntegerProperty bodyProductionSpeedProperty() {
        return bodyProductionSpeed;
    }

    public int getAccessoryProductionSpeed() {
        return accessoryProductionSpeed.get();
    }

    public IntegerProperty accessoryProductionSpeedProperty() {
        return accessoryProductionSpeed;
    }

    public int getAssemblyProductionSpeed() {
        return assemblyProductionSpeed.get();
    }

    public IntegerProperty assemblyProductionSpeedProperty() {
        return assemblyProductionSpeed;
    }

    public int getDeliverySpeed() {
        return deliverySpeed.get();
    }

    public IntegerProperty deliverySpeedProperty() {
        return deliverySpeed;
    }
}
