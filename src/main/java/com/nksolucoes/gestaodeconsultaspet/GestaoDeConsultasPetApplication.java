package com.nksolucoes.gestaodeconsultaspet;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nksolucoes.gestaodeconsultaspet.domain.Consulta;
import com.nksolucoes.gestaodeconsultaspet.domain.Veterinario;
import com.nksolucoes.gestaodeconsultaspet.domain.enums.StatusConsulta;
import com.nksolucoes.gestaodeconsultaspet.repositorires.ConsultaRepository;
import com.nksolucoes.gestaodeconsultaspet.repositorires.VeterinarioRepository;

@SpringBootApplication
public class GestaoDeConsultasPetApplication implements CommandLineRunner {

	@Autowired
	private VeterinarioRepository veterinarioRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeConsultasPetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Veterinario vet1 = new Veterinario(null, "Endrick Rodrigues", "endrick@gmail.com");
		Veterinario vet2 = new Veterinario(null, "Amanda Ferreira", "amanda@gmail.com");

		vet1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		vet2.getTelefones().addAll(Arrays.asList("32268472", "98745682"));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Consulta con1 = new Consulta(null, sdf.parse("26/07/2021 15:30"), StatusConsulta.AGENDADA, vet1);
		Consulta con2 = new Consulta(null, sdf.parse("30/07/2021 09:45"), StatusConsulta.CONFIRMADA, vet2);
		Consulta con3 = new Consulta(null, sdf.parse("05/05/2021 11:00"), StatusConsulta.NAO_CONFIRMADA, vet1);

		vet1.getConsultas().addAll(Arrays.asList(con1, con3));
		vet2.getConsultas().addAll(Arrays.asList(con2));

		veterinarioRepository.saveAll(Arrays.asList(vet1, vet2));
		consultaRepository.saveAll(Arrays.asList(con1, con2, con3));

	}

}
