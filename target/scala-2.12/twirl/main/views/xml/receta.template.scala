
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

object receta extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Receta,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(receta: Receta):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*2.1*/("""<receta>
    <titulo>"""),_display_(/*3.14*/receta/*3.20*/.getTitulo()),format.raw/*3.32*/("""</titulo>
</receta>"""))
      }
    }
  }

  def render(receta:Receta): play.twirl.api.XmlFormat.Appendable = apply(receta)

  def f:((Receta) => play.twirl.api.XmlFormat.Appendable) = (receta) => apply(receta)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Dec 29 18:15:25 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/app/views/receta.scala.xml
                  HASH: 2873a2d04e0fdec85edd67c1bcb5c68bf1867aeb
                  MATRIX: 943->1|1053->17|1080->18|1128->40|1142->46|1174->58
                  LINES: 28->1|33->1|34->2|35->3|35->3|35->3
                  -- GENERATED --
              */
          