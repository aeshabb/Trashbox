package org.itmo.server;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;

import static org.itmo.server.CheckHit.checkIfInArea;

@WebServlet("/areaCheck")
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long startTime = System.nanoTime();
        try {

                for (String x_str : request.getParameterValues("x[]")) {
                    double x = Double.parseDouble(x_str);
                    double y = Double.parseDouble(request.getParameter("y"));
                    double r = Double.parseDouble(request.getParameter("radius"));


                    boolean isInArea = checkIfInArea(x, y, r);

                    HttpSession session = request.getSession();
                    ResultsBean resultsBean = (ResultsBean) session.getAttribute("resultsBean");
                    if (resultsBean == null) {
                        resultsBean = new ResultsBean();
                        session.setAttribute("resultsBean", resultsBean);
                    }

                    long executionTime = (System.nanoTime() - startTime) / 1_000_000;
                    if (executionTime == 0) {
                        executionTime = 1;
                    }
                    resultsBean.addResult(x, y, r, isInArea, executionTime);

                    // Устанавливаем атрибуты для отображения результата на странице
                    request.setAttribute("x", x);
                    request.setAttribute("y", y);
                    request.setAttribute("radius", r);
                    request.setAttribute("isInArea", isInArea);
                    request.setAttribute("executionTime", executionTime);

                }

            // Перенаправляем на result.jsp для отображения результата
            request.getRequestDispatcher("/result.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

}