package br.com.paneladev.repository;

import br.com.paneladev.entity.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmailRepository extends MongoRepository<Email, String> {

    List<Email> findBySendFalse();
}
