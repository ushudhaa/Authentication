package com.authentication.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void addUserCookie(HttpServletResponse resp, String email) {
        Cookie cookie = new Cookie("email", email);
        resp.addCookie(cookie);
    }
}