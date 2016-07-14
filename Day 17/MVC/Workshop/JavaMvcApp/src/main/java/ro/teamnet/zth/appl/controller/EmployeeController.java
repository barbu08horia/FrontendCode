package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;


/**
 * Created by Lion King on 14-Jul-16.
 */
@MyController(urlPath = "/employees")
public class EmployeeController{

    @MyRequestMethod(urlPath = "/all")
    public String getAllEmployees(){
        return "allEmployees";
    }
    @MyRequestMethod(urlPath = "/one")
    public String getOneEmployee(){
        return "oneRandomEmployee";
    }
}
