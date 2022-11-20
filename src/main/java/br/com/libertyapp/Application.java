package br.com.libertyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		
		//   ApplicationContext context = SpringApplication.run(Application.class);
	        try {

	            // MensagemService service = context.getBean(MensagemService.class);
	            
	            // List<Mensagem> mensagens = service.browserMensagens("QL.TESTE.PERFORMANCE.01");
	            
	            // System.out.println(">>>>>>> Qtd msgs: " + mensagens.size());
	            
	        } catch (Exception e) {
				e.printStackTrace();
			}
	}

}
