package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Lion King on 15-Jul-16.
 */
@MyController(urlPath = "/locations")
public class LocationController {

    @MyRequestMethod(urlPath = "/all")
    public String getAllLocations(){
        return "allLocations";
    }
    @MyRequestMethod(urlPath = "/one")
    public String getOneLocation(){
        return "oneRandomDepartment";
    }
}