package br.unipe.jacademy.config;

import br.unipe.jacademy.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UdsSecurityConfig <Service extends PessoaService> {


}
