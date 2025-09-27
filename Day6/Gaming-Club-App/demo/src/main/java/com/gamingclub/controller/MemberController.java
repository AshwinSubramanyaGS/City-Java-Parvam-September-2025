package com.gamingclub.controller;
import com.gamingclub.dto.MemberRequest;
import com.gamingclub.dto.MemberResponse;
import com.gamingclub.dto.SearchRequest;
import com.gamingclub.model.Member;
import com.gamingclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberRequest request) {
        Member member = memberService.createMember(request);
        return ResponseEntity.ok(member);
    }

    @PostMapping("/search")
    public ResponseEntity<MemberResponse> searchMember(@RequestBody SearchRequest request) {
        MemberResponse response = memberService.searchMember(request.getPhone());
        return ResponseEntity.ok(response);
    }
}