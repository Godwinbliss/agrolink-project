package com.agrolink.agrolink.controller;

import com.agrolink.agrolink.service.UssdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ussd")
public class UssdController {

    @Autowired
    private UssdService ussdService;

    @GetMapping(path = "/welcome")
    public String index() {
        return "Your have reached us";
    }

    @PostMapping()
    public String handleUssdRequest(@RequestParam String sessionId,
                                    @RequestParam String phoneNumber,
                                    @RequestParam String text) {
        return ussdService.processUssdInput(sessionId, phoneNumber, text);
    }
}
