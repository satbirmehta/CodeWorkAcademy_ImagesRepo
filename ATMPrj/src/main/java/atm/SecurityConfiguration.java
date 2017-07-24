package atm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


//Grant access to remaining resources

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


	@Autowired
	private AccountRepository userRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/assets/**", "/bootstrap3/**").permitAll()
		.anyRequest().authenticated();
		http
		.formLogin().failureUrl("/login?error")
		.defaultSuccessUrl("/")
		.loginPage("/login")
		.permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
		.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		Iterable<Account> accountList =  userRepository.findAll();
		for(Account acc : accountList) {
			auth.inMemoryAuthentication().withUser(acc.getAccountNo()).password(acc.getPin()).roles("USER");
		}
	}
}


