
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mimo/_MASTER MIMO/_proyectos/play/_practica/conf/routes
// @DATE:Tue Nov 14 02:31:52 CET 2017

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

  
    // @LINE:28
    def editarReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.editarReceta",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/"})
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
  
    // @LINE:29
    def borrarReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.borrarReceta",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/"})
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
  
    // @LINE:26
    def obtenerReceta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecetaController.obtenerReceta",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/"})
        }
      """
    )
  
  }

  // @LINE:32
  class ReversePasoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def obtenerPasos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.obtenerPasos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pasos/"})
        }
      """
    )
  
    // @LINE:33
    def obtenerPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.obtenerPaso",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/"})
        }
      """
    )
  
    // @LINE:35
    def editarPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.editarPaso",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/"})
        }
      """
    )
  
    // @LINE:36
    def borrarPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.borrarPaso",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/"})
        }
      """
    )
  
    // @LINE:32
    def crearPaso: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PasoController.crearPaso",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "paso/"})
        }
      """
    )
  
  }


}
