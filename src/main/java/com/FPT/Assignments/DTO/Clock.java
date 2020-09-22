
package com.FPT.Assignments.DTO;


public class Clock{
    String id, manufacturer;
    Double price ;
    Integer gurantee;

    public Clock(String id, String manufact, Double price, Integer gurantee) {
        this.id = id;
        this.manufacturer = manufact;
        this.price = price;
        this.gurantee = gurantee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufact) {
        this.manufacturer = manufact;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getGurantee() {
        return gurantee;
    }

    public void setGurantee(Integer gurantee) {
        this.gurantee = gurantee;
    }

    
}