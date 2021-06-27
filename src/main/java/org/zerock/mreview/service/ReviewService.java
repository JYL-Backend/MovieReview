package org.zerock.mreview.service;

import org.zerock.mreview.dto.ReviewDTO;
import org.zerock.mreview.entity.Member;
import org.zerock.mreview.entity.Movie;
import org.zerock.mreview.entity.Review;

import java.util.List;

public interface ReviewService {

    /* 영화의 모든 영화 리뷰를 가져온다*/
    List<ReviewDTO> getListOfMovie(Long mno);

    /* 영화 리뷰 추가 */
    Long register(ReviewDTO movieReviewDTO);

    /* 특정한 영화리뷰 수정*/
    void modify(ReviewDTO movieReviewDTO);

    /* 영화 리뷰 삭제*/
    void remove(Long reviewnum);

    default Review dtoToEntity(ReviewDTO dto){
        Review review = Review.builder()
                .text(dto.getText())
                .grade(dto.getGrade())
                .member(Member.builder().mid(dto.getMid()).build())
                .reviewnum(dto.getReviewnum())
                .movie(Movie.builder().mno(dto.getMno()).build())
                .build();

        return review;
    }

    default ReviewDTO entityToDto(Review review){
        ReviewDTO moviewReviewDTO = ReviewDTO.builder()
                .email(review.getMember().getEmail())
                .mid(review.getMember().getMid())
                .modDate(review.getModDate())
                .nickname(review.getMember().getNickname())
                .regDate(review.getRegDate())
                .mno(review.getMovie().getMno())
                .reviewnum(review.getReviewnum())
                .grade(review.getGrade())
                .text(review.getText())
                .mid(review.getMember().getMid())
                .build();

        return moviewReviewDTO;
    }

}
