package com.sample.carmarket.screen.manufacturer;

import com.sample.carmarket.app.CarService;
import com.sample.carmarket.entity.CarStatistics;
import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.screen.*;
import com.sample.carmarket.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Manufacturer.browse")
@UiDescriptor("manufacturer-browse.xml")
@LookupComponent("table")
public class ManufacturerBrowse extends MasterDetailScreen<Manufacturer> {

    @Autowired
    private CarService carService;
    @Autowired
    private CollectionContainer<Manufacturer> manufacturersDc;
    @Autowired
    private Notifications notifications;
    @Autowired
    private MessageBundle messageBundle;

    @Subscribe("table.calculateCars")
    public void onTableCalculateCars(Action.ActionPerformedEvent event) {
        CarStatistics carStatistics = carService.calculateCars(manufacturersDc.getItem());
        notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption(messageBundle.getMessage("messageHeader"))
                .withDescription("Electric cars:" + carStatistics.getElectricCarCount() +
                        ", gasoline cars: " + carStatistics.getGasolineCarCount()).show();
    }


}