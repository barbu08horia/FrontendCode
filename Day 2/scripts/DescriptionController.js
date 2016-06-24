/**
 * Created by Lion King on 24-Jun-16.
 */
angular.module('hrApp').controller('DescriptionController', ['$rootScope','$scope',function($rootScope, $scope) {
    $scope.title = 'Two Way Binding Demo';
    $scope.childtemplate = 'templates/childscope.html';
    $scope.resetFirstVariable = function () {
        $scope.firstVariable = undefined;
    };
    $scope.setFirstVariable = function (val) {
        $scope.firstVariable = val;
    };
    $scope.descriptionHide = false;
    $scope.descriptionShow = true;
}]);