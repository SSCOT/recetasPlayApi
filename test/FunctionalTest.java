import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A functional test starts a Play application for every test.
 * <p>
 * https://www.playframework.com/documentation/latest/JavaFunctionalTest
 */
public class FunctionalTest extends WithApplication {

    private static Cocinero cocinero;
    private Apikey key;
    private static Receta receta;
    private static Ingrediente ingrediente;
    private static Tag tag;
    private static Paso paso;

    @Before
    public void preparacionDatos() {
        cocinero = new Cocinero();
        cocinero.setNombre("tNombre");
        cocinero.setApellido("tApellido");
        cocinero.setTipo("cocinero");
        cocinero.setRestaurante("tRestaurante");
        key = new Apikey();
        key.setKey("aaa");
        key.setCocinero(cocinero);
        key.save();
        cocinero.setKey(key);
        cocinero.save();

        receta = new Receta();
        receta.setTitulo("tTitulo");
        receta.setTipo("privada");
        receta.setR_cocinero(cocinero);
        receta.save();

        ingrediente = new Ingrediente();
        ingrediente.setNombre("tIngrediente");
        ingrediente.save();

        tag = new Tag();
        tag.setTexto("tTag");
        tag.setT_receta(receta);
        tag.save();

        paso = new Paso();
        paso.setDescripcion("tDescripcion");
        paso.setTiempo(new Long(2));
        paso.setP_receta(receta);
        paso.save();
    }

    @Test
    public void renderTemplate() {
        // If you are calling out to Assets, then you must instantiate an application
        // because it makes use of assets metadata that is configured from
        // the application.

        Content html = views.html.index.render("Your new application is ready.");
        assertThat("text/html").isEqualTo(html.contentType());
        assertThat(html.body()).contains("Your new application is ready.");
    }

    // ----------------------------------
    // TEST COCINEROS
    // ----------------------------------

