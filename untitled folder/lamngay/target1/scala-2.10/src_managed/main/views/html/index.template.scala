
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main()/*3.8*/ {_display_(Seq[Any](format.raw/*3.10*/("""
	<div class="container" style="margin-top : 10px">
		<form id="search" action="/search" method="get">
			<div class="flex-wrapper index-search-flex-wrapper">
				<div id="search-input-wrapper" class="flex">
					<input id="home-search-box" placeholder="Gõ vào đây để tìm việc" name="f" type="text">
				</div>
				<button id="search-btn" class="btn-a btn-large" type="submit"><span class="glyphicon glyphicon-search"></span><p style="margin-top : 7px">
					TÌM KIẾM</p></button>
			</div>
		</form>
		<h1 class="side-lined thin">Việc làm tốt </h1>
		<ul id="topcourses" class="discover-works-list multi-line" style="text-align : center">
			<li class="works-box">
				<a href="details" class="mask">
					<img src=""""),_display_(Seq[Any](/*18.17*/routes/*18.23*/.Assets.at("images/s66.png"))),format.raw/*18.51*/("""" alt="Senior iOS Developer" class="iconHldr">
					<span class="title">
						Senior iOS Developer
					</span>
					<span class="details">
						<span class="work-address">
						Nơi làm việc: Ho Chi Minh, Others.
							<br/>
							Mức lương: $1000 - $1500
						</span>
					</span>

					<span class="details2">
						<span class="ins-job-title ellipsis">
							Yêu Cầu Công Việc:
						</span>
						- Tốt nghiệp các trường Đại học chuyên ngành công nghệ thông tin hoặc điện tử viễn thông.<br/>
						- Nắm vững ngôn ngữ lập trình C/C++, Objective C, iOS SDK.<br/>

					</span>

				</a>
			</li>
			<li class="works-box">
				<a href="details" class="mask">
					<img src=""""),_display_(Seq[Any](/*43.17*/routes/*43.23*/.Assets.at("images/img/DotNet.png"))),format.raw/*43.58*/("""" alt="Lập trình Android căn bản" class="iconHldr">
					<span class="title">
						Lập Trình Viên Dotnet
					</span>
					<span class="details">
						<span class="work-address">
						Nơi làm việc: Hà Nội.
							<br/>
							Mức lương: $1000 - $1500
						</span>
					</span>
					<span class="details2">
						<span class="ins-job-title ellipsis">
							Yêu Cầu Công Việc:
						</span>
						1. Understanding object oriented programing method. Understanding Data Driven Application model and Service Oriented Application model is an advantage.
					</span>

				</a>
			</li>
			<li class="works-box">
				<a href="details" class="mask">
					<img src=""""),_display_(Seq[Any](/*65.17*/routes/*65.23*/.Assets.at("images/img/s65.jpg"))),format.raw/*65.55*/("""" alt="Lập trình Android căn bản" class="iconHldr">
					<span class="title">
						Mobile App Developer $2500-$10,000us Per Month
					</span>
					<span class="details">
						<span class="work-address">
						Nơi làm việc: Hà Nội.
						<br/>
						Mức lương: $1000 - $1500
						</span>
					</span>
					<span class="details2">
						<span class="ins-job-title ellipsis">
							Yêu Cầu Công Việc:
						</span>
						- University/ College graduate in software engineering or relevant field
						<br/>
						- Minimum 2 year of relevant work experience is required
						</span>

				</a>
			</li>
			<li class="works-box">
				<a href="details" class="mask">
					<img src=""""),_display_(Seq[Any](/*89.17*/routes/*89.23*/.Assets.at("images/img/hanel.png"))),format.raw/*89.57*/("""" alt="" class="iconHldr">
					<span class="title">
						Nhân Viên Xử Lý Dữ Liệu
					</span>
					<span class="details">
					<span class="work-address">
						Nơi làm việc: Hà Nội.
							<br/>
							Mức lương: $1000 - $1500
					</span>
					</span>
					<span class="details2">
						<span class="ins-job-title ellipsis">
							Yêu Cầu Công Việc:
						</span>
						- Không yêu cầu bằng cấp và kinh nghiệm.<br/>
						- Sử dụng thành thạo máy vi tính.<br/>
						- Sử dụng được các công thức, hàm tính toán trong Microsoft Excel<br/>
						</span>
				</a>
			</li>
		</ul>
		<h1 class="side-lined thin">Việc làm mới </h1>

		<ul id="hotjob" class="discover-works-list multi-line" style="text-align: center">

				<li class="works-box">
					<a href="details" class="mask">
						<img src=""""),_display_(Seq[Any](/*117.18*/routes/*117.24*/.Assets.at("images/s66.png"))),format.raw/*117.52*/("""" alt="Senior iOS Developer" class="iconHldr">
						<span class="title">
							Senior iOS Developer
						</span>
						<span class="details">
							<span class="work-address">
								Nơi làm việc: Ho Chi Minh, Others.
								<br/>
								Mức lương: $1000 - $1500
							</span>
						</span>

						<span class="details2">
							<span class="ins-job-title ellipsis">
								Yêu Cầu Công Việc:
							</span>
							- Tốt nghiệp các trường Đại học chuyên ngành công nghệ thông tin hoặc điện tử viễn thông.<br/>
							- Nắm vững ngôn ngữ lập trình C/C++, Objective C, iOS SDK.<br/>

						</span>

					</a>
				</li>
				<li class="works-box">
					<a href="details" class="mask">
						<img src=""""),_display_(Seq[Any](/*142.18*/routes/*142.24*/.Assets.at("images/img/DotNet.png"))),format.raw/*142.59*/("""" alt="Lập trình Android căn bản" class="iconHldr">
						<span class="title">
							Lập Trình Viên Dotnet
						</span>
						<span class="details">
							<span class="work-address">
								Nơi làm việc: Hà Nội.
								<br/>
								Mức lương: $1000 - $1500
							</span>
						</span>
						<span class="details2">
							<span class="ins-job-title ellipsis">
								Yêu Cầu Công Việc:
							</span>
							1. Understanding object oriented programing method. Understanding Data Driven Application model and Service Oriented Application model is an advantage.
						</span>

					</a>
				</li>
				<li class="works-box">
					<a href="details" class="mask">
						<img src=""""),_display_(Seq[Any](/*164.18*/routes/*164.24*/.Assets.at("images/img/s65.jpg"))),format.raw/*164.56*/("""" alt="Lập trình Android căn bản" class="iconHldr">
						<span class="title">
							Mobile App Developer $2500-$10,000us Per Month
						</span>
						<span class="details">
							<span class="work-address">
								Nơi làm việc: Hà Nội.
								<br/>
								Mức lương: $1000 - $1500
							</span>
						</span>
						<span class="details2">
							<span class="ins-job-title ellipsis">
								Yêu Cầu Công Việc:
							</span>
							- University/ College graduate in software engineering or relevant field
							<br/>
							- Minimum 2 year of relevant work experience is required
						</span>

					</a>
				</li>
				<li class="works-box">
					<a href="details" class="mask">
						<img src=""""),_display_(Seq[Any](/*188.18*/routes/*188.24*/.Assets.at("images/img/hanel.png"))),format.raw/*188.58*/("""" alt="" class="iconHldr">
						<span class="title">
							Nhân Viên Xử Lý Dữ Liệu
						</span>
						<span class="details">
							<span class="work-address">
								Nơi làm việc: Hà Nội.
								<br/>
								Mức lương: $1000 - $1500
							</span>
						</span>
						<span class="details2">
							<span class="ins-job-title ellipsis">
								Yêu Cầu Công Việc:
							</span>
							- Không yêu cầu bằng cấp và kinh nghiệm.<br/>
							- Sử dụng thành thạo máy vi tính.<br/>
							- Sử dụng được các công thức, hàm tính toán trong Microsoft Excel<br/>
						</span>
					</a>
				</li>

		</ul>
		<a href="#" class="internal-index">Xem tất cả danh sách tuyển dụng</a>
	</div>


""")))})),format.raw/*215.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 29 10:26:55 ICT 2014
                    SOURCE: /Users/tuanna/Desktop/luu2705/project/lamngay/app/views/index.scala.html
                    HASH: 24c0573bbb6bc4258173c46587c562589790dbfd
                    MATRIX: 556->1|667->18|704->21|717->27|756->29|1510->747|1525->753|1575->781|2295->1465|2310->1471|2367->1506|3065->2168|3080->2174|3134->2206|3852->2888|3867->2894|3923->2928|4760->3728|4776->3734|4827->3762|5571->4469|5587->4475|5645->4510|6366->5194|6382->5200|6437->5232|7181->5939|7197->5945|7254->5979|7976->6669
                    LINES: 19->1|22->1|24->3|24->3|24->3|39->18|39->18|39->18|64->43|64->43|64->43|86->65|86->65|86->65|110->89|110->89|110->89|138->117|138->117|138->117|163->142|163->142|163->142|185->164|185->164|185->164|209->188|209->188|209->188|236->215
                    -- GENERATED --
                */
            