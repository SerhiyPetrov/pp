package com.Stock;

import com.Item.IItem;

public interface IStock {
    IItem GetItem();
    boolean AddItem(IItem item);
}
