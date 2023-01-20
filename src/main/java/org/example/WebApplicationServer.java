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
