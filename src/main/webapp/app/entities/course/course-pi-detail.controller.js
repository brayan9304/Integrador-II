(function() {
    'use strict';

    angular
        .module('integradorIiApp')
        .controller('CoursePiDetailController', CoursePiDetailController);

    CoursePiDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Course', 'Session', 'Professor'];

    function CoursePiDetailController($scope, $rootScope, $stateParams, previousState, entity, Course, Session, Professor) {
        var vm = this;

        vm.course = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('integradorIiApp:courseUpdate', function(event, result) {
            vm.course = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
