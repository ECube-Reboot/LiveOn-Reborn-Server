package com.twoCube.auth.test;


import com.twoCube.auth.Token.RefreshToken;
import com.twoCube.auth.Token.RefreshTokenRepository;
import com.twoCube.auth.Token.TokenDto;
import com.twoCube.auth.Token.TokenService;
import com.twoCube.members.domain.Member;
import com.twoCube.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestAuthService {

    private final MemberRepository memberRepository;
    private final TokenService tokenService;
    private final RefreshTokenRepository refreshTokenRepository;
//    private final ClientApple clientApple;
    private RefreshToken refreshToken;

//    public AuthResponse signUpOrLogIn(AuthRequest authRequest) {
//        Member member;
//
//        member = getAppleProfile(authRequest.getAccessToken());
//
//
//        Token token = tokenService.generateToken(user.getSocialId(), "USER");
//
//        boolean isNewMember = false;
//        boolean isUserSettingDone = false;
//
//        if (userRepository.findBySocialId(user.getSocialId()).equals(Optional.empty())) {
//            user.setPoint(20);
//            userRepository.save(user);
//
//            System.out.println(user.getSocialId());
//            refreshToken = RefreshToken.builder()
//                    .id(user.getSocialId())
//                    .refreshToken(token.getRefreshToken())
//                    .build();
//            refreshTokenRepository.save(refreshToken);
//            isNewMember = true;
//        } else {
//            Optional<User> currentUser = userRepository.findBySocialId(user.getSocialId());
//            Optional<RefreshToken> oldRefreshToken = refreshTokenRepository.findById(user.getSocialId());
//            if (!oldRefreshToken.equals(Optional.empty())) {
//                refreshToken = refreshTokenRepository.getById(user.getSocialId());
//                refreshToken = refreshToken.updateValue(token.getRefreshToken());
//            } else {
//                refreshToken = RefreshToken.builder()
//                        .id(user.getSocialId())
//                        .refreshToken(token.getRefreshToken())
//                        .build();
//            }
//            refreshTokenRepository.save(refreshToken);
//
//            User thisUser = currentUser.get();
//            if(thisUser.getNickName() != null){
//                isUserSettingDone = true;
//            }
//        }
//
//        return AuthResponse.builder()
//                .isNewMember(isNewMember)
//                .accessToken(token.getAccessToken())
//                .refreshToken(token.getRefreshToken())
//                .userSettingDone(isUserSettingDone)
//                .build();
//    }
//
//
//    public Member getAppleProfile(String refreshToken) {
//        Member appleMember = clientApple.getUserData(oauthToken);
//        System.out.println("getApple");
//        return appleUser;
//    }
//
//    public TokenReissue reissue(TokenReissue tokenReissueRequest) {
//        Long timeLeft = tokenService.verifyRefreshToken(tokenReissueRequest.getRefreshToken());
//        if (timeLeft == 0) {
//            throw new RuntimeException("Refresh Token ??? ???????????? ????????????.");
//        }
//        String currentSocialId = tokenService.getSocialId(tokenReissueRequest.getAccessToken());
//
//        RefreshToken refreshToken = refreshTokenRepository.findById(currentSocialId)
//                .orElseThrow(() -> new RuntimeException("???????????? ??? ??????????????????."));
//
//        if (!refreshToken.getToken().equals(tokenReissueRequest.getRefreshToken())) {
//            throw new RuntimeException("????????? ?????? ????????? ???????????? ????????????.");
//        }
//
//        Token token = tokenService.generateToken(currentSocialId, "USER");
//        TokenReissue tokenReissueResponse;
//        if (timeLeft < 1000L * 60L * 60L * 24L * 3L) {
//
//            refreshToken = refreshToken.updateValue(token.getRefreshToken());
//            refreshTokenRepository.save(refreshToken);
//
//            tokenReissueResponse = TokenReissue.builder()
//                    .accessToken(token.getAccessToken())
//                    .refreshToken(token.getRefreshToken())
//                    .build();
//        } else {
//            String accessToken = tokenService.generateAccessToken(currentSocialId, "USER");
//            tokenReissueResponse = TokenReissue.builder()
//                    .accessToken(token.getAccessToken())
//                    .refreshToken(tokenReissueRequest.getRefreshToken())
//                    .build();
//        }
//        return tokenReissueResponse;
//    }
////
////    public User getKakaoProfile(String oauthToken) {
////        User kakaoUser = clientKakao.getUserData(oauthToken);
////        System.out.println("getKakao");
////        return kakaoUser;
////    }
//
//    public void logout(User user){
//        RefreshToken refreshToken = refreshTokenRepository
//                .findById(user.getSocialId()).orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));
//
//        refreshToken.setToken(null);
//        refreshTokenRepository.save(refreshToken);
//    }
//
//    @Transactional
//    public void withdrawl(User user){
//        refreshTokenRepository.deleteById(user.getSocialId());
//        user.setSocialId(null);
//        userRepository.save(user);
//    }


    public TestAuthResponse testSignUpOrLogIn(TestAuthRequest authRequest) {
        Member member;

        member = Member.builder()
                .socialId(authRequest.getName())
                .build();

        TokenDto token = tokenService.generateToken(authRequest.getName(), "USER");

        boolean isNewMember = false;
        boolean isUserSettingDone = false;

        if (memberRepository.findBySocialId(member.getSocialId()).equals(Optional.empty())) {
            member.setNickName(authRequest.getName());
            memberRepository.save(member);

            refreshToken = RefreshToken.builder()
                    .id(member.getSocialId())
                    .refreshToken(token.getRefreshToken())
                    .build();
            System.out.println("not saving");

            //refreshToken ??????
            refreshTokenRepository.save(refreshToken);
            isNewMember = true;

        } else {
            Optional<Member> currentUser = memberRepository.findBySocialId(member.getSocialId());
            Optional<RefreshToken> oldRefreshToken = refreshTokenRepository.findById(member.getSocialId());
            if (!oldRefreshToken.equals(Optional.empty())) {
                refreshToken = refreshTokenRepository.getById(member.getSocialId());
                refreshToken = refreshToken.updateValue(token.getRefreshToken());
            } else {
                refreshToken = RefreshToken.builder()
                        .id(member.getSocialId())
                        .refreshToken(token.getRefreshToken())
                        .build();
            }
            refreshTokenRepository.save(refreshToken);

            Member thisMember = currentUser.get();
            if(thisMember.getNickName() != null){
                isUserSettingDone = true;
            }
        }

        return TestAuthResponse.builder()
                .isNewMember(isNewMember)
                .accessToken(token.getAccessToken())
                .refreshToken(token.getRefreshToken())
                .userSettingDone(isUserSettingDone)
                .build();
    }
}
