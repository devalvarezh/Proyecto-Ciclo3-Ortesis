package com.AlquilerOrtesis.Ortesis3.Repositories;

import com.AlquilerOrtesis.Ortesis3.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCRUDRepository extends CrudRepository<Message, Integer> {
}
