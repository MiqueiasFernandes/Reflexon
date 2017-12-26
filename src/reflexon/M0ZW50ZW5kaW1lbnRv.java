package reflexon;

import java.util.HashMap;

public class M0ZW50ZW5kaW1lbnRv extends Template {

    ;
public String getTipo() {;
        return "metodo";
    }

    ;
public String getNomeReal() {;
        return "entendimento";
    }
    ;

boolean terminou = false;
    String resposta = "";

    HashMap<String, Template[]> conversa = new HashMap<>();
    Template roteiroAtivo;

    public void setData(Object frase) {;

        if (roteiroAtivo != null) {
            try {
                roteiroAtivo.getClass().getMethod("setData", Object.class).invoke(roteiroAtivo, frase);
                Object[] oo = (Object[]) roteiroAtivo.getClass().getMethod("getData").invoke(roteiroAtivo);

                Template novaConversa = (Template) oo[0];
                boolean compativel = (boolean) oo[1];
                resposta = (String) oo[2];
                terminou = (boolean) oo[3];

                if (!compativel) {

                    if (novaConversa != null) {
                        addRoteiro(novaConversa, getKeyByTp(roteiroAtivo));
                        roteiroAtivo = novaConversa;
                        roteiroAtivo.getClass().getMethod("setData", Object.class).invoke(roteiroAtivo, frase);
                    } else {
                        resposta = "não entendi isso, oque é isso?";
                    }

                }
                if (terminou) {
                    String key = getKeyByTp(roteiroAtivo);
                    Template novo = null;
                    Template[] get = conversa.get(key);
                    for (int i = 0; i < get.length; i++) {
                        if (get[i] == roteiroAtivo) {
                            for (int k = i + 1; k < get.length; k++) {
                                if (!(boolean) get[k].getClass().getMethod("terminou").invoke(get[k])) {
                                    novo = get[k];
                                }
                            }
                            if (novo == null) {
                                for (int j = i - 1; j >= 0; j--) {
                                    if (!(boolean) get[j].getClass().getMethod("terminou").invoke(get[j])) {
                                        novo = get[j];
                                    }
                                }
                            }

                        }
                    }

                    if (novo == null) {
                        int k = (Integer.parseInt(key) + 1);
                        if (conversa.size() > k) {
                            roteiroAtivo = conversa.get("" + k)[0];
                        }
                    } else {
                        roteiroAtivo = novo;
                    }
                    if (roteiroAtivo != null) {
                        roteiroAtivo.getClass().getMethod("setData", Object.class).invoke(roteiroAtivo);
                    }

                }

            } catch (Exception ex) {
                sendException(ex);
            }
        }

        System.out.println("a entender frase: " + frase);
    }

    ;

    String getKeyByTp(Template t) {
        for (String string : conversa.keySet()) {
            for (Template template : conversa.get(string)) {
                if (template == t) {
                    return string;
                }
            }
        }
        return null;
    }

    public void addRoteiro(Template t, String apos) {
        if (apos == null) {
            if (roteiroAtivo == null) {
                roteiroAtivo = t;
            }
            conversa.put("" + conversa.size(), new Template[]{t});
        } else {
            Template[] get = conversa.get(apos);
            Template[] t2 = new Template[get.length + 1];
            for (int i = 0; i < t2.length - 1; i++) {
                t2[i] = get[i];
            }
            t2[t2.length - 1] = t;
            conversa.put(apos, t2);
        }
    }

    public Object getData() {;
        return (Object) new Object[]{resposta, terminou};
    }

    ;

public void run() {;

    }
;
}
