package main.java.br.edu.ifpb.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.br.edu.ifpb.repository.ContatoRepository;
import main.java.br.edu.ifpb.service.ContatoService;

public class EmailValidator implements Validator<String>{
    private final ContatoService contatoService = new ContatoService(ContatoRepository.getInstance());
    private final boolean checkIfExists;

    public EmailValidator(boolean checkIfExists) {
        // Construtor da classe que permite definir se a validação deve verificar a existência do CPF.
        this.checkIfExists = checkIfExists;
    }

    @Override
    public boolean validate(String data) {
        String contatoPattern = "^[A-Za-z0-9+_.-]+@(.+)$"; 
        Pattern pattern = Pattern.compile(contatoPattern);
        Matcher matcher = pattern.matcher(data);

    return matcher.matches() && (!checkIfExists || !contatoService.existe(data));




    }

}

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; // Padrão de email simples
        return email.matches(regex);
    }

        return matcher.matches() && (!checkIfExists || !pacienteService.existe(data));
        // matcher.matches(): Verifica se o CPF está no formato correto. Se o formato estiver correto, isso é verdadeiro (true).
        // checkIfExists: É uma configuração que diz se você deseja verificar se o CPF já existe em algum lugar. Se for verdadeiro (true), você deseja essa 
        // verificação. Se for falso (false), você não deseja. pacienteService.existe(data): Isso verifica se o CPF já existe no repositório de pacientes. 
        // Se o CPF já existir, isso é verdadeiro (true).
        
        // Agora, a linha (!checkIfExists || !pacienteService.existe(data)) pode ser explicada da seguinte maneira:

        // !checkIfExists: Se checkIfExists for verdadeiro (true), isso se torna falso (false). Se checkIfExists for falso, isso se torna verdadeiro.
        // ||: Isso é o operador "OU". Ele retorna verdadeiro se pelo menos uma das duas partes é verdadeira.

        // Portanto, (!checkIfExists || !pacienteService.existe(data)) significa o seguinte:

        // Se checkIfExists for falso (você não deseja verificar a existência do CPF), então (!checkIfExists) se torna verdadeiro.
        // Se checkIfExists for verdadeiro (você deseja verificar a existência do CPF), então (!checkIfExists) se torna falso, a menos que 
        // pacienteService.existe(data) seja verdadeiro (o CPF já existe no repositório).

        // Se você não deseja verificar a existência do CPF, apenas verifica se o formato está correto (matcher.matches()).
        // Se você deseja verificar a existência do CPF, ele verifica o formato e também verifica se o CPF não existe no repositório (!pacienteService.existe(data)). Se o CPF não existir no repositório, a validação é bem-sucedida.
    
    
    }
}


// Pattern é usado para definir o padrão de expressão regular que descreve o formato esperado de um número de CPF. Ele é como a "receita" que diz como um CPF deve ser estruturado.

// Matcher é usado para comparar o CPF fornecido com o padrão definido em Pattern. Ele é como a "ferramenta" que verifica se o CPF corresponde ao formato especificado.

// Portanto, Pattern é usado para criar o padrão e Matcher é usado para aplicar esse padrão ao CPF, verificando se o CPF está no formato correto. Em conjunto, essas duas classes 
// permitem validar se o CPF segue as regras definidas pela expressão regular.



// Suponha que você deseja verificar se o CPF "123.456.789-09" é válido. A linha return matcher.matches() && (!checkIfExists || !pacienteService.existe(data)); 
// realiza a validação da seguinte maneira:

// matcher.matches(): Esta parte verifica se o CPF "123.456.789-09" está no formato correto, que é XXX.XXX.XXX-XX, onde "X" representa um dígito. Nesse caso, 
// o formato está correto, então matcher.matches() retorna true.

// checkIfExists: Suponha que checkIfExists seja true, o que significa que você deseja verificar se o CPF já existe no repositório de pacientes.

// !checkIfExists: Como checkIfExists é true, !checkIfExists se torna false. Ou seja, a validação continuará verificando a existência do CPF no repositório.

// pacienteService.existe(data): Suponha que o CPF "123.456.789-09" não exista no repositório de pacientes. Nesse caso, pacienteService.existe(data) retorna false.

// Agora, vamos combinar todas as partes:

// matcher.matches() é true porque o formato está correto.
// !checkIfExists é false porque você deseja verificar a existência do CPF.
// pacienteService.existe(data) é false porque o CPF não existe no repositório.
// A validação é bem-sucedida porque a expressão (!checkIfExists || !pacienteService.existe(data)) retorna true no final. Isso significa que o 
// CPF "123.456.789-09" é válido de acordo com os critérios definidos.

// Lembre-se de que o resultado final depende das configurações de checkIfExists e da existência do CPF no repositório. Se checkIfExists for false, 
// a validação será bem-sucedida apenas com base no formato. Se checkIfExists for true, a validação exigirá que o CPF esteja no formato correto e não exista no repositório para ser considerada bem-sucedida.





