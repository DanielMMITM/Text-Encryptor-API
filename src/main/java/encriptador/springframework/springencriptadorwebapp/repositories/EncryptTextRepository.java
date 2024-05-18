package encriptador.springframework.springencriptadorwebapp.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class EncryptTextRepository {
    static char arrayCifrar[][];

    public String cryptByColumn(String text, int rowsNumber){
        int rows = rowsNumber, columnas;
        float aux;
        if (text.length() > 255){
            return "El texto es demasiado grande";
        }
        else{
            text = text.toUpperCase();
            text = text.replaceAll(" ", "" );
            //AQUI EMPIEZA CALCULO DE COLUMNAS, RENGLONES DEBERIA SER 3,4 O 5
            aux = (float)text.length() / (float)rows;
            columnas = (int)Math.ceil(aux);
            return "El texto cifrado es: " + columnCryptAlgorithm(columnas, rows, text) + ". Con un total de " + columnas + " columnas";
        }
    }

    public String cryptByKey(String text, String key){
        if (text.length() > 255){
            return "El texto es demasiado grande";
        }
        else{
            text = text.toUpperCase();
            text = text.replaceAll(" ", "");
            if(key.length() > 50){
                return "La clave es demasiado grande";
            }
            else{
                key = key.toUpperCase();
                key = key.replaceAll(" ", "");
                float aux = (float)text.length() / (float)key.length();
                int rows = (int)Math.ceil(aux);
                return "El texto cifrado es el siguiente: " + keyCryptAlgorithm(key.length(), rows+1, text, key);
            }

        }
    }

    private static String columnCryptAlgorithm (int col, int ren, String texto){
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

    private static String keyCryptAlgorithm(int cols, int rows, String text, String key){
        arrayCifrar = new char [rows][cols];
        int numChar = 0;
        String cryptedText ="";
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0){
                    arrayCifrar[i][j] = key.charAt(j);
                }
                else{
                    if(numChar < text.length()){
                        arrayCifrar[i][j] = text.charAt(numChar);
                        numChar++;
                    }
                    else{
                        arrayCifrar[i][j] = '$';
                    }
                }
            }
        }

        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                System.out.print(arrayCifrar[i][j] + " ");
            }
            System.out.println("");
        }
        String orderedKey = orderKey(key);

        System.out.println("\n\nEl texto quedara cifrado con respecto a este orden alfabetico: " + orderedKey);

        // COLOCACION DE ORDEN NUEVO PARA IMPRIMIR LA FRASE CIFRADA
        int[] ordenPosChar = new int[orderedKey.length()];
        for (int i = 0; i < orderedKey.length(); i++) {
            for (int j = 0; j < orderedKey.length(); j++) {
                if (orderedKey.charAt(i) == key.charAt(j)) {
                    ordenPosChar[i] = j;
                }
            }
        }

        // IMPRIMIR LA MATRIZ EN EL ORDEN CORRECTO PARA QUE ESTE CIFRADO
        for (int j = 0; j < ordenPosChar.length; j++) {
            for (int i = 1; i < rows; i++) {
                cryptedText = cryptedText + (arrayCifrar[i][ordenPosChar[j]]);
            }
            if(j < ordenPosChar.length-1){
                cryptedText = cryptedText + " ";
            }
        }
        return cryptedText;
    }

    protected static String orderKey(String key){
        char aux, orderArray[];
        String orderedKey = "";
        orderArray = new char [key.length()];
        for(int i = 0; i < orderArray.length; i++){
            orderArray[i] = key.charAt(i);
        }
        for (int i = 0; i < orderArray.length; i++) {
            for(int j = 0; j < orderArray.length - 1; j++){
                if(orderArray[j] > orderArray[j+1]){
                    aux = orderArray[j];
                    orderArray[j] = orderArray[j+1];
                    orderArray[j+1] = aux;
                }
            }
        }

        for(int i = 0; i < orderArray.length; i++){
            orderedKey = orderedKey + orderArray[i];
        }

        return orderedKey;
    }

}
