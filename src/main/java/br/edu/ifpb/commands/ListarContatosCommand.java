package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.domain.Contato;

public class ListarContatosCommand implements Command {
    @Override
    public void execute() {
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n\n=================================");
        System.out.println("Listar contatos por Rede Social\n");

        String atributoRedeSocial = "Instagram"; // Atributo de rede social desejado (por exemplo, "Instagram")

        for (Contato c : contatoService.getContatos()) {
            if (c.getRedeSocial() != null && c.getRedeSocial().equals(atributoRedeSocial)) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("Rede Social: " + c.getRedeSocial());
                // Adicione outros atributos relevantes aqui
                System.out.println("====================");
            }
        }
    }
}
