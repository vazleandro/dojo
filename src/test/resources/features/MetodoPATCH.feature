# language: pt
@GET
Funcionalidade: Usuario deseja atualizar o email de um contato

  Cenario: Atualizar o email de um contato
    Dado que eu tenha o id 926 do contato
    Quando eu atualizar o e-mail
      """
      {
      "email": "atualizae-maila@hotmail.com"
      }
      """
    Entao terei o e-mail do contato atualizado com sucesso
