/**
 * Created by Lion King on 29-Jun-16.
 */
hrApp.service('JobsService', ['$http', 'CommonResourcesFactoryBackup', function ($http, CommonResourcesFactoryBackup) {
    return {

        findAll: function () {
            return $http.get(CommonResourcesFactoryBackup.findAllJobsUrl)
                .success(function (data) {
                    return data;
                })

        }
    }
}
]);