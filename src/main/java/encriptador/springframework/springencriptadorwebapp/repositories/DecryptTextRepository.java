package encriptador.springframework.springencriptadorwebapp.repositories;

import org.springframework.stereotype.Repository;

import static encriptador.springframework.springencriptadorwebapp.repositories.EncryptTextRepository.orderKey;

@Repository
public class DecryptTextRepository {
    static char arrayCifrar[][];

    public String decryptByColumn(String text, int columnsNumber){
        int rows = 0;
        float aux = 0;
        if(text.length() > 255){
            return "The text is too long";
        }
        else{
            text = text.toUpperCase();
            text = text.replace(" ", "");
            aux = (float) text.length() / (float) columnsNumber;
            rows = (int) Math.ceil(aux);
            return "The encrypted text is: " + decryptColumnAlgorithm(columnsNumber, rows, text);
        }
    }

    public String decryptByKey(String text, String key){
        if(text.length() > 255){
            return "The text is too long";
        }
        else{
            text = text.toUpperCase();
            text = text.replace(" ", "");
            if (key.length() > 50){
                return "The key is too long";
            }
            else{
                key = key.toUpperCase();
                key = key.replaceAll(" ", "");
                float aux = (float)text.length() / (float)key.length();
                int rows = (int)Math.ceil(aux);
                return "The encrypted text is: " + decryptKeyAlgorithm(key.length(), rows, text, key);
            }

        }
    }

    private static String decryptColumnAlgorithm(int col, int ren, String texto) {
        String textDescifrado = "";
        int numChar = 0;
        arrayCifrar = new char[ren][col];
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < ren; i++) {
                if (numChar < texto.length()) {
                    arrayCifrar[i][j] = texto.charAt(numChar);
                    numChar++;
                } else {
                    arrayCifrar[i][j] = '$';
                }
            }
        }

        for (int i = 0; i < ren; i++) {
            for (int j = 0; j < col; j++) {
                if (arrayCifrar[i][j] != '$') {
                    textDescifrado = textDescifrado + arrayCifrar[i][j];
                } else {
                    break;
                }
            }
        }
        return textDescifrado;
    }

    private static String decryptKeyAlgorithm(int cols, int rows, String text, String key){
        String newText = "";
        int numChar = 0;
        arrayCifrar = new char [rows][cols];

        String claveOrdenada = orderKey(key);

        int[] ordenPosChar = new int[claveOrdenada.length()];
        for (int i = 0; i < claveOrdenada.length(); i++) {
            for (int j = 0; j < claveOrdenada.length(); j++) {
                if (claveOrdenada.charAt(i) == key.charAt(j)) {
                    ordenPosChar[i] = j;
                }
            }
        }

        char[][] arrayCifrar = new char[rows][cols];
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (numChar < text.length()) {
                    arrayCifrar[i][ordenPosChar[j]] = text.charAt(numChar);
                    numChar++;
                }
                else{
                    arrayCifrar[i][ordenPosChar[j]] = '$';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(arrayCifrar[i][j] != '$'){
                    newText = newText + arrayCifrar[i][j];
                    System.out.print(arrayCifrar[i][j] + " ");
                }
                else{
                    break;
                }
            }
        }
        return newText;
    }
}
