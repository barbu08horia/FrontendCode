package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Lion King on 14-Jul-16.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {

    @MyRequestMethod(urlPath = "/all")
    public String getAllDepartments(){
        return "allDepartments";
    }
    @MyRequestMethod(urlPath = "/one")
    public String getOneDepartment(){
        return "oneRandomDepartment";
    }
}