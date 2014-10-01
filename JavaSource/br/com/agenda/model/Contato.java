package br.com.agenda.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String nome;

	@Size(max = 100)
	@Column(length = 100)
	private String endereco;

	@Size(max = 60)
	@Column(length = 60)
	private String email;

	@Size(max = 60)
	@Column(length = 60)
	private String cidade;

	@Size(max = 2)
	@Column(length = 2)
	private String estado;

	@Size(max = 20)
	@Column(length = 20)
	private String cep;

	@Size(max = 3)
	@Column(length = 3)
	private String ddd;

	@Size(max = 30)
	@Column(length = 30)
	private String telefone;

	@Size(max = 30)
	@Column(length = 30)
	private String telefoneComercial;

	@Size(max = 30)
	@Column(length = 30)
	private String telefoneCelular;

	@Size(max = 30)
	@Column(length = 30)
	private String telefoneFax;

	@Size(max = 10)
	@Column(length = 10)
	private String ramal;

	@Column(columnDefinition = "text")
	private String informacoes;

	@Temporal(TemporalType.DATE)
	private Calendar dataInclusao = Calendar.getInstance();

	@Temporal(TemporalType.DATE)
	private Calendar dataAltarecao = Calendar.getInstance();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneFax() {
		return telefoneFax;
	}

	public void setTelefoneFax(String telefoneFax) {
		this.telefoneFax = telefoneFax;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Calendar getDataAltarecao() {
		return dataAltarecao;
	}

	public void setDataAltarecao(Calendar dataAltarecao) {
		this.dataAltarecao = dataAltarecao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
