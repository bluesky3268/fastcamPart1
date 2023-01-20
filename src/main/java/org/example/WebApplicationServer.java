package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {

    private static final Logger log = LoggerFactory.getLogger("WebApplicationServer");

    /**
     * 메인 메서드 실행 시 내장 톰캣 띄우기
     */
    public static void main(String[] args) throws Exception {

        // localhost:8080 으로 붙었을 때 루트 폴더를 webapps를 바라보도록 설정
        // 서버가 뜰 때 빌드된 파일들이 webapps/classes 하위로 들어감
        // embedded 톰캣이 루트 경로(webapp 디렉토리, 우리가 코드로 설정했음) 밑에 있는 WEB-INF/classes(톰캣과 약속된 경로) 밑에서 실행할(빌드된) 클래스 파일을 찾기
        String webappDirLocation = "webapps/";
        int port = 8080;
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(port);
        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        log.info("configuration app with baseDir : {}", new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
