package com.demo.api.services;

import com.demo.api.models.Item;
import com.demo.api.models.TotalPriceCalc;
import com.demo.api.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Gayan Samuditha
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @MockBean
    private ItemRepository itemRepository;

    @Autowired
    private ItemServiceImpl itemService;

    @Test
    public void createNewItem() {
        Item item = getItem();
        Mockito.when(itemRepository.save(item)).thenReturn(item);
        Item created = itemService.creteOrUpdateItem(item);
        assertThat(created.getItemName()).isEqualTo(item.getItemName());
    }

    @Test
    public void updateExcistingItem() {
        Item item = getItem();
        String updateName = "Tested updated Name";
        Mockito.when(itemRepository.save(item)).thenReturn(item);
        Item created = itemService.creteOrUpdateItem(item);
        created.setItemName(updateName);
        Mockito.when((itemRepository.save(created))).thenReturn(created);
        Item updated = itemService.creteOrUpdateItem(item);
        assertThat(updated.getItemName()).isEqualTo(updateName);
    }

    @Test
    public void searchItem() {
        Item item = getItem();
        Integer id = 1;
        item.setId(Long.parseLong(id.toString()));
        Optional<Item> itemExcisting = Optional.of(item);
        Mockito.when(itemRepository.findById(Long.parseLong(id.toString()))).thenReturn(itemExcisting);
        Item getItem = itemService.getItemById(Long.parseLong(id.toString()));
        assertThat(getItem.getItemName()).isEqualTo(item.getItemName());
    }

    @Test
    public void calculationPriceOfSingleCartonLessthanCartoonAmount() {
        Item item = getItem();
        Double singlePrice = itemService.calculateItemCartonPrice(item, 20);
        assertThat(singlePrice).isEqualTo(115.85);
    }

    @Test
    public void calculationPriceOfSingleCartonMorethanCartoonAmount() {
        Item item = getItem();
        Double singlePrice = itemService.calculateItemCartonPrice(item, 35);
        assertThat(singlePrice).isEqualTo(302.45);
    }

    @Test
    public void calculatePriceOfMultipleItemsPurchased() {
        List<TotalPriceCalc> purchasedItems = getItemListForCalculation();
        Double singlePrice = itemService.calculateTotalCartonPrice(purchasedItems);
        assertThat(singlePrice).isEqualTo(168.2648);
    }

    private Item getItem() {
        Item item = new Item();
        item.setImageUrl("https://i.pinimg.com/originals/f2/99/69/f299690d8b53f5e038eb3d18ffdf3e7d.jpg");
        item.setPriceOfSingleCarton(185.44);
        item.setNumberOfUnitsInCarton(25);
        item.setItemName("Testing item - Penguin Ear");
        return item;
    }

    private List<TotalPriceCalc> getItemListForCalculation() {
        Item item = new Item();
        item.setImageUrl("https://i.pinimg.com/originals/f2/99/69/f299690d8b53f5e038eb3d18ffdf3e7d.jpg");
        item.setPriceOfSingleCarton(175.00);
        item.setNumberOfUnitsInCarton(20);
        item.setItemName("Test Penguin Ear");

        Item itemTwo = new Item();
        itemTwo.setImageUrl("https://i.pinimg.com/originals/f2/99/69/f299690d8b53f5e038eb3d18ffdf3e7d.jpg");
        itemTwo.setPriceOfSingleCarton(825.00);
        itemTwo.setNumberOfUnitsInCarton(5);
        itemTwo.setItemName("Test Horse Shoe");

        TotalPriceCalc priceOne = new TotalPriceCalc();
        priceOne.setItem(item);
        priceOne.setPurchasedAmount(370);

        TotalPriceCalc priceTwo = new TotalPriceCalc();
        priceTwo.setItem(itemTwo);
        priceTwo.setPurchasedAmount(67);

        List<TotalPriceCalc> priceList = new ArrayList<TotalPriceCalc>();
        priceList.add(priceOne);
        priceList.add(priceTwo);

        return priceList;
    }

}
