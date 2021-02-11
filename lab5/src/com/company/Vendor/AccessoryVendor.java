package com.Vendor;

import com.MainModel;
import com.Stock.IStock;
import com.Item.Accessory;
import com.ThreadPool.Task.DillerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessoryVendor implements IVendor {
    private final Logger logger = LoggerFactory.getLogger(AccessoryVendor.class);

    IStock _stock;
    public AccessoryVendor(IStock stock)
    {
        _stock = stock;
    }
    int time;
    @java.lang.Override
    public void Produce(String _id, String _Titel) throws InterruptedException {
        boolean isSuccess = false;
        while(!isSuccess){
            synchronized (_stock){
                this.logger.info(_id.toString()+_Titel+" was produced");
                //System.out.println(_id.toString()+_Titel+" was produced");
                isSuccess = _stock.AddItem(new Accessory(_id, _Titel));
            }
            if(!isSuccess)
                Thread.sleep(MainModel.getInstance().assemblyProductionSpeedProperty().get());
        }
    }
}
