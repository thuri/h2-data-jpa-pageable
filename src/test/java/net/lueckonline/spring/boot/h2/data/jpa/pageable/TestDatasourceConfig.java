package net.lueckonline.spring.boot.h2.data.jpa.pageable;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ConditionalOnProperty(name = "spring.datasource.driver-class-name", havingValue = "org.h2.Driver")
public class TestDatasourceConfig {
  
  @Value("${spring.datasource.url}")
  String url;
  
  @Value("${spring.datasource.username}")
  String username;
  
  @Value("${spring.datasource.password}")
  String password;
  
  @Value("${spring.datasource.driver-class-name}")
  String driverClassName;
  
  @Bean
  public DataSource dataSource() {
    
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    if(url.contains("MODE=Oracle")) {
      // Ref https://groups.google.com/g/h2-database/c/yxnv64Ak-u8/m/n-kqYV_yBQAJ
      org.h2.engine.Mode mode = org.h2.engine.Mode.getInstance("ORACLE");
      mode.limit = true;
    }
    
    return dataSource;
  }
}
