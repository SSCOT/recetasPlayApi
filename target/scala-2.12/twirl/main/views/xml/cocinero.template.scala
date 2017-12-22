
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

object cocinero extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Cocinero,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(cocinero: Cocinero):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.22*/("""
"""),format.raw/*2.1*/("""<cocinero>
    <nombre>"""),_display_(/*3.14*/cocinero/*3.22*/.getNombre()),format.raw/*3.34*/("""</nombre>
    <apellido>"""),_display_(/*4.16*/cocinero/*4.24*/.getApellido()),format.raw/*4.38*/("""</apellido>
</cocinero>"""))
      }
    }
  }

  def render(cocinero:Cocinero): play.twirl.api.XmlFormat.Appendable = apply(cocinero)

  def f:((Cocinero) => play.twirl.api.XmlFormat.Appendable) = (cocinero) => apply(cocinero)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Dec 18 21:24:01 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/app/views/cocinero.scala.xml
                  HASH: 9dbd1c567a9566f16005ad739c2a89c4d81033f5
                  MATRIX: 947->1|1061->21|1088->22|1138->46|1154->54|1186->66|1237->91|1253->99|1287->113
                  LINES: 28->1|33->1|34->2|35->3|35->3|35->3|36->4|36->4|36->4
                  -- GENERATED --
              */
          