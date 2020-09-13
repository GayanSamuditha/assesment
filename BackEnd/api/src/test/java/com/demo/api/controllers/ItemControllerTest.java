package com.demo.api.controllers;

import com.demo.api.models.Item;
import com.demo.api.services.ItemServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Gayan Samuditha
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @MockBean
    private ItemServiceImpl itemService;

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void createItem() throws Exception{
        Item mockItem = new Item();
        mockItem.setItemName("Penguin Ears");
        mockItem.setNumberOfUnitsInCarton(20);
        mockItem.setPriceOfSingleCarton(188.00);
        mockItem.setImageUrl("https://i.pinimg.com/originals/f2/99/69/f299690d8b53f5e038eb3d18ffdf3e7d.jpg");
        String inputJson = this.mapToJson(mockItem);
        String uri = "/items/";
        Mockito.when(itemService.creteOrUpdateItem(Mockito.any(Item.class))).thenReturn(mockItem);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).content(inputJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMVC.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString();
        assertThat(outputJson).isEqualTo(inputJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getItemById() throws Exception {
        Integer id = 1;
        Item mockItem = new Item();
        mockItem.setId(Long.parseLong(id.toString()));
        mockItem.setItemName("Penguin Ears");
        mockItem.setNumberOfUnitsInCarton(20);
        mockItem.setPriceOfSingleCarton(188.45);
        mockItem.setImageUrl("https://i.pinimg.com/originals/f2/99/69/f299690d8b53f5e038eb3d18ffdf3e7d.jpg");
        String inputJson = this.mapToJson(mockItem);

        String uri = "/items/1";
        Mockito.when(itemService.getItemById(Mockito.anyLong())).thenReturn(mockItem);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMVC.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(mockItem);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void getAllItem() throws Exception {
        Integer id = 1;
        Item mockItem = new Item();
        mockItem.setId(Long.parseLong(id.toString()));
        mockItem.setItemName("Penguin Ears");
        mockItem.setNumberOfUnitsInCarton(20);
        mockItem.setPriceOfSingleCarton(175.00);
        mockItem.setImageUrl("https://i.pinimg.com/originals/f2/99/69/f299690d8b53f5e038eb3d18ffdf3e7d.jpg");

        Integer idTwo = 2;
        Item mockItemTwo = new Item();
        mockItemTwo.setId(Long.parseLong(idTwo.toString()));
        mockItemTwo.setItemName("Horse Shoe");
        mockItemTwo.setNumberOfUnitsInCarton(5);
        mockItemTwo.setPriceOfSingleCarton(825.00);
        mockItemTwo.setImageUrl("https://i.pinimg.com/originals/f2/99/69/f299690d8b53f5e038eb3d18ffdf3e7d.jpg");

        List<Item> itemList = new ArrayList<Item>();
        itemList.add(mockItem);
        itemList.add(mockItemTwo);

        Mockito.when(itemService.getAllItems()).thenReturn(itemList);
        String uri = "/items";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMVC.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(itemList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);


    }



}
