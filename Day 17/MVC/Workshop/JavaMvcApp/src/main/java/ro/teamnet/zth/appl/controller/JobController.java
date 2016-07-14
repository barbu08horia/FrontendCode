package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Lion King on 15-Jul-16.
 */

    @MyController(urlPath = "/jobs")
    public class JobController{

        @MyRequestMethod(urlPath = "/all")
        public String getAllJobs(){
            return "allJobs";
        }
        @MyRequestMethod(urlPath = "/one")
        public String getOneJob(){
            return "oneRandomJob";
        }
    }
