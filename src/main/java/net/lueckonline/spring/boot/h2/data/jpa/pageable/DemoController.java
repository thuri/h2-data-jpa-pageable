package net.lueckonline.spring.boot.h2.data.jpa.pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {

  @Autowired DemoRepository demoRepo;
  
  @GetMapping(path = "")
  public ResponseEntity<?> getEntities(Pageable pageable) {
    
    Page<DemoEntity> findAll = demoRepo.findAll(pageable);
    
    return ResponseEntity.ok().body(PagedModel.of(findAll));
  }
  
}
