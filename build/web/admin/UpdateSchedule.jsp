<%-- 
    Document   : UpdateSchedule
    Created on : Jul 13, 2023, 4:45:17 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Schedule</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
            />
        <link rel="stylesheet" href="../menu.css" />
        <link rel="stylesheet" href="../login.css"/>
        <link rel="stylesheet" href="profile.css"/>
        <link rel="stylesheet" href="../admin/adminPages.css"/>

        <!--        <link rel="stylesheet" href="attendance.css"/>
                <link rel="stylesheet" href="../instructor/instructorAttendance.css"/>-->
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
            <div class="switch-wrap">
                <h1 class="title" style="font-size: 4em;">Update Schedule</h1>
                <form method="post" action="updateschedule" id="search-form">
                    <div class="container">
                        <input required="" type="text" name="instructorid" class="input" value="${selectedInstructorID}">
                        <label class="label">
                            Instructor ID
                        </label>
                    </div>
                    <input type="date" name="date" value="${selectedDate}">
                    <input class="btn" type="submit" name="form1Submit" value="Search">
                </form>

                <c:forEach items="${data}" var="a">
                    <form class="single-class-container" method="post" action="updateschedule">
                        <input type="text" value="${a.teachingScheduleID}" name="teachingScheduleID" style="display: none;">
                        <p>Instructor ID: ${a.instructorID}</p>
                        <p>Group: ${a.getGroupName()}</p>
                        Classroom:
                        <select name="classroom" id="classroom">
                            <c:forEach items="${classrooms}" var="c">
                                <option value="${c.id}" <c:if test="${a.classroomID.equals(c.id)}">selected=""</c:if>>${c.name}</option>
                            </c:forEach>
                        </select>
                        Slot:
                        <select name="slot">
                            <c:forEach items="${slots}" var="s">
                                <option value="${s.id}" <c:if test="${a.slot.equals(s.id)}">selected=""</c:if>>${s.id}</option>
                            </c:forEach>
                        </select>
                        Date:
                        <input type="date" value="${a.teachingDate}" name="updatedDate">
                        <c:if test="${a.status.equals('0')}"><input type="submit" class="btn" value="Update" name="update"></c:if>
                        </form>
                </c:forEach>
                <c:choose>
                    <c:when test="${notification.equalsIgnoreCase('Update Successful!')}">
                        <p class="notification success">${notification}</p>
                    </c:when>
                    <c:otherwise>
                        <p class="notification fail">${notification}</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="cursor" id="cursor"></div>
        <div class="cursor2" id="cursor2"></div>
        <div class="cursor3" id="cursor3"></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="../menu.js"></script>
    </body>
</html>
