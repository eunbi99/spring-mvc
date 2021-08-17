package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    //테스트 실행 후 초기화
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member =new Member("hello",20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){
        //given ( member1과 member2를 생성후 저장)
        Member member1 = new Member("member1",20);
        Member member2 = new Member("member2",30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when (모든 회원 리스트를 result에 담는다)
        List<Member> result = memberRepository.findAll();

        //then
        // ( result에 담긴 값이 2개인지 확인 -> member1, member2)
        assertThat(result.size()).isEqualTo(2);
        // member1과 member2가 들어있는지 확인
        assertThat(result).contains(member1,member2);


    }
}
