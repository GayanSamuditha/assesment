package com.demo.api.services;

import com.demo.api.models.Item;
import com.demo.api.models.TotalPriceCalc;
import com.demo.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gayan Samuditha
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {

        List<Item> itemList = itemRepository.findAll();

        if(itemList.size() > 0){
            return itemList;
        }else{
            return new ArrayList<Item>();
        }
    }

    @Override
    public Item getItemById(Long id) {
        return null;
    }

    @Override
    public void deleteItemById(Long id) {

    }

    @Override
    public Item creteOrUpdateItem(Item itemEntity) {
        return null;
    }

    public Double calculateItemCartonPrice(Item item, Integer amount){

        Double totalCartonPrice = 0.0;



        return  null;
    }


    public Double calculateTotalCartonPrice(List<TotalPriceCalc> list){

        return  null;
    }


}

