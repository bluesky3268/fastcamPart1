# CGI(Common Gateway Interface)란 
웹 서버와 애플리케이션 사이에 데이터를 주고 받는 규약을 뜻한다.
* CGI 규칙에 따라 만들어진 프로그램을 CGI 프로그램이라고 하고
* 컴파일 방식(C, C++, Java 등)과 인터프리터 방식(PHP, Python 등)으로 나뉜다.

### 인터프리터 방식 CGI 프로그램
> 웹 서버 <-> Script engine <-> Script 파일

### 서블릿과 서블릿 컨테이너
> 웹 서버 <-> Servlet Container <-> Servlet 파일

* Servlet(Server + Applet)
  * 자바에서 웹 애플리케이션을 만드는 기술
  * 자바에서 동적 웹 페이지를 구현하기 위한 표준

* Servlet Container
  * 서블릿의 생명주기를 관리한다.
  * 웹 서버와 소켓을 만들고 통신하는 과정을 대신해 준다.(개발자는 비지니스 로직 구현에만 집중)
  * 서블릿 객체를 싱글톤으로 관리한다.
    * Thread safety하지 않기 때문에 우리는 stateless상태로 설계해야 한다.

* WAS와 서블릿 컨테이너 
  * WAS는 서블릿 컨테이너를 포함하는 개념
  * WAS는 매 요청마다 쓰레드를 생성하는 것이 아니라 쓰레드 풀에서 이미 생성되어 있는 쓰레드를 가져와서 사용한 후 반납함
  * max thread가 주요 튜닝 포인트
  * 대표적인 WAS는 톰캣

* Servlet interface
  * UserDefinedServlet(concrete class) -> javax.servlet.http.HttpServlet(abstract class) -> javax.servlet.GenericServlet(abstract class) -> Javax.servlet.Servlet(interface)
  
  * 서블릿 컨테이너가 서블릿 인터페이스에 있는 메서드들을 호출한다.
  * 생명주기와 관련된 메서드 : init(), service(), destroy()
  * 기타 메서드 : getServletConfig(), getServletInfo()