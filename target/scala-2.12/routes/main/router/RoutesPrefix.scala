
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/conf/routes
// @DATE:Sun Dec 31 03:20:16 CET 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
