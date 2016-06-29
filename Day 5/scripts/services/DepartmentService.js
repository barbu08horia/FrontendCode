/**
 * Created by Lion King on 29-Jun-16.
 */
hrApp.service('DepartmentService', ['$http', 'CommonResourcesFactoryBackup', function ($http, CommonResourcesFactoryBackup) {
    return {

        findAll: function () {
            return $http.get(CommonResourcesFactoryBackup.findAllDepartmentsUrl)
                .success(function (data) {
                    return data;
                })

        }
    }
}
]);