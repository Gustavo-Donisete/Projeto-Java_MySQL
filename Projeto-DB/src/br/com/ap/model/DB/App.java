package br.com.ap.model.DB;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String path = "C:\\Users\\gusta\\OneDrive\\Documentos\\servidores_cargo1.csv";
        File arq = new File(path);
        try {
            List<Cadastro> lst = leitor(arq);

            for (Cadastro cad : lst) {
                new CadastroDB().insert(cad);
                System.out.println(cad);
                System.out.println("Registro Inserido Com Sucesso!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Cadastro> leitor(File arq) throws IOException {
        List<Cadastro> lst = new ArrayList<Cadastro>();

        BufferedReader buffRead = Files.newBufferedReader(arq.toPath(), StandardCharsets.UTF_8);

        boolean primeiraLinha = true;

        String linha = buffRead.readLine();

        while (linha != null) {
            if (primeiraLinha) {
                primeiraLinha = false;
            } else {
                System.out.println(linha);
                String[] parts = linha.split(";");
                Cadastro cadastro = new Cadastro();

                cadastro.setCargo(parts[0]);
                cadastro.setQuantidade(Integer.parseInt(parts[1]));
                
                lst.add(cadastro);
            }

            linha = buffRead.readLine();

        }

        buffRead.close();

        return lst;
    }

}

