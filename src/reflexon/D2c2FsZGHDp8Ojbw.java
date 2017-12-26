package reflexon;

public class D2c2FsZGHDp8Ojbw extends Template {

    ;
public String getTipo() {;
        return "conceito";
    }

    ;
public String getNomeReal() {;
        return "saldação";
    }

    ;
public String[] getVerbetes() {;
        return "salda,saldar,cumprimento,cumprimentar".split(",");
    }

    ;
public String[] getSignificados(String[] verbetes) {;
        if (contem("dialogo", verbetes)) {
            return new String[]{"oi", "olá!"};
        }
        return null;
    }

    ;

public String[] getPalavras() {
        return "salda,saldar,cumprimento,cumprimentar,oi,olá!".split(",");
    }

    boolean contem(String s) {
        for (String v : getPalavras()) {
            if (v.equals(s)) {
                return true;
            }
        }
        return false;
    }

}
