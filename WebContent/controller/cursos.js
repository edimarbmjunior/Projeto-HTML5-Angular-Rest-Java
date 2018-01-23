var cursoModulo = angular.module('cursoModulo',[]);

cursoModulo.controller("cursoController", function($scope, $http) {

	/*$scope.cursos = [
	    {codigo:1, nome:'Neri Neitzke',email:'videoaulaneri@gmail.com',fone:'54 3329 5400'},
		{codigo:2, nome:'Lisiane Neitzke',email:'lisiane@informaticon.com',fone:'54 3329 1111'},
		{codigo:3, nome:'Gustavo Neitzke',email:'gustavo@gmail.com',fone:'54 3329 6789'},
		{codigo:4, nome:'Giulia Neitzke',email:'Giulia@gmail.com',fone:'54 6666 6789'}
	];

	$scope.cursos = [
	    {codigo:1, nome:'Java para Web',diashorarios:'Segundas e quartas, 19 hrs', professor:{codigo:1, nome:'Neri Neitzke',email:'videoaulaneri@gmail.com',fone:'54 3329 5400'}},
		{codigo:2, nome:'Delphi',diashorarios:'Terças e Quintas, 20 hrs',professor:{codigo:2, nome:'Lisiane Neitzke',email:'lisiane@informaticon.com',fone:'54 3329 1111'}},
		{codigo:3, nome:'PHP',diashorarios:'Sábados, 9 hrs',professor:{codigo:3, nome:'Gustavo Neitzke',email:'gustavo@gmail.com',fone:'54 3329 6789'}},
		{codigo:4, nome:'Arduino',diashorarios:'Sextas, 7 hrs',professor:{codigo:4, nome:'Giulia Neitzke',email:'Giulia@gmail.com',fone:'54 6666 6789'}}
	];*/
	
	urlCurso = 'http://localhost:8080/Projeto4Final/rest/cursos';
	urlProfessor = 'http://localhost:8080/Projeto4Final/rest/professores';

	$scope.listarCursos = function() {
			$http.get(urlCurso).success(function(cursos) {
			$scope.cursos = cursos;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.listarProfessores = function() {
		$http.get(urlProfessor).success(function(professores) {
			$scope.professores = professores;
		}).error(function(erro) {
			alert(erro);
		});
	}

	$scope.limparCampos = function() {
		$scope.curso = "";
	}

	$scope.salvar = function() {
		if(typeof $scope.curso.codigo == 'undefined'){
			$http.post(urlCurso, $scope.curso).success(function(curso) {
				//$scope.cursos.push($scope.curso);
				$scope.limparCampos();
				$scope.listarCursos();
			}).error(function(erro) {
				alert(erro);
			});
		}else{
			$http.put(urlCurso, $scope.curso).success(function(curso) {
				$scope.listarCursos();
				$scope.limparCampos();
			}).error(function(erro) {
				alert(erro);
			});
		}
	}
	
	$scope.selecionaCurso = function(cursoSelecionado) {
		$scope.curso = cursoSelecionado;
	}
	
	$scope.excluir = function() {
		if(typeof $scope.curso.codigo != 'undefined'){
			$http.delete(urlCurso+'/'+$scope.curso.codigo).success(function(curso) {
				$scope.listarCursos();
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
	$scope.listarCursos();
	$scope.listarProfessores();
});





