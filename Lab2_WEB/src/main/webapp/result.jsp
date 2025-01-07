<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.itmo.server.ResultsBean" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ru-RU">

<head>
    <meta charset="UTF-8">
    <title>Результаты проверки</title>
    <link rel="stylesheet" href="static/index.css">
</head>

<body>
<div class="content-container">
    <header class="header">
        <div class="header-container">
            <div>Беля Алексей Иванович P3217</div>
            <div></div>
            <div>Вариант 51591</div>
        </div>
    </header>

    <main class="main">
        <div class="table-container">
            <h2>Последние 10 результатов</h2>
            <table id="result-table_2">
                <thead>
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Результат</th>
                    <th>Текущее время</th>
                    <th>Время выполнения</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ResultsBean resultsBean = (ResultsBean) session.getAttribute("resultsBean");
                    if (resultsBean != null) {
                        int count = 0;
                        List<ResultsBean.Result> results = resultsBean.getResults();
                        int totalResults = results.size();
                        for (int i = totalResults - 1; i >= 0; i--) {
                            ResultsBean.Result result = results.get(i);
                            count++;
                            if (count > 10) { break; }
                %>
                <tr>
                    <td><%= result.getX() %></td>
                    <td><%= result.getY() %></td>
                    <td><%= result.getRadius() %></td>
                    <td><%= result.isInArea() ? "Попадание" : "Не попал" %></td>
                    <td><%= new java.util.Date(result.getTimestamp()) %></td>
                    <td><%= result.getExecutionTime() %> ms</td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>



            <div class="navigation">
                <a href="index.jsp">Назад к форме</a>
            </div>
        </div>
    </main>
</div>
</body>
</html>