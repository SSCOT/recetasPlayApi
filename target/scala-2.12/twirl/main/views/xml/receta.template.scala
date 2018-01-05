
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
    <autor>"""),_display_(/*4.13*/receta/*4.19*/.getR_cocinero().getNombre()),format.raw/*4.47*/(""" """),_display_(/*4.49*/receta/*4.55*/.getR_cocinero().getApellido()),format.raw/*4.85*/("""</autor>
    <ingredientes>
        """),_display_(/*6.10*/for(i <- receta.getIngredientes()) yield /*6.44*/ {_display_(Seq[Any](format.raw/*6.46*/("""
        """),_display_(/*7.10*/ingrediente(i)),format.raw/*7.24*/("""
        """)))}),format.raw/*8.10*/("""
    """),format.raw/*9.5*/("""</ingredientes>
    <pasos>
        """),_display_(/*11.10*/for(p <- receta.getPasos()) yield /*11.37*/ {_display_(Seq[Any](format.raw/*11.39*/("""
        """),_display_(/*12.10*/paso(p)),format.raw/*12.17*/("""
        """)))}),format.raw/*13.10*/("""
    """),format.raw/*14.5*/("""</pasos>
    <tags>
        """),_display_(/*16.10*/for(t <- receta.getTags()) yield /*16.36*/ {_display_(Seq[Any](format.raw/*16.38*/("""
        """),_display_(/*17.10*/tag(t)),format.raw/*17.16*/("""
        """)))}),format.raw/*18.10*/("""
    """),format.raw/*19.5*/("""</tags>
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
                  DATE: Thu Jan 04 16:49:52 CET 2018
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/apiRecetas/app/views/receta.scala.xml
                  HASH: 6dcac07669675f13eee320c177e3114ac2f219cb
                  MATRIX: 943->1|1053->17|1080->18|1128->40|1142->46|1174->58|1222->80|1236->86|1284->114|1312->116|1326->122|1376->152|1439->189|1488->223|1527->225|1563->235|1597->249|1637->259|1668->264|1732->301|1775->328|1815->330|1852->340|1880->347|1921->357|1953->362|2009->391|2051->417|2091->419|2128->429|2155->435|2196->445|2228->450
                  LINES: 28->1|33->1|34->2|35->3|35->3|35->3|36->4|36->4|36->4|36->4|36->4|36->4|38->6|38->6|38->6|39->7|39->7|40->8|41->9|43->11|43->11|43->11|44->12|44->12|45->13|46->14|48->16|48->16|48->16|49->17|49->17|50->18|51->19
                  -- GENERATED --
              */
          