package com.Vendor;

import com.MainModel;
import com.Stock.IStock;
import com.Item.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineVendor implements IVendor {
    private final Logger logger = LoggerFactory.getLogger(EngineVendor.class);

    IStock _stock;

    public EngineVendor(IStock stock){
        _stock = stock;
    }
    @java.lang.Override

    public void Produce(String _id, String _Titel) throws InterruptedException {
        boolean isSuccess = false;
        while(!isSuccess){
            synchronized (_stock){
                this.logger.info(_id.toString()+_Titel+" was produced");
                //System.out.println(_id.toString()+_Titel+" was produced");
                isSuccess = _stock.AddItem(new Engine(_id, _Titel));
            }
            if(!isSuccess)
                Thread.sleep(MainModel.getInstance().assemblyProductionSpeedProperty().get());
        }
    }
}
