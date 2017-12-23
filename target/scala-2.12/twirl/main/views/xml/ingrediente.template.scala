
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

object ingrediente extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Ingrediente,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ingrediente: Ingrediente):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*2.1*/("""<ingrediente>
    <nombre>"""),_display_(/*3.14*/ingrediente/*3.25*/.getNombre()),format.raw/*3.37*/("""</nombre>
</ingrediente>"""))
      }
    }
  }

  def render(ingrediente:Ingrediente): play.twirl.api.XmlFormat.Appendable = apply(ingrediente)

  def f:((Ingrediente) => play.twirl.api.XmlFormat.Appendable) = (ingrediente) => apply(ingrediente)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Dec 23 05:01:15 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/app/views/ingrediente.scala.xml
                  HASH: f5e680a1b2b9dc65c14335aeee67b0bf5ccde09e
                  MATRIX: 953->1|1073->27|1100->28|1153->55|1172->66|1204->78
                  LINES: 28->1|33->1|34->2|35->3|35->3|35->3
                  -- GENERATED --
              */
          