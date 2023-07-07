package encriptador.springframework.springencriptadorwebapp.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class DecryptTextRepository {
    static char arrayCifrar[][];

    public String decryptByColumn(String text, int columnsNumber){
        int columns = 0, rows = 0;
        float aux = 0;
        if(text.length() > 255){
            return "El texto es demasiado grande";
        }
        else{
            text = text.toUpperCase();
            text = text.replace(" ", "");
            aux = (float) text.length() / (float) columns;
            rows = (int) Math.ceil(aux);
            return "El texto descifrado es: " + decryptColumnAlgorithm(columns, rows, text);
        }
    }

    public String decryptByKey(String text, String key){
        return "hola2";
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
}
