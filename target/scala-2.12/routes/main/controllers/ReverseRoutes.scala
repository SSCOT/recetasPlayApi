
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mimo/_MASTER MIMO/_proyectos/play/_practica/conf/routes
// @DATE:Mon Nov 13 02:18:59 CET 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:13
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:18
  class ReverseCocineroController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def obtenerCocinero(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cocinero/")
    }
  
    // @LINE:21
    def editarCocinero(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "cocinero/")
    }
  
    // @LINE:20
    def obtenerCocineros(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cocineros/")
    }
  
    // @LINE:22
    def borrarCocinero(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "cocinero/")
    }
  
    // @LINE:18
    def crearCocinero(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "cocinero/")
    }
  
  }

  // @LINE:8
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:25
  class ReverseRecetaController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def editarReceta(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "receta/")
    }
  
    // @LINE:27
    def obtenerRecetas(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/")
    }
  
    // @LINE:29
    def borrarReceta(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/")
    }
  
    // @LINE:25
    def crearReceta(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "receta/")
    }
  
    // @LINE:26
    def obtenerReceta(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receta/")
    }
  
  }

  // @LINE:32
  class ReversePasoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def obtenerPasos(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pasos/")
    }
  
    // @LINE:33
    def obtenerPaso(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "paso/")
    }
  
    // @LINE:35
    def editarPaso(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "paso/")
    }
  
    // @LINE:36
    def borrarPaso(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "paso/")
    }
  
    // @LINE:32
    def crearPaso(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "paso/")
    }
  
  }


}
