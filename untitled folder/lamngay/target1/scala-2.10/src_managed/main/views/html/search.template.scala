
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
object search extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

	"""),_display_(Seq[Any](/*3.3*/main()/*3.9*/ {_display_(Seq[Any](format.raw/*3.11*/("""
		<div class="container" style="margin-top : 10px">
			<form id="search" action="/search" method="post">
				<div class="flex-wrapper index-search-flex-wrapper">
					<div id="search-input-wrapper" class="flex">
						<input id="home-search-box" placeholder="Gõ vào đây để tìm việc" name="f" type="text">
					</div>
					<button id="search-btn" class="btn-a btn-large" type="submit"><span class="glyphicon glyphicon-search"></span><p style="margin-top : 7px">
						TÌM KIẾM</p></button>
				</div>
			</form>

			<div class="col-sm-3 col-md-2">
				<div class="category-names">
					<div class="categories">
						<ul>

							<li class="discover-course-category" style="">
								<a href="http://hocngay.com/searchResult?ca=1" class="">Lập trình di động </a>
							</li>

							<li class="discover-course-category" style="">
								<a href="http://hocngay.com/searchResult?ca=2" class="">Lập trình web </a>
							</li>

							<li class="discover-course-category" style="">
								<a href="http://hocngay.com/searchResult?ca=3" class="">Ngoại ngữ </a>
							</li>

							<li class="discover-course-category" style="">
								<a href="http://hocngay.com/searchResult?ca=7" class="">Giải thuật </a>
							</li>

						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-9 col-md-10 text-center divminH">
				<div class="context-and-filters single-header flex-wrapper ">
					<div class="l flex">
						<h2 class="dark"><i>Kết quả tìm kiếm</i></h2>
						<div style="text-align : left ; margin-top : 4px"><b>6</b> Kết quả</div>
					</div>
					<div class="r">
						<div class="action-box sort">
							<div class="btn-group">
								<button data-toggle="dropdown" class="btn dropdown-toggle">
									Sắp xếp <span class="caret"></span></button>
								<ul class="dropdown-menu">

									<li style="text-decoration : underline">
										<a href="http://hocngay.com/searchResult">Học viên</a>
									</li>


									<li style="">
										<a href="http://hocngay.com/searchResult?o=2">Mới nhất</a>
									</li>


									<li style="">
										<a href="http://hocngay.com/searchResult?o=3">Giá</a>
									</li>

								</ul>
							</div>
						</div>
					</div>
				</div>

				<ul id="works" class="discover-works-list multi-line">

					<li class="works-box small">
						<a href="#" class="mask">
							<img src=""""),_display_(Seq[Any](/*77.19*/routes/*77.25*/.Assets.at("images/img/hanel.png"))),format.raw/*77.59*/("""" alt="" class="iconHldr">
							<span class="title">
								Nhân Viên Xử Lý Dữ Liệu
							</span>
							<span class="details">
								<span class="work-address">
									Nơi làm việc: Hà Nội.<br/>
									Mức lương: Thỏa thuận
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

					<li class="works-box small">
						<a href="#" class="mask">
							<img src=""""),_display_(Seq[Any](/*101.19*/routes/*101.25*/.Assets.at("images/s66.png"))),format.raw/*101.53*/("""" alt="Senior iOS Developer" class="iconHldr">
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
					<li class="works-box small">
						<a href="http://http://hocngay.com/courseDetail/30/lap-trinh-android-can-ban" class="mask">
							<img src=""""),_display_(Seq[Any](/*124.19*/routes/*124.25*/.Assets.at("images/img/DotNet.png"))),format.raw/*124.60*/("""" alt="Lập trình Android căn bản" class="iconHldr">
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
					<li class="works-box small">
						<a href="http://http://hocngay.com/courseDetail/30/lap-trinh-android-can-ban" class="mask">
							<img src=""""),_display_(Seq[Any](/*145.19*/routes/*145.25*/.Assets.at("images/img/s65.jpg"))),format.raw/*145.57*/("""" alt="Lập trình Android căn bản" class="iconHldr">
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
					<li class="works-box small">
						<a href="#" class="mask">
							<img src=""""),_display_(Seq[Any](/*169.19*/routes/*169.25*/.Assets.at("images/img/hanel.png"))),format.raw/*169.59*/("""" alt="" class="iconHldr">
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

							</span>
						</a>
					</li>

				</ul>

				<div class="pull-right">
					<ul class="pagination">
						<li class="disabled"><a href="http://hocngay.com/searchResult">First</a></li>

						<li class="active"><a href="http://hocngay.com/searchResult">1</a></li>

						<li class="disabled"><a href="http://hocngay.com/searchResult">Last</a></li>
					</ul>
				</div>


			</div>

		</div>
	""")))})),format.raw/*207.3*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 29 10:30:06 ICT 2014
                    SOURCE: /Users/tuanna/Desktop/luu2705/project/lamngay/app/views/search.scala.html
                    HASH: 75f89c0d83b377e4a7616a4f87a5eaa63fee2276
                    MATRIX: 557->1|668->18|706->22|719->28|758->30|3153->2389|3168->2395|3224->2429|3951->3119|3967->3125|4018->3153|4848->3946|4864->3952|4922->3987|5729->4757|5745->4763|5800->4795|6568->5526|6584->5532|6641->5566|7575->6468
                    LINES: 19->1|22->1|24->3|24->3|24->3|98->77|98->77|98->77|122->101|122->101|122->101|145->124|145->124|145->124|166->145|166->145|166->145|190->169|190->169|190->169|228->207
                    -- GENERATED --
                */
            