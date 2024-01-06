<%-- 
    Document   : Login
    Created on : Jul 1, 2023, 10:22:19 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Schedule Management</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
            />
        <link
            rel="stylesheet"
            href="https://unicons.iconscout.com/release/v2.1.9/css/unicons.css"
            />
        <link rel="stylesheet" type="text/css" href="login.css" />
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="section">
            <div class="container">
                <div class="row full-height justify-content-center">
                    <div class="col-12 text-center align-self-center py-5">
                        <div class="section pb-5 pt-5 pt-sm-2 text-center">
                            <label for="reg-log"></label>
                            <div class="card-3d-wrap mx-auto">
                                <div class="card-3d-wrapper">
                                    <div class="card-front">
                                        <form action="login" method="post">
                                            <div class="center-wrap">
                                                <div class="section text-center">
                                                    <h4 class="mb-4 pb-3">Log In</h4>
                                                    <div class="form-group">
                                                        <input
                                                            type="text"
                                                            name="logusername"
                                                            class="form-style"
                                                            placeholder="User Name"
                                                            id="logusername"
                                                            autocomplete="off"
                                                            required
                                                            />
                                                        <i class="input-icon uil uil-user"></i>
                                                    </div>
                                                    <div class="form-group mt-2">
                                                        <input
                                                            type="password"
                                                            name="logpass"
                                                            class="form-style"
                                                            placeholder="Your Password"
                                                            id="logpass"
                                                            autocomplete="off"
                                                            required
                                                            />
                                                        <i class="input-icon uil uil-lock-alt"></i>
                                                    </div>
                                                    <button type="submit" class="btn mt-4" name="login">Login</button>
                                                </div>
                                            </div> 
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <h5 style="color: red">${loginerror}</h5>
                    </div>
                </div>
            </div>
        </div>
        <!-- partial -->
        <script src="scripts.js"></script>
    </body>
</html>
