(function() {
    'use strict';

    angular
        .module('integradorIiApp')
        .controller('ProfessorPiController', ProfessorPiController);

    ProfessorPiController.$inject = ['Professor'];

    function ProfessorPiController(Professor) {

        var vm = this;

        vm.professors = [];

        loadAll();

        function loadAll() {
            Professor.query(function(result) {
                vm.professors = result;
                vm.searchQuery = null;
            });
        }
    }
})();
