//package com.application.nextshow.security.jwt;
//
//
//import com.application.nextshow.services.impl.UserDetailsImpl;
//import jakarta.servlet.http.HttpServletRequest;
//
//import java.util.stream.Collectors;
//
////contains all the JWT helper methods that our app needs
//public class JwtUtils {
//    //pass the jwt token using authorization header
//    //Authorization -> Bearer<TOKEN >
//    public String getJwtToken(HttpServletRequest request){
//        //first get the token from the Authorization Header
//        String bearerToken = request.getHeader("Authorization");
//        //check
//        //removing bearer prefix wth the space
//        if(bearerToken != null && bearerToken.startsWith("bearer ")){
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//    public String generateToken(UserDetailsImpl userDetails){
//        String username = userDetails.getUsername();
//        String roles = userDetails.getAuthorities().stream()
//                .map(authority -> userDetails.getAuthorities())
//                .collect(Collectors.joining(","));
//    }
//}
