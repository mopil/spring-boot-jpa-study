package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
//        영한님의 "커맨드와 엔티티를 분리해라 원칙"에 의해
//        멤버 자체를 리턴하지 않고(사이드 이펙트가 있을 수 있음)
//        간단하게 조회 정도 가능한 id만 리턴한다
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
