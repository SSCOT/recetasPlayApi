
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

object listatags extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Tag],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tags: List[Tag]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""
        """),format.raw/*2.9*/("""<?xml version="1.0" encoding="UTF-8"?>
<tags>
    """),_display_(/*4.6*/for(i <- tags) yield /*4.20*/ {_display_(Seq[Any](format.raw/*4.22*/("""
    """),_display_(/*5.6*/tag(i)),format.raw/*5.12*/("""
    """)))}),format.raw/*6.6*/("""
"""),format.raw/*7.1*/("""</tags>"""))
      }
    }
  }

  def render(tags:List[Tag]): play.twirl.api.XmlFormat.Appendable = apply(tags)

  def f:((List[Tag]) => play.twirl.api.XmlFormat.Appendable) = (tags) => apply(tags)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Dec 27 01:30:28 CET 2017
                  SOURCE: /Users/mimo/_MASTER MIMO/_proyectos/2 CLOUD/play/_practica/app/views/listatags.scala.xml
                  HASH: 98555c70d393431859a799bb963737ecbbae3393
                  MATRIX: 949->1|1060->18|1095->27|1171->78|1200->92|1239->94|1270->100|1296->106|1331->112|1358->113
                  LINES: 28->1|33->1|34->2|36->4|36->4|36->4|37->5|37->5|38->6|39->7
                  -- GENERATED --
              */
          