package main.java.br.edu.ifpb.commands;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;
import main.java.br.edu.ifpb.validators.EmailValidator;
import main.java.br.edu.ifpb.validators.IntervalValidator;
import main.java.br.edu.ifpb.validators.NonEmptyValidator;
import main.java.br.edu.ifpb.validators.ValidationContext;

public class AdicionarContatoCommand implements Command{
    @Override
    public void execute(){
        ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());

        System.out.println("\n-----------------------------------");
        System.out.println("Adicionar um novo contato");
        System.out.println("\n-----------------------------------");

    ValidationContext<String> strValidationContext = new ValidationContext<>(new NonEmptyValidator());
    

        System.out.println("Escolha a Rede Social:");
        System.out.println("[1] - Email");
        System.out.println("[2] - WhatsApp");
        System.out.println("[3] - Instagram");
        System.out.println("[4] - Telegram");

        ValidationContext<Integer> intValidationContext = new ValidationContext<>(new IntervalValidator(1, 4));

        int escolhaRedeSocial = intValidationContext.getValidValue("Escolha a opção desejada: ", "Escolha inválida, escolha entre 1 e 4 (inclusivo)", Integer.class);
        String redeSocial = "";

        String nome = strValidationContext.getValidValue("Nome: ", "Nome não pode ser vazio", String.class);
        String sobrenome = strValidationContext.getValidValue("Sobrenome: ", "Sobrenome não pode ser vazio", String.class);
        
        String telefone = strValidationContext.getValidValue("Telefone: ", "Telefone não pode ser vazio", String.class);

        String aniversario = strValidationContext.getValidValue("Aniversário: ", "Telefone não pode ser vazio", String.class);


        
        boolean ligacao = false; 
        boolean chamadaVideo = false; 
        String valorDaEntrada = ""; 

        if (escolhaRedeSocial == 1) {
            redeSocial = "Email";

            strValidationContext.setValidator(new EmailValidator(true));
            valorDaEntrada = strValidationContext.getValidValue("Email: ", "Email não pode ser vazio", String.class);
            
        } else if(escolhaRedeSocial == 2){
            redeSocial = "WhatsApp";
            valorDaEntrada = strValidationContext.getValidValue("Contato: ", "Contato não pode ser vazio", String.class);
            ligacao = true;
            chamadaVideo = true;

        } else if(escolhaRedeSocial == 3){
            redeSocial = "Instagram";
            valorDaEntrada = strValidationContext.getValidValue("Usuário: ", "Usuário não pode ser vazio", String.class);
            ligacao = true;
            chamadaVideo = true;

        } else if(escolhaRedeSocial == 4){
            redeSocial = "Telegram";
            valorDaEntrada = strValidationContext.getValidValue("d: ", "Id não pode ser vazio", String.class);
            ligacao = true;
        } 


        

        contatoService.criar(nome, sobrenome, ligacao, chamadaVideo, "nenhuma", valorDaEntrada, redeSocial, telefone, aniversario);
        System.out.println("Contato adicionado ao aplicativo " + redeSocial + " com sucesso!");

    }
}
