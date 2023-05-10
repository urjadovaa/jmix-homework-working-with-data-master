package com.sample.carmarket.app;

import com.sample.carmarket.entity.CarStatistics;
import com.sample.carmarket.entity.EngineType;
import com.sample.carmarket.entity.Manufacturer;
import io.jmix.core.DataManager;
import io.jmix.core.entity.KeyValueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarService {

    @Autowired
    private DataManager dataManager;

    // подсчитать в БД количество автомобилей выбранного в таблице производителя,
    // с разбиением по признаку Model#engineType.
    // Нужно подсчитать раздельно количество бензиновых и электрических автомобилей
    public CarStatistics calculateCars(Manufacturer manufacturer) {
        CarStatistics carStatistics = dataManager.create(CarStatistics.class);

        String queryString = "select COUNT(c) from Car c where " +
                "c.model.manufacturer = :manufacturer and " +
                "c.model.engineType = :engineType";

        List<KeyValueEntity> keyValueEntities;

        keyValueEntities = dataManager.loadValues(queryString)
                .parameter("manufacturer", manufacturer)
                .parameter("engineType", EngineType.ELECTRIC)
                .properties("electricCount")
                .list();
        carStatistics.setElectricCarCount(keyValueEntities.get(0).getValue("electricCount"));

        keyValueEntities = dataManager.loadValues(queryString)
                .parameter("manufacturer", manufacturer)
                .parameter("engineType", EngineType.GASOLINE)
                .properties("gasolineCount")
                .list();
        carStatistics.setGasolineCarCount(keyValueEntities.get(0).getValue("gasolineCount"));

        return carStatistics;
    }

}