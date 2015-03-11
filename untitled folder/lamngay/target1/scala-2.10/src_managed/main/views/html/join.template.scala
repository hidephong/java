
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object join extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[scala.Tuple2[String, String]],Lang,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ans: List[(String,String)])(implicit  lang: Lang):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""

"""),_display_(Seq[Any](/*3.2*/main()/*3.8*/ {_display_(Seq[Any](format.raw/*3.10*/("""

	<ul>
	"""),_display_(Seq[Any](/*6.3*/for(q <- ans) yield /*6.16*/ {_display_(Seq[Any](format.raw/*6.18*/("""
		<li>"""),_display_(Seq[Any](/*7.8*/q)),format.raw/*7.9*/("""</li>""")))})),format.raw/*7.15*/("""

	</ul>


""")))})),format.raw/*12.2*/("""
"""))}
    }
    
    def render(ans:List[scala.Tuple2[String, String]],lang:Lang): play.api.templates.HtmlFormat.Appendable = apply(ans)(lang)
    
    def f:((List[scala.Tuple2[String, String]]) => (Lang) => play.api.templates.HtmlFormat.Appendable) = (ans) => (lang) => apply(ans)(lang)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 29 11:56:21 ICT 2014
                    SOURCE: /Users/tuanna/Desktop/luu2705/project/lamngay/app/views/join.scala.html
                    HASH: 39da0db09aa0cd7ec3c1737367ebe3191a5dced5
                    MATRIX: 588->1|732->51|769->54|782->60|821->62|865->72|893->85|932->87|974->95|995->96|1032->102|1075->114
                    LINES: 19->1|22->1|24->3|24->3|24->3|27->6|27->6|27->6|28->7|28->7|28->7|33->12
                    -- GENERATED --
                */
            