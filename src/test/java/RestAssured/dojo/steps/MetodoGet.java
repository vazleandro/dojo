package RestAssured.dojo.steps;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class MetodoGet {

	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";
	Response response;
	String uriBase;
	int id_contatos = 0;

	@Dado("^que eu possua minha lista de contados$")
	public void que_eu_possua_minha_lista_de_contados() throws Throwable {

		uriBase = BASE_URL_CONTATOS;

	}

	@Quando("^eu realizar uma consulta$")
	public void eu_realizar_uma_consulta() throws Throwable {

		response = given().contentType("application/json")
				.accept("application/vnd.tasksmanager.v2")
				.when()
				.get(uriBase);
	}

	@Entao("^terei todos os dados dos meus contatos$")
	public void terei_todos_os_dados_de_meus_contatos() throws Throwable {

		response.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.assertThat()
				.body(matchesJsonSchemaInClasspath("schema/json-schema-contatos.json"));

	}

}
