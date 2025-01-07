<%@ page import="org.itmo.server.ResultsBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ru-RU">

<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №2</title>
    <link rel="stylesheet" href="static/index.css">
</head>

<body>
<script src="static/script.js"></script>
<script src="static/canvas.js"></script>
<div class="content-container">
    <header class="header">
        <div class="header-container">
            <div>Беля Алексей Иванович P3217</div>
            <div></div>
            <div>Вариант 51591</div>
        </div>
    </header>
    <main class="main">
        <div id="toast" class="toast"></div>
        <div class="main__left-column">
            <form id="form-1" action="${pageContext.request.contextPath}/controller" method="get" >
                <div class="main__block">
                    <canvas id="canvas" width="500" height="500"></canvas>
                </div>
                <div class="main__block">
                    <div class="row">Параметры</div>
                    <div class="row">
                        <div>Выберите X:</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="-5">
                        </label>-5</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="-4">
                        </label>-4</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="-3">
                        </label>-3</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="-2">
                        </label>-2</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="-1">
                        </label>-1</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="0">
                        </label>0</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="1">
                        </label>1</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="2">
                        </label>2</div>
                        <div><label>
                            <input type="checkbox" name="x[]" value="3">
                        </label>3</div>
                    </div>
                    <div class="row">
                        <div>Введите Y (от -5 до 3):</div>
                        <label for="y-input"></label><input name="y" id="y-input" type="text" placeholder="значение от -5 до 3" maxlength="12">
                    </div>
                    <div class="row">
                        <div>Введите R (от 1 до 4):</div>
                        <label for="radius-input"></label><input name="radius" id="radius-input" type="text" placeholder="значение от 1 до 4" maxlength="12">
                    </div>
                </div>
                <button class="main__block submit_button" type="submit" id="submit_button">Проверить</button>
            </form>
            <button class="main__block clear_button" id="clear">Очистить точки с графика</button>
        </div>

        <div class="table-container">
            <table id="result-table">
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
                <tbody id="result-body">
                <%
                    // Получение списка результатов из Bean-компонента
                    ResultsBean resultsBean = (ResultsBean) session.getAttribute("resultsBean");
                    if (resultsBean != null) {
                        for (ResultsBean.Result result : resultsBean.getResults()) {
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
        </div>
    </main>
</div>

</body>
</html>