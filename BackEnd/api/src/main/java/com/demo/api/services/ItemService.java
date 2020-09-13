package com.demo.api.services;

import com.demo.api.exceptions.ResourceNotFoundException;
import com.demo.api.models.Item;

import java.util.List;

/**
 * @author Gayan Samuditha
 */


public interface ItemService extends priceCalc {

    List<Item> getAllItems();

    Item getItemById(Long id) throws ResourceNotFoundException;

    void deleteItemById(Long id) throws ResourceNotFoundException;

    Item creteOrUpdateItem(Item itemEntity) throws ResourceNotFoundException;

}
