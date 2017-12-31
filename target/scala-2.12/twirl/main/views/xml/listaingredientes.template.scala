
package views.xml

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.xml._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object listaingredientes extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Ingrediente],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ingredientes: List[Ingrediente]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.35*/("""
        """),format.raw/*2.9*/("""<?xml version="1.0" encoding="UTF-8"?>
<ingredientes>
    """),_display_(/*4.6*/for(i <- ingredientes) yield /*4.28*/ {_display_(Seq[Any](format.raw/*4.30*/("""
    """),_display_(/*5.6*/ingrediente(i)),format.raw/*5.20*/("""
    """)))}),format.raw/*6.6*/("""
"""),format.raw/*7.1*/("""</ingredientes>"""))
      }
    }
  }

  def render(ingredientes:List[Ingrediente]): play.twirl.api.XmlFormat.Appendable = apply(ingredientes)

  def f:((List[Ingrediente]) => play.twirl.api.XmlFormat.Appendable) = (ingredientes) => apply(ingredientes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Dec 29 18:15:25 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/app/views/listaingredientes.scala.xml
                  HASH: f89c69729b8b18e10de91e73a3b04c221697e9a6
                  MATRIX: 965->1|1092->34|1127->43|1211->102|1248->124|1287->126|1318->132|1352->146|1387->152|1414->153
                  LINES: 28->1|33->1|34->2|36->4|36->4|36->4|37->5|37->5|38->6|39->7
                  -- GENERATED --
              */
          