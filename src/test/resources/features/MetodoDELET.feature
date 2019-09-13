# language: pt
@GET
Funcionalidade: Usuario deseja realizar a exclusao de um contato

  Cenario: Excluir um contato
    Dado que eu tenha o ID 1186
    Quando eu realizar uma exclusao
    Entao terei minha lista atualizada

  Cenario: Consultar StatusCode de um contato inexistente
    Dado que eu tenha um id 1186 de um contato excluso 
    Quando eu executar uma exclusao
    Entao terei o statuscode e a mensagem de erro