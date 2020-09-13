package com.demo.api.controllers;

import com.demo.api.dto.CartonPriceCalcReq;
import com.demo.api.dto.CartonPriceCalcResp;
import com.demo.api.exceptions.ItemServiceException;
import com.demo.api.exceptions.ResourceNotFoundException;
import com.demo.api.models.Item;
import com.demo.api.models.TotalPriceCalc;
import com.demo.api.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gayan Samuditha
 */

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Item>> getAllItems() throws ResourceNotFoundException, ItemServiceException {

        List<Item> list = itemService.getAllItems();

        return new ResponseEntity<List<Item>>(list, new HttpHeaders(), HttpStatus.OK);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long id) throws ResourceNotFoundException{

        Item itemEntity = itemService.getItemById(id);

        return new ResponseEntity<Item>(itemEntity, new HttpHeaders(), HttpStatus.OK);

    }


    @PostMapping(path= "/createOrUpdateItem", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Item> createOrUpdateItem(@RequestBody Item item) throws ResourceNotFoundException {

        Item updated = itemService.creteOrUpdateItem(item);

        return new ResponseEntity<Item>(updated, new HttpHeaders(), HttpStatus.OK);

    }

    @RequestMapping(path="/calculate_carton_price/singleCarton/{itemId}/{amount}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<CartonPriceCalcResp> calculateSingleCartonItemPrice(@PathVariable("itemId") Long itemId, @PathVariable("amount") Integer amount)
            throws ResourceNotFoundException {

        Item item = itemService.getItemById(itemId);

        CartonPriceCalcResp cartonPriceCalcRespDto = new CartonPriceCalcResp();

        if(item != null) {
            cartonPriceCalcRespDto.setCartonPrice(itemService.calculateItemCartonPrice(item,amount));
        }
        return new ResponseEntity<CartonPriceCalcResp>(cartonPriceCalcRespDto, new HttpHeaders(), HttpStatus.OK);

    }


    @RequestMapping(path="/calculate_carton_price/all", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CartonPriceCalcResp> calculateTotalPrice(@RequestBody ArrayList<CartonPriceCalcReq> cartonItemList)
            throws ResourceNotFoundException {

        List<TotalPriceCalc> items = new ArrayList<TotalPriceCalc>();

        for(CartonPriceCalcReq cartonItem : cartonItemList){
            Item availableItem = itemService.getItemById(cartonItem.getItemId());
            if(availableItem != null) {
                TotalPriceCalc newPrice = new TotalPriceCalc();
                newPrice.setItem(availableItem);
                newPrice.setPurchasedAmount(cartonItem.getItemAmount());
                items.add(newPrice);
            }
        }

        CartonPriceCalcResp cartonPriceCalcRespDto = new CartonPriceCalcResp();

        cartonPriceCalcRespDto.setCartonPrice(itemService.calculateTotalCartonPrice(items));

        return new ResponseEntity<CartonPriceCalcResp>(cartonPriceCalcRespDto, new HttpHeaders(), HttpStatus.OK);

    }


}
