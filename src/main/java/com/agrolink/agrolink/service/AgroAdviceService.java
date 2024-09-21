package com.agrolink.agrolink.service;

import com.agrolink.agrolink.model.AgroAdvice;
import com.agrolink.agrolink.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgroAdviceService {


        @Autowired
        private AdviceRepository adviceRepository;

        public List<AgroAdvice> getAllAgroAdvice() {
            return adviceRepository.findAll();
        }

        public List<AgroAdvice> findAdviceByLanguage(String language) {
            return adviceRepository.findByLanguage(language);
        }

        public AgroAdvice createAgroAdvice(AgroAdvice advice) {
            return adviceRepository.save(advice);
        }

        public AgroAdvice updateAgroAdvice(AgroAdvice advice) {
            return adviceRepository.save(advice);
        }

        public void deleteAgroAdvice(Long id) {
            adviceRepository.deleteById(id);
        }

    public String getAdviceByLanguage(String language) {
            return adviceRepository.findByLanguage(language).toString();
    }
}
