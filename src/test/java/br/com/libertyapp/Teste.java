package br.com.libertyapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.libertyapp.entidade.Mensagem;
import br.com.libertyapp.service.MensagemService;

@SpringBootTest
public class Teste {

	@Autowired
	MensagemService service;

	 @Test
	 public void testeObter() {
	 	List<Mensagem> lista = service.obter();
	 	System.out.println(lista.size());
	 }

	 @Test
	 public void testeBrowserMensagens() {
	 	try {
	 		List<Mensagem> mensagens = service.browserMensagens("DEV.QUEUE.1");
	 		
	 		System.out.println("Mensagens na fila: " + mensagens.size());

	 	} catch (Exception e) {
	 		e.printStackTrace();
	 	}
	 }

}
