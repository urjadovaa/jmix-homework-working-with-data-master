package com.sample.carmarket.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;

import java.util.UUID;

@JmixEntity
public class CarStatistics {
    @JmixGeneratedValue
    @JmixId
    private UUID id;

    private Long gasolineCarCount;

    private Long electricCarCount;

    public void setGasolineCarCount(Long gasolineCarCount) {
        this.gasolineCarCount = gasolineCarCount;
    }

    public Long getGasolineCarCount() {
        return gasolineCarCount;
    }

    public void setElectricCarCount(Long electricCarCount) {
        this.electricCarCount = electricCarCount;
    }

    public Long getElectricCarCount() {
        return electricCarCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}