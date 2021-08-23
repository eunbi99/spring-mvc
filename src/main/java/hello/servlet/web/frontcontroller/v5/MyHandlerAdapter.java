package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    //handler : controller
    //해당 컨트롤러를 처리할 수 있는지 판단하는 메서드
    boolean supports(Object handler);

    //실제컨트롤러를 호출하고, 그 결과로 ModelView 반환
    //반환하지 못하면 직접 생성해서라도 반환
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}
