
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/conf/routes
// @DATE:Sun Dec 31 03:20:16 CET 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:13
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:50
  class ReverseTagController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:54
    def borrarTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.borrarTag",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:52
    def obtenerTags: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.obtenerTags",
      """
        function(idReceta0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tags/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idReceta", idReceta0))})
        }
      """
    )
  
    // @LINE:51
    def obtenerTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.obtenerTag",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:50
    def crearTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.crearTag",
      """
        function(texto0,idReceta1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("texto", texto0)) + "/receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idReceta", idReceta1))})
        }
      """
    )
  
    // @LINE:53
    def editarTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TagController.editarTag",
      """
        function(id0,texto1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tag/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("texto", texto1))})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseCocineroController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def obtenerCocinero: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CocineroController.obtenerCocinero",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cocinero/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:21
    def editarCocinero: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CocineroController.editarCocinero",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "cocinero/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:22
    def borrarCocinero: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CocineroController.borrarCocinero",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "cocinero/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:20
    def obtenerCocineros: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CocineroController.obtenerCocineros",
      """
        function(page0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cocineros/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("page", page0))})
        }
      """
    )
  
    // @LINE:18
    def crearCocinero: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CocineroController.crearCocinero",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cocinero/"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:41
  class ReverseIngredienteController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def borrarIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredienteController.borrarIngrediente",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:41
    def obtenerIngredientes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredienteController.obtenerIngredientes",
      """
        function(page0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredientes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("page", page0))})
        }
      """
    )
  
    // @LINE:43
    def editarIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredienteController.editarIngrediente",
      """
        function(id0,nombre1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nombre", nombre1))})
        }
      """
    )
  
    // @LINE:42
    def crearIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredienteController.crearIngrediente",
      """
        function(nombre0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nombre", nombre0))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:25
  class ReverseRecetaController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def anadirIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.anadirIngrediente",
      """
        function(idR0,idI1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idR", idR0)) + "/ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idI", idI1))})
        }
      """
    )
  
    // @LINE:27
    def obtenerRecetas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.obtenerRecetas",
      """
        function(page0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("page", page0))})
        }
      """
    )
  
    // @LINE:57
    def busqueda: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.busqueda",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "busqueda/"})
        }
      """
    )
  
    // @LINE:30
    def editarReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.editarReceta",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:26
    def obtenerReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.obtenerReceta",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:25
    def crearReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.crearReceta",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/"})
        }
      """
    )
  
    // @LINE:47
    def quitarIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.quitarIngrediente",
      """
        function(idR0,idI1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idR", idR0)) + "/ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idI", idI1))})
        }
      """
    )
  
    // @LINE:31
    def borrarReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.borrarReceta",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:28
    def obtenerRecetasCocinero: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.obtenerRecetasCocinero",
      """
        function(idCocinero0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/cocinero/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idCocinero", idCocinero0))})
        }
      """
    )
  
    // @LINE:29
    def obtenerIngredientes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.obtenerIngredientes",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0)) + "/ingredientes"})
        }
      """
    )
  
  }

  // @LINE:34
  class ReversePasoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def obtenerPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.obtenerPaso",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:37
    def editarPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.editarPaso",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:34
    def crearPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.crearPaso",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/"})
        }
      """
    )
  
    // @LINE:36
    def obtenerPasos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.obtenerPasos",
      """
        function(idReceta0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pasos/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idReceta", idReceta0))})
        }
      """
    )
  
    // @LINE:38
    def borrarPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.borrarPaso",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
