# 프론트 컨트롤러 패턴
* 모든 요청을 하나의 핸들러에서 처리하는 패턴을 말한다.
* 스프링 MVC가 그 대표적인 예로 DispatcherServlet이 프론트 컨트롤러이다.

# Foward VS redirect
## Foward 
* 서블릿에서 클라이언트로 다시 가지 않고 다른 서블릿(JSP)에게 요청하는 방식
* 서버 내부에서 일어나는 요청이므로 HttpServletRequest, HttpServletResponse 객체는 새롭게 생성되지 않는다.
```
 RequestDispatcher dispatcher = request.getRequestDispatcher("포워드할 서블릿");
 dispatcher.forward(request, response)
```

## Redirect 
* 서블릿이 클라이언트를 다시 거쳐서 다른 서블릿에게 요청하는 방식
* 클라이언트로부터 새로 들어오는 요청이기 때무에 HttpServletRequest, HttpServletResponse 객체가 새롭게 생성된다.
```
response.sendRedirect()
``` 