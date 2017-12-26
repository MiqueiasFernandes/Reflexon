package reflexon;
 public class M0bW9zdHJhciB0b2RvcyBldmVudG9z extends Template {;
public String getTipo() {;
 return "metodo";
};
public String getNomeReal(){;
 return "mostrar todos eventos";
};
public void setData(Object data){;

};
public Object getData(){;
return null;
};
public void run(){;
///instanciador.runTemplate("saldação", "temp.conversar.saldar", "oi", null)
};
  @Override
  public void _evento(String tipo, Object data) {
        System.out.println("EVENTO: " + tipo + " -> " + data);
    }
}