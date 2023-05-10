package com.sample.carmarket.screen.car;

import io.jmix.ui.screen.*;
import com.sample.carmarket.entity.Car;

@UiController("Car.edit")
@UiDescriptor("car-edit.xml")
@EditedEntityContainer("carDc")
public class CarEdit extends StandardEditor<Car> {
}