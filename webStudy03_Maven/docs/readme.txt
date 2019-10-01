<English>
GETTING STARTED
Building ddit basic framework 

This guide walks you through the process of building the ddit Framework.

What you’ll build
You’ll build a service that will accept all HTTP requests at:
FrontController(which serves FrontController role as it names)

It helps to reduce duplicated process
Main role :
1. setEncoding as UTF-8
2. dispatch or redirect to view side as POJO or JSP process set 

You can add any function as required(ex: authentication procedure)

It is builded based on as below list.
(You need to set up build-path as required)

JDK 1.8 or later


How to build basic set up
1. set up web.xml (Servlet config file)
1-1. set up FrontController mapping information.
Ex)
<servlet>
<servlet-name>FrontController</servlet-name>
<servlet-class>(Your.ImportedPackage.Path).FrontController</servlet-class>

1-2. list-up packages you want to connect with FrontController.
it is distinguished by blank or newline
 
 
 <한글>
 1. 프레임워크의 FrontController를 web.xml에 등록하여, 프레임워크의 컨텍스트를 형성.
  1) 등록시, basePackages(컨트롤러패키지 -스캔의 대상),
           prefix(뷰레이어 영역),
           suffix(뷰레이어 확장자) 파라미터설정
  2) FrontController는 요청 이전에 객체가 생성됨
 2. 프레임워크의 구조에 기반하여 사용자는 다음 규칙에 따라
    Command Handler(Back Controller) 와 View layer 를 구현함.
    1) Command Handler
       - @CommandHandler로 핸들러를 프레임워크의 컨텍스트에 등록
       - @URIMapping(URI, Http request method) 정보를 설정하여,
        특정 요청에 대한 1:1 구조의 핸들러 메소드 등록
       - 핸들러 메소드는 public 접근자와,
        HttpServletRequest, HttpServletResponse 파라미터,
        String 반환 타입이 필요함.
       - 핸들러 메소드는 논리적 뷰네임을 반환하며,
        각 뷰레이어가 prfix로 설정한 영역에 위치함을 전제로 prefix와 suffix 가 제거된 형태의 논리적 네임을 가짐.
       - redirect 구조를 사용하기 위해서는 논리적 네임에 "redirect:"접두어를 적용함.