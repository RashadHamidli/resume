package com.example.resume.util;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpResponse;

public class ControllerUtil {
    public static void errorPage(HttpServletResponse response, Exception ex) {
        try {
            response.sendRedirect("error?msg=" + ex.getMessage());
        } catch (IOException e) {
            ex.printStackTrace();
        }
    }
}
