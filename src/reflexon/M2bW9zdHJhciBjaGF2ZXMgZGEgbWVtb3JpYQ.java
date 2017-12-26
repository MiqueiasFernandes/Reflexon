package reflexon;
 public class M2bW9zdHJhciBjaGF2ZXMgZGEgbWVtb3JpYQ extends Template {;
public String getTipo() {;
 return "metodo";
};
public String getNomeReal(){;
 return "mostrar chaves da memoria";
};
public void setData(Object data){;

};
public Object getData(){;
return null;
};
public void run(){;

};
  @Override
  public void _evento(String tipo, Object data) {
          if (tipo.equals("TEMPLATE_INST") ||tipo.equals("FILE_UPDATE")  )
            System.out.println("IN MEMO -> " + java.util.Arrays.toString(MEMORIA.keySet().toArray(new String[]{})));
    }
}