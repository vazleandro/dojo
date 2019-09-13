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

public class MetodoGet {
                                                     
	private static final String BASE_URL_CONTATOS = "http://api-de-tarefas.herokuapp.com/contacts/";
	Response response;
	String uriBase;
	int id_contatos = 0;

	@Dado("^que eu possua minha lista de contatos$")
	public void que_eu_possua_minha_lista_de_contatos() throws Throwable {

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
	public void terei_todos_os_dados_dos_meus_contatos() throws Throwable {

		response.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.assertThat()
				.body(matchesJsonSchemaInClasspath("schema/json-schema-contatos.json"));

	}
	
	@Quando("^eu realizar uma consulta de um contato especifico (\\d+)$")
	public void eu_realizar_uma_consulta_de_um_contato_especifico(int arg1) throws Throwable {
	    
		response = given().contentType("application/json")
				.accept("application/vnd.tasksmanager.v2")
				.when()
				.get(uriBase+arg1);
		
	}

	@Entao("^terei todos os dados do meu contato$")
	public void terei_todos_os_dados_do_meu_contato() throws Throwable {

		response.then().log().body()
		.statusCode(200)
		.contentType(ContentType.JSON);
		//.assertThat()
				//.body(matchesJsonSchemaInClasspath("schema/json-schema-contatos-especifico.json"))
				//.body("data.attributes.name", equalTo("Maico"))
				//.body("data.attributes.email", equalTo("maicomizuhara4@gmail.com"));

	}

}
