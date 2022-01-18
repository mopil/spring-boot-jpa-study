package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기 전용이면 이걸 넣어주면 성능 최적화가 된다(근데 DB 드라이버마다 달라서 확인해봐야함)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional // 쓰기에는 그냥 이걸 넣는다 readOnly를 넣으면 당연히 쓰기가 안된다 디폴트가 false임
    public Long join(Member member) {
        validateDuplicateMember(member); // 증복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}


