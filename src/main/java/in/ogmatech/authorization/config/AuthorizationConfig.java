package in.ogmatech.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpQIBAAKCAQEAsH4sH/r4PnpTP2ks/5yGPRgWxrTS7EZs/2As+E0rSU50G4LG\n" +
            "Uf63U1d4NecTStKL6BoW3KdbANynnJC1R29HapcYq3OxBdTloFqBtyGjjPsuNSge\n" +
            "cDNgdj24zf2WxYQeSC9W5FC+8PV8p3Gp9Nm9peTGlC5T+62nDJ1eLGBmXP0N+MA5\n" +
            "OTUBqnDt2OdWLaZghAlVzAZ3ygaj48K6uVyNY/OwB4yM62LxQ+BdJwhaofXsmpZr\n" +
            "6lf/UPSVWf2tvLl3GtPix8Bo2TxWqtCMLLRFMI8pEjHieaSlx++91BlJOUEDyA1b\n" +
            "hxUk+fpuvlSDF9rEteQUnwFRCjZyvAawk0nkAQIDAQABAoIBAE9mtBs/IWeaSNGC\n" +
            "U8g7dvkNWVHUEABUPr01W4Xp0cuNDBdEYkyJN5i7BU3aw4cp6d9lvVtPv1VH7/Az\n" +
            "+hpFKe/+Qg8AYWeqPBREI49sBtRqPIOVpPv9YSxQ4E9sAuShZ645/fGBkiV9i7MZ\n" +
            "I8kQHI4BuoT3wri7iyfVtIRqaiLyxd6G0KxBMSqo2eI/k4Fa/1fLuMwSeFkuS8OM\n" +
            "ARHvPZ9sBZ3FWoSASYHQwBUu7eOV43u5LMxH5ByTJ3Nij8dGZiftbbBDerzv2PwJ\n" +
            "CGMqic/VQw4cnGspNdxVjlcz64Yv3INDHxSHeKSgg5LJiYFqJ2qLKTSNayuc+ruC\n" +
            "DnqHnkECgYEA53YgiAP/KPfQ669jpkqShdULQ0ToR3Bgzf87MRRvjCEgSZL+1CPg\n" +
            "f0EFmvhAhQ76E7hRISZeKA0A19hByZyLCefk8tZtrvf0R2p0ocD1ld/Ksytkk2b1\n" +
            "392iQW/h3FZXWs382OnFvMcXxPIgEJGmAsOCPgmjp7nFNDPWJJsWWpUCgYEAwzQy\n" +
            "KJXZhRosqb7g45fLXX1nt9Ag0yLR3agH09jPjqBpJmV0Zo4/vraIFT3lpCpOsCF5\n" +
            "jqbC7aDCSJTInBzut9CmKZS4kK+PNML2tO8SKz+wHjZEy5WjVnxZsBlRRqoQXIHm\n" +
            "QeEm3boDNEZpnhXsuArhMqgzrKOwx/UHX6Xn9L0CgYEAnuTrBDSqL7egBovKvtem\n" +
            "qpVMPAvL4W72JbQ3MEQ1J19+SMPOiFdwwCsk6/PMZwuXBX6cw0MRlDEJCSP+VadP\n" +
            "k6dL9qDZfync2kHsezZ54T9WaZU6YC5oUBxYTM+/n4DuSvnpwAcLpcKPQLZu6LDz\n" +
            "5CXO/UOkw3m2NVX4hfypZdkCgYEAwCFK0UmUvH5jwXt/rGOGpfE9ud0fwdC+0bWG\n" +
            "Zsw6ln5qoIExTZPrSBIu5QF0Wt3Nb2yzUWXv7KXTNE9FGOsdR00Vj02zT62MfXj8\n" +
            "DGBW+LyJ42K02dDh4MkqGbsBlVTkH7k3YlZyw8BHUReQ8ylPQmJq/0ow+lZvNJCG\n" +
            "/my0Xt0CgYEAsht8/LHhrFqI7NruDHH+DozrEW/vhWkJ5N6lLzsfET5ICG8p1WeR\n" +
            "6UwGAOL3x4CZh5+HvBT7wDoBYicG7vcr1pH+DXEp+eMCHsdgrKYGYorcNmyf4Nvi\n" +
            "IHmTO7tnPrMggQgPoFEkn13mXfQAZHbHnvtWBIeeCT/mjKzT4zrhp4U=\n" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsH4sH/r4PnpTP2ks/5yG\n" +
            "PRgWxrTS7EZs/2As+E0rSU50G4LGUf63U1d4NecTStKL6BoW3KdbANynnJC1R29H\n" +
            "apcYq3OxBdTloFqBtyGjjPsuNSgecDNgdj24zf2WxYQeSC9W5FC+8PV8p3Gp9Nm9\n" +
            "peTGlC5T+62nDJ1eLGBmXP0N+MA5OTUBqnDt2OdWLaZghAlVzAZ3ygaj48K6uVyN\n" +
            "Y/OwB4yM62LxQ+BdJwhaofXsmpZr6lf/UPSVWf2tvLl3GtPix8Bo2TxWqtCMLLRF\n" +
            "MI8pEjHieaSlx++91BlJOUEDyA1bhxUk+fpuvlSDF9rEteQUnwFRCjZyvAawk0nk\n" +
            "AQIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("hasAuthority('ROLE_TRUSTED_CLIENT')")
                .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("trusted-client")
                .secret("secret123")
                .authorities("ROLE_TRUSTED_CLIENT")
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .tokenServices(tokenServices())
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter());
    }

    @Bean
    public JwtTokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        defaultTokenServices.setAccessTokenValiditySeconds(10);
        defaultTokenServices.setRefreshTokenValiditySeconds(30);
        defaultTokenServices.setReuseRefreshToken(false);
        defaultTokenServices.setTokenEnhancer(accessTokenConverter());
        return defaultTokenServices;
    }



}
