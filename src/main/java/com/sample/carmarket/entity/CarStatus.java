package com.sample.carmarket.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum CarStatus implements EnumClass<String> {

    IN_STOCK("A"),
    SOLD("B");

    private String id;

    CarStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CarStatus fromId(String id) {
        for (CarStatus at : CarStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}