hrApp.controller('EmployeeAddController', ['$scope', '$http', '$location', 'CommonResourcesFactoryBackup', 'JobsService', 'DepartmentService', 'EmployeeService',
    function($scope, $http, $location, $commonResourcesFactoryBackup, $jobsService, $departmentService, $managerService) {
        $scope.employee = {};
        $scope.requiredErrorMessage = "Please fill out this form!";
        $scope.patternDateNotRespectedMessage = "The date format should be yyyy-mm-dd";
        $scope.patternCommisionNotRespectedMessage = "Commission should be in the format 0.XX";

        //TODO #HR1
        $scope.jobs=[];
        $jobsService.findAll().then (function(data){
            $scope.jobs=data.data
        })   ;
        $scope.department=[];
        $departmentService.findAll().then (function(response){
            $scope.departments=response.data
        })   ;
        $scope.manager=[];
        $managerService.findAll().then (function(response){
            $scope.managers=response.data
        })   ;
        /**
         * Reset form
         */
        $scope.reset = function () {
            this.employee = {};
        };

        /**
         * Persist an employee
         * @param addEmployee - employee to be persisted
         */
        $scope.create = function (addEmployee) {
            $http({url: $commonResourcesFactoryBackup.addEmployeeUrl, method: 'POST', data: addEmployee})
                .success(function (data) {
                    $scope.employee = data;
                    $location.url('/employeeView/' + $scope.employee.employeeId);
                });
        };

        $scope.datePattern = /^\d{4}-\d{2}-\d{2}$/;
        $scope.commissionPattern = /^[0]\.\d{1}(\d)?$/;
}]);