    @Test
    public void testCocineroGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/cocinero/" + cocinero.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testCocinerosGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/cocineros/0" + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testCocineroPost() throws Exception {
        // https://stackoverflow.com/questions/35265408/test-post-request-on-playframework-2-4-x
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"nombre\":\"postNombre\"," +
                "\"apellido\":\"postApellido\"," +
                "\"tipo\":\"cocinero\"," +
                "\"restaurante\":\"postRestaurante\"" +
                "}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("POST")
                .uri("/cocinero/" + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(201);

        if (r.status() == 201) {
            Cocinero cocineroCreado = Cocinero.findByNombre("postNombre", "postApellido");
            cocineroCreado.delete();
        }
    }

    @Test
    public void testCocineroPut() throws Exception {
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"nombre\":\"putNombre_mod\"}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("PUT")
                .uri("/cocinero/" + cocinero.id + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testCocineroDelete() {
        Cocinero cocineroBorrar = new Cocinero();
        cocineroBorrar.setNombre("cocineroBorrar");
        cocineroBorrar.setTipo("estudiante");
        cocineroBorrar.save();
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("DELETE")
                .uri("/cocinero/" + cocineroBorrar.id + "?apikey=" + cocinero.key.getKey());

        Result r1 = Helpers.route(app, req);
        assertThat(r1.status()).isEqualTo(200);

        Http.RequestBuilder reqGet = Helpers.fakeRequest()
                .method("get")
                .uri("/cocinero/" + cocineroBorrar.id);

        Result r = Helpers.route(app, reqGet);
        assertThat(r.status()).isEqualTo(404);
    }

    // ----------------------------------
    // TEST RECETAS
    // ----------------------------------
    @Test
    public void testRecetaPost() throws Exception {

        // https://stackoverflow.com/questions/35265408/test-post-request-on-playframework-2-4-x
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"titulo\":\"postTitulo\"," +
                "\"tipo\":\"publica\"}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("POST")
                .uri("/receta/" + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(201);

        if (r.status() == 201) {
            Receta recetaCreada = Receta.findByTituloAndAutor("postTitulo", cocinero);
            recetaCreada.delete();
        }
    }

    @Test
    public void testRecetaGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/receta/" + receta.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testRecetasGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/recetas/0" + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testRecetaPut() throws Exception {
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"titulo\":\"putTitulo_mod\"}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("PUT")
                .uri("/receta/" + receta.id + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testRecetaDelete() {
        Receta recetaBorrar = new Receta();
        recetaBorrar.setTitulo("recetaBorrar");
        recetaBorrar.setR_cocinero(cocinero);
        recetaBorrar.save();


        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("DELETE")
                .uri("/receta/" + recetaBorrar.id + "?apikey=" + cocinero.key.getKey());

        Result r1 = Helpers.route(app, req);
        assertThat(r1.status()).isEqualTo(200);

        Http.RequestBuilder reqGet = Helpers.fakeRequest()
                .method("get")
                .uri("/receta/" + recetaBorrar.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, reqGet);
        assertThat(r.status()).isEqualTo(404);
    }

    // ----------------------------------
    // TEST INGREDIENTES
    // ----------------------------------
    @Test
    public void testIngredientePost() throws Exception {

        // https://stackoverflow.com/questions/35265408/test-post-request-on-playframework-2-4-x
        JsonNode json = (new ObjectMapper()).readTree("{\"nombre\":\"postIngrediente\"}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("POST")
                .uri("/ingrediente/" + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(201);

        if (r.status() == 201) {
            Ingrediente ingredienteCreado = Ingrediente.findByNombre("postIngrediente");
            ingredienteCreado.delete();
        }
    }

    @Test
    public void testIngredientesGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/ingredientes/0" + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testIngredientePut() throws Exception {
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"nombre\":\"putIngrediente_mod\"}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("PUT")
                .uri("/ingrediente/" + ingrediente.id + "?apikey=" + cocinero.key.getKey() )
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testIngredienteDelete() {
        Ingrediente ingredienteBorrar = new Ingrediente();
        ingredienteBorrar.save();

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("DELETE")
                .uri("/ingrediente/" + ingredienteBorrar.id + "?apikey=" + cocinero.key.getKey());

        Result r1 = Helpers.route(app, req);
        assertThat(r1.status()).isEqualTo(200);

        Http.RequestBuilder reqGet = Helpers.fakeRequest()
                .method("get")
                .uri("/ingrediente/" + ingredienteBorrar.id);

        Result r = Helpers.route(app, reqGet);
        assertThat(r.status()).isEqualTo(404);
    }

    // ----------------------------------
    // TEST TAGS
    // ----------------------------------
    @Test
    public void testTagPost() throws Exception {

        // https://stackoverflow.com/questions/35265408/test-post-request-on-playframework-2-4-x
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"texto\":\"postTag\"," +
                "\"t_receta\":{\"id\":" + receta.id + "}" +
                "}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("POST")
                .uri("/tag/" + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(201);

    }

    @Test
    public void testTagGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/tag/" + tag.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testTagsGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/tags/" + receta.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testTagPut() throws Exception {
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"texto\":\"tTag_mod\"}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("PUT")
                .uri("/tag/" + tag.id + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testTagDelete() {
        Tag tagBorrar = new Tag();
        tagBorrar.setTexto("tagBorrar");
        tagBorrar.setT_receta(receta);
        tagBorrar.save();

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("DELETE")
                .uri("/tag/" + tagBorrar.id + "?apikey=" + cocinero.key.getKey());

        Result r1 = Helpers.route(app, req);
        assertThat(r1.status()).isEqualTo(200);

        Http.RequestBuilder reqGet = Helpers.fakeRequest()
                .method("GET")
                .uri("/tag/" + tagBorrar.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, reqGet);
        assertThat(r.status()).isEqualTo(404);
    }

    // ----------------------------------
    // TEST PASOS
    // ----------------------------------
    @Test
    public void testPasoPost() throws Exception {
        // https://stackoverflow.com/questions/35265408/test-post-request-on-playframework-2-4-x
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"descripcion\":\"postPaso\"," +
                "\"p_receta\":{\"id\":" + receta.id + "}" +
                "}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("POST")
                .uri("/paso/" + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(201);
    }

    @Test
    public void testPasoGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/paso/" + paso.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testPasosGet() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("GET")
                .uri("/pasos/" + receta.id + "/page/0" + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testPasoPut() throws Exception {
        JsonNode json = (new ObjectMapper()).readTree("{" +
                "\"descripcion\":\"tPaso_mod\"}");

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("PUT")
                .uri("/paso/" + paso.id + "?apikey=" + cocinero.key.getKey())
                .header("Content-Type", "application/json")
                .bodyJson(json);

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }

    @Test
    public void testPasoDelete() {

        Paso pasoBorrar = new Paso();
        pasoBorrar.setTiempo(new Long(1));
        pasoBorrar.setDescripcion("pasoBorrar");
        pasoBorrar.setP_receta(receta);
        pasoBorrar.setIndice(new Long(1));
        pasoBorrar.save();

        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("DELETE")
                .uri("/paso/" + pasoBorrar.id + "?apikey=" + cocinero.key.getKey());

        Result r1 = Helpers.route(app, req);
        assertThat(r1.status()).isEqualTo(200);

        Http.RequestBuilder reqGet = Helpers.fakeRequest()
                .method("GET")
                .uri("/paso/" + pasoBorrar.id + "?apikey=" + cocinero.key.getKey());

        Result r2 = Helpers.route(app, reqGet);
        assertThat(r2.status()).isEqualTo(404);
    }

    @Test
    public void testAnadirIngrediente() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("POST")
                .uri("/receta/" + receta.id + "/ingrediente/" + ingrediente.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(201);
    }

    @Test
    public void testQuitarIngrediente() {
        Http.RequestBuilder req = Helpers.fakeRequest()
                .method("DELETE")
                .uri("/receta/" + receta.id + "/ingrediente/" + ingrediente.id + "?apikey=" + cocinero.key.getKey());

        Result r = Helpers.route(app, req);
        assertThat(r.status()).isEqualTo(200);
    }


    @After
    public void borradoDatos() {
        if (receta != null)
            receta.delete();
        if (cocinero != null)
            cocinero.delete();
        if (ingrediente != null)
            ingrediente.delete();
    }
}