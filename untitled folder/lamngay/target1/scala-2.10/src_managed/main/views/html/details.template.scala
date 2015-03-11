
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
object details extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main()/*3.8*/ {_display_(Seq[Any](format.raw/*3.10*/("""


	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/bootstrap-rating-input.min.js"))),format.raw/*6.77*/("""" type="text/javascript"></script>
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/main.js"))),format.raw/*7.55*/("""" type="text/javascript"></script>
	<script type="text/javascript">
	$(function()"""),format.raw/*9.14*/("""{"""),format.raw/*9.15*/("""
	$('.hasTooltip').tooltip();
	$('.review-modal').on('hidden.bs.modal', function (e) """),format.raw/*11.56*/("""{"""),format.raw/*11.57*/("""
	$('.vote-d').popover('hide');
	$('.vote-u').popover('hide');
	"""),format.raw/*14.2*/("""}"""),format.raw/*14.3*/(""");
	$('.pre-video-modal').on('hidden.bs.modal', function (e) """),format.raw/*15.59*/("""{"""),format.raw/*15.60*/("""
	var myVideo = $(this ).find('video');
	if (myVideo) myVideo[0].pause();
	"""),format.raw/*18.2*/("""}"""),format.raw/*18.3*/(""");
	$(".comment").shorten();
	var editor = $('#review-textarea');
	editor.summernote("""),format.raw/*21.20*/("""{"""),format.raw/*21.21*/("""
	height: 100,
	toolbar: [
	//['style', ['style']], // no style button
	['style', ['bold', 'italic', 'underline', 'clear']],
	['fontsize', ['fontsize']],
	['color', ['color']],
	['para', ['ul', 'ol', 'paragraph']],
	['height', ['height']]
	//['insert', ['picture', 'link']], // no insert buttons
	//['table', ['table']], // no table button
	//['help', ['help']] //no help button
	]
	"""),format.raw/*34.2*/("""}"""),format.raw/*34.3*/(""");


	"""),format.raw/*37.2*/("""}"""),format.raw/*37.3*/(""");


	$( ".mlnk" ).click(function() """),format.raw/*40.32*/("""{"""),format.raw/*40.33*/("""
	$( "p" ).hide( "slow" );
	"""),format.raw/*42.2*/("""}"""),format.raw/*42.3*/(""");

	</script>
			<div class="container">
				<div class="row-fluid-sub visible-xs">
					<div class="col-sm-6">
						<div>
							<a>Hết hạn: 31/02/2014</a>
						</div>

						<div class="pb-ta">
							<a class="btn-a btn-startlearning" href="#">
								Nộp đơn </a>
						</div>

						</div>
					</div>

				<div class="row-fluid">
					<div class="col-sm-9">

							<h2 class="ci-h">Lập Trình Viên Dotnet</h2>
							<div class="aboutcourse">

								<b>MÔ TẢ CHI TIẾT CÔNG VIỆC</b>
								<div class="aboutcourse">
									<span style="font-size: 14px;">- Phát triển các ứng dụng trên nền tảng .Net</span><br style="font-size: 14px; line-height: 21px;">
									<span style="font-size: 14px;">- Thực hiện việc phát triển các modules trong dự án như: winform,webform…</span><br style="font-size: 14px; line-height: 21px;">
									<span style="font-size: 14px;">- Thực hiện viết code</span><br style="font-size: 14px; line-height: 21px;">
									<span style="font-size: 14px;">- Cộng tác với các thành viên khác trong nhóm</span><br style="font-size: 14px; line-height: 21px;">
									<span style="font-size: 14px;">- Nghiên cứu và sử dụng công nghệ mới</span><br style="font-size: 14px; line-height: 21px;">
									<span style="font-size: 14px;">- Thực hiện các công việc do trưởng bộ phận phân công</span><br style="font-size: 14px; line-height: 21px;">
								</div>
								</div>

						<hr/>
						<h4>Yêu cầu: </h4>
						<div class="lectures-list-wrap">
							- Tốt nghiệp các trường Đại học chuyên ngành CNTT, điện tử viễn thông hoặc liên quan.<br/>
							- Hiểu sâu về cơ sở dữ liệu, biết phân tích thiết kế cơ sở dữ liệu chuyển hóa sơ đồ ERD sang bảng dữ liệu.<br/>
							- Sử dụng thành thạo các hệ quản trị cơ sở dữ liệu SQL server hoặc Oracle.<br/>
							- Biết viết các Procedure, thành thạo các câu lệnh truy vấn.<br/>
							- Hiểu sâu về lập trình ASP.Net,<br/>
							- Đã làm việc với các công nghệ làm wed khác CSS, Java Script library: Jquery, dojo<br/>
							- Biết lập trình winform, C#.<br/>
							- Thông thạo một trong các IDE phát triển ứng dụng bằng: VS 2008, 2010.<br/>
							- Có kinh nghiệm làm việc với các hệ thống quản lý mã nguồn GIT hoặc SVN<br/>
							- Biết Cystalreport.<br/>
							- Ưu tiên biết Sharepoint.<br/>
							- Ưu tiên các ứng viên đã có kinh nghiệm làm việc trong các dự án gia công phần mềm cho nước ngoài<br/>
							- Có khả năng làm việc bằng tiếng Anh (đọc và nghiên cứu tài liệu)<br/>
							- Năng động, kiên trì, cầu tiến, có trách nhiệm với công việc<br/>
							- Có khả năng chịu được áp lực, nhiệt tình sáng tạo trong công việc, có khả năng nghiên cứu công nghệ mới<br/>
						</div>
						<hr/>
						<img src=""""),_display_(Seq[Any](/*97.18*/routes/*97.24*/.Assets.at("images/img/hanel.png"))),format.raw/*97.58*/("""" alt="" class="iconHldrg">
						<h2 class="ci-h">Thông tin công ty </h2>
						<div>		Tên công ty:	Hanel Software<br/>

							Website công ty:	<a>hanelsoft.vn</a><br/>
							Số nhân viên:	 100-499<br/>
							Tên liên hệ:	 Phòng Nhân Sự<br/>
							<div style="display: block;" class="shortcontent">Công ty CP Giải Pháp Phần Mềm Hanel (HanelSoft) là một đơn vị thành viên của Công ty TNHH MTV Hanel với sứ mệnh xây dựng công nghiệp phần mềm, là nòng cốt của một doanh nghiệp công nghệ tiên tiến hiện đại, cánh chim đầu đàn của công nghiệp thủ đô.
							</div>

							<div style="display: none;" class="allcontent">
								<div>	<p>	Công ty CP Giải Pháp Phần Mềm Hanel (HanelSoft) là một đơn vị thành viên của Công ty TNHH MTV Hanel với sứ mệnh xây dựng công nghiệp phần mềm, là nòng cốt của một doanh nghiệp công nghệ tiên tiến hiện đại, cánh chim đầu đàn của công nghiệp thủ đô.</p>
								</div><div>
								<p>	HanelSoft đang từng ngày xây dựng để trở thành nơi quy tụ đội ngũ nhân sự trẻ trung, nhiệt huyết với nền tảng vững mạnh về công nghệ, kiến trúc thông tin, các giải pháp quản lý, các nền tảng ứng dụng nội dung số.</p>
							</div><div>
								<p>	Chúng tôi đã và đang áp dụng những kiến thức và kinh nghiệm của mình để triển khai thành công nhiều dự án phần mềm cho các khách hàng tại Việt Nam cũng như Singapore trong rất nhiều lĩnh vực khác nhau như y tế, giáo dục, quản lý nhà nước, giải trí, du lịch, quản trị sản xuất và phân phối.</p>
							</div><div>
								<p>	Nhằm đáp ứng nhu cầu sản xuất kinh doanh, chúng tôi cần tìm kiếm và tuyển dụng những nhân viên cũng như quản lý có năng lực vào các vị trí sau: Kỹ Sư Phát Triển Phần Mềm (.NET, SharePoint, PHP, Java, UI, iOS, Android), Chuyên viên Kiểm Thử (Tester), Chuyên viên Quản Lý Chất Lượng (QA), Trưởng Nhóm Thiết Kế, Chuyên viên Thiết Kế (Designer), Quản lý Dự Án (PM), Chuyên viên Phân Tích Nghiệp Vụ (BA), Chuyênviên Phát Triển Ý Tưởng (Idea Developer), Chuyên viên Phát Triển Kế Hoạch Kinh Doanh (Businees Plan Developer).</p></div>
							</div>
							<span><a class="mlnk">more</a></span>
						</div>
					</div>

					<div class="col-sm-3">

						<div class="pb-t">

								<div>
									<a>Hết hạn: 31/02/2014</a>
								</div>

							<div class="pb-ta">
								<a class="btn-a btn-startlearning" href="#">
									Nộp đơn </a>
							</div>
						</div>
						<div class="wi">
							<h5 class="wi-h">Mô tả</h5>
							<ul class="wi-ul bulleted-ul">
								<li class="wi-li">Ngành nghề việc làm:
									<a>	CNTT - Phần mềm</a> </li>
								<li class="wi-li">Cấp bậc: <a> Nhân viên </a> </li>
								<li class="wi-li">Nơi làm việc:<a>	Hà Nội</a></li>
								<li class="wi-li">	Lương:<a> 8,000,000VNĐ - 15,000,000VNĐ </a></li>

							</ul>
						</div>

						<div>
							<h4>Danh mục</h4>
							<a href="">Technology </a><br>

							<h4>Công việc tương tự </h4>
							<table class="table table-hover" >
								<tr><td><a>Account Manager</a><br/>HR Vietnam’s ESS Client</td></tr>
								<tr><td><a>Account Manager</a><br/>BLUE ART - Quảng Cáo Mỹ Thuật Xanh</td></tr>
								<tr><td><a>Account Manager</a><br/>	HR Vietnam’s ESS Client</td></tr>
								<tr><td><a>Account Manager</a><br/>CareerBuilder</td></tr>
								<tr><td><a>Key Account Manager</a><br/>Vilube Corp.</td></tr>
								<tr><td><a>Senior Digital Account Manager</a><br/>HR Vietnam’s ESS Client</td></tr>
								<tr><td><a>Key Account Planning Manager</a><br/>Digital Account Manager</td></tr>
								<tr><td><a>Xem tất cả</a></td></tr>
							</table>

						</div>
					</div>

				</div>

			</div>

			""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 29 10:18:18 ICT 2014
                    SOURCE: /Users/tuanna/Desktop/luu2705/project/lamngay/app/views/details.scala.html
                    HASH: 60ca7b1a57af1ff6290eaa8a5985c4a64478873c
                    MATRIX: 558->1|669->18|706->21|719->27|758->29|811->47|825->53|901->108|986->158|1000->164|1054->197|1162->278|1190->279|1303->364|1332->365|1423->429|1451->430|1540->491|1569->492|1671->567|1699->568|1812->653|1841->654|2251->1037|2279->1038|2312->1044|2340->1045|2404->1081|2433->1082|2488->1110|2516->1111|5261->3820|5276->3826|5332->3860
                    LINES: 19->1|22->1|24->3|24->3|24->3|27->6|27->6|27->6|28->7|28->7|28->7|30->9|30->9|32->11|32->11|35->14|35->14|36->15|36->15|39->18|39->18|42->21|42->21|55->34|55->34|58->37|58->37|61->40|61->40|63->42|63->42|118->97|118->97|118->97
                    -- GENERATED --
                */
            