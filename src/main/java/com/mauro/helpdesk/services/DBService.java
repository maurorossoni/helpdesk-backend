package com.mauro.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mauro.helpdesk.domain.Chamado;
import com.mauro.helpdesk.domain.Cliente;
import com.mauro.helpdesk.domain.Tecnico;
import com.mauro.helpdesk.domain.enums.Perfil;
import com.mauro.helpdesk.domain.enums.Prioridade;
import com.mauro.helpdesk.domain.enums.Status;
import com.mauro.helpdesk.repositories.ChamadoRepository;
import com.mauro.helpdesk.repositories.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Mauro Test", "550.482.150-95", "mauro@helpdesk.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Luciano Sávio ", "903.347.070-56", "stallman@mail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Marcos Tonon ", "271.068.470-54", "shannon@mail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Hélton Nunes ", "162.720.120-39", "lee@mail.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Adalberto ", "778.556.170-27", "linus@mail.com", encoder.encode("123"));

		Cliente cli1 = new Cliente(null, "Videira", "111.661.890-74", "Videira@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Braço do norte", "322.429.140-06", "Braçodonorte@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Tubarão", "792.043.830-62", "Tubarão@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Orleans", "177.409.680-30", "Orleans@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Joaçaba", "081.399.300-83", "Joaçaba@mail.com", encoder.encode("123"));
 
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);

		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
}
