<%-- 
    Document   : Attendace
    Created on : Jul 3, 2023, 11:25:59 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
            />
        <link rel="stylesheet" href="../menu.css" />
        <link rel="stylesheet" href="../login.css"/>
        <link rel="stylesheet" href="attendance.css"/>
    </head>
    <body>
        <header class="cd-header">
            <div class="header-wrapper">
                <div class="nav-but-wrap">
                    <div class="menu-icon hover-target">
                        <span class="menu-icon__line menu-icon__line-left"></span>
                        <span class="menu-icon__line"></span>
                        <span class="menu-icon__line menu-icon__line-right"></span>
                    </div>
                </div>
            </div>
        </header>

         <div class="nav">
            <div class="nav__content">
                <ul class="nav__list">
                    <li class="nav__list-item ">
                        <a href="../home" class="hover-target">Home</a>
                    </li>
                    <li class="nav__list-item">
                        <a href="profile" class="hover-target">Profile</a>
                    </li>
                    <li class="nav__list-item active-nav">
                        <a href="attendance" class="hover-target">Attendance</a>
                    </li>
                    <li class="nav__list-item">
                        <a href="timetable" class="hover-target">Timetable</a>
                    </li>
                    <li class="nav__list-item">
                        <a href="" class="hover-target">
                            <form method="post" action="../logout">
                                <button class="btn mt-4">Logout</button>
                            </form>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="section full-height">
                <h1 class="title" style="font-size: 4em;">View Attendance</h1>
                <form action="attendance" method="post" id="course-select">
                    <select  name="selectCourse" id="selectCourse">
                        <c:forEach items="${courses}" var="c">
                            <option
                                <c:if test="${c.id.equals(course.id)}">selected=""</c:if>
                                value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </form>
                <div class="attendane-container">
                    <table border="5" class="attendance-info">
                        <tr>
                            <td>DATE</td>
                            <td>SLOT</td>
                            <td>ROOM</td>
                            <td>LECTURER</td>
                            <td>GROUP</td>
                            <td>ATTENDANCE STATUS</td>
                        </tr>
                        <c:forEach items="${data}" var="activity">
                            <tr>
                                <td>${activity.dayOfWeek}__${activity.actDate}</td>
                                <td>${activity.slot}__${activity.timeStart}-${activity.timeEnd}</td>
                                <td>${activity.classroom}</td>
                                <td>${activity.instructor}</td>
                                <td>${activity.studentGroup}</td>
                                <td>${activity.getIsAbsent()}</td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
        </div>


        <div class="cursor" id="cursor"></div>
        <div class="cursor2" id="cursor2"></div>
        <div class="cursor3" id="cursor3"></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="../menu.js"></script>
        <script>
            const courseSelect = document.querySelector("#course-select");
            const select = document.querySelector("#selectCourse");

            select.addEventListener("change", (e) => {
                e.preventDefault();
                courseSelect.submit();
            });
        </script>

    </body>
</html>
