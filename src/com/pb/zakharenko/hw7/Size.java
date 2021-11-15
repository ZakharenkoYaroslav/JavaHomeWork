package com.pb.zakharenko.hw7;

public enum Size {
    XXS ("Дитячий розмір",32),
    XS("Підлітковий розмір",34),
    S("Дорослий розмір",36),
    M("Дорослий розмір",38),
    L("Дорослий розмір",40);

    private String description;
    private Integer euroSize;

    Size(String description, Integer euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return description;
    }

    public Integer getEuroSize() {
        return euroSize;
    }


    @Override
    public String toString() {
        return description+' '+euroSize.toString();
    }
}
