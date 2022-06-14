package com.twoCube.auth.main;

import com.twoCube.auth.Token.*;
import com.twoCube.members.domain.Member;
import com.twoCube.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final TokenService tokenService;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenReissueDto reissue(TokenReissueDto tokenReissueRequest) {
        Long timeLeft = tokenService.verifyRefreshToken(tokenReissueRequest.getRefreshToken());
        if (timeLeft == 0) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }
        String currentSocialId = tokenService.getSocialId(tokenReissueRequest.getAccessToken());

        RefreshToken refreshToken = refreshTokenRepository.findById(currentSocialId)
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        if (!refreshToken.getToken().equals(tokenReissueRequest.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        TokenDto tokenDto = tokenService.generateToken(currentSocialId, "USER");
        TokenReissueDto tokenReissueResponse;
        if (timeLeft < 1000L * 60L * 60L * 24L * 3L) {

            refreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
            refreshTokenRepository.save(refreshToken);

            tokenReissueResponse = TokenReissueDto.builder()
                    .accessToken(tokenDto.getAccessToken())
                    .refreshToken(tokenDto.getRefreshToken())
                    .build();
        } else {
            String accessToken = tokenService.generateAccessToken(currentSocialId, "USER");
            tokenReissueResponse = TokenReissueDto.builder()
                    .accessToken(tokenDto.getAccessToken())
                    .refreshToken(tokenReissueRequest.getRefreshToken())
                    .build();
        }
        return tokenReissueResponse;
    }
}
