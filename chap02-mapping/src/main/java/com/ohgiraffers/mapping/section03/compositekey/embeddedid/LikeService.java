package com.ohgiraffers.mapping.section03.compositekey.embeddedid;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Transactional
    public void registLikeInfo(LikeDTO likeDTO) {

        Like likeDTO1 = new Like(
                new LikedCompositkey(
                    new LikedMemberNo(likeDTO.getLikedMemberNo()),
                    new LikedBookNo(likeDTO.getLikedBookNo())
                )
        );
       likeRepository.save(likeDTO1);
    }
}
