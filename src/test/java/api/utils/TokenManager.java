package api.utils;

import api.services.TokenService;

public class TokenManager {

    private static String token;

    public static String getToken() {

        if (token == null) {
            token = TokenService.generateToken();
        }
        return token;
    }
}
