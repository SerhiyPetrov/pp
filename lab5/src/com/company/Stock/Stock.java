package com.Stock;

import com.Item.IItem;
import com.MainModel;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Stock implements IStock {
    private final Logger logger = LoggerFactory.getLogger(Stock.class);

    private final int capacity;
    private final String name;
    private ArrayList<IItem> itemList;
    private final StockType type;

    public Stock(StockType type, int capacity, String name) {
        this.type = type;
        this.capacity = capacity;
        this.name = name;
        this.itemList = new ArrayList<IItem>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public ArrayList<IItem> getItemList() {
        return itemList;
    }

    public StockType getType() {
        return type;
    }

    @Override
    public IItem GetItem() {
        var item = this.itemList.remove(0);

        var mainModel = MainModel.getInstance();
        final CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            try {
                switch(type) {
                    case Accessory:
                        mainModel.accessoriesInStockProperty().set(itemList.size());
                        mainModel.accessoriesInTotalProperty().set(mainModel.assembliesInTotalProperty().get() + 1);
                        break;
                    case Body:
                        mainModel.bodiesInStockProperty().set(itemList.size());
                        mainModel.bodiesInTotalProperty().set(mainModel.bodiesInTotalProperty().get() + 1);
                        break;
                    case Engine:
                        mainModel.enginesInStockProperty().set(itemList.size());
                        mainModel.enginesInTotalProperty().set(mainModel.enginesInTotalProperty().get() + 1);
                        break;
                    case Car:
                        mainModel.assembliesInStockProperty().set(itemList.size());
                        mainModel.assembliesInTotalProperty().set(mainModel.assembliesInTotalProperty().get() + 1);
                        break;
                }
            } finally {
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.logger.info(item.getTitel() + item.getId() +": taken from "+this.name+" Stock");
        //System.out.println(ConsoleColors.ANSI_RED+ item.getTitel() + item.getId() +": taken from "+this.name+" Stock" + ConsoleColors.ANSI_RESET);
        return item;
    }

    @Override
    public boolean AddItem(IItem item) {
        if (itemList.size() < capacity) {
            itemList.add(item);
            var mainModel = MainModel.getInstance();
            final CountDownLatch latch = new CountDownLatch(1);
            Platform.runLater(() -> {
                try {
                    switch(type) {
                        case Accessory:
                            mainModel.accessoriesInStockProperty().set(itemList.size());
                            mainModel.accessoriesInTotalProperty().set(mainModel.assembliesInTotalProperty().get() + 1);
                            break;
                        case Body:
                            mainModel.bodiesInStockProperty().set(itemList.size());
                            mainModel.bodiesInTotalProperty().set(mainModel.bodiesInTotalProperty().get() + 1);
                            break;
                        case Engine:
                            mainModel.enginesInStockProperty().set(itemList.size());
                            mainModel.enginesInTotalProperty().set(mainModel.enginesInTotalProperty().get() + 1);
                            break;
                        case Car:
                            mainModel.assembliesInStockProperty().set(itemList.size());
                            mainModel.assembliesInTotalProperty().set(mainModel.assembliesInTotalProperty().get() + 1);
                            break;
                    }
                } finally {
                    latch.countDown();
                }
            });
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.logger.info(item.getTitel() + item.getId() +": added to "+this.name+" Stock");
            //System.out.println(item.getTitel() + item.getId() +": added to "+this.name+" Stock");
            return true;
        }
        return false;
    }
}
