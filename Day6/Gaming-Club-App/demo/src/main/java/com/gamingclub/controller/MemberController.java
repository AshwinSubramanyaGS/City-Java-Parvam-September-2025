package com.gamingclub.controller;
import com.gamingclub.dto.MemberRequest;
import com.gamingclub.dto.MemberResponse;
import com.gamingclub.dto.SearchRequest;
import com.gamingclub.model.Member;
import com.gamingclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberRequest request) {
        Member member=null;
        Map<String, Object> errorBody = new LinkedHashMap<>();
        try{
            member = memberService.createMember(request);
            return ResponseEntity.ok(member);
        }
        catch (RuntimeException e){
            errorBody.put("timestamp", LocalDateTime.now());
            errorBody.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorBody.put("error", "Member already exists");
            errorBody.put("message", "Member already exists");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Member) errorBody);
    }

    @PostMapping("/search")
    public ResponseEntity<MemberResponse> searchMember(@RequestBody SearchRequest request) {
        MemberResponse response = memberService.searchMember(request.getPhone());
        return ResponseEntity.ok(response);
    }
}