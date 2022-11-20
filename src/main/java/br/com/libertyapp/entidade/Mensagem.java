package br.com.libertyapp.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENSAGEM")
public class Mensagem {

    @Id
    @Column(name = "ID", length = 24)
    private String id;

    @Column(name = "TEXTO")
    private String texto;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}