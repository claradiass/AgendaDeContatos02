package main.java.br.edu.ifpb;

import java.util.Scanner;

import main.java.br.edu.ifpb.commands.AdicionarContatoCommand;
import main.java.br.edu.ifpb.commands.CommandExecutor;
import main.java.br.edu.ifpb.commands.ListarContatosCommand;
import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.repository.FileDataService;

public class AgendaDeContatosConsoleApplication {
    public static void main(String[] args) {
        ContatoRepository dataService = ContatoRepository.getInstance();
        dataService.setRepository(new FileDataService());
        CommandExecutor executor = new CommandExecutor();

        Scanner leitor = new Scanner(System.in);

        int op = -1;

        while (op != 7) {
            System.out.println("\n=================================");
            System.out.println("MENU");
            System.out.println("[1] - Adicionar contato");
            System.out.println("[2] - Editar contato");
            System.out.println("[3] - Listar contatos");
            System.out.println("[4] - Buscar contatos");
            System.out.println("[5] - Excluir contato");
            System.out.println("[6] - Sair");

            System.out.print("Digite a opção -> ");
            op = leitor.nextInt();
            leitor.nextLine();

            switch (op) {
                case 1 -> executor.executeCommand(new AdicionarContatoCommand());
                case 2 -> executor.executeCommand(new ListarContatosCommand());
                case 6 ->
                default -> System.out.println("Opção inválida");
                
            }

        }
    }
}
