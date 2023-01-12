package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HorasContrato;
import entidades.Trabalhador;
import entidades.enums.LevelTrabalhador;

public class Programa {
	public void main(String args[]) throws ParseException {
		Scanner num = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Insira o nome do departamento: ");
		String nomeDepartamento = num.nextLine();

		System.out.print("Insira os dados do trabalhador");
		System.out.print("Insira o nome: ");
		String nomeTrabalhador = num.nextLine();
		System.out.print("Insira o level: ");
		String levelTrabalhador = num.nextLine();
		System.out.print("Insira o salario base: ");
		double salarioBase = num.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, LevelTrabalhador.valueOf(levelTrabalhador),
				salarioBase, new Departamento(nomeDepartamento));

		System.out.println("Quantos contratos este trabalhador tem? ");
		int cont = num.nextInt();
		for (int i = 1; i < cont; i++) {
			System.out.printf("Insira a data do %d contrato: ", i);
			System.out.print("Data(DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(num.next());
			System.out.print("Qual o valor por hora? ");
			double valorPorHora = num.nextDouble();
			System.out.print("Duracao em horas: ");
			int horas = num.nextInt();

			HorasContrato contrato = new HorasContrato(dataContrato, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}

		System.out.print("Informe o mes e ano para calcular o salario(MM/YYYY): ");
		String mesAno = num.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2)); // Substring recorta a string do 0 ao 2. pegando apenas o
															// mes no formato digitado
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Total do " + mesAno + ": " + String.format("%.2f ", trabalhador.total(ano, mes)));
		num.close();
	}

}
