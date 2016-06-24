/**
 * Created by Lion King on 24-Jun-16.
 */
angular.module('hrApp').controller('ScopesController', ['$rootScope','$scope',function($rootScope, $scope) {

$scope.title = 'Two Way Binding Demo';
$scope.childtemplate = 'templates/childscope.html';
$scope.resetFirstVariable = function(){
    $scope.firstVariable = undefined;
};
    $scope.setfirstVariable = function(val){
    $scope.setFirstVariable = val;
    }}]);