package com.twoCube.auth;


import com.twoCube.members.domain.Member;

import java.security.NoSuchAlgorithmException;

public interface ClientProxy {
    Member getUserData(String accessToken) throws NoSuchAlgorithmException;
}
