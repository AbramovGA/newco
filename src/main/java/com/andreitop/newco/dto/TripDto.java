package com.andreitop.newco.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TripDto implements IdentifiableDto {

    private static final long serialVersionUID = 5914366185889783660L;

    @NotNull
    @Min(1)
    private Long id;
    @NotNull
    private String origin;
    @NotNull
    private String destination;
    @NotNull
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
