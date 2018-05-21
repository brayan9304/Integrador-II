(function() {
    'use strict';

    angular
        .module('integradorIiApp')
        .controller('SessionPiDetailController', SessionPiDetailController);

    SessionPiDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Session', 'Course', 'Material'];

    function SessionPiDetailController($scope, $rootScope, $stateParams, previousState, entity, Session, Course, Material) {
        var vm = this;

        vm.session = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('integradorIiApp:sessionUpdate', function(event, result) {
            vm.session = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
