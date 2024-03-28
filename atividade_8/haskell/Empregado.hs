newtype Empregado = Empregado String Int String Double String

inicializar :: String Int String Double String -> Empregado

atualizarNome :: Empregado -> Void
atualizarId :: Empregado -> Void
atualizarSalario :: Empregado -> Void
atualizarCargo :: Empregado -> Void
atualizarDepartamento :: Empregado -> Void

transferirEmpregado :: Empregado -> Empregado

getDepartamento :: Empregado -> Departamento

newtype Departamento = Departamento String Int String
inicializar :: String Int String -> Empregado

adicionarEmpregado :: Empregado -> Void
removerEmpregado :: Empregado -> Void
getEmpregados :: Void -> Empregado[]