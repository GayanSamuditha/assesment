package com.demo.api.services;

import com.demo.api.models.Item;
import com.demo.api.models.TotalPriceCalc;

import java.util.List;

/**
 * @author Gayan Samuditha
 */

public interface priceCalc {

    Double calculateItemCartonPrice(Item item, Integer amount);

    Double calculateTotalCartonPrice(List<TotalPriceCalc> list);

}
