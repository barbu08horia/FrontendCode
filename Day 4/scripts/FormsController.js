/**
 * Created by Lion King on 28-Jun-16.
 */

hrApp.controller('FormsController',['$scope', function ($scope) {
    $scope.fct = function () {
        if ($scope.myForm.input.$valid == true)
            alert('IS VALID!!!');
    }
}
]);