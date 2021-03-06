(function() {
    'use strict';

    angular
        .module('integradorIiApp')
        .controller('ProfessorPiDetailController', ProfessorPiDetailController);

    ProfessorPiDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Professor', 'Course', 'Post', 'Comment'];

    function ProfessorPiDetailController($scope, $rootScope, $stateParams, previousState, entity, Professor, Course, Post, Comment) {
        var vm = this;

        vm.professor = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('integradorIiApp:professorUpdate', function(event, result) {
            vm.professor = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
