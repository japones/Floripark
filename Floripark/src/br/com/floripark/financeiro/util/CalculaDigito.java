package br.com.floripark.financeiro.util;

public class CalculaDigito {

    private String ret;

    public String CodigoBarra(String linha) {
        // ***********
        // * CAMPO 1 *
        // ***********
        Integer[] campo1 = new Integer[9];
        Integer dvCampo1;
        String sCampo1 = "";
        campo1[0] = Integer.parseInt(linha.substring(17, 18));
        campo1[1] = Integer.parseInt(linha.substring(18, 19));
        campo1[2] = Integer.parseInt(linha.substring(19, 20));
        campo1[3] = Integer.parseInt(linha.substring(20, 21));
        campo1[4] = Integer.parseInt(linha.substring(36, 37));
        campo1[5] = Integer.parseInt(linha.substring(37, 38));
        campo1[6] = Integer.parseInt(linha.substring(38, 39));
        campo1[7] = Integer.parseInt(linha.substring(39, 40));
        campo1[8] = Integer.parseInt(linha.substring(40, 41));
        dvCampo1 = CalcularFator10(campo1);
        for (int i = 0; i < campo1.length; i++) {
            if (i != 5) {
                sCampo1 = sCampo1 + String.valueOf(campo1[i]);
            } else {
                sCampo1 = sCampo1 + "." + String.valueOf(campo1[i]);
            }
        }
        sCampo1 = sCampo1 + String.valueOf(dvCampo1);

        // ***********
        // * CAMPO 2 *
        // ***********
        Integer[] campo2 = new Integer[10];
        Integer dvCampo2;
        String sCampo2 = "";
        campo2[0] = Integer.parseInt(linha.substring(41, 42));
        campo2[1] = Integer.parseInt(linha.substring(42, 43));
        campo2[2] = Integer.parseInt(linha.substring(43, 44));
        campo2[3] = Integer.parseInt(linha.substring(44, 45));
        campo2[4] = Integer.parseInt(linha.substring(45, 46));
        campo2[5] = Integer.parseInt(linha.substring(46, 47));
        campo2[6] = Integer.parseInt(linha.substring(47, 48));
        campo2[7] = Integer.parseInt(linha.substring(48, 49));
        campo2[8] = Integer.parseInt(linha.substring(49, 50));
        campo2[9] = Integer.parseInt(linha.substring(50, 51));
        dvCampo2 = CalcularFator10(campo2);
        for (int i = 0; i < campo2.length; i++) {
            if (i != 5) {
                sCampo2 = sCampo2 + String.valueOf(campo2[i]);
            } else {
                sCampo2 = sCampo2 + "." + String.valueOf(campo2[i]);
            }
        }
        sCampo2 = sCampo2 + String.valueOf(dvCampo2);

        // ***********
        // * CAMPO 3 *
        // ***********
        Integer[] campo3 = new Integer[10];
        Integer dvCampo3;
        String sCampo3 = "";
        campo3[0] = Integer.parseInt(linha.substring(51, 52));
        campo3[1] = Integer.parseInt(linha.substring(52, 53));
        campo3[2] = Integer.parseInt(linha.substring(53, 54));
        campo3[3] = Integer.parseInt(linha.substring(54, 55));
        campo3[4] = Integer.parseInt(linha.substring(55, 56));
        campo3[5] = Integer.parseInt(linha.substring(56, 57));
        campo3[6] = Integer.parseInt(linha.substring(57, 58));
        campo3[7] = Integer.parseInt(linha.substring(58, 59));
        campo3[8] = Integer.parseInt(linha.substring(59, 60));
        campo3[9] = Integer.parseInt(linha.substring(60, 61));
        dvCampo3 = CalcularFator10(campo3);
        for (int i = 0; i < campo2.length; i++) {
            if (i != 5) {
                sCampo3 = sCampo3 + String.valueOf(campo3[i]);
            } else {
                sCampo3 = sCampo3 + "." + String.valueOf(campo3[i]);
            }
        }
        sCampo3 = sCampo3 + String.valueOf(dvCampo3);

        // ***********
        // * CAMPO 4 *
        // ***********
        String campo4 = linha.substring(21, 22);
        
        // ***********
        // * CAMPO 5 *
        // ***********
        String campo5 = linha.substring(22, 36);


        ret = sCampo1 + "  " + sCampo2 + "  " + sCampo3 + "  " + campo4 + "  " + campo5;
        return ret;
    }

    public Integer CalcularFator10(Integer[] campo) {

        Integer[] campos = campo;
        Integer res;
        Integer resto = 0;
        Integer ret;
        Integer controle = 0;

        for (int i = (campos.length - 1); i > -1; i--) {
            if ((controle % 2) == 0) {
                res = campos[i] * 2;
                if (res > 9) {
                    res = (res - 10) + 1;
                }
            } else {
                res = campos[i] * 1;
                if (res > 9) {
                    res = (res - 10) + 1;
                }
            }
            controle++;
            resto = resto + res;
        }
        System.out.println(resto);
        ret = 10 - (resto % 10);
        System.out.println(ret);
        return ret;
    }
}
