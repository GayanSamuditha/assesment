package com.demo.api.models;

import javax.persistence.*;

/**
 * @author Gayan Samuditha
 */

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "carton_units")
    private Integer numberOfUnitsInCarton;

    @Column(name = "carton_price")
    private Double priceOfSingleCarton;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "increased_percentage")
    private Double increasedPercentage;

    @Column(name = "discount_percentage")
    private Double discountPercentage;

    @Column(name = "discount_range")
    private Integer cartonDiscount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getNumberOfUnitsInCarton() {
        return numberOfUnitsInCarton;
    }

    public void setNumberOfUnitsInCarton(Integer numberOfUnitsInCarton) {
        this.numberOfUnitsInCarton = numberOfUnitsInCarton;
    }

    public Double getPriceOfSingleCarton() {
        return priceOfSingleCarton;
    }

    public Double calculateSingleUnitPrice() {
        return (this.priceOfSingleCarton / this.numberOfUnitsInCarton) +
                (this.priceOfSingleCarton / this.numberOfUnitsInCarton * this.increasedPercentage);
    }

    public void setPriceOfSingleCarton(Double priceOfSingleCarton) {

        this.priceOfSingleCarton = priceOfSingleCarton;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public Double getIncreasedPercentage() {

        return increasedPercentage;
    }

    public void setIncreasedPercentage(Double increasedPercentage) {

        this.increasedPercentage = increasedPercentage;
    }

    public Double getDiscountPercentage() {

        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {

        this.discountPercentage = discountPercentage;
    }

    public Integer getCartonDiscount() {

        return cartonDiscount;
    }

    public void setCartonDiscount(Integer cartonDiscount) {

        this.cartonDiscount = cartonDiscount;
    }


}
