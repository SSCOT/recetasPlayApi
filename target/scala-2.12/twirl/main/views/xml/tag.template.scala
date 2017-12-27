
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
    <texto>"""),_display_(/*3.13*/tag/*3.16*/.getTexto()),format.raw/*3.27*/("""</texto>
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
                  DATE: Wed Dec 27 01:30:28 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/app/views/tag.scala.xml
                  HASH: 6823014616d9b7808daee3d1b3e9fd5419b619dc
                  MATRIX: 937->1|1041->11|1068->12|1112->30|1123->33|1154->44
                  LINES: 28->1|33->1|34->2|35->3|35->3|35->3
                  -- GENERATED --
              */
          