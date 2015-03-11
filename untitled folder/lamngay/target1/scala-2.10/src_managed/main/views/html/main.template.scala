
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Html,Lang,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(content: Html)(implicit l: Lang):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.37*/("""

<!DOCTYPE html>

<html>
	<head>
		<title>Welcome to Hocngay</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">

		<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.53*/routes/*11.59*/.Assets.at("images/favicon.png"))),format.raw/*11.91*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*12.48*/routes/*12.54*/.Assets.at("stylesheets/font-awesome.css"))),format.raw/*12.96*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*13.48*/routes/*13.54*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*13.93*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*14.48*/routes/*14.54*/.Assets.at("stylesheets/datepicker.css"))),format.raw/*14.94*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*15.48*/routes/*15.54*/.Assets.at("stylesheets/summernote.css"))),format.raw/*15.94*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*16.48*/routes/*16.54*/.Assets.at("stylesheets/video-js.min.css"))),format.raw/*16.96*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*17.48*/routes/*17.54*/.Assets.at("stylesheets/jasny-bootstrap.min.css"))),format.raw/*17.103*/("""">
			<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
			<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
			<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<[endif]-->
		<script src=""""),_display_(Seq[Any](/*24.17*/routes/*24.23*/.Assets.at("javascripts/modernizr.custom.28468.js"))),format.raw/*24.74*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*25.17*/routes/*25.23*/.Assets.at("javascripts/jquery-1.11.0.min.js"))),format.raw/*25.69*/(""""></script>
		<script src=""""),_display_(Seq[Any](/*26.17*/routes/*26.23*/.Assets.at("javascripts/bootstrap.js"))),format.raw/*26.61*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*27.17*/routes/*27.23*/.Assets.at("javascripts/jquery.validate.js"))),format.raw/*27.67*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*28.17*/routes/*28.23*/.Assets.at("javascripts/bootstrap-datepicker.js"))),format.raw/*28.72*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*29.17*/routes/*29.23*/.Assets.at("javascripts/main.js"))),format.raw/*29.56*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*30.17*/routes/*30.23*/.Assets.at("javascripts/summernote.min.js"))),format.raw/*30.66*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*31.17*/routes/*31.23*/.Assets.at("javascripts/pace.min.js"))),format.raw/*31.60*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*32.17*/routes/*32.23*/.Assets.at("javascripts/jasny-bootstrap.min.js"))),format.raw/*32.71*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*33.17*/routes/*33.23*/.Assets.at("javascripts/holder.js"))),format.raw/*33.58*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*34.17*/routes/*34.23*/.Assets.at("javascripts/jquery.shorten.js"))),format.raw/*34.66*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*35.17*/routes/*35.23*/.Assets.at("javascripts/bootstrap-tooltip.js"))),format.raw/*35.69*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*36.17*/routes/*36.23*/.Assets.at("javascripts/bootstrap-confirmation.js"))),format.raw/*36.74*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*37.17*/routes/*37.23*/.Assets.at("javascripts/autoNumeric-1.9.21.js"))),format.raw/*37.70*/("""" type="text/javascript"></script>
		<script src=""""),_display_(Seq[Any](/*38.17*/routes/*38.23*/.Assets.at("javascripts/video.js"))),format.raw/*38.57*/("""" type="text/javascript"></script>
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*39.48*/routes/*39.54*/.Assets.at("stylesheets/style.css"))),format.raw/*39.89*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*40.48*/routes/*40.54*/.Assets.at("stylesheets/style2.css"))),format.raw/*40.90*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*41.48*/routes/*41.54*/.Assets.at("stylesheets/main.css"))),format.raw/*41.88*/("""">

	</head>
	<body>
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content col-sm-12" style="padding : 0">

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
				<nav class="navbar-collapse bs-navbar-collapse collapse" role="navigation" style="height : 1px ;">
					<ul class="nav navbar-nav navbar-right">
						<li><a href=""""),_display_(Seq[Any](/*64.21*/routes/*64.27*/.Application.index)),format.raw/*64.45*/("""">"""),_display_(Seq[Any](/*64.48*/Messages("header.home"))),format.raw/*64.71*/("""</a></li>
						<li><a href="#">"""),_display_(Seq[Any](/*65.24*/Messages("header.course"))),format.raw/*65.49*/("""</a></li>
						<li><a href="#">"""),_display_(Seq[Any](/*66.24*/Messages("header.whatsnew"))),format.raw/*66.51*/("""</a></li>

						<li><a href="#" class="btn-a btn--nav">"""),_display_(Seq[Any](/*68.47*/Messages("header.register"))),format.raw/*68.74*/("""</a></li>
						<li class="login">
							<a href="#" class="btn-c btn--nav" data-toggle="modal" data-target="#loginModal">"""),_display_(Seq[Any](/*70.90*/Messages("header.login"))),format.raw/*70.114*/("""</a>
						</li>

						<li>
							<a href="#" title="Tiếng Việt" class="qtrans_flag qtrans_flag_vi"><span style="display : none">
								Tiếng Việt</span></a>
						</li>
						<li>
							<a href="#" title="English" class="qtrans_flag qtrans_flag_en"><span style="display : none">
								English</span></a>
						</li>
					</ul>
				</nav>
			</div>
			<script>

			</script>
		</header>
			"""),_display_(Seq[Any](/*88.5*/content)),format.raw/*88.12*/("""

		<div class="modal fade" id="termModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-text">
				<div class="modal-content col-sm-12" style="padding : 0">

				</div>
			</div>
		</div>
		<div class="bs-docs-footer">
			<div class="top">
				<div class="container">
					<div class="table-cell footer-table">
						<div class="mob footer-i">
							<h3 class="mob-h">http://hocngay.com trên di động</h3>
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
					<div id="copyright">© 2014 http://hocngay.com</div>
				</div>
			</div>
		</div>




	</body>
</html>
"""))}
    }
    
    def render(content:Html,l:Lang): play.api.templates.HtmlFormat.Appendable = apply()(content)(l)
    
    def f:(() => (Html) => (Lang) => play.api.templates.HtmlFormat.Appendable) = () => (content) => (l) => apply()(content)(l)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed May 28 11:04:56 ICT 2014
                    SOURCE: /Users/tuanna/Desktop/luu2705/project/lamngay/app/views/main.scala.html
                    HASH: a84faeb261e616bfd5460585201fc0e5f9d19b7d
                    MATRIX: 558->1|687->36|964->277|979->283|1033->315|1119->365|1134->371|1198->413|1284->463|1299->469|1360->508|1446->558|1461->564|1523->604|1609->654|1624->660|1686->700|1772->750|1787->756|1851->798|1937->848|1952->854|2024->903|2456->1299|2471->1305|2544->1356|2631->1407|2646->1413|2714->1459|2778->1487|2793->1493|2853->1531|2940->1582|2955->1588|3021->1632|3108->1683|3123->1689|3194->1738|3281->1789|3296->1795|3351->1828|3438->1879|3453->1885|3518->1928|3605->1979|3620->1985|3679->2022|3766->2073|3781->2079|3851->2127|3938->2178|3953->2184|4010->2219|4097->2270|4112->2276|4177->2319|4264->2370|4279->2376|4347->2422|4434->2473|4449->2479|4522->2530|4609->2581|4624->2587|4693->2634|4780->2685|4795->2691|4851->2725|4969->2807|4984->2813|5041->2848|5127->2898|5142->2904|5200->2940|5286->2990|5301->2996|5357->3030|6254->3891|6269->3897|6309->3915|6348->3918|6393->3941|6462->3974|6509->3999|6578->4032|6627->4059|6720->4116|6769->4143|6929->4267|6976->4291|7409->4689|7438->4696
                    LINES: 19->1|22->1|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|45->24|45->24|45->24|46->25|46->25|46->25|47->26|47->26|47->26|48->27|48->27|48->27|49->28|49->28|49->28|50->29|50->29|50->29|51->30|51->30|51->30|52->31|52->31|52->31|53->32|53->32|53->32|54->33|54->33|54->33|55->34|55->34|55->34|56->35|56->35|56->35|57->36|57->36|57->36|58->37|58->37|58->37|59->38|59->38|59->38|60->39|60->39|60->39|61->40|61->40|61->40|62->41|62->41|62->41|85->64|85->64|85->64|85->64|85->64|86->65|86->65|87->66|87->66|89->68|89->68|91->70|91->70|109->88|109->88
                    -- GENERATED --
                */
            