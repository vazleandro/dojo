# language: pt
@GET
Funcionalidade: Usuario deseja atualizar o email de um contato

  Cenario: Atualizar todos os dados de um contato
    Dado que eu tenha o id 926 do contato x
    Quando eu atualizar os dados
     """
      {
	      "address": "Kub Streetaaaaa",
	      "phone": "1-648-635-2222",
	      "city": "Missourishireaaaa",
	      "name": "Claraaaaa",
	      "state": "Floridaaaaaa",
	      "email": "atualizae-mailaaaa@hotmail.com",
	      "age": "12",
	      "last-name": "Kreigeraaaaa"
      }
      """
    Entao terei todos os dados do contato atualizado com sucesso
