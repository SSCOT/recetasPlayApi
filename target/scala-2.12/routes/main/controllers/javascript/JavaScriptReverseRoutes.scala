
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/conf/routes
// @DATE:Tue Dec 26 23:36:57 CET 2017

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
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cocineros/"})
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

  // @LINE:44
  class ReverseIngredienteController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def obtenerIngredientes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredienteController.obtenerIngredientes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredientes/"})
        }
      """
    )
  
    // @LINE:47
    def borrarIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredienteController.borrarIngrediente",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:46
    def editarIngrediente: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredienteController.editarIngrediente",
      """
        function(id0,nombre1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ingrediente/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nombre", nombre1))})
        }
      """
    )
  
    // @LINE:45
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

  
    // @LINE:49
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
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/"})
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
  
    // @LINE:50
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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idCocinero", idCocinero0))})
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

  // @LINE:37
  class ReversePasoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def obtenerPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.obtenerPaso",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:40
    def editarPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.editarPaso",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:37
    def crearPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.crearPaso",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/"})
        }
      """
    )
  
    // @LINE:39
    def obtenerPasos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.obtenerPasos",
      """
        function(idReceta0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pasos/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("idReceta", idReceta0))})
        }
      """
    )
  
    // @LINE:41
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
