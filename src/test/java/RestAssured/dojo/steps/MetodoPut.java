package RestAssured.dojo.steps;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import cucumber.api.PendingException;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class MetodoPut {

	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";
	Response response;
	String uriBase;
	int id_contatos = 0;

	@Dado("^que eu tenha o id (\\d+) do contato x$")
	public void que_eu_tenha_o_id_do_contato(int arg1) throws Throwable {
		uriBase = BASE_URL_CONTATOS;
		id_contatos = arg1;
	}

	@Quando("^eu atualizar os dados$")
	public void eu_atualizar_os_dados(String json) throws Throwable {
		response = given().contentType("application/json")
				.accept("application/vnd.tasksmanager.v2")
				.body(json)
				.when()
				.put(uriBase + id_contatos);
	}

	@Entao("^terei todos os dados do contato atualizado com sucesso$")
	public void terei_todos_os_dados_do_contato_atualizado_com_sucesso() throws Throwable {
		response.then().statusCode(200).contentType(ContentType.JSON);
	}


}
