
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
object footer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.4*/("""
<div class="modal fade" id="termModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-text">
        <div class="modal-content col-sm-12" style="padding: 0">

        </div>
    </div>
</div>
<div class="bs-docs-footer">
    <div class="top">
        <div class="container">
            <div class="table-cell footer-table">
                <div class="mob footer-i">
                    <h3 class="mob-h">Hocngay.com trên di động</h3>
                    <div class="mob-body">
                        <div class="mob-r">
                            <a href="#" class="sp mob-app"></a>
                            <a href="#" class="sp mob-app mob-app-apple"></a>
                        </div>
                    </div>
                </div>
            </div>
            <ul class="bs-docs-footer-links">
                <li><a href="">Giới thiệu</a></li>
                <li>·</li>
                <li><a data-uv-show="instant_answers" href="" data-uv-scanned="true" id="uv-1">Hỗ trợ</a></li>
                <li>·</li>
                <li><a href="#" data-toggle="modal" data-target="#termModal">Điều khoản</a></li>
                <li>·</li>
                <li><a href="" rel="nofollow">Chính sách</a></li>
            </ul>
            <div  id="copyright">© 2014 Hocngay.com</div>
        </div>
    </div>
</div>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue May 27 18:16:47 ICT 2014
                    SOURCE: /Users/tuanna/Desktop/luu2705/project/lamngay/app/views/footer.scala.html
                    HASH: 807f35661e1926662ec2fd594253592c4e7426ec
                    MATRIX: 550->1|645->3
                    LINES: 19->1|22->1
                    -- GENERATED --
                */
            