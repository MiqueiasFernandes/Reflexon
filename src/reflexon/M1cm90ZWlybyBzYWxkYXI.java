package reflexon;

import java.io.IOException;

public class M1cm90ZWlybyBzYWxkYXI extends Template {

    ;

    public M1cm90ZWlybyBzYWxkYXI() {
        try {
            this.elediz = new Class[]{instanciador.getTemplate("saldação", null).getClass()};
        } catch (Exception ex) {
            instanciador.sendEvent("ERRO", ex);
        }
    }

    public String getTipo() {;
        return "metodo";
    }

    ;


public String getNomeReal() {;
        return "roteiro saldar";
    }
    ;

Class[] elediz;

    Object[] resposta;

    String[] respondo = new String[]{"oi"};
    int pos = 0;

    public void setData(Object data) {;

        if (data == null) {///se nao diz nada
            resposta = new Object[]{null, true, respondo[pos]};
        } else { ////se diz veifico
            resposta = compativel(elediz[pos], (String) data);
            if ((boolean) resposta[1]) {
                ////comp passa p frente
                resposta = new Object[]{null, true, respondo[pos++]};
            }
        }
        if (pos == respondo.length) {
            ///terminou
            resposta = new Object[]{resposta[0], resposta[1], resposta[2], true};
        } else {
            resposta = new Object[]{resposta[0], resposta[1], resposta[2], true};
        }

    }

    ;
public Object getData() {;
        return resposta;
    }

    ;


public boolean terminou(){
    return (boolean) resposta[3];
}

public void run() {;

    }

    ;

    Object[] compativel(Class esperado, String obtido) {
        try {
            Template[] ts = getTemplate(null, null);
            if (ts == null || ts.length < 1) {
                ////////////////////template novo --- compativel -- desconhecido
                return new Object[]{null, false}; ///incomp desc
            }
            Template q = null;
            for (Template t : ts) {
                if (templateContainsContent(t, obtido)) {
                    if (t.getClass().equals(esperado)) {
                        ///achei oque esperava, prossegue minha conversa
                        return new Object[]{null, true}; ///comp con
                    }
                    q = t;
                }
            }
            return new Object[]{q, false}; ////inc conh
        } catch (Exception ex) {
            instanciador.sendEvent("ERRO", ex);
        }
        return new Object[]{null, false};///incomp desc
    }

}
