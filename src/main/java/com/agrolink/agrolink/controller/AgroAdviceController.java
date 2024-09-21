package com.agrolink.agrolink.controller;
import com.agrolink.agrolink.model.AgroAdvice;
import com.agrolink.agrolink.service.AgroAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advice")
public class AgroAdviceController {

    @Autowired
    private AgroAdviceService agroAdviceService;

    @GetMapping("/all")
    public ResponseEntity<List<AgroAdvice>> getAllAgroAdvice() {
        List<AgroAdvice> adviceList = agroAdviceService.getAllAgroAdvice();
        return ResponseEntity.ok(adviceList);
    }

    @GetMapping("/find")
    public ResponseEntity<List<AgroAdvice>> findAdviceByLanguage(@RequestParam String language) {
        List<AgroAdvice> adviceList = agroAdviceService.findAdviceByLanguage(language);
        return ResponseEntity.ok(adviceList);
    }

    @PostMapping("/create")
    public ResponseEntity<AgroAdvice> createAgroAdvice(@RequestBody AgroAdvice advice) {
        AgroAdvice newAdvice = agroAdviceService.createAgroAdvice(advice);
        return ResponseEntity.ok(newAdvice);
    }

    @PutMapping("/update")
    public ResponseEntity<AgroAdvice> updateAgroAdvice(@RequestBody AgroAdvice advice) {
        AgroAdvice updatedAdvice = agroAdviceService.updateAgroAdvice(advice);
        return ResponseEntity.ok(updatedAdvice);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAgroAdvice(@PathVariable Long id) {
        agroAdviceService.deleteAgroAdvice(id);
        return ResponseEntity.noContent().build();
    }
}

