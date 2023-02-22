package com.auto.dealeraudit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auto.dealeraudit.dto.Section;

public interface SectionRepository extends JpaRepository<Section, Integer> {

}
