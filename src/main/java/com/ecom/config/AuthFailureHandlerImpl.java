package com.ecom.config;

import java.io.IOException;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.ecom.model.UserDtls;
import com.ecom.repository.UserRepository;
import com.ecom.service.UserService;
import com.ecom.util.AppConstant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {

	private UserRepository userRepository;
	
	private UserService userService;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
	
		String email = request.getParameter("username");
		
		UserDtls userDtls = userRepository.findByEmail(email);
	
		if(userDtls !=null) {
		
		if( userDtls.getIsEnable())
		{
			if(userDtls.getAccountNonLocked())
			{
			
				if(userDtls.getFailedAttempt() < AppConstant.ATTEMPT_TIME)
				{
				userService.increaseFailedAttempt(userDtls);	
				}else {
					userService.userAccountLock(userDtls);
					exception = new LockedException("Your Account is Locked || Failed Attempt 3");
				}
				
			}else {
				if(userService.unlockAccountTimeExpired(userDtls))
				{
					exception = new LockedException("Your Account is UnLocked || Please Try to Login");
				}else {
					exception = new LockedException("Your Account is Locked || Please try After Sometime");
				}
				 
			}
			
		}else {
			exception = new LockedException("Your Account is InActive"); 
		}
		}else {
			exception = new LockedException("Email & Password is Invalid"); 
		}
		super.setDefaultFailureUrl("/signin?error");
		super.onAuthenticationFailure(request, response, exception);
	}

	
}
