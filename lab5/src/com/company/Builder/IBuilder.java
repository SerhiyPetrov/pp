package com.Builder;

import com.Item.IItem;

public interface IBuilder {
    IItem Build() throws InterruptedException;
    void PutToStock(IItem car) throws InterruptedException;
    boolean IsIdle();
}
