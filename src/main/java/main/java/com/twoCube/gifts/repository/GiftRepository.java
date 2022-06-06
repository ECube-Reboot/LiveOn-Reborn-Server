package main.java.com.twoCube.gifts.repository;

import main.java.com.twoCube.gifts.domain.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Long> {
}
