/*
 * Copyright 2023-2025 EAIRP Team, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://opensource.wansenai.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.wansenai.middleware.security;

import tools.jackson.databind.ObjectMapper;
import com.wansenai.utils.redis.RedisUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor { //校验类

    private final RedisUtil redisUtil;

    private final JWTUtil jwtUtil;

    public JWTInterceptor(RedisUtil redisUtil, JWTUtil jwtUtil) {
        this.redisUtil = redisUtil;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<Object, Object> map = new HashMap<>();
        String requestToken = request.getHeader("Authorization");
        if(StringUtils.hasText(requestToken)){
            Claims claims = jwtUtil.checkToken(request.getHeader("Authorization"));
            if (claims != null) {
                String token = redisUtil.getString(claims.get("userName") + ":token");
                if(Boolean.TRUE.equals(redisUtil.hasKey(claims.get("userName") + ":token"))){
                    if(requestToken.equals(token)){
                        // token正确
                        return true;
                    }else {
                        // token错误，判为并发登录，挤下线
                        // 对应的修改响应头的状态，用于前端判断做出相应的策略
                        map.put("msg", "token无效签名");
                        map.put("code", "A0312");
                        log.error("用户token验证失败======>" + "无效签名");
                    }
                }else {
                    // token不存在于redis中，已过期
                    map.put("msg", "token过期");
                    map.put("code", "A0312");
                    log.error("用户token验证失败======>" + "token过期");
                }
            }
        }
        // 这里先不做token的判断，不然首次前端加载会出现token无效给用户造成误解 2024-08-12
        // map.put("msg", "token无效");
        // map.put("code", "A0312");

        String value = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(value);
        return false;



//        Map<Object, Object> map = new HashMap<>();
//        String token = request.getHeader("Authorization");
//        try {
//            JWTUtils.verify(token); //验证令牌
//            Long userId = JWTUtils.getToken(token);
//            return true; //放行请求
//        } catch (SignatureVerificationException e) {
//            log.error("用户token验证失败======>" + "无效签名");
//            map.put("msg", "无效签名");
//        } catch (TokenExpiredException e) {
//            log.error("用户token验证失败======>" + "token过期");
//            map.put("msg", "token过期");
//        } catch (AlgorithmMismatchException e) {
//            log.error("用户token验证失败======>" + "token算法不一致");
//            map.put("msg", "token算法不一致");
//        } catch (Exception e) {
//            log.error("用户token验证失败======>" + "token无效");
//            map.put("msg", "token无效");
//        }
//        map.put("code", "A0312");
//        String value = new ObjectMapper().writeValueAsString(map);
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().println(value);
//        return false;
    }

}
