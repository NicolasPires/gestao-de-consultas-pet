package com.nksolucoes.gestaodeconsultaspet;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nksolucoes.gestaodeconsultaspet.domain.Animal;
import com.nksolucoes.gestaodeconsultaspet.domain.Consulta;
import com.nksolucoes.gestaodeconsultaspet.domain.Tutor;
import com.nksolucoes.gestaodeconsultaspet.domain.Veterinario;
import com.nksolucoes.gestaodeconsultaspet.domain.enums.EspecieAnimal;
import com.nksolucoes.gestaodeconsultaspet.domain.enums.StatusConsulta;
import com.nksolucoes.gestaodeconsultaspet.repositorires.AnimalRepository;
import com.nksolucoes.gestaodeconsultaspet.repositorires.ConsultaRepository;
import com.nksolucoes.gestaodeconsultaspet.repositorires.TutorRepository;
import com.nksolucoes.gestaodeconsultaspet.repositorires.VeterinarioRepository;

@SpringBootApplication
public class GestaoDeConsultasPetApplication implements CommandLineRunner {

	@Autowired
	private VeterinarioRepository veterinarioRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private AnimalRepository animalRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeConsultasPetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Veterinario vet1 = new Veterinario(null, "Endrick Rodrigues", "endrick@gmail.com");
		Veterinario vet2 = new Veterinario(null, "Amanda Ferreira", "amanda@gmail.com");

		vet1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		vet2.getTelefones().addAll(Arrays.asList("32268472", "98745682"));

		Tutor tut1 = new Tutor(null, "Kirk Pires", "kirk@gmail.com");
		Tutor tut2 = new Tutor(null, "Katiuce Almeida", "katiuce@gmail.com");

		tut1.getTelefones().addAll(Arrays.asList("32265658", "98574523"));
		tut2.getTelefones().addAll(Arrays.asList("32878956", "98887456"));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Animal anim1 = new Animal(null, "Luck", EspecieAnimal.CAO, "Shitzu", sdf.parse("01/04/2015 15:30"), tut1);
		Animal anim2 = new Animal(null, "Theo", EspecieAnimal.GATO, "Persa", sdf.parse("22/12/2018 15:30"), tut2);

		Consulta con1 = new Consulta(null, sdf.parse("26/07/2021 15:30"), StatusConsulta.AGENDADA, vet1, anim1);
		Consulta con2 = new Consulta(null, sdf.parse("30/07/2021 09:45"), StatusConsulta.CONFIRMADA, vet2, anim2);
		Consulta con3 = new Consulta(null, sdf.parse("05/12/2021 11:00"), StatusConsulta.NAO_CONFIRMADA, vet1, anim2);

		vet1.getConsultas().addAll(Arrays.asList(con1, con3));
		vet2.getConsultas().addAll(Arrays.asList(con2));

		tut1.getAnimais().addAll(Arrays.asList(anim1));
		tut2.getAnimais().addAll(Arrays.asList(anim2));

		anim1.getConsultas().addAll(Arrays.asList(con1, con3));
		anim2.getConsultas().addAll(Arrays.asList(con2));

		tutorRepository.saveAll(Arrays.asList(tut1, tut2));
		animalRepository.saveAll(Arrays.asList(anim1, anim2));
		veterinarioRepository.saveAll(Arrays.asList(vet1, vet2));
		consultaRepository.saveAll(Arrays.asList(con1, con2, con3));

	}

}
