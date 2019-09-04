<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4><%=request.getParameter("sesMember") %></h4>
	<div class="people_info section _people_info _cs_same_name people_spc"
		id="people_info_z" data-dss-logarea="x29">
		<div class="section_head">
			<h2>인물 정보</h2>
		</div>
		<div class="cont_noline" style="z-index: 10">
			<div class="profile_wrap">
				<div class="big_thumb">
					<a nocr=""
						onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.image&amp;i='+'1800000D_000000017138');"
						href="https://search.naver.com/search.naver?where=image&amp;query=%EC%9C%A0%EC%88%98%EC%98%81&amp;merge=0&amp;res_fr=0&amp;res_to=0&amp;sort=0&amp;viewtype=0&amp;site=&amp;face=1&amp;color=0&amp;mcs=0&amp;a_q=&amp;n_q=&amp;o_q=&amp;sm=tab_etc"><img
						src="https://search.pstatic.net/common?type=a&amp;size=120x150&amp;quality=95&amp;direct=true&amp;src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F158%2F201701031338332821.jpg"
						alt="가수 유수영 이미지" width="120" height="150"
						onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"></a>
					<a nocr=""
						onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.edit&amp;i='+'1800000D_000000017138');"
						class="btn_profile_update" href="http://myprofile.naver.com"
						target="_blank"><span class="blind">가수 유수영</span>내 인물정보 수정</a>
				</div>
				<dl class="detail_profile">
					<dd class="name">
						<a nocr=""
							onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.namepeople&amp;i='+'1800000D_000000017138');"
							href="https://people.search.naver.com/search.naver?where=nexearch&amp;query=%EC%9C%A0%EC%88%98%EC%98%81&amp;sm=tab_etc&amp;ie=utf8&amp;key=PeopleService&amp;os=94520"
							target="_blank"><strong>유수영</strong></a> <span>가수, 뮤지컬배우</span>
					</dd>
					<dt>신체</dt>
					<dd>
						<span>162cm</span>, <span>44kg</span>
					</dd>
					<dt>소속그룹</dt>
					<dd>
						<a nocr=""
							onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.group&amp;i='+'1800000D_000000017138');"
							href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjky&amp;pkid=1&amp;os=94630&amp;query=s.e.s.">S.E.S.</a>
					</dd>
					<dt>가족</dt>
					<dd>
						배우자 <a nocr=""
							onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.family&amp;i='+'1800000D_000000017138');"
							href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjky&amp;pkid=1&amp;os=117671&amp;query=%EC%9E%84%ED%9A%A8%EC%84%B1">
							임효성</a>
					</dd>
					<dt>학력</dt>
					<dd>
						<a nocr=""
							onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.school&amp;i='+'1800000D_000000017138');"
							href="?where=nexearch&amp;sm=tab_etc&amp;query=%ED%95%9C%EA%B5%AD%EC%BC%84%ED%8A%B8%EC%99%B8%EA%B5%AD%EC%9D%B8%ED%95%99%EA%B5%90">한국켄트외국인학교</a>
					</dd>
					<dt>데뷔</dt>
					<dd>
						<span>1997년 S.E.S 1집 앨범 [I'm Your Girl]</span>
					</dd>
					<dt>수상</dt>
					<dd>2015년 MTN 방송광고 페스티벌 CF모델부문 여자 스타상</dd>
					<dt>사이트</dt>
					<dd>
						<a nocr=""
							onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.instagram&amp;i='+'1800000D_000000017138');"
							href="http://instagram.com/shoodesu" target="_blank">인스타그램</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="go_relate">
			<div class="offer_more2">
				<div class="confirm">
					<em>본인참여</em> 2018.06.26. <a nocr="" href="javascript:;"
						id="more_div_btn"><img
						src="https://ssl.pstatic.net/sstatic/search/img/ico_help.gif"
						width="12" height="12" alt="네이버 인물정보 도움말"></a>
				</div>
				<div style="left: -65px; width: 286px; visibility: hidden;"
					class="layer_tooltip_wrap" id="tooltip_layer">
					<div class="layer_tooltip2">
						<div class="content">
							<p>
								당사자 본인이 직접 또는 그 대리인을 통해 네이버에<br>제공한 자료를 중심으로 제공하는 인물정보입니다.<br>본인
								또는 그 대리인이 마지막으로 신청한 건이 처리된<br>날짜가 본인참여 일자로 표시됩니다.
							</p>
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.imaginfmy&amp;r=1&amp;i=1800000D_000000017138+1800000D_000000033704&amp;u=' + urlencode(this.href));"
								href="https://myprofile.naver.com/Main.nhn" class="request"
								target="_blank">인물정보 수정신청</a>, <a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.imaginfcs&amp;r=1&amp;i=1800000D_000000017138+1800000D_000000033704&amp;u=' + urlencode(this.href));"
								href="https://help.naver.com/support/alias/search/people/people_0.naver"
								class="helpdesk" target="_blank">네이버 고객센터</a> <a nocr=""
								onclick="fnLayerClose();return false;" href="javascript:;"
								class="closelayer C"><img
								src="https://ssl.pstatic.net/sstatic/search/images11/btn_layer_close.gif"
								width="10" height="9" alt="네이버 인물정보 도움말 닫기"></a> <span
								class="arw detail C"></span>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				$Fn(fnLayerOpen).attach($('more_div_btn'), "click");
				function fnLayerOpen(e) {
					$('tooltip_layer').style.visibility = "visible";
					goOtherTCR(this,
							'a=nco_x29*3.imaginf&r=1&i=1800000D_000000017138+1800000D_000000033704');
				}
				function fnLayerClose(e) {
					$('tooltip_layer').style.visibility = "hidden";
					$('more_div_btn').focus();
					goOtherTCR(this,
							'a=nco_x29*3.imaginfclose&r=1&i=1800000D_000000017138+1800000D_000000033704');
				}
			</script>
			<a nocr=""
				onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.profiledetail&amp;i='+'1800000D_000000017138');"
				href="https://people.search.naver.com/search.naver?where=nexearch&amp;query=%EC%9C%A0%EC%88%98%EC%98%81&amp;sm=tab_etc&amp;ie=utf8&amp;key=PeopleService&amp;os=94520"
				class="btn_txt_more" target="_blank"><span class="blind">가수
					유수영</span>인물정보 더보기</a>
		</div>
		<script type="text/javascript">
			var __sDefaultPeopleTab = "네이버TV";
		</script>
		<div class="people_type" id="tx_ca_people_workall">
			<div class="texttab_type">
				<ul>
					<li id="tx_ca_people_tvcast_tab" class="select"><a nocr="1"
						href="#" class="pg_btn">네이버TV</a></li>
					<li id="tx_ca_people_album_tab"><a nocr="1" href="#"
						class="pg_btn">앨범</a></li>
					<li id="tx_ca_people_play_tab"><a nocr="1" href="#"
						class="pg_btn">공연</a></li>
					<li id="tx_ca_people_onair_tab"><a nocr="1" href="#"
						class="pg_btn">방송</a></li>
					<li id="tx_ca_people_movie_tab"><a nocr="1" href="#"
						class="pg_btn">영화</a></li>
				</ul>
			</div>
			<div class="lst_cont tvcast " style="display: block;">
				<h3 class="blind">네이버TV</h3>
				<ul>
					<li>
						<div class="thumb_box">
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.tvcimg&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
								target="_blank" href="https://tv.naver.com/v/4439961"> <img
								src="https://search.pstatic.net/common?type=ofullfill_black&amp;size=128x72&amp;quality=95&amp;direct=true&amp;src=https%3A%2F%2Fphinf.pstatic.net%2Ftvcast%2F20181105_79%2F4T9HL_1541386603328cHiGt_PNG%2FTnm1CiGKjhH9.png"
								alt="S.E.S. - I`m Your Girl" width="128" height="72"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""> <span class="ico_play"></span> <span
								class="runtime"><span class="bg">재생시간</span><em>3분
										39초</em></span> <span class="img_bd"></span>
							</a>
						</div>
						<div class="txt_box">
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.tvctit&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
								target="_blank" href="https://tv.naver.com/v/4439961"
								class="cast_txt">S.E.S. - I`m Your Girl</a> <span
								class="day_txt">2018.11.05.</span>
						</div>
					</li>
					<li>
						<div class="thumb_box">
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.tvcimg&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
								target="_blank" href="https://tv.naver.com/v/4439681"> <img
								src="https://search.pstatic.net/common?type=ofullfill_black&amp;size=128x72&amp;quality=95&amp;direct=true&amp;src=https%3A%2F%2Fphinf.pstatic.net%2Ftvcast%2F20181105_147%2Fxxw2h_1541384848821BluvX_PNG%2FrZaDVYInm4vy.png"
								alt="S.E.S. - I`m Your Girl(feat. 앤디, 에릭)" width="128"
								height="72"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""> <span class="ico_play"></span> <span
								class="runtime"><span class="bg">재생시간</span><em>3분
										36초</em></span> <span class="img_bd"></span>
							</a>
						</div>
						<div class="txt_box">
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.tvctit&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
								target="_blank" href="https://tv.naver.com/v/4439681"
								class="cast_txt">S.E.S. - I`m Your Girl(...</a> <span
								class="day_txt">2018.11.05.</span>
						</div>
					</li>
					<li>
						<div class="thumb_box">
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.tvcimg&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
								target="_blank" href="https://tv.naver.com/v/2711312"> <img
								src="https://search.pstatic.net/common?type=ofullfill_black&amp;size=128x72&amp;quality=95&amp;direct=true&amp;src=https%3A%2F%2Fphinf.pstatic.net%2Ftvcast%2F20190220_254%2FTSQgC_15506461447966bSVC_JPEG%2FCA201802130078.jpg"
								alt="집에 꼭 한 명씩 있다는 그분?" width="128" height="72"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""> <span class="ico_play"></span> <span
								class="runtime"><span class="bg">재생시간</span><em>2분
										50초</em></span> <span class="img_bd"></span>
							</a>
						</div>
						<div class="txt_box">
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.tvctit&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
								target="_blank" href="https://tv.naver.com/v/2711312"
								class="cast_txt">집에 꼭 한 명씩 있다는 그분?</a> <span class="day_txt">2018.02.13.</span>
						</div>
					</li>
					<li>
						<div class="thumb_box">
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.tvcimg&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
								target="_blank" href="https://tv.naver.com/v/2711315"> <img
								src="https://search.pstatic.net/common?type=ofullfill_black&amp;size=128x72&amp;quality=95&amp;direct=true&amp;src=https%3A%2F%2Fphinf.pstatic.net%2Ftvcast%2F20190220_83%2Fz0EGb_155064615251631qIj_JPEG%2FCA201802130081.jpg"
								alt="산후조리용 클럽 댄스 전수!!" width="128" height="72"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""> <span class="ico_play"></span> <span
								class="runtime"><span class="bg">재생시간</span><em>2분
										33초</em></span> <span class="img_bd"></span>
							</a>
						</div>
						<div class="txt_box">
							<a nocr=""
								onclick="return goOtherCR(this, 'a=nco_x29*3.tvctit&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
								target="_blank" href="https://tv.naver.com/v/2711315"
								class="cast_txt">산후조리용 클럽 댄스 전수!!</a> <span class="day_txt">2018.02.13.</span>
						</div>
					</li>
				</ul>
				<a nocr=""
					onclick="return goOtherCR(this, 'a=nco_x29*3.tvcmore&amp;r=1&amp;i=1800000D_000000017138&amp;u=' + urlencode(this.href));"
					target="_blank" class="more_view"
					href="http://tv.naver.com/search/clip?query=유수영&amp;sort=date"><span
					class="blind">네이버TV </span>더보기</a>
			</div>
			<div class="lst_cont albumlist" id="tx_ca_people_album_content"
				style="display: none;">
				<h3 class="blind">앨범</h3>
				<ul>
					<li><div class="thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.albumimage&amp;i='+'1800000D_000000017138');"
								href="https://vibe.naver.com/album/1771371" target="_blank"><img
								src="https://search.pstatic.net/common?type=o&amp;size=78x71&amp;quality=95&amp;direct=true&amp;src=https%3A%2F%2Fmusicmeta-phinf.pstatic.net%2Falbum%2F001%2F771%2F1771371.jpg%3Ftype%3Dr204Fll%26v%3D20190813023526"
								alt="Remember - S.E.S. 20th Anniversary Special Album"
								width="78" height="71"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""><img height="75" width="84" class="bg_album"
								alt=""
								src="https://ssl.pstatic.net/sstatic/search/images11/blank.gif"></a>
						</div>
						<dl>
							<dt>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.albumtitle&amp;i='+'1800000D_000000017138');"
									class="sh_people_title sh_people_link"
									href="https://vibe.naver.com/album/1771371" target="_blank"
									title="Remember - S.E.S. 20th Anniversary Special Album">Remember
									...</a>
							</dt>
							<dd>S.E.S.</dd>
							<dd>2017.01.02</dd>
						</dl></li>
					<li><div class="thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.albumimage&amp;i='+'1800000D_000000017138');"
								href="https://vibe.naver.com/album/1616938" target="_blank"><img
								src="https://search.pstatic.net/common?type=o&amp;size=78x71&amp;quality=95&amp;direct=true&amp;src=https%3A%2F%2Fmusicmeta-phinf.pstatic.net%2Falbum%2F001%2F616%2F1616938.jpg%3Ftype%3Dr204Fll%26v%3D20190402193022"
								alt="Love [story] - SM STATION" width="78" height="71"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""><img height="75" width="84" class="bg_album"
								alt=""
								src="https://ssl.pstatic.net/sstatic/search/images11/blank.gif"></a>
						</div>
						<dl>
							<dt>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.albumtitle&amp;i='+'1800000D_000000017138');"
									class="sh_people_title sh_people_link"
									href="https://vibe.naver.com/album/1616938" target="_blank"
									title="Love [story] - SM STATION">Love [sto...</a>
							</dt>
							<dd>S.E.S.</dd>
							<dd>2016.11.28</dd>
						</dl></li>
					<li><div class="thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.albumimage&amp;i='+'1800000D_000000017138');"
								href="https://vibe.naver.com/album/167271" target="_blank"><img
								src="https://search.pstatic.net/common?type=o&amp;size=78x71&amp;quality=95&amp;direct=true&amp;src=https%3A%2F%2Fmusicmeta-phinf.pstatic.net%2Falbum%2F000%2F167%2F167271.jpg%3Ftype%3Dr204Fll%26v%3D20181212190158"
								alt="Devote One's Love (Single)" width="78" height="71"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""><img height="75" width="84" class="bg_album"
								alt=""
								src="https://ssl.pstatic.net/sstatic/search/images11/blank.gif"></a>
						</div>
						<dl>
							<dt>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.albumtitle&amp;i='+'1800000D_000000017138');"
									class="sh_people_title sh_people_link"
									href="https://vibe.naver.com/album/167271" target="_blank"
									title="Devote One" s="" love="" (single)'="">Devote On...</a>
							</dt>
							<dd>유수영</dd>
							<dd>2010.01.08</dd>
						</dl></li>
				</ul>
			</div>
			<div class="lst_cont" id="tx_ca_people_play_content"
				style="display: none;">
				<h3 class="blind">공연</h3>
				<ul>
					<li>
						<div class="big_thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.playimage&amp;i='+'1800000D_000000017138');"
								href="?where=nexearch&amp;sm=tab_etc&amp;query=%EA%B3%B5%EC%97%B0%20%EC%8A%A4%ED%8E%98%EC%85%9C%20%EB%9D%BC%EC%9D%B4%EC%96%B4%20-%20%EC%9D%B8%EC%B2%9C"
								target="_blank"><img
								src="https://search.pstatic.net/common?type=mfullfill&amp;size=66x80&amp;quality=95&amp;direct=true&amp;src=http%3A%2F%2Fdbscthumb.phinf.naver.net%2F4209_000_3%2F20170613112107229_BSQUTJDQ7.png%2F%25EC%258A%25A4%25ED%258E%2598.png%3Ftype%3Dr160"
								alt="스페셜 라이어 - 인천" width="66" height="80"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""></a>
						</div>
						<dl>
							<dd>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.playtitle&amp;i='+'1800000D_000000017138');"
									class="sh_people_title sh_people_link"
									href="?where=nexearch&amp;sm=tab_etc&amp;query=%EA%B3%B5%EC%97%B0%20%EC%8A%A4%ED%8E%98%EC%85%9C%20%EB%9D%BC%EC%9D%B4%EC%96%B4%20-%20%EC%9D%B8%EC%B2%9C"
									target="_blank" title="스페셜 라이어 - 인천">스페셜 라이어 -...</a>
							</dd>
							<dt>인천종합문화예술회관 대공연장</dt>
							<dd>2017.09.15 ~ 2017.09.16</dd>
						</dl>
					</li>
					<li>
						<div class="big_thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.playimage&amp;i='+'1800000D_000000017138');"
								href="http://www.cwcf.or.kr/art_info/art_info_view.asp?p_idx=2713"
								target="_blank"><img
								src="https://search.pstatic.net/common?type=mfullfill&amp;size=66x80&amp;quality=95&amp;direct=true&amp;src=http%3A%2F%2Fdbscthumb.phinf.naver.net%2F4209_000_1%2F20170719191535802_9TDYDNB15.png%2F%25EC%258A%25A4%25EB%259D%25BC.png%3Ftype%3Dr160"
								alt="스페셜 라이어 - 창원" width="66" height="80"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""></a>
						</div>
						<dl>
							<dd>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.playtitle&amp;i='+'1800000D_000000017138');"
									class="sh_people_title sh_people_link"
									href="http://www.cwcf.or.kr/art_info/art_info_view.asp?p_idx=2713"
									target="_blank" title="스페셜 라이어 - 창원">스페셜 라이어 -...</a>
							</dd>
							<dt>창원성산아트홀 대극장</dt>
							<dd>2017.09.09 ~ 2017.09.10</dd>
						</dl>
					</li>
					<li class="last">
						<div class="big_thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.playimage&amp;i='+'1800000D_000000017138');"
								href="?where=nexearch&amp;sm=tab_etc&amp;query=%EA%B3%B5%EC%97%B0%20%EC%8A%A4%ED%8E%98%EC%85%9C%20%EB%9D%BC%EC%9D%B4%EC%96%B4%20-%20%EC%A0%84%EC%A3%BC"
								target="_blank"><img
								src="https://search.pstatic.net/common?type=mfullfill&amp;size=66x80&amp;quality=95&amp;direct=true&amp;src=http%3A%2F%2Fdbscthumb.phinf.naver.net%2F4209_000_3%2F20170613133940623_R9YYZ5KB2.jpg%2F%25EC%258A%25A4%25ED%258E%2598.jpg%3Ftype%3Dr160"
								alt="스페셜 라이어 - 전주" width="66" height="80"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""></a>
						</div>
						<dl>
							<dd>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.playtitle&amp;i='+'1800000D_000000017138');"
									class="sh_people_title sh_people_link"
									href="?where=nexearch&amp;sm=tab_etc&amp;query=%EA%B3%B5%EC%97%B0%20%EC%8A%A4%ED%8E%98%EC%85%9C%20%EB%9D%BC%EC%9D%B4%EC%96%B4%20-%20%EC%A0%84%EC%A3%BC"
									target="_blank" title="스페셜 라이어 - 전주">스페셜 라이어 -...</a>
							</dd>
							<dt>한국소리문화의전당 모악당</dt>
							<dd>2017.09.01 ~ 2017.09.02</dd>
						</dl>
					</li>
				</ul>
				<a nocr=""
					onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.wtplaymore&amp;i='+'1800000D_000000017138');"
					class="more_view"
					href="https://people.search.naver.com/search.naver?where=nexearch&amp;query=%EC%9C%A0%EC%88%98%EC%98%81&amp;sm=tab_etc&amp;ie=utf8&amp;key=PeopleService&amp;os=94520"
					target="_blank"><span class="blind">공연 </span>더보기</a>
			</div>
			<div class="lst_cont" id="tx_ca_people_onair_content"
				style="display: none;">
				<h3 class="blind">방송</h3>
				<ul>
					<li>
						<div class="big_thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.dramaimage&amp;i='+'1800000D_000000017138');"
								href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjkw&amp;x_csa=%7B%22pkid%22%3A%2257%22%2C%22os%22%3A%22674457%22%7D&amp;pkid=57&amp;os=674457&amp;query=%ED%86%A0%EC%9A%94%EC%9D%BC%EC%9D%B4%EC%A2%8B%EB%8B%A4%EC%98%A4%EB%A7%88%EC%9D%B4%EB%B2%A0%EC%9D%B4%EB%B9%84"><img
								src="https://search.pstatic.net/common?type=o&amp;size=58x82&amp;quality=95&amp;direct=true&amp;src=http%3A%2F%2Fsstatic.naver.net%2Fkeypage%2Fimage%2Fdss%2F57%2F67%2F44%2F57%2F57_674457_poster_image_1454639763772.jpg"
								alt="오! 마이 베이비" width="58" height="82"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""></a>
						</div>
						<dl>
							<dd>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.dramatitle&amp;i='+'1800000D_000000017138');"
									href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjkw&amp;x_csa=%7B%22pkid%22%3A%2257%22%2C%22os%22%3A%22674457%22%7D&amp;pkid=57&amp;os=674457&amp;query=%ED%86%A0%EC%9A%94%EC%9D%BC%EC%9D%B4%EC%A2%8B%EB%8B%A4%EC%98%A4%EB%A7%88%EC%9D%B4%EB%B2%A0%EC%9D%B4%EB%B9%84">오!
									마이 베이비</a>
							</dd>
							<dd>2015 ~ 2016</dd>
						</dl>
					</li>
					<li>
						<div class="big_thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.dramaimage&amp;i='+'1800000D_000000017138');"
								href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjkw&amp;x_csa=%7B%22pkid%22%3A%2257%22%2C%22os%22%3A%222227799%22%7D&amp;pkid=57&amp;os=2227799&amp;query=%ED%9C%B4%EB%A8%BC%EB%8B%A4%ED%81%90%EB%B6%80%EB%B6%80%EC%9D%BC%EA%B8%B0"><img
								src="https://search.pstatic.net/common?type=o&amp;size=58x82&amp;quality=95&amp;direct=true&amp;src=http%3A%2F%2Fsstatic.naver.net%2Fkeypage%2Fimage%2Fdss%2F57%2F22%2F77%2F99%2F57_2227799_poster_image_1418024879066.jpg"
								alt="휴(休)먼다큐 부부일기" width="58" height="82"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""></a>
						</div>
						<dl>
							<dd>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.dramatitle&amp;i='+'1800000D_000000017138');"
									href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjkw&amp;x_csa=%7B%22pkid%22%3A%2257%22%2C%22os%22%3A%222227799%22%7D&amp;pkid=57&amp;os=2227799&amp;query=%ED%9C%B4%EB%A8%BC%EB%8B%A4%ED%81%90%EB%B6%80%EB%B6%80%EC%9D%BC%EA%B8%B0"
									title="휴(休)먼다큐 부부일기">휴(休)먼다큐 부...</a>
							</dd>
							<dd>2014</dd>
						</dl>
					</li>
					<li class="last">
						<div class="big_thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.dramaimage&amp;i='+'1800000D_000000017138');"
								href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjkw&amp;x_csa=%7B%22pkid%22%3A%2257%22%2C%22os%22%3A%22665647%22%7D&amp;pkid=57&amp;os=665647&amp;query=%EC%95%84%EB%82%B4%EB%A5%BC%EB%B6%80%ED%83%81%ED%95%B4"><img
								src="https://search.pstatic.net/common?type=o&amp;size=58x82&amp;quality=95&amp;direct=true&amp;src=http%3A%2F%2Fsstatic.naver.net%2Fkeypage%2Fimage%2Fdss%2F57%2F0%2F0%2F162%2F162258.jpg"
								alt="아내를 부탁해" width="58" height="82"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""></a>
						</div>
						<dl>
							<dd>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.dramatitle&amp;i='+'1800000D_000000017138');"
									href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjkw&amp;x_csa=%7B%22pkid%22%3A%2257%22%2C%22os%22%3A%22665647%22%7D&amp;pkid=57&amp;os=665647&amp;query=%EC%95%84%EB%82%B4%EB%A5%BC%EB%B6%80%ED%83%81%ED%95%B4">아내를
									부탁해</a>
							</dd>
							<dd>2010</dd>
						</dl>
					</li>
				</ul>
				<a nocr=""
					onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.wtonairmore&amp;i='+'1800000D_000000017138');"
					class="more_view"
					href="https://people.search.naver.com/search.naver?where=nexearch&amp;query=%EC%9C%A0%EC%88%98%EC%98%81&amp;sm=tab_etc&amp;ie=utf8&amp;key=PeopleService&amp;os=94520"
					target="_blank"><span class="blind">방송 </span>더보기</a>
			</div>
			<div class="lst_cont" id="tx_ca_people_movie_content"
				style="display: none;">
				<h3 class="blind">영화</h3>
				<ul>
					<li>
						<div class="big_thumb">
							<a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.movieimage&amp;i='+'1800000D_000000017138');"
								href="https://movie.naver.com/movie/bi/mi/basic.nhn?code=69266"
								target="_blank"><img
								src="https://search.pstatic.net/common?type=ofullfill&amp;size=56x80&amp;quality=95&amp;direct=true&amp;src=https%3A%2F%2Fssl.pstatic.net%2Fimgmovie%2Fmdi%2Fmi%2F0692%2FF9266-00.jpg"
								alt="잘못된 만남" width="56" height="80"
								onerror="tx_noimage_thumb(this, 'sp_noimg', 'https://ssl.pstatic.net/sstatic/search/images11/blank.gif');"
								class=""></a>
						</div>
						<dl>
							<dd>
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.movietitle&amp;i='+'1800000D_000000017138');"
									class="sh_people_title sh_people_link"
									href="https://movie.naver.com/movie/bi/mi/basic.nhn?code=69266"
									target="_blank">잘못된 만남</a>
							</dd>
							<dt>조연 - 일도의 아내, 연희</dt>
							<dd>2008</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			nhn.peopleTabView = function(a) {
				var d = a;
				for (var b = 0, c = d.length; b < c; b++) {
					new nhn.peopleTabView.Tab(d[b]);
				}
			};
			nhn.peopleTabView.Tab = $Class({
				$init : function(b) {
					var a = $$.getSingle(">div.texttab_type>ul", b);
					this.aTab = $$(">li>a", a);
					this.aLayer = $$(">div.lst_cont", b);
					this.htClickArea = {
						"영화" : "nco_x29*3.wtmovie",
						"앨범" : "nco_x29*3.wtmusic",
						"선거이력" : "nco_x29*3.telection",
						"경기성적" : "nco_x29*3.wtsports",
						"공연" : "nco_x29*3.wtplay",
						"주요근황" : "nco_x29*3.wtrecent",
						"방송" : "nco_x29*3.wtonair",
						"도서" : "nco_x29*3.wtbook",
						"웹툰" : "nco_x29*3.wtwebtoon",
						"미술작품" : "nco_x29*3.wtarts",
						"사진작품" : "nco_x29*3.wtphoto",
						"칼럼" : "nco_x29*3.wtcolumn",
						"네이버TV" : "nco_x29*3.tvc",
						"그라폴리오" : "nco_x29*3.gra",
						"아트" : "nco_x29*3.art",
						"명언" : "nco_x29*3.quotation",
						"지식iN" : "nco_x29*3.wtkin",
						"전시" : "nco_x29*3.exh"
					};
					$Fn(this.click, this).attach(a, "click");
					this.initTab();
				},
				click : function(a) {
					a.stop();
					var d = a.element;
					if (d.tagName == "A") {
						for (var c = 0, f = this.aTab.length; c < f; c++) {
							var b = $Element(this.aTab[c]).parent();
							if (this.aTab[c] == d) {
								if (!b.hasClass("select")) {
									b.addClass("select");
								}
								$Element(this.aLayer[c]).show();
								nhn.common.ellipsis(this.aLayer[c]);
							} else {
								b.removeClass("select");
								$Element(this.aLayer[c]).hide();
							}
						}
						try {
							for ( var c in this.htClickArea) {
								if (d.innerHTML.match(new RegExp(c))) {
									goOtherTCR(
											this,
											("a=" + this.htClickArea[c]
													+ "&r=1&i=" + txinfo_people_gdid));
									break;
								}
							}
						} catch (g) {
						}
					}
				},
				initTab : function() {
					try {
						if (__sDefaultPeopleTab && __sDefaultPeopleTab != "") {
							for (var b = 0, c = this.aTab.length; b < c; b++) {
								var a = $Element(this.aTab[b]).parent();
								if ($Element(this.aTab[b]).html().match(
										__sDefaultPeopleTab)) {
									if (!a.hasClass("select")) {
										a.addClass("select");
									}
									$Element(this.aLayer[b]).show();
								} else {
									a.removeClass("select");
									$Element(this.aLayer[b]).hide();
								}
							}
						}
					} catch (d) {
					}
				}
			});
			if ($("tx_ca_people_workall")) {
				var aPeopleType = [ $("tx_ca_people_workall") ];
				nhn.peopleTabView(aPeopleType);
			} else {
				$Fn(function() {
					var a = [ $("tx_ca_people_workall") ];
					nhn.peopleTabView(a);
				}).attach(window, "load");
			}
			var elTxCaPeopleKinContent = $("tx_ca_people_kin_content");
			if (elTxCaPeopleKinContent)
				nhn.common.ellipsis(elTxCaPeopleKinContent);
		</script>
		<script type="text/javascript"> function tx_noimage_thumb(img, className, noimage) { img.onerror = null; if (noimage) { img.src = noimage; } else { img.src = "https://ssl.pstatic.net/sstatic/search/images11/blank.gif"; } if (img.alt == '') { img.alt = "이미지 준비중"; } else { img.alt = img.alt + " 준비중"; } if (className) { img.className = className; } } function tx_set_href(a) { if(a.href) a.href = a.href.replace(/&query=[^&]*/g, "&query=" + headerfooter_query_encoded_utf8); } </script>
		<div class="same_name pp3">
			<h3>동명이인</h3>
			<div class="wrap_same_list">
				<ul class="same_list">
					<li><div class="temp">
							<span><a nocr=""
								onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.namesimage&amp;i='+'1800000D_000000033704');"
								href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjky&amp;pkid=1&amp;os=210692&amp;query=%EC%8A%88"><img
									src="https://ssl.pstatic.net/sstatic/keypage/outside/scui/people/img/no_img8.gif"
									alt="가수 준비중" width="56" height="70"><span class="mask"></span></a></span>
						</div>
						<div class="same_con">
							<h4 class="scm_ellipsis _ellipsis">
								<a nocr=""
									onclick="return goOtherCR(this, 'u='+urlencode(this.href)+'&amp;r=1&amp;a='+nco_area_94520_210692+'.names&amp;i='+'1800000D_000000033704');"
									href="?where=nexearch&amp;sm=tab_etc&amp;mra=bjky&amp;pkid=1&amp;os=210692&amp;query=%EC%8A%88">슈</a>
							</h4>
							<span class="job">가수</span><span class="birth">1980</span>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>