package com.ohgiraffers.springdatajpa.common;

import org.springframework.data.domain.Page;

public class Pagenation {

    // 공통적으로 사용할 페이징 정보 기술
    // ex) 첫 페이지 번호, 페이지에 해당하는 데이터 수 등등
    public static PagingButton getPagingInfo(Page page) {

        int currentPage = page.getNumber() + 1; // 현재 페이지에 대한 정보 (+1 을 하는 이유는 인덱스가 0부터 시작하기 때문) 사용자 시점에서 보기 편하게!!

        // 페이지 버튼의 기본 갯수
        int defaultButtonCount = 5; // 글이 10개 이상이면 뒤로 밀리게

        // 현재 시작페이지 계산
        int startPage = (int)(Math.ceil((double) currentPage / defaultButtonCount) - 1) * defaultButtonCount + 1;

        int endPage = startPage + defaultButtonCount - 1;

        // 실제 총 페이지가 endPage 보다 작을 경우 endPage 를 총 페이지 수로 지정
        if(page.getTotalPages() < endPage) {
            endPage = page.getTotalPages(); // 마지막페이지가 총페이지보다 클경우 토탈페이지로
        }
        // 페이지가 0이면 끝 페이지를 시작 페이지로 설정
        if(page.getTotalPages() == 0 && endPage == 0) {
            endPage = startPage; // 엔드페이지를 startPage 로 변환
        }

        // 계산 된 정보들을 반환
        return new PagingButton(currentPage, startPage, endPage);
    }
}
