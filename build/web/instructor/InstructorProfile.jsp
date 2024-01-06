<%-- 
    Document   : Profile
    Created on : Jul 3, 2023, 11:23:40 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
            />
        <link rel="stylesheet" href="../menu.css" />
        <link rel="stylesheet" href="../login.css"/>
        <link rel="stylesheet" href="profile.css"/>
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
                    <li class="nav__list-item active-nav">
                        <a href="profile" class="hover-target">Profile</a>
                    </li>
                    <li class="nav__list-item">
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
        <div class="section full-height over-hide">
            <div class="switch-wrap">
                <div class="profile-container">
                    <h1>PROFILE</h1>
                    <div class="img-container">
                        <c:choose>
                            <c:when test="${instructor.picURL==null}">
                                <img src="
                                     https://i.pinimg.com/564x/3b/bb/3c/3bbb3ca63120fd8241ca1bb553a18a17.jpg
                                     ">
                            </c:when>
                            <c:otherwise>
                                <img src="${instructor.picURL}">
                            </c:otherwise>
                        </c:choose>

                    </div>
                    <div class="info-container">
                        <div class="container">
                            <input required="" type="text" name="name" class="input" value="${instructor.fullName}" disabled="">
                            <label class="label">
                                Full name
                            </label>
                        </div>
                        <div class="container">
                            <div class="radio-buttons-container">
                                <c:choose>
                                    <c:when test="${instructor.gender==1}">
                                        <input required="" type="text" class="input" value="Male" disabled="">
                                    </c:when>
                                    <c:otherwise>
                                        <input required="" type="text" class="input" value="Female" disabled="">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <label class="label">
                                Gender
                            </label>
                        </div>

                    </div>
                </div>
            </div>
        </div>


        <div class="cursor" id="cursor"></div>
        <div class="cursor2" id="cursor2"></div>
        <div class="cursor3" id="cursor3"></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="../menu.js"></script>
    </body>
</html>
