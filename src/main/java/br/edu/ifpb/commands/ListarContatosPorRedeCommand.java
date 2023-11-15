package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.domain.Contato;

public class ListarContatosPorRedeCommand implements Command {
    @Override
    public void execute() {
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n=================================");
        System.out.println("Listar contatos por Rede Social");
        System.out.println("=================================\n");


        String atributoRedeSocial1 = "Instagram"; // Atributo de rede social desejado (por exemplo, "Instagram")
        String atributoRedeSocial2 = "Email";
        String atributoRedeSocial3 = "WhatsApp";        
        String atributoRedeSocial4 = "Telegram";

        

        for (Contato c : contatoService.getContatos()) {
            if (c.getRedeSocial() != null && c.getRedeSocial().equals(atributoRedeSocial1)) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("Rede Social: " + c.getRedeSocial());
                // Adicione outros atributos relevantes aqui
                System.out.println("-------------------------");
            }
            if (c.getRedeSocial() != null && c.getRedeSocial().equals(atributoRedeSocial2)) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("Rede Social: " + c.getRedeSocial());
                // Adicione outros atributos relevantes aqui
                System.out.println("-------------------------");
            }
            if (c.getRedeSocial() != null && c.getRedeSocial().equals(atributoRedeSocial3)) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("Rede Social: " + c.getRedeSocial());
                // Adicione outros atributos relevantes aqui
                System.out.println("-------------------------");
            }
            if (c.getRedeSocial() != null && c.getRedeSocial().equals(atributoRedeSocial4)) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("Rede Social: " + c.getRedeSocial());
                // Adicione outros atributos relevantes aqui
                System.out.println("-------------------------");
            }
        }
    }
}
