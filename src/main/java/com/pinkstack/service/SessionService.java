package com.pinkstack.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionService {

    private Map<String, Integer> sessionIdMap = new HashMap<String, Integer>();

    public Integer createAndGetSessionId(String email) {
        Integer sessionId = email.hashCode();
        sessionIdMap.put(email, sessionId);
        return sessionId;
    }

    public Integer getSessionId(String email) {
         return sessionIdMap.get(email);
    }

    public boolean deleteSessionId(String email) {
        return sessionIdMap.remove(email) != null;
    }
}
