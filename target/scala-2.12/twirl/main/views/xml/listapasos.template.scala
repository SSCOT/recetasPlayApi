
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

object listapasos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Paso],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pasos: List[Paso]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.21*/("""
        """),format.raw/*2.9*/("""<?xml version="1.0" encoding="UTF-8"?>
<pasos>
    """),_display_(/*4.6*/for(i <- pasos) yield /*4.21*/ {_display_(Seq[Any](format.raw/*4.23*/("""
    """),_display_(/*5.6*/paso(i)),format.raw/*5.13*/("""
    """)))}),format.raw/*6.6*/("""
"""),format.raw/*7.1*/("""</pasos>"""))
      }
    }
  }

  def render(pasos:List[Paso]): play.twirl.api.XmlFormat.Appendable = apply(pasos)

  def f:((List[Paso]) => play.twirl.api.XmlFormat.Appendable) = (pasos) => apply(pasos)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Dec 26 23:36:58 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/app/views/listapasos.scala.xml
                  HASH: a311ca6a319243d476b9b31b4c717ee6811ead5d
                  MATRIX: 951->1|1064->20|1099->29|1176->81|1206->96|1245->98|1276->104|1303->111|1338->117|1365->118
                  LINES: 28->1|33->1|34->2|36->4|36->4|36->4|37->5|37->5|38->6|39->7
                  -- GENERATED --
              */
          