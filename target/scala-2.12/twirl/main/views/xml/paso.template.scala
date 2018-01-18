
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
    <receta>"""),_display_(/*3.14*/paso/*3.18*/.getP_receta().getTitulo()),format.raw/*3.44*/("""</receta>
    <descripcion>"""),_display_(/*4.19*/paso/*4.23*/.getDescripcion()),format.raw/*4.40*/("""</descripcion>
    <tiempo>"""),_display_(/*5.14*/paso/*5.18*/.getTiempo()),format.raw/*5.30*/("""</tiempo>
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
                  DATE: Thu Jan 18 20:03:34 CET 2018
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_err/recetasPlayApi/app/views/paso.scala.xml
                  HASH: a35610554dc9c166d3a07681d77e46701af378e0
                  MATRIX: 939->1|1045->13|1072->14|1118->34|1130->38|1176->64|1230->92|1242->96|1279->113|1333->141|1345->145|1377->157
                  LINES: 28->1|33->1|34->2|35->3|35->3|35->3|36->4|36->4|36->4|37->5|37->5|37->5
                  -- GENERATED --
              */
          