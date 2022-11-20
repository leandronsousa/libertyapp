package br.com.libertyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.libertyapp.entidade.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, String> {

    boolean existsById(String id);

}
