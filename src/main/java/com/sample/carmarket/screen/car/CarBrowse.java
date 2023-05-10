package com.sample.carmarket.screen.car;

import com.sample.carmarket.entity.CarStatus;
import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.screen.*;
import com.sample.carmarket.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@UiController("Car.browse")
@UiDescriptor("car-browse.xml")
@LookupComponent("carsTable")
public class CarBrowse extends StandardLookup<Car> {

    @Autowired
    private CollectionContainer<Car> carsDc;
    @Autowired
    private Notifications notifications;
    @Autowired
    private MessageBundle messageBundle;
    @Autowired
    private DataManager dataManager;

    @Subscribe("carsTable.markAsSold")
    public void onCarsTableMarkAsSold(Action.ActionPerformedEvent event) {
        Car car = carsDc.getItem();
        if (CarStatus.SOLD.equals(car.getStatus())) {
            notifications.create(Notifications.NotificationType.HUMANIZED)
                    .withDescription(messageBundle.getMessage("alreadySold"))
                    .show();
        } else if (CarStatus.IN_STOCK.equals(car.getStatus())) {
            car.setStatus(CarStatus.SOLD);
            car.setDateOfSale(new Date());
            dataManager.save(car);
            notifications.create(Notifications.NotificationType.HUMANIZED)
                    .withDescription(messageBundle.getMessage("done"))
                    .show();
        }
    }

}