package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;
    // 원래 @PersistanceContext 애노테이션으로 JPA에게 넣어달라고 해야하지만,
    // 스프링 데이터 JPA가 이제는 마치 의존성 주입처럼 Autowired해도 JPA가 넣어주는 기능을 제공함
    // 그래서 생성자 주입처럼 사용가능 @RequiredArgsConstructor

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }


    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
