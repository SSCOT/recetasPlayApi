
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/conf/routes
// @DATE:Sun Jan 14 00:58:17 CET 2018

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

  // @LINE:49
  class ReverseTagController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:53
    def borrarTag(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "tag/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:51
    def obtenerTags(idReceta:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tags/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("idReceta", idReceta)))
    }
  
    // @LINE:49
    def crearTag(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tag/")
    }
  
    // @LINE:50
    def obtenerTag(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tag/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:52
    def editarTag(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tag/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
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
    def obtenerCocineros(page:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cocineros/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("page", page)))
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

  // @LINE:40
  class ReverseIngredienteController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def borrarIngrediente(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:41
    def obtenerIngredientes(page:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ingredientes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("page", page)))
    }
  
    // @LINE:42
    def editarIngrediente(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:40
    def crearIngrediente(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ingrediente/")
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

  
    // @LINE:45
    def anadirIngrediente(idR:Long, idI:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("idR", idR)) + "/ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("idI", idI)))
    }
  
    // @LINE:27
    def obtenerRecetas(page:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("page", page)))
    }
  
    // @LINE:56
    def busqueda(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "busqueda/")
    }
  
    // @LINE:29
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
  
    // @LINE:46
    def quitarIngrediente(idR:Long, idI:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("idR", idR)) + "/ingrediente/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("idI", idI)))
    }
  
    // @LINE:30
    def borrarReceta(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "receta/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:28
    def obtenerRecetasCocinero(idCocinero:Long, page:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recetas/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("page", page)) + "/cocinero/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("idCocinero", idCocinero)))
    }
  
  }

  // @LINE:33
  class ReversePasoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def obtenerPasos(idReceta:Long, page:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "pasos/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("idReceta", idReceta)) + "/page/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("page", page)))
    }
  
    // @LINE:34
    def obtenerPaso(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "paso/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:36
    def editarPaso(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "paso/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:33
    def crearPaso(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "paso/")
    }
  
    // @LINE:37
    def borrarPaso(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "paso/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }


}
