package com.vaasu.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "number_of_unit_in_carton")
    private Long numberOfUnitInCarton;

    @Column(name = "carton_price")
    private Double cartonPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getNumberOfUnitInCarton() {
        return numberOfUnitInCarton;
    }

    public void setNumberOfUnitInCarton(Long numberOfUnitInCarton) {
        this.numberOfUnitInCarton = numberOfUnitInCarton;
    }

    public Double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(Double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", numberOfUnitInCarton=" + numberOfUnitInCarton +
                ", cartonPrice=" + cartonPrice +
                '}';
    }
}
