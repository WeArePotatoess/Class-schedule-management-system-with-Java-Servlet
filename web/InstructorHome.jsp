<%-- 
    Document   : InstructorHome
    Created on : Jul 12, 2023, 6:10:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
            />
        <link rel="stylesheet" href="menu.css" />
        <link rel="stylesheet" href="login.css"/>
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
                    <li class="nav__list-item active-nav">
                        <a href="home" class="hover-target">Home</a>
                    </li>
                    <li class="nav__list-item">
                        <a href="home/profile" class="hover-target">Profile</a>
                    </li>
                    <li class="nav__list-item">
                        <a href="home/attendance" class="hover-target">Take Attendance</a>
                    </li>
                    <li class="nav__list-item">
                        <a href="home/timetable" class="hover-target">Timetable</a>
                    </li>
                    <li class="nav__list-item">
                        <a href="#" class="hover-target">
                            <form method="post" action="logout">
                                <button class="btn mt-4">Logout</button>
                            </form>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="section full-height over-hide">
            <div class="switch-wrap">
                <h1>HOME</h1>
                <div class="home-menu" >
                    <div class="home-icon" >
                        <a href="home/profile">
                            <img src="Icons/user.png" alt="alt" width="100%"/>
                        </a>
                        <p>Profile</p>
                    </div>
                    <div class="home-icon">
                        <a href="home/timetable">
                            <img src="Icons/calendar.png" alt="alt" width="100%"/>
                        </a>
                        <p>Timetable</p>

                    </div>
                    <div class="home-icon" >
                        <a href="home/attendance">
                            <img src="Icons/Attendance.png" alt="alt" width="100%"/>
                        </a>                       
                        <p>Take Attendance</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="cursor" id="cursor"></div>
        <div class="cursor2" id="cursor2"></div>
        <div class="cursor3" id="cursor3"></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="menu.js"></script>
    </body>
</html>
