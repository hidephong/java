
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
object header extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Lang,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit l: Lang):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content col-sm-12" style="padding: 0">

        </div>
    </div>
</div>
<header class="navbar navbar-default navbar-static-top bs-docs-nav">
    <div class="container">
        <div class="navbar-header">
            <a href="/" class="navbar-brand"></a>
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <nav class="navbar-collapse bs-navbar-collapse collapse" role="navigation" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right">
                <li><a href=""""),_display_(Seq[Any](/*21.31*/routes/*21.37*/.Application.index)),format.raw/*21.55*/("""">"""),_display_(Seq[Any](/*21.58*/Messages("header.home"))),format.raw/*21.81*/("""</a></li>
                <li><a href="#">"""),_display_(Seq[Any](/*22.34*/Messages("header.course"))),format.raw/*22.59*/("""</a></li>
                <li><a href="#">"""),_display_(Seq[Any](/*23.34*/Messages("header.whatsnew"))),format.raw/*23.61*/("""</a></li>

                    <li><a href="#" class="btn-a btn--nav">"""),_display_(Seq[Any](/*25.61*/Messages("header.register"))),format.raw/*25.88*/("""</a></li>
                    <li class="login">
                        <a href="#" class="btn-c btn--nav" data-toggle="modal" data-target="#loginModal">"""),_display_(Seq[Any](/*27.107*/Messages("header.login"))),format.raw/*27.131*/("""</a>
                    </li>

                <li>
                    <a href="#"  title="Tiếng Việt" class="qtrans_flag qtrans_flag_vi"><span style="display:none">Tiếng Việt</span></a>
                </li>
                <li>
                    <a href="#"  title="English" class="qtrans_flag qtrans_flag_en"><span style="display:none">English</span></a>
                </li>
            </ul>
        </nav>
    </div>
<script>

</script>
</header>

"""))}
    }
    
    def render(l:Lang): play.api.templates.HtmlFormat.Appendable = apply()(l)
    
    def f:(() => (Lang) => play.api.templates.HtmlFormat.Appendable) = () => (l) => apply()(l)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue May 27 18:16:47 ICT 2014
                    SOURCE: /Users/tuanna/Desktop/luu2705/project/lamngay/app/views/header.scala.html
                    HASH: 0e4baa974655bfd6d7fc9b3ae656770e94111651
                    MATRIX: 555->1|669->21|1628->944|1643->950|1683->968|1722->971|1767->994|1846->1037|1893->1062|1972->1105|2021->1132|2128->1203|2177->1230|2369->1385|2416->1409
                    LINES: 19->1|22->1|42->21|42->21|42->21|42->21|42->21|43->22|43->22|44->23|44->23|46->25|46->25|48->27|48->27
                    -- GENERATED --
                */
            