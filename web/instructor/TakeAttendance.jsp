<%-- 
    Document   : TakeAttendance
    Created on : Jul 12, 2023, 7:30:22 PM
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
        <link rel="stylesheet" href="../instructor/instructorAttendance.css"/>
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
            <h1 class="title" style="font-size: 4em;">Take Attendance</h1>
            <form class="student-container">
                <c:forEach items="${data}" var="s">
                    <div class="single-student">
                        <div class="student-img-container">
                            <img src="${s.picURL}">
                        </div>
                        <p>${s.studentCode}</p>
                        <p>${s.studentName}</p>
                        <div class="check-attendance">
                            <input type="radio" value="0" name="${s.studentCode}" id="${s.studentCode}-absent" <c:if test="${s.isAbsent.equals('1')}">checked=""</c:if>>
                            <label for="${s.studentCode}-absent">Absent</label>
                            <input type="radio" value="1" name="${s.studentCode}" id="${s.studentCode}-present" <c:if test="${s.isAbsent.equals('0')}">checked=""</c:if>>
                            <label for="${s.studentCode}-present">Present</label>
                        </div>
                    </div>
                </c:forEach>
                <button class="btn mt-4">Submit</button>
            </form>
        </div>


        <div class="cursor" id="cursor"></div>
        <div class="cursor2" id="cursor2"></div>
        <div class="cursor3" id="cursor3"></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="../menu.js"></script>
    </body>
</html>
