package com.thoughtworks.aceleradora.controller;

import com.thoughtworks.aceleradora.domain.NetPromoterScore;
import com.thoughtworks.aceleradora.service.NetPromoterScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/net-promoter-score")
public class NetPromoterScoreController {
    private NetPromoterScoreService netPromoterScoreService;

    @Autowired
    public NetPromoterScoreController(NetPromoterScoreService netPromoterScoreService) {
        this.netPromoterScoreService = netPromoterScoreService;
    }

    @PostMapping
    public NetPromoterScore saveNPS(@RequestBody NetPromoterScore netPromoterScore) {
        NetPromoterScore newNPS =  new NetPromoterScore();
        return netPromoterScoreService.saveNPS(newNPS);
    }
}

