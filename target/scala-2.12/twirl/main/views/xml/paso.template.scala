
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

object paso extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Paso,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(paso: Paso):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""
"""),format.raw/*2.1*/("""<paso>
    <descripcion>"""),_display_(/*3.19*/paso/*3.23*/.getDescripcion()),format.raw/*3.40*/("""</descripcion>
    <tiempo>"""),_display_(/*4.14*/paso/*4.18*/.getTiempo()),format.raw/*4.30*/("""</tiempo>
</paso>"""))
      }
    }
  }

  def render(paso:Paso): play.twirl.api.XmlFormat.Appendable = apply(paso)

  def f:((Paso) => play.twirl.api.XmlFormat.Appendable) = (paso) => apply(paso)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Dec 26 23:36:58 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/app/views/paso.scala.xml
                  HASH: 375c603443df856811ca2868d6ef6dd367445ffb
                  MATRIX: 939->1|1045->13|1072->14|1123->39|1135->43|1172->60|1226->88|1238->92|1270->104
                  LINES: 28->1|33->1|34->2|35->3|35->3|35->3|36->4|36->4|36->4
                  -- GENERATED --
              */
          