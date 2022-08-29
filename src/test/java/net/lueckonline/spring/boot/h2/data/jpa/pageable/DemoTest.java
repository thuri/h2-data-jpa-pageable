package net.lueckonline.spring.boot.h2.data.jpa.pageable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.net.HttpURLConnection;
import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoTest {

  @LocalServerPort
  int port;
  
  @Test
  void shouldReturnPagedResult() throws Exception {
    
    HttpURLConnection con = (HttpURLConnection) URI.create("http://localhost:"+port+"/demo?page=0&size=20").toURL().openConnection();
    
    assertThat(con.getResponseCode(), is(200));
    
  }
}
