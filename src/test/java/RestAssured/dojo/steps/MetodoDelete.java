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

public class MetodoDelete {

	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";
	Response response;
	String uriBase;
	int id_contatos = 0;

	@Dado("^que eu tenha o ID (\\d+)$")
	public void que_eu_tenha_o_ID(int arg1) throws Throwable {
		uriBase = BASE_URL_CONTATOS;
		id_contatos = arg1;
	}

	@Quando("^eu realizar uma exclusao$")
	public void eu_realizar_uma_exclusao() throws Throwable {
		response = given().contentType("application/json").accept("application/vnd.tasksmanager.v2").when()
				.delete(uriBase + id_contatos);
	}

	@Entao("^terei minha lista atualizada$")
	public void terei_minha_lista_atualizada() throws Throwable {
		response.then().statusCode(204);
	}

	@Dado("^que eu tenha um id (\\d+) de um contato excluso$")
	public void que_eu_tenha_um_id_de_um_contato_excluso(int arg1) throws Throwable {
		uriBase = BASE_URL_CONTATOS;
		id_contatos = arg1;
	}

	@Quando("^eu executar uma exclusao$")
	public void eu_executar_uma_exclusao() throws Throwable {
		response = given().contentType("application/json").accept("application/vnd.tasksmanager.v2").when()
				.delete(uriBase + id_contatos);
	}

	@Entao("^terei o statuscode e a mensagem de erro$")
	public void terei_o_statuscode_e_a_mensagem_de_erro() throws Throwable {
		response.then().statusCode(404)
        .body("error", equalTo("Not Found"));
	}

}
