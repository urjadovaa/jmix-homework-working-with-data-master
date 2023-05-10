package com.sample.carmarket.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "MODEL", indexes = {
        @Index(name = "IDX_MODEL_MANUFACTURER", columnList = "MANUFACTURER_ID")
})
@Entity
public class Model {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @JoinColumn(name = "MANUFACTURER_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Manufacturer manufacturer;

    @Column(name = "ENGINE_TYPE", nullable = false)
    @NotNull
    private String engineType;

    public EngineType getEngineType() {
        return engineType == null ? null : EngineType.fromId(engineType);
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType == null ? null : engineType.getId();
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}