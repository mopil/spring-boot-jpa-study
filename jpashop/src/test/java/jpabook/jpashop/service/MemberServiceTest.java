package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest // 스프링 부트를 띄운 상태에서 테스트 할래 (Autowired 쓰려면 필요)
@Transactional // 테스트 끝나면 다 롤백해버리는 것
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedId = memberService.join(member);

        // then
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class) // 예외처리 안하고 애노테이션으로 적용하기
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");
        
        // when
        memberService.join(member1);
        memberService.join(member2);
//        try {
//            memberService.join(member2); // 예외가 나와야 한다!
//        } catch (IllegalStateException e) {
//            return;
//        } <-원래는 이렇게 예외처리 해줘야함
        
        // then
        fail("예외가 발생해야 한다");
        
    }

}