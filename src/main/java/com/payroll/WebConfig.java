// package com.payroll;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// @EnableWebMvc
// public class ConfigCors implements WebMvcConfigurer {

// 	// @Bean
// 	// public WebMvcConfigurer corsConfigurer() {
// 		// return new WebMvcConfigurer() {
			
// 			@Override
// 			public void addCorsMappings(CorsRegistry registry) {
// 				// registry.addMapping("/**");
// 					// .allowedMethods("GET", "POST", "PUT")
// 					// .allowedHeaders("*")
// 					// .allowedOrigins("http://localhost:8080");
// 					// .allowedOrigins("*");
// 				// registry.addMapping("/**");
// 				System.out.println("HEYSOss");
// 			}
			
// 		// };
// 	}
// // }

// @Configuration
// // @EnableWebMvc
// public class WebConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**").allowedOrigins("*");;
//     }
// }