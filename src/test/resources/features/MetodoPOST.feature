# language: pt
@GET
Funcionalidade: Usuario deseja realizar uma inclusao de um contato

  Cenario: Incluir um novo contato
    Dado que eu tenha os dados dos meus contatos
    Quando eu realizar uma nova inclusao
      """
      {
	      "address": "Kub Street",
	      "phone": "1-648-635-4812",
	      "city": "Missourishire",
	      "name": "Clara",
	      "state": "Florida",
	      "email": "cassi123@hotmail.com",
	      "age": "4",
	      "last-name": "Kreiger"
      }
      """
    Entao terei minha lista atualizada com sucesso
