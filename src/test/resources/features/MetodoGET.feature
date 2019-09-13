# language: pt
@GET
Funcionalidade: Usuario deseja realizar consultas apenas de um contato

  Cenario: Realizar consulta de um contato
    Dado que eu possua minha lista de contatos
    Quando eu realizar uma consulta de um contato especifico 721
    Entao terei todos os dados do meu contato
    
 Esquema do Cenario: Realizar consulta de x contatos
    Dado que eu possua minha lista de contatos
    Quando eu realizar uma consulta de um contato especifico <id>
    Entao terei todos os dados do meu contato
    Exemplos: 
    |id|
    |721|
    |926|
    |931|
