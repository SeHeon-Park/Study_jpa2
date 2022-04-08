package jpabook3.jpashop3.repository.order.query;


import jpabook3.jpashop3.repository.order.simplequery.OrderSimpleQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class orderSimpleQueryRepository {

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery(
          "select new jpabook3.jpashop3.repository.order.simplequery.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +
                  " from Order o" +
                  " join o.member m" +
                  " join o.delivery d", OrderSimpleQueryDto.class
        ).getResultList();
    }
}
