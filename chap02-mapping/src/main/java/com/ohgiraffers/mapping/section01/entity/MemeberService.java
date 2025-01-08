package com.ohgiraffers.mapping.section01.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public void registMember(MemberRegistDTO newMember) {

        Member member = new Member(

                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()

        );

        memberRepository.save(member);

    }
}
