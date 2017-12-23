
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/conf/routes
// @DATE:Sat Dec 23 04:59:30 CET 2017

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
    def obtenerCocinero(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cocinero/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:21
    def editarCocinero(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "cocinero/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:22
    def borrarCocinero(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "cocinero/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:20
    def obtenerCocineros(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cocineros/")
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

  // @LINE:41
  class ReverseIngredienteController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def obtenerIngredientes(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ingredientes")
    }
  
    // @LINE:45
    def borrarIngrediente(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:44
    def editarIngrediente(id:Long, nombre:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nombre", nombre)))
    }
  
    // @LINE:43
    def crearIngrediente(nombre:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("nombre", nombre)))
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

  
    // @LINE:27
    def obtenerRecetas(idCocinero:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("idCocinero", idCocinero)))
    }
  
    // @LINE:30
    def editarReceta(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:26
    def obtenerReceta(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:25
    def crearReceta(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "receta/")
    }
  
    // @LINE:31
    def borrarReceta(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:28
    def obtenerIngredientes(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)) + "/ingredientes")
    }
  
  }

  // @LINE:34
  class ReversePasoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def crearPaso(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "paso/")
    }
  
  }


}
