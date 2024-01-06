<%-- 
    Document   : Weekly Timetable
    Created on : Jul 3, 2023, 11:34:11 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weekly Timetable</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
            />
        <link rel="stylesheet" href="../menu.css" />
        <link rel="stylesheet" href="../login.css"/>
        <link rel="stylesheet" href="weeklytimetable.css"/>
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
                    <li class="nav__list-item">
                        <a href="attendance" class="hover-target">Attendance</a>
                    </li>
                    <li class="nav__list-item active-nav">
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
            <h1 class="title">Weekly Timetable</h1>
            <form id="date-selector" method="post" action="timetable">
                <input type="date" value="${date}" name="date-changed">
            </form>
            <form id="week-selector" method="post" action="timetable">
                <select name="week-changed" id="selectWeek">
                    <c:forEach items="${weeks}" var="week">
                        <option <c:if test="${week.equals(selectedWeek)}">selected=""</c:if> >${week}</option>
                    </c:forEach>
                </select>
            </form>


            <div class="cd-schedule loading">
                <div class="timeline">
                    <ul>
                        <li><span>07:30</span></li>
                        <li><span>08:30</span></li>
                        <li><span>09:30</span></li>
                        <li><span>10:30</span></li>
                        <li><span>11:30</span></li>
                        <li><span>12:30</span></li>
                        <li><span>13:30</span></li>
                        <li><span>14:30</span></li>
                        <li><span>15:30</span></li>
                        <li><span>16:30</span></li>
                        <li><span>17:30</span></li>
                        <li><span>18:30</span></li>
                        <li><span>19:30</span></li>
                    </ul>
                </div>
                <!-- .timeline -->

                <div class="events">
                    <ul class="wrap">
                        <li class="events-group">
                            <div class="top-info"><span>Monday</span></div>
                            <ul>
                                <c:forEach items="${data}" var="activity">
                                    <c:if test="${activity.getDayOfWeek().equalsIgnoreCase('MONDAY')}">
                                        <li
                                            class="single-event"
                                            teachingDate="${activity.dayOfWeek} ${activity.actDate}"
                                            classroom="${activity.classroom}"
                                            slot="${activity.slot}"
                                            data-start="${activity.timeStart}"
                                            data-end="${activity.timeEnd}"
                                            group="${activity.studentGroup}"
                                            instructor="${activity.instructor}"
                                            course="${activity.courseName}(${activity.courseCode}) "
                                            attendance="${activity.getIsAbsent()}"
                                            data-event="event-4"
                                            <c:if test="${activity.getIsAbsent().equals('Attended')}">style="background: #0ee000;"</c:if>
                                                >
                                                <a href="#0">
                                                    <em class="event-name">${activity.courseCode}</em>
                                                <p style="color: azure">At ${activity.classroom}</p>
                                                <p>${activity.getIsAbsent()}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>

                        <li class="events-group">
                            <div class="top-info"><span>Tuesday</span></div>

                            <ul>
                                <c:forEach items="${data}" var="activity">
                                    <c:if test="${activity.getDayOfWeek().equalsIgnoreCase('Tuesday')}">
                                        <li
                                            class="single-event"
                                            teachingDate="${activity.dayOfWeek} ${activity.actDate}"
                                            classroom="${activity.classroom}"
                                            slot="${activity.slot}"
                                            data-start="${activity.timeStart}"
                                            data-end="${activity.timeEnd}"
                                            group="${activity.studentGroup}"
                                            instructor="${activity.instructor}"
                                            course="${activity.courseName}(${activity.courseCode}) "
                                            attendance="${activity.getIsAbsent()}"
                                            data-event="event-4"
                                            <c:if test="${activity.getIsAbsent().equals('Attended')}">style="background: #0ee000;"</c:if>

                                                >
                                                <a href="#0">
                                                    <em class="event-name">${activity.courseCode}</em>
                                                <p style="color: azure">At ${activity.classroom}</p>
                                                <p>${activity.getIsAbsent()}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>

                        <li class="events-group">
                            <div class="top-info"><span>Wednesday</span></div>

                            <ul>
                                <c:forEach items="${data}" var="activity">
                                    <c:if test="${activity.getDayOfWeek().equalsIgnoreCase('Wednesday')}">
                                        <li
                                            class="single-event"
                                            teachingDate="${activity.dayOfWeek} ${activity.actDate}"
                                            classroom="${activity.classroom}"
                                            slot="${activity.slot}"
                                            data-start="${activity.timeStart}"
                                            data-end="${activity.timeEnd}"
                                            group="${activity.studentGroup}"
                                            instructor="${activity.instructor}"
                                            course="${activity.courseName}(${activity.courseCode}) "
                                            attendance="${activity.getIsAbsent()}"
                                            data-event="event-4"
                                            <c:if test="${activity.getIsAbsent().equals('Attended')}">style="background: #0ee000;"</c:if>
                                                >
                                                <a href="#0">
                                                    <em class="event-name">${activity.courseCode}</em>
                                                <p style="color: azure">At ${activity.classroom}</p>
                                                <p>${activity.getIsAbsent()}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>

                        <li class="events-group">
                            <div class="top-info"><span>Thursday</span></div>

                            <ul>
                                <c:forEach items="${data}" var="activity">
                                    <c:if test="${activity.getDayOfWeek().equalsIgnoreCase('Thursday')}">
                                        <li
                                            class="single-event"
                                            teachingDate="${activity.dayOfWeek} ${activity.actDate}"
                                            classroom="${activity.classroom}"
                                            slot="${activity.slot}"
                                            data-start="${activity.timeStart}"
                                            data-end="${activity.timeEnd}"
                                            group="${activity.studentGroup}"
                                            instructor="${activity.instructor}"
                                            course="${activity.courseName}(${activity.courseCode}) "
                                            attendance="${activity.getIsAbsent()}"
                                            data-event="event-4"
                                            <c:if test="${activity.getIsAbsent().equals('Attended')}">style="background: #0ee000;"</c:if>

                                                >
                                                <a href="#0">
                                                    <em class="event-name">${activity.courseCode}</em>
                                                <p style="color: azure">At ${activity.classroom}</p>
                                                <p>${activity.getIsAbsent()}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>

                        <li class="events-group">
                            <div class="top-info"><span>Friday</span></div>

                            <ul>
                                <c:forEach items="${data}" var="activity">
                                    <c:if test="${activity.getDayOfWeek().equalsIgnoreCase('Friday')}">
                                        <li
                                            class="single-event"
                                            teachingDate="${activity.dayOfWeek} ${activity.actDate}"
                                            classroom="${activity.classroom}"
                                            slot="${activity.slot}"
                                            data-start="${activity.timeStart}"
                                            data-end="${activity.timeEnd}"
                                            group="${activity.studentGroup}"
                                            instructor="${activity.instructor}"
                                            course="${activity.courseName}(${activity.courseCode}) "
                                            attendance="${activity.getIsAbsent()}"
                                            data-event="event-4"
                                            <c:if test="${activity.getIsAbsent().equals('Attended')}">style="background: #0ee000;"</c:if>

                                                >
                                                <a href="#0">
                                                    <em class="event-name">${activity.courseCode}</em>
                                                <p style="color: azure">At ${activity.classroom}</p>
                                                <p>${activity.getIsAbsent()}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                        <!--        -->
                        <li class="events-group">
                            <div class="top-info"><span>Saturday</span></div>
                            <ul>
                                <c:forEach items="${data}" var="activity">
                                    <c:if test="${activity.getDayOfWeek().equalsIgnoreCase('Saturday')}">
                                        <li
                                            class="single-event"
                                            teachingDate="${activity.dayOfWeek} ${activity.actDate}"
                                            classroom="${activity.classroom}"
                                            slot="${activity.slot}"
                                            data-start="${activity.timeStart}"
                                            data-end="${activity.timeEnd}"
                                            group="${activity.studentGroup}"
                                            instructor="${activity.instructor}"
                                            course="${activity.courseName}(${activity.courseCode}) "
                                            attendance="${activity.getIsAbsent()}"
                                            data-event="event-4"
                                            <c:if test="${activity.getIsAbsent().equals('Attended')}">style="background: #0ee000;"</c:if>

                                                >
                                                <a href="#0">
                                                    <em class="event-name">${activity.courseCode}</em>
                                                <p style="color: azure">At ${activity.classroom}</p>
                                                <p>${activity.getIsAbsent()}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                        <!--        -->

                        <!--        -->
                        <li class="events-group">
                            <div class="top-info"><span>Sunday</span></div>
                            <ul>
                                <c:forEach items="${data}" var="activity">
                                    <c:if test="${activity.getDayOfWeek().equalsIgnoreCase('Sunday')}">
                                        <li
                                            class="single-event"
                                            teachingDate="${activity.dayOfWeek} ${activity.actDate}"
                                            classroom="${activity.classroom}"
                                            slot="${activity.slot}"
                                            data-start="${activity.timeStart}"
                                            data-end="${activity.timeEnd}"
                                            group="${activity.studentGroup}"
                                            instructor="${activity.instructor}"
                                            course="${activity.courseName}(${activity.courseCode}) "
                                            attendance="${activity.getIsAbsent()}"
                                            data-event="event-4"
                                            <c:if test="${activity.getIsAbsent().equals('Attended')}">style="background: #0ee000;"</c:if>

                                                >
                                                <a href="#0">
                                                    <em class="event-name">${activity.courseCode}</em>
                                                <p style="color: azure">At ${activity.classroom}</p>
                                                <p>${activity.getIsAbsent()}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                        <!--        -->
                    </ul>
                </div>

                <div class="event-modal">
                    <header class="header">
                        <div class="content">
                            <span class="event-date"></span>
                            <h3 class="event-name"></h3>
                        </div>

                        <div class="header-bg"></div>
                    </header>

                    <div class="body">
                        <div class="event-info">
                        </div>
                        <div class="body-bg"></div>
                    </div>

                    <a href="#0" class="close"></a>
                </div>

                <div class="cover-layer"></div>
            </div>

        </div>


        <div class="cursor" id="cursor"></div>
        <div class="cursor2" id="cursor2"></div>
        <div class="cursor3" id="cursor3"></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
        <script src="WeeklyTimetable.js"></script>
        <script src="../menu.js"></script>
    </body>
</html>
