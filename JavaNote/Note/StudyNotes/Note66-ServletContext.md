# 웹 애플리케이션과 컨텍스트
>웹 애플리케이션 = 컨텍스트 = 루트

## ServletContextListener
웹 애플리케이션이 시작되거나 종료될 때 호출하는 메서드의 규칙

즉, ServletContainer에서 웹 애플리케이션 생명주기가 변화했을 때 호출한다.

리스너 인터페이스의 메서드
- contextInitialized(): 웹 애플리케이션이 시작된 직후, 실행되는 동안 사용할 자원을 준비  
ex) DB커넥션, DAO, 서비스 객체, 트랜잭션

- contextDestroyed(): 웹 애플리케이션 종료 직전, 웹 애플리케이션을 종료하기 전에 사용한 자원을 해제

ServletContextListener는 웹 애플리케이션을 시작하거나 종료할 때 작업을 수행시키는 방법으로 모든 서블릿이 공유하는 자원을 준비하기에 적절한 위치(저장소)이다.

ServletContext