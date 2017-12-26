package reflexon;
 public class M2cm90ZWlybyBkZSBjb252ZXJzYQ extends Template {;
public String getTipo() {;
 return "metodo";
};
public String getNomeReal(){;
 return "roteiro de conversa";
};

boolean isConcluido = false, inesperado = false, ok = false;
String echo = "";


public void setData(Object data){;
//Object[] dt = (Object[]) data;
//        frase = (String) dt[0];
//        conversa = (HashMap) dt[1];
//        roteiro = (Template) dt[2];
//
//boolean ok = (boolean) roteiro.getClass().getMethod("conversar", Object.class).invoke(roteiro, data);
//
//if (!ok){
//
//if (((boolean) roteiro.getClass().getMethod("inesperado").invoke(roteiro))){
//inesperado = true;
/////descobrir oque esta falando
//} else {
//echo = "";
//}
//
//} else {
//echo = (String) roteiro.getClass().getMethod("echo").invoke(roteiro);
//}


};

public Object getData(){;
Object[] oo = new Object[]{isConcluido, inesperado, echo};
return (Object) oo;
};

public void run(){;
////verifica se esta tudo certo

};


}