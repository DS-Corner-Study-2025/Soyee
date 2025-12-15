package com.springboot.config;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfig{

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
		
	/*@Bean
	public UserDetailsService 1 userDetailsService() {		
		UserDetails admin = User.builder()
			.username("admin")
			.password(passwordEncoder().encode("a1234"))
			.roles("ADMIN")
			.build();
			
			return new InMemoryUserDetailsManager(admin);		
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
			authorizeHttpRequests -> authorizeHttpRequests
	    	   .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN") 
	        .requestMatchers("/manager/**").hasRole("MANAGER")		
             .requestMatchers("/member/**").authenticated() 
              .anyRequest().permitAll()
              ) 
		.formLogin(Customizer.withDefaults());
	        return http.build();
	}
   */
	
	@Bean
	public UserDetailsService users() {		
		UserDetails user = User.builder()			
			.username("guest")
			.password(passwordEncoder().encode("g1234"))
			.roles("USER")
			.build();
		UserDetails manager = User.builder()			
			.username("manager")
			.password(passwordEncoder().encode("m1234"))
			.roles("MANAGER")
			.build();	
		UserDetails admin = User.builder()			
			.username("admin")
			.password(passwordEncoder().encode("a1234"))
			.roles("ADMIN")
			.build();
			
		return new InMemoryUserDetailsManager(user, manager, admin);	
	
	}
	
	

	

	 /*@Bean
	protected  SecurityFilterChain examMethod01(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
			 authorize -> authorize	   
			.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN" )
			.requestMatchers("/manager/**").hasRole("MANAGER")			
			.requestMatchers("/admin/**").hasAnyRole("ADMIN")			
			.anyRequest().permitAll()
		   )		  
		   .formLogin(Customizer.withDefaults());
		
	     return http.build();
	}
	*/
   
    
  
	
	@Bean
	public SecurityFilterChain examMethod02(HttpSecurity http) throws Exception {
		http
    	.csrf(AbstractHttpConfigurer::disable)
		// 특정 URL에 대한 권한 설정.
		
    	
		.authorizeHttpRequests(
        		authorizeRequests -> authorizeRequests        		
        		.requestMatchers("/admin").hasRole("ADMIN" )      
        		.anyRequest().permitAll()
        )
		.formLogin(
		        	formLogin->formLogin				    
				    
				    .loginPage("/exam05") // 사용자 정의 로그인 페이지
				    .loginProcessingUrl("/exam05") 
				    .defaultSuccessUrl("/admin") // 로그인 성공 후 이동 페이지    
				  	.usernameParameter("username") 
		 			.passwordParameter("password")
			          .failureUrl("/loginfailed") // 로그인 실패 후 이동 페이지
		 			
		       )
		
		
		 .logout(logout -> logout
				  .logoutUrl("/logout")             		
		           .logoutSuccessUrl("/exam05")
		            );
	        return http.build();
	}

   /* @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    	return(web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
    */
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    	 UserDetails user1 = User.withUsername("user1")
    	            .password(passwordEncoder().encode("user1Pass"))
    	            .roles("USER")
    	            .build();
    	        UserDetails user2 = User.withUsername("user2")
    	            .password(passwordEncoder().encode("user2Pass"))
    	            .roles("USER")
    	            .build();
    	            
    	        UserDetails admin = User.withUsername("admin")
    	            .password(passwordEncoder().encode("adminPass"))
    	            .roles("ADMIN")
    	            .build();
    	       // return new InMemoryUserDetailsManager(user1, user2, admin);
    	        return new InMemoryUserDetailsManager( admin);
    }
    */
    

}
