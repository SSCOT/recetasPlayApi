
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/conf/routes
// @DATE:Thu Jan 04 16:28:51 CET 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_2: controllers.HomeController,
  // @LINE:8
  CountController_1: controllers.CountController,
  // @LINE:10
  AsyncController_4: controllers.AsyncController,
  // @LINE:13
  Assets_8: controllers.Assets,
  // @LINE:18
  CocineroController_5: controllers.CocineroController,
  // @LINE:25
  RecetaController_0: controllers.RecetaController,
  // @LINE:34
  PasoController_3: controllers.PasoController,
  // @LINE:41
  IngredienteController_7: controllers.IngredienteController,
  // @LINE:50
  TagController_6: controllers.TagController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_2: controllers.HomeController,
    // @LINE:8
    CountController_1: controllers.CountController,
    // @LINE:10
    AsyncController_4: controllers.AsyncController,
    // @LINE:13
    Assets_8: controllers.Assets,
    // @LINE:18
    CocineroController_5: controllers.CocineroController,
    // @LINE:25
    RecetaController_0: controllers.RecetaController,
    // @LINE:34
    PasoController_3: controllers.PasoController,
    // @LINE:41
    IngredienteController_7: controllers.IngredienteController,
    // @LINE:50
    TagController_6: controllers.TagController
  ) = this(errorHandler, HomeController_2, CountController_1, AsyncController_4, Assets_8, CocineroController_5, RecetaController_0, PasoController_3, IngredienteController_7, TagController_6, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, CountController_1, AsyncController_4, Assets_8, CocineroController_5, RecetaController_0, PasoController_3, IngredienteController_7, TagController_6, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cocinero/""", """controllers.CocineroController.crearCocinero()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cocinero/""" + "$" + """id<[^/]+>""", """controllers.CocineroController.obtenerCocinero(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cocineros/""" + "$" + """page<[^/]+>""", """controllers.CocineroController.obtenerCocineros(page:Integer)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cocinero/""" + "$" + """id<[^/]+>""", """controllers.CocineroController.editarCocinero(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cocinero/""" + "$" + """id<[^/]+>""", """controllers.CocineroController.borrarCocinero(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""", """controllers.RecetaController.crearReceta()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """id<[^/]+>""", """controllers.RecetaController.obtenerReceta(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/""" + "$" + """page<[^/]+>""", """controllers.RecetaController.obtenerRecetas(page:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas/""" + "$" + """page<[^/]+>/cocinero/""" + "$" + """idCocinero<[^/]+>""", """controllers.RecetaController.obtenerRecetasCocinero(idCocinero:Long, page:Integer)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """id<[^/]+>""", """controllers.RecetaController.editarReceta(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """id<[^/]+>""", """controllers.RecetaController.borrarReceta(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paso/""", """controllers.PasoController.crearPaso()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paso/""" + "$" + """id<[^/]+>""", """controllers.PasoController.obtenerPaso(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """pasos/""" + "$" + """idReceta<[^/]+>/page/""" + "$" + """page<[^/]+>""", """controllers.PasoController.obtenerPasos(idReceta:Long, page:Integer)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paso/""" + "$" + """id<[^/]+>""", """controllers.PasoController.editarPaso(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paso/""" + "$" + """id<[^/]+>""", """controllers.PasoController.borrarPaso(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingrediente/""", """controllers.IngredienteController.crearIngrediente()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingredientes/""" + "$" + """page<[^/]+>""", """controllers.IngredienteController.obtenerIngredientes(page:Integer)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingrediente/""" + "$" + """id<[^/]+>""", """controllers.IngredienteController.editarIngrediente(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ingrediente/""" + "$" + """id<[^/]+>""", """controllers.IngredienteController.borrarIngrediente(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """idR<[^/]+>/ingrediente/""" + "$" + """idI<[^/]+>""", """controllers.RecetaController.anadirIngrediente(idR:Long, idI:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """idR<[^/]+>/ingrediente/""" + "$" + """idI<[^/]+>""", """controllers.RecetaController.quitarIngrediente(idR:Long, idI:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tag/""", """controllers.TagController.crearTag()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tag/""" + "$" + """id<[^/]+>""", """controllers.TagController.obtenerTag(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tags/""" + "$" + """idReceta<[^/]+>""", """controllers.TagController.obtenerTags(idReceta:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tag/""" + "$" + """id<[^/]+>""", """controllers.TagController.editarTag(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tag/""" + "$" + """id<[^/]+>""", """controllers.TagController.borrarTag(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """busqueda/""", """controllers.RecetaController.busqueda()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_1.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_4.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_8.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_CocineroController_crearCocinero4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cocinero/")))
  )
  private[this] lazy val controllers_CocineroController_crearCocinero4_invoker = createInvoker(
    CocineroController_5.crearCocinero(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CocineroController",
      "crearCocinero",
      Nil,
      "POST",
      this.prefix + """cocinero/""",
      """ Cocineros""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_CocineroController_obtenerCocinero5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cocinero/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CocineroController_obtenerCocinero5_invoker = createInvoker(
    CocineroController_5.obtenerCocinero(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CocineroController",
      "obtenerCocinero",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """cocinero/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_CocineroController_obtenerCocineros6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cocineros/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CocineroController_obtenerCocineros6_invoker = createInvoker(
    CocineroController_5.obtenerCocineros(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CocineroController",
      "obtenerCocineros",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """cocineros/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_CocineroController_editarCocinero7_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cocinero/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CocineroController_editarCocinero7_invoker = createInvoker(
    CocineroController_5.editarCocinero(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CocineroController",
      "editarCocinero",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """cocinero/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_CocineroController_borrarCocinero8_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cocinero/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CocineroController_borrarCocinero8_invoker = createInvoker(
    CocineroController_5.borrarCocinero(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CocineroController",
      "borrarCocinero",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """cocinero/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_RecetaController_crearReceta9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/")))
  )
  private[this] lazy val controllers_RecetaController_crearReceta9_invoker = createInvoker(
    RecetaController_0.crearReceta(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "crearReceta",
      Nil,
      "POST",
      this.prefix + """receta/""",
      """ Recetas""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_RecetaController_obtenerReceta10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetaController_obtenerReceta10_invoker = createInvoker(
    RecetaController_0.obtenerReceta(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "obtenerReceta",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """receta/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_RecetaController_obtenerRecetas11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetaController_obtenerRecetas11_invoker = createInvoker(
    RecetaController_0.obtenerRecetas(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "obtenerRecetas",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """recetas/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_RecetaController_obtenerRecetasCocinero12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas/"), DynamicPart("page", """[^/]+""",true), StaticPart("/cocinero/"), DynamicPart("idCocinero", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetaController_obtenerRecetasCocinero12_invoker = createInvoker(
    RecetaController_0.obtenerRecetasCocinero(fakeValue[Long], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "obtenerRecetasCocinero",
      Seq(classOf[Long], classOf[Integer]),
      "GET",
      this.prefix + """recetas/""" + "$" + """page<[^/]+>/cocinero/""" + "$" + """idCocinero<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_RecetaController_editarReceta13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetaController_editarReceta13_invoker = createInvoker(
    RecetaController_0.editarReceta(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "editarReceta",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """receta/""" + "$" + """id<[^/]+>""",
      """GET     /receta/:id/ingredientes        controllers.RecetaController.obtenerIngredientes(id: Long)""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_RecetaController_borrarReceta14_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetaController_borrarReceta14_invoker = createInvoker(
    RecetaController_0.borrarReceta(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "borrarReceta",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """receta/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_PasoController_crearPaso15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paso/")))
  )
  private[this] lazy val controllers_PasoController_crearPaso15_invoker = createInvoker(
    PasoController_3.crearPaso(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PasoController",
      "crearPaso",
      Nil,
      "POST",
      this.prefix + """paso/""",
      """ Pasos""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_PasoController_obtenerPaso16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paso/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PasoController_obtenerPaso16_invoker = createInvoker(
    PasoController_3.obtenerPaso(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PasoController",
      "obtenerPaso",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """paso/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_PasoController_obtenerPasos17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("pasos/"), DynamicPart("idReceta", """[^/]+""",true), StaticPart("/page/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PasoController_obtenerPasos17_invoker = createInvoker(
    PasoController_3.obtenerPasos(fakeValue[Long], fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PasoController",
      "obtenerPasos",
      Seq(classOf[Long], classOf[Integer]),
      "GET",
      this.prefix + """pasos/""" + "$" + """idReceta<[^/]+>/page/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_PasoController_editarPaso18_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paso/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PasoController_editarPaso18_invoker = createInvoker(
    PasoController_3.editarPaso(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PasoController",
      "editarPaso",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """paso/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_PasoController_borrarPaso19_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paso/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PasoController_borrarPaso19_invoker = createInvoker(
    PasoController_3.borrarPaso(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PasoController",
      "borrarPaso",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """paso/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_IngredienteController_crearIngrediente20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingrediente/")))
  )
  private[this] lazy val controllers_IngredienteController_crearIngrediente20_invoker = createInvoker(
    IngredienteController_7.crearIngrediente(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredienteController",
      "crearIngrediente",
      Nil,
      "POST",
      this.prefix + """ingrediente/""",
      """ Ingredientes""",
      Seq()
    )
  )

  // @LINE:42
  private[this] lazy val controllers_IngredienteController_obtenerIngredientes21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingredientes/"), DynamicPart("page", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredienteController_obtenerIngredientes21_invoker = createInvoker(
    IngredienteController_7.obtenerIngredientes(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredienteController",
      "obtenerIngredientes",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """ingredientes/""" + "$" + """page<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_IngredienteController_editarIngrediente22_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingrediente/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredienteController_editarIngrediente22_invoker = createInvoker(
    IngredienteController_7.editarIngrediente(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredienteController",
      "editarIngrediente",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """ingrediente/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_IngredienteController_borrarIngrediente23_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ingrediente/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_IngredienteController_borrarIngrediente23_invoker = createInvoker(
    IngredienteController_7.borrarIngrediente(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IngredienteController",
      "borrarIngrediente",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """ingrediente/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_RecetaController_anadirIngrediente24_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("idR", """[^/]+""",true), StaticPart("/ingrediente/"), DynamicPart("idI", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetaController_anadirIngrediente24_invoker = createInvoker(
    RecetaController_0.anadirIngrediente(fakeValue[Long], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "anadirIngrediente",
      Seq(classOf[Long], classOf[Long]),
      "POST",
      this.prefix + """receta/""" + "$" + """idR<[^/]+>/ingrediente/""" + "$" + """idI<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_RecetaController_quitarIngrediente25_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("idR", """[^/]+""",true), StaticPart("/ingrediente/"), DynamicPart("idI", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecetaController_quitarIngrediente25_invoker = createInvoker(
    RecetaController_0.quitarIngrediente(fakeValue[Long], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "quitarIngrediente",
      Seq(classOf[Long], classOf[Long]),
      "DELETE",
      this.prefix + """receta/""" + "$" + """idR<[^/]+>/ingrediente/""" + "$" + """idI<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:50
  private[this] lazy val controllers_TagController_crearTag26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tag/")))
  )
  private[this] lazy val controllers_TagController_crearTag26_invoker = createInvoker(
    TagController_6.crearTag(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "crearTag",
      Nil,
      "POST",
      this.prefix + """tag/""",
      """ tags""",
      Seq()
    )
  )

  // @LINE:51
  private[this] lazy val controllers_TagController_obtenerTag27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tag/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_obtenerTag27_invoker = createInvoker(
    TagController_6.obtenerTag(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "obtenerTag",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """tag/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_TagController_obtenerTags28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tags/"), DynamicPart("idReceta", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_obtenerTags28_invoker = createInvoker(
    TagController_6.obtenerTags(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "obtenerTags",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """tags/""" + "$" + """idReceta<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:53
  private[this] lazy val controllers_TagController_editarTag29_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tag/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_editarTag29_invoker = createInvoker(
    TagController_6.editarTag(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "editarTag",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """tag/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:54
  private[this] lazy val controllers_TagController_borrarTag30_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tag/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TagController_borrarTag30_invoker = createInvoker(
    TagController_6.borrarTag(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TagController",
      "borrarTag",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """tag/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:57
  private[this] lazy val controllers_RecetaController_busqueda31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("busqueda/")))
  )
  private[this] lazy val controllers_RecetaController_busqueda31_invoker = createInvoker(
    RecetaController_0.busqueda(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecetaController",
      "busqueda",
      Nil,
      "GET",
      this.prefix + """busqueda/""",
      """ búsqueda""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params@_) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_1.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message2_route(params@_) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_4.message)
      }
  
    // @LINE:13
    case controllers_Assets_versioned3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_8.versioned(path, file))
      }
  
    // @LINE:18
    case controllers_CocineroController_crearCocinero4_route(params@_) =>
      call { 
        controllers_CocineroController_crearCocinero4_invoker.call(CocineroController_5.crearCocinero())
      }
  
    // @LINE:19
    case controllers_CocineroController_obtenerCocinero5_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CocineroController_obtenerCocinero5_invoker.call(CocineroController_5.obtenerCocinero(id))
      }
  
    // @LINE:20
    case controllers_CocineroController_obtenerCocineros6_route(params@_) =>
      call(params.fromPath[Integer]("page", None)) { (page) =>
        controllers_CocineroController_obtenerCocineros6_invoker.call(CocineroController_5.obtenerCocineros(page))
      }
  
    // @LINE:21
    case controllers_CocineroController_editarCocinero7_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CocineroController_editarCocinero7_invoker.call(CocineroController_5.editarCocinero(id))
      }
  
    // @LINE:22
    case controllers_CocineroController_borrarCocinero8_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_CocineroController_borrarCocinero8_invoker.call(CocineroController_5.borrarCocinero(id))
      }
  
    // @LINE:25
    case controllers_RecetaController_crearReceta9_route(params@_) =>
      call { 
        controllers_RecetaController_crearReceta9_invoker.call(RecetaController_0.crearReceta())
      }
  
    // @LINE:26
    case controllers_RecetaController_obtenerReceta10_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetaController_obtenerReceta10_invoker.call(RecetaController_0.obtenerReceta(id))
      }
  
    // @LINE:27
    case controllers_RecetaController_obtenerRecetas11_route(params@_) =>
      call(params.fromPath[Integer]("page", None)) { (page) =>
        controllers_RecetaController_obtenerRecetas11_invoker.call(RecetaController_0.obtenerRecetas(page))
      }
  
    // @LINE:28
    case controllers_RecetaController_obtenerRecetasCocinero12_route(params@_) =>
      call(params.fromPath[Long]("idCocinero", None), params.fromPath[Integer]("page", None)) { (idCocinero, page) =>
        controllers_RecetaController_obtenerRecetasCocinero12_invoker.call(RecetaController_0.obtenerRecetasCocinero(idCocinero, page))
      }
  
    // @LINE:30
    case controllers_RecetaController_editarReceta13_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetaController_editarReceta13_invoker.call(RecetaController_0.editarReceta(id))
      }
  
    // @LINE:31
    case controllers_RecetaController_borrarReceta14_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RecetaController_borrarReceta14_invoker.call(RecetaController_0.borrarReceta(id))
      }
  
    // @LINE:34
    case controllers_PasoController_crearPaso15_route(params@_) =>
      call { 
        controllers_PasoController_crearPaso15_invoker.call(PasoController_3.crearPaso())
      }
  
    // @LINE:35
    case controllers_PasoController_obtenerPaso16_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PasoController_obtenerPaso16_invoker.call(PasoController_3.obtenerPaso(id))
      }
  
    // @LINE:36
    case controllers_PasoController_obtenerPasos17_route(params@_) =>
      call(params.fromPath[Long]("idReceta", None), params.fromPath[Integer]("page", None)) { (idReceta, page) =>
        controllers_PasoController_obtenerPasos17_invoker.call(PasoController_3.obtenerPasos(idReceta, page))
      }
  
    // @LINE:37
    case controllers_PasoController_editarPaso18_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PasoController_editarPaso18_invoker.call(PasoController_3.editarPaso(id))
      }
  
    // @LINE:38
    case controllers_PasoController_borrarPaso19_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PasoController_borrarPaso19_invoker.call(PasoController_3.borrarPaso(id))
      }
  
    // @LINE:41
    case controllers_IngredienteController_crearIngrediente20_route(params@_) =>
      call { 
        controllers_IngredienteController_crearIngrediente20_invoker.call(IngredienteController_7.crearIngrediente())
      }
  
    // @LINE:42
    case controllers_IngredienteController_obtenerIngredientes21_route(params@_) =>
      call(params.fromPath[Integer]("page", None)) { (page) =>
        controllers_IngredienteController_obtenerIngredientes21_invoker.call(IngredienteController_7.obtenerIngredientes(page))
      }
  
    // @LINE:43
    case controllers_IngredienteController_editarIngrediente22_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_IngredienteController_editarIngrediente22_invoker.call(IngredienteController_7.editarIngrediente(id))
      }
  
    // @LINE:44
    case controllers_IngredienteController_borrarIngrediente23_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_IngredienteController_borrarIngrediente23_invoker.call(IngredienteController_7.borrarIngrediente(id))
      }
  
    // @LINE:46
    case controllers_RecetaController_anadirIngrediente24_route(params@_) =>
      call(params.fromPath[Long]("idR", None), params.fromPath[Long]("idI", None)) { (idR, idI) =>
        controllers_RecetaController_anadirIngrediente24_invoker.call(RecetaController_0.anadirIngrediente(idR, idI))
      }
  
    // @LINE:47
    case controllers_RecetaController_quitarIngrediente25_route(params@_) =>
      call(params.fromPath[Long]("idR", None), params.fromPath[Long]("idI", None)) { (idR, idI) =>
        controllers_RecetaController_quitarIngrediente25_invoker.call(RecetaController_0.quitarIngrediente(idR, idI))
      }
  
    // @LINE:50
    case controllers_TagController_crearTag26_route(params@_) =>
      call { 
        controllers_TagController_crearTag26_invoker.call(TagController_6.crearTag())
      }
  
    // @LINE:51
    case controllers_TagController_obtenerTag27_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_TagController_obtenerTag27_invoker.call(TagController_6.obtenerTag(id))
      }
  
    // @LINE:52
    case controllers_TagController_obtenerTags28_route(params@_) =>
      call(params.fromPath[Long]("idReceta", None)) { (idReceta) =>
        controllers_TagController_obtenerTags28_invoker.call(TagController_6.obtenerTags(idReceta))
      }
  
    // @LINE:53
    case controllers_TagController_editarTag29_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_TagController_editarTag29_invoker.call(TagController_6.editarTag(id))
      }
  
    // @LINE:54
    case controllers_TagController_borrarTag30_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_TagController_borrarTag30_invoker.call(TagController_6.borrarTag(id))
      }
  
    // @LINE:57
    case controllers_RecetaController_busqueda31_route(params@_) =>
      call { 
        controllers_RecetaController_busqueda31_invoker.call(RecetaController_0.busqueda())
      }
  }
}
