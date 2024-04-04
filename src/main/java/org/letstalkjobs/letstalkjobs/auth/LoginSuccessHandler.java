package org.letstalkjobs.letstalkjobs.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.letstalkjobs.letstalkjobs.Utils.UserRole;
import org.letstalkjobs.letstalkjobs.entities.userentities.BaseUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(
            @NotNull HttpServletRequest request,
            HttpServletResponse response,
            @NotNull Authentication authentication
    ) throws ServletException, IOException
    {
        BaseUser user = (BaseUser) authentication.getPrincipal();
        String redirectURL = request.getContextPath();

        if (user.getUserRole() == UserRole.APPLICANT || user.getUserRole() == UserRole.MENTOR){
            redirectURL = "/home";
        } else if (user.getUserRole() == UserRole.ADMIN || user.getUserRole() == UserRole.MANAGER) {
            redirectURL = "/admin/home";
        }
        response.sendRedirect(redirectURL);
    }


}
