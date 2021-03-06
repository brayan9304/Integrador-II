(function() {
    'use strict';

    angular
        .module('integradorIiApp')
        .controller('MaterialPiDetailController', MaterialPiDetailController);

    MaterialPiDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'Material'];

    function MaterialPiDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, Material) {
        var vm = this;

        vm.material = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('integradorIiApp:materialUpdate', function(event, result) {
            vm.material = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
