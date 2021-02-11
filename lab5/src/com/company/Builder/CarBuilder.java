package com.Builder;

import com.MainModel;
import com.Stock.*;
import com.Helper.ConsoleColors;
import com.Item.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class CarBuilder implements IBuilder {
    private final Logger logger = LoggerFactory.getLogger(CarBuilder.class);

    private IStock _engineStock;
    private IStock _bodyStock;
    private IStock _accessoryStock;
    private IStock _carsStock;
    private boolean _isIdle;
    private long _randomInt=0;

    public  CarBuilder(IStock engineStock, IStock bodyStock, IStock accessoryStock, IStock carStock){
        _engineStock = engineStock;
        _bodyStock = bodyStock;
        _accessoryStock = accessoryStock;
        _carsStock = carStock;
        _randomInt = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        _isIdle = true;
    }

    @Override
    public IItem Build() throws InterruptedException {
        _isIdle = false;
        Body body = null;
        Accessory accessory = null;
        Engine engine = null;

        while(body == null){
            try {
                synchronized (_bodyStock) {
                    body = (Body) _bodyStock.GetItem();
                }
            }
            catch (IndexOutOfBoundsException exception) {
                Thread.sleep(MainModel.getInstance().bodyProductionSpeedProperty().get() + _randomInt);
            }
        }


        while(engine == null){
            try {
                synchronized (_engineStock) {
                    engine = (Engine) _engineStock.GetItem();
                }
            }
            catch (IndexOutOfBoundsException exception){
                Thread.sleep(MainModel.getInstance().engineProductionSpeedProperty().get() + _randomInt);
            }
        }

        while(accessory == null){
            try{
                synchronized (_accessoryStock){
                    accessory = (Accessory) _accessoryStock.GetItem();
                }
            }
            catch (IndexOutOfBoundsException exception){
                Thread.sleep(MainModel.getInstance().accessoryProductionSpeedProperty().get() + _randomInt);
            }
        }

        Car car = new Car();
        car.setId("BBK"+car.hashCode());
        car.setTitel("Bibika v12");

        car.setAccessory(accessory);
        car.setBody(body);
        car.setEngine(engine);
        Thread.sleep(MainModel.getInstance().assemblyProductionSpeedProperty().get());

        this.logger.info("BIBIKA was built");
        //System.out.println(ConsoleColors.ANSI_GREEN+ "BIBIKA was built"+ ConsoleColors.ANSI_RESET);
        return car;
    }

    @Override
    public void PutToStock(IItem car) throws InterruptedException {
        boolean isSuccess = false;
        while(!isSuccess){
            synchronized (_carsStock){
                isSuccess = _carsStock.AddItem(car);
            }
            if(!isSuccess)
                Thread.sleep(MainModel.getInstance().assemblyProductionSpeedProperty().get()  + _randomInt );
        }
        _isIdle = true;
    }

    @Override
    public boolean IsIdle() {
        return _isIdle;
    }
}
