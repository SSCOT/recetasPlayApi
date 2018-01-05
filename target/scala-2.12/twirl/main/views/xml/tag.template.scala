
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

object tag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Tag,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tag: Tag):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.12*/("""
"""),format.raw/*2.1*/("""<tag>
    <receta>"""),_display_(/*3.14*/tag/*3.17*/.getT_receta().getTitulo()),format.raw/*3.43*/("""</receta>
    <texto>"""),_display_(/*4.13*/tag/*4.16*/.getTexto()),format.raw/*4.27*/("""</texto>
</tag>"""))
      }
    }
  }

  def render(tag:Tag): play.twirl.api.XmlFormat.Appendable = apply(tag)

  def f:((Tag) => play.twirl.api.XmlFormat.Appendable) = (tag) => apply(tag)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Jan 04 17:11:26 CET 2018
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/app/views/tag.scala.xml
                  HASH: abeca5ffa8ff8779a8a2a1633fa116615c69c85b
                  MATRIX: 937->1|1041->11|1068->12|1113->31|1124->34|1170->60|1218->82|1229->85|1260->96
                  LINES: 28->1|33->1|34->2|35->3|35->3|35->3|36->4|36->4|36->4
                  -- GENERATED --
              */
          