(function() {
    'use strict';

    angular
        .module('integradorIiApp')
        .controller('MaterialPiController', MaterialPiController);

    MaterialPiController.$inject = ['DataUtils', 'Material'];

    function MaterialPiController(DataUtils, Material) {

        var vm = this;

        vm.materials = [];
        vm.openFile = DataUtils.openFile;
        vm.byteSize = DataUtils.byteSize;

        loadAll();

        function loadAll() {
            Material.query(function(result) {
                vm.materials = result;
                vm.searchQuery = null;
            });
        }
    }
})();
