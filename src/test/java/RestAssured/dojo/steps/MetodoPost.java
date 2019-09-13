package RestAssured.dojo.steps;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.PendingException;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MetodoPost {
                                                     
	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";
	Response response;
	String uriBase;
	int id_contatos = 0;

	@Dado("^que eu tenha os dados dos meus contatos$")
	public void que_eu_possua_minha_lista_de_contatos() throws Throwable {

		uriBase = BASE_URL_CONTATOS;

	}

	@Quando("^eu realizar uma nova inclusao$")
	public void eu_realizar_uma_nova_inclusao(String json) throws Throwable {
		response = given().contentType("application/json")
				.accept("application/vnd.tasksmanager.v2")
				.body(json)
				.when()
				.post(uriBase);
	}

	@Entao("^terei minha lista atualizada com sucesso$")
	public void terei_minha_lista_atualizada_com_sucesso() throws Throwable {
		response.then().log().body()
		.statusCode(201)
		.contentType(ContentType.JSON);
	}
}
