package com.in28minutes.springboot.myfirstwebapplication.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    //url: "say-hello" should return => "Hello! What are you learning today?"

    //You can see the method output in this URL: http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    //@ResponseBody will return the output of the method as view as it is
    @ResponseBody
    public String helloMessage(){
        return "Hello! What are you learning today?";
    }

    //Return the HTML to the browser
    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        //tab name in the browser
        sb.append("<title> My First HTML Page - Changed</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body - Changed");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }


    //Output using jsp
    // "say-hello-jsp" => sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
    // folder for JSP to look up the jsp files, use view controller to attach prefix and suffix
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}
