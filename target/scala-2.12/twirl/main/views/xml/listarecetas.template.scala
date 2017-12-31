
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

object listarecetas extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Receta],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(recetas: List[Receta]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.25*/("""
        """),format.raw/*2.9*/("""<?xml version="1.0" encoding="UTF-8"?>
<recetas>
    """),_display_(/*4.6*/for(i <- recetas) yield /*4.23*/ {_display_(Seq[Any](format.raw/*4.25*/("""
    """),_display_(/*5.6*/receta(i)),format.raw/*5.15*/("""
    """)))}),format.raw/*6.6*/("""
"""),format.raw/*7.1*/("""</recetas>"""))
      }
    }
  }

  def render(recetas:List[Receta]): play.twirl.api.XmlFormat.Appendable = apply(recetas)

  def f:((List[Receta]) => play.twirl.api.XmlFormat.Appendable) = (recetas) => apply(recetas)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Dec 29 18:15:25 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/app/views/listarecetas.scala.xml
                  HASH: cb81d7b7e39cc062618d2637201253c2ea5df0d6
                  MATRIX: 955->1|1072->24|1107->33|1186->87|1218->104|1257->106|1288->112|1317->121|1352->127|1379->128
                  LINES: 28->1|33->1|34->2|36->4|36->4|36->4|37->5|37->5|38->6|39->7
                  -- GENERATED --
              */
          