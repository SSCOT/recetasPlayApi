
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

object listacocineros extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Cocinero],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(cocineros: List[Cocinero]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""
        """),format.raw/*2.9*/("""<?xml version="1.0" encoding="UTF-8"?>
<cocineros>
    """),_display_(/*4.6*/for(c <- cocineros) yield /*4.25*/ {_display_(Seq[Any](format.raw/*4.27*/("""
    """),_display_(/*5.6*/cocinero(c)),format.raw/*5.17*/("""
    """)))}),format.raw/*6.6*/("""
"""),format.raw/*7.1*/("""</cocineros>"""))
      }
    }
  }

  def render(cocineros:List[Cocinero]): play.twirl.api.XmlFormat.Appendable = apply(cocineros)

  def f:((List[Cocinero]) => play.twirl.api.XmlFormat.Appendable) = (cocineros) => apply(cocineros)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Dec 26 23:36:58 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/app/views/listacocineros.scala.xml
                  HASH: 958365ce0fad2ed6174170fdde06a5c7c2506b43
                  MATRIX: 959->1|1080->28|1115->37|1196->93|1230->112|1269->114|1300->120|1331->131|1366->137|1393->138
                  LINES: 28->1|33->1|34->2|36->4|36->4|36->4|37->5|37->5|38->6|39->7
                  -- GENERATED --
              */
          