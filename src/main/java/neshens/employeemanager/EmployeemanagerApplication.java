package neshens.employeemanager;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
//		System.setProperty("server.port", "8081");
		// or use
		System.getProperties().put("server.port", 8081);
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

//	@Bean
//	public CorsFilter corsFilter(){
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
//				"Accept","Authorization","Origin,Accept","X-Requested-With",
//				"Access-Control-Request-Method","Access-Control-Request-Headers"));
//		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Authorization",
//				"Access-Control-Allow-Origin","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
//		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
//		return new CorsFilter(urlBasedCorsConfigurationSource);
//	}

	@Component
	public class CorsFilter extends OncePerRequestFilter {

		@Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException, IOException {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
			response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
			if ("OPTIONS".equals(request.getMethod())) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				filterChain.doFilter(request, response);
			}
		}
	}

}
