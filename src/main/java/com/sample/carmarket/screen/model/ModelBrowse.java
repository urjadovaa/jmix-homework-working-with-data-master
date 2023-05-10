package com.sample.carmarket.screen.model;

import io.jmix.ui.screen.*;
import com.sample.carmarket.entity.Model;

@UiController("Model.browse")
@UiDescriptor("model-browse.xml")
@LookupComponent("table")
public class ModelBrowse extends MasterDetailScreen<Model> {
}