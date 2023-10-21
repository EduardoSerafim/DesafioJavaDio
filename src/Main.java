import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
//        analisarCandidato(1900);
//        analisarCandidato(2200);
//        analisarCandidato(2000);

//        selecaoCandidatos();

//        imprimirSelecionados();



        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }

    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            }else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        }while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        }else{
            System.out.println("NÂO CONSEGUIMOS CONTATO COM " + candidato + " NUMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADA");

        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de número " + (i + 1) + " é " + candidatos[i] );
        }

        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato);
        }

    }

    static void selecaoCandidatos(){
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato " + candidato + " Solicitou este valor de saláirio " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " Foi selecionado para a vaga" );
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA CANDIDATO COM CONTRAPROPOSTA");
        }else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}