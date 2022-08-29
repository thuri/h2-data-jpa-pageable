package net.lueckonline.spring.boot.h2.data.jpa.pageable;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface DemoRepository extends PagingAndSortingRepository<DemoEntity, Long>{

}
