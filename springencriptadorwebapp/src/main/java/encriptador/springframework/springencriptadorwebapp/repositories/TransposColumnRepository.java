package encriptador.springframework.springencriptadorwebapp.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class TransposColumnRepository {
    static char arrayCifrar[][];

    public String cryptText(String text){
        int renglones = 4, columnas;
        float aux;
        if (text.length() > 255){
            return "El texto es demasiado grande";
        }
        else{
            text = text.toUpperCase();
            text = text.replaceAll(" ", "" );
            //AQUI EMPIEZA CALCULO DE COLUMNAS, RENGLONES DEBERIA SER 3,4 O 5
            aux = (float)text.length() / (float)renglones;
            columnas = (int)Math.ceil(aux);
            text = Cifrar(columnas, renglones, text);
            return "El texto cifrado es: " + text;

        }
    }

    private static String Cifrar (int col, int ren, String texto){
        String newtext = "";
        arrayCifrar = new char [ren][col];
        int numChar = 0;
        for(int i = 0; i < ren; i++){
            for(int j = 0; j < col; j++){
                if(numChar < texto.length()){
                    arrayCifrar[i][j] = texto.charAt(numChar);
                    numChar++;
                }
                else{
                    arrayCifrar[i][j] = '$';
                }
            }
        }

        for(int j = 0; j < col; j++){
            for(int i = 0; i < ren; i++){
                newtext = newtext + arrayCifrar[i][j];
            }
            if(j+1 != col){
                newtext = newtext + " ";
            }
        }
        return newtext;
    }

}
