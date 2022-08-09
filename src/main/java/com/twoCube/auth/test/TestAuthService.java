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

            //refreshToken 저장
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
