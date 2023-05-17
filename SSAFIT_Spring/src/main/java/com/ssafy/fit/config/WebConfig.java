package com.ssafy.fit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.fit.interceptor.JwtInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
//	@Value("${spring.mvc.view.prefix}")
//	private String prefix;
//	
//	@Value("${spring.mvc.view.suffix}")
//	private String suffix;
//	
	
	@Autowired
	private JwtInterceptor jwtInterceptor;
//	
//	@Bean
//	public ViewResolver internalResourceViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		
//		resolver.setPrefix(prefix);
//		resolver.setSuffix(suffix);
//		resolver.setViewClass(JstlView.class);
//		
//		return resolver;
//	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
	// Interceptor Bean 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
		.excludePathPatterns("/api-user/login", "/api-user/logout", "/api-user/signup", "/api-user/user/**",
				"/swagger-resources/**", "/swagger-ui/**", "/v2/api-docs"
				,"/api-video/video", "/api-video/videoByPart/**"
				);
	}
	
//	// CORS 에러 해결 전역 설정
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("*"); //.allowedMethods("GET", "POST", "PUT", "DELETE");
//	}
}
