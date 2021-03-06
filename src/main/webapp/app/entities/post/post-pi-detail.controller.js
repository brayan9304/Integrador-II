(function() {
    'use strict';

    angular
        .module('integradorIiApp')
        .controller('PostPiDetailController', PostPiDetailController);

    PostPiDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'Post', 'Professor', 'Comment'];

    function PostPiDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, Post, Professor, Comment) {
        var vm = this;

        vm.post = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('integradorIiApp:postUpdate', function(event, result) {
            vm.post = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
