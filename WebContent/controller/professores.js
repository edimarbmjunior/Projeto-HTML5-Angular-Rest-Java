var professorModulo = angular.module('professorModulo', []);

professorModulo.controller("professoresController", function($scope, $http) {

	urlProfessor = 'http://localhost:8080/Projeto4Final/rest/professores';
	$scope.listarProfessores = function() {
			$http.get(urlProfessor).success(function(professores) {
			$scope.professores = professores;
		}).error(function(erro) {
			alert(erro);
		});
	}

	$scope.limparCampos = function() { $scope.professor = ""; }

	$scope.salvar = function() {
		if(typeof $scope.professor.codigo == 'undefined'){
			$http.post(urlProfessor, $scope.professor).success(function(professor) {
				//$scope.professores.push($scope.professor);
				$scope.listarProfessores();
				$scope.limparCampos();
			}).error(function(erro) {
				alert(erro);
			});
		}else{
			$http.put(urlProfessor, $scope.professor).success(function(professor) {
				$scope.listarProfessores();
				$scope.limparCampos();
			}).error(function(erro) {
				alert(erro);
			});
		}
	}
	
	$scope.selecionaprofessor = function(professorSelecionado) {
		$scope.professor = professorSelecionado;
	}
	
	$scope.excluir = function() {
		if(typeof $scope.professor.codigo != 'undefined'){
			$http.delete(urlProfessor+'/'+$scope.professor.codigo).success(function(professor) {
				$scope.listarProfessores();
				$scope.limparCampos();
			}).error(function(erro) {
				alert(erro);
			});
		}else{
			alert("Por favor, selecionar um registro para excluir!");
			console.log("Por favor, selecionar um registro para excluir!");
		}
	}

	// executa no momento de carregar a pagina
	$scope.listarProfessores();
});
