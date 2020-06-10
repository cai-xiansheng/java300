package com.zh.webserver02;

/**
 * @author 张辉
 * @Description
 * @create 2020-06-07 13:49
 */
public class LoginServlet implements Servlet {
    @Override
    public void servive(Request request, Response response) {
        // 关注内容
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("第一个小脚本");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("终于回来了" + request.getParameter("uname"));
        response.print("</body>");
        response.print("</html>");
    }
}
