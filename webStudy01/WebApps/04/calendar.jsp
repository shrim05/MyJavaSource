<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Calendar"%>
<%@page import="static java.util.Calendar.*"%><!-- 스태틱임포트구문 // 스태틱요소들을 바로 사용가능해진다-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/calendar.jsp</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function eventHandler(year, month) {
		var form = document.calForm;
		if(year&&month>=0){
			form.year.value = year;
			form.month.value = month;
		}
		form.submit();
	}
</script>
</head>
<%
String yearStr = request.getParameter("year");
String monthStr = request.getParameter("month");
String lang = request.getParameter("lang");
Calendar cal = Calendar.getInstance();
if(yearStr!=null && yearStr.matches("\\d{4}") &&
	monthStr!=null&&monthStr.matches("\\d{1,2}")){
	cal.set(YEAR,Integer.parseInt(yearStr));
	cal.set(MONTH,Integer.parseInt(monthStr));
}

//현재 시간
int year  = cal.get(YEAR);
int month = cal.get(MONTH);
int currentDate = cal.get(DAY_OF_MONTH);
//이전달
cal.add(MONTH, -1);
int beforeYear = cal.get(YEAR);
int beforeMonth = cal.get(MONTH);
//다음달 
cal.add(MONTH, 2);
int nextYear = cal.get(YEAR);
int nextMonth = cal.get(MONTH);

//다시 현재 월로 변경
cal.add(MONTH,-1);

//해당 달의 첫번째 날
cal.set(DAY_OF_MONTH, 1);
int date = cal.get(DAY_OF_WEEK);
int offset = date - 1;
int lastday = cal.getActualMaximum(DAY_OF_MONTH);

Locale[] locales = Locale.getAvailableLocales();
Locale currentLocale = request.getLocale();
if(StringUtils.isNotBlank(lang)){
	currentLocale = Locale.forLanguageTag(lang);
}

DateFormatSymbols dfs = new DateFormatSymbols(currentLocale);
String[] months = dfs.getMonths();
String[] weekDays = dfs.getWeekdays();
%>
<body>

<h4><%=String.format("%d년 %d월",year,month+1) %></h4>
<%//get방식으로 처리할 경우, 새로운 요소 추가할 대마다 href 경로 수정 등 수정사항이 많음. 해당 요소들을 form의 submit방식으로 통일하여 
//request전달 하기 위해 javascript 함수 활용 %>
<a href="#" onclick="eventHandler(<%=beforeYear%>,<%=beforeMonth%>)">이전달</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<form name="calForm" method="post">
	<input type="number" name="year" value="<%=year%>"
	onblur="eventHandler();" />년
	<select name="month" onchange="eventHandler();">
		<%
		for(int idx=0; idx<months.length-1;idx++){
		%>"<option <%=idx==month?"selected":"" %> value=<%=idx%>><%=months[idx]%></option>"
		<%
		}
	 	%>
	</select>
	<select name="lang" onchange="eventHandler();">
		<% 
			for( Locale tmp : locales){
				if(StringUtils.isNotBlank(tmp.getDisplayLanguage())){
		%>
				<option <%= tmp.equals(currentLocale)?"selected":"" %> value="<%=tmp.toLanguageTag()%>"><%=tmp.getDisplayLanguage(tmp) %></option>
		<%		
				}
			}
		%>
	</select>
</form>
<a href="javascript:eventHandler(<%=nextYear%>,<%=nextMonth%>)">다음달</a>
 <table>
 	<thead>
 		<tr>
 		<% 
 			for(String tmp : weekDays){
 				if(StringUtils.isNotBlank(tmp)){
 					%>
	 			<th><%=tmp%></th>
 				<%
 				}
 			}
 		%>
 		</tr>
	</thead> 
 	<tbody>
 <%
 	int count = 1;
     for(int row=0; row<6 ; row++){
         out.println("<tr>");
         for(int col= 0;col<7;col++){
	        int display = count++ - offset;
   			String displayStr = display+"";
        	if(display<1 || display>lastday){
        		displayStr = "&nbsp;";
        	}
			out.println(String.format("<td>%s</td>", displayStr));
         }
         out.println("</tr>");
     }
 %>
 </tbody>
 </table>
<script type="text/javascript">
	$("td, th").css({border:"1px solid black"});
	$("td:first-child, th:first-child").css({color:"red"});
	$("td:last-child, th:last-child").css({color:"blue"});
	$("table").css({width:"100%", height:"500px",borderCollapse:"collapse"});
	var today = new Date();
	if(today.getFullYear() == <%=year%> &&today.getMonth()==<%=month%>){
		var date = today.getDate();
		var tds = $("td");
		for(var idx=0; idx<tds.length;idx++){
			if($(tds[idx]).text()==date){
				$(tds[idx]).css('backgroundColor','green');
			}
		}
	}
	
</script>
</body>
</html>