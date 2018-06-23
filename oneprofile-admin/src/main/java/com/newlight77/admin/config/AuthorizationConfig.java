package com.newlight77.admin.config;

import com.newlight77.right.annotation.DB;
import com.newlight77.right.annotation.EnableRightAspect;
import org.springframework.context.annotation.Configuration;

@EnableRightAspect(db = DB.MONGO)
@Configuration
public class AuthorizationConfig {
}
