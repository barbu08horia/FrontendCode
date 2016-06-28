/**
 * Created by Lion King on 28-Jun-16.
 */
hrApp.controller('ColorsController', function ($scope) {

    $scope.colors = [
        {
            "text": "muted",
            "class": "text-muted",
            "type": "strong"
        },
        {
            "text": "primary",
            "class": "text-primary",
            "type": "strong"
        },
        {
            "text": "success",
            "class": "text-success",
            "type": "strong"
        },
        {
            "text": "info",
            "class": "text-info",
            "type": "boring"
        },
        {
            "text": "warning",
            "class": "text-warning",
            "type": "boring"
        },
        {
            "text": "danger",
            "class": "text-danger",
            "type": "boring"
        }
    ];
    $scope.thing=undefined;
    $scope.changeColor=function(){
        $scope.thing=$scope.selected.class;
    }
   
        
    
});

