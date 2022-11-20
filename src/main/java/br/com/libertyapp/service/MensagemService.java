package br.com.libertyapp.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.libertyapp.entidade.Mensagem;
import br.com.libertyapp.repository.MensagemRepository;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository repository;

	@Autowired
	JmsTemplate jmsTemplate;

	public List<Mensagem> obter() {
		return repository.findAll();
	}

	public List<Mensagem> browserMensagens(String nomeFila) {
    	return jmsTemplate.browse(nomeFila, (session, browser) -> {
            @SuppressWarnings("rawtypes")
            Enumeration mensagensDaFila = browser.getEnumeration();
            List<Mensagem> mensagens = new ArrayList<Mensagem>();
            while (mensagensDaFila.hasMoreElements()) {
                try {
                    TextMessage msg = TextMessage.class.cast(mensagensDaFila.nextElement());
                    String id = msg.getStringProperty("id");

                    Mensagem mensagem = new Mensagem();
                    mensagem.setId(id);
                    mensagem.setTexto(msg.getText());

                    mensagens.add(mensagem);
                } catch (ClassCastException e) {
                    
                }
            }
            return mensagens;
        });
    }

}
