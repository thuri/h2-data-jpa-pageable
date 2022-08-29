package net.lueckonline.spring.boot.h2.data.jpa.pageable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DemoEntity {

  @Id
  private long id;
  
  private String name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
