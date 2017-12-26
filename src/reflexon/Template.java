/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflexon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfernandes
 */
public abstract class Template {

    public HashMap<String, Object> MEMORIA;
    public String MEMORIA_POS;
    public Properties properties;
    public String file;
    public Instanciador instanciador;

    ///conceito metodo coisa 
    public abstract String getTipo();

    public void _c(HashMap<String, Object> MEMORIA, String MEMORIA_POS, Properties properties, String file, Instanciador instanciador) {
        this.MEMORIA = MEMORIA;
        this.MEMORIA_POS = MEMORIA_POS;
        this.properties = properties;
        this.file = file;
        this.instanciador = instanciador;
        instanciador.sendEvent("TEMPLATE_INST_SUCESS", this);
    }

    public boolean _auto() {
        return false;
    }

    public boolean _base() {
        return MEMORIA_POS.startsWith("base.template.");
    }

    public boolean store() {
        try {
            properties.store(new FileWriter(file), file);
            instanciador.sendEvent("FILE_UPDATE", file);
            return true;
        } catch (IOException ex) {
            System.err.println(ex);
            return false;
        }
    }

    public abstract String getNomeReal();

    public void _evento(String tipo, Object data) {
    }

    Template[] getTemplate(String pref, String sufix) throws IOException {
        return Files.list(new File(properties.getProperty("classLoader") + "reflexon/").toPath()).filter((t) -> {
            return (t.startsWith("D") || t.startsWith("M") || t.startsWith("C") || t.startsWith("O"))
                    && (pref == null || t.getFileName().toString().startsWith(pref))
                    && (sufix == null || t.getFileName().toString().endsWith(sufix));
        }).map((t) -> {
            try {
                return instanciador.getTemplate(((String) t.getFileName().toString()).replace(".class", ""), "temp." + getNomeReal() + ".template." + t.getFileName());
            } catch (Exception ex) {
                instanciador.sendEvent("ERRO", ex);
                return null;
            }
        }).toArray(Template[]::new);
    }

    ;

/////conceito
//    public abstract String[] getVerbetes();
//    public abstract String[] getSignificados(String[] verbetes);
/////   metodo 
//    public abstract void setData(Object data);
//    public abstract Object getData();
//    public abstract void run();
////coisa 
//    public abstract String[] getClasses();
//    public abstract Method[] getMetodos();
//    public abstract Field[] getAtributos();
/*


template=package reflexon; public class NOME extends Template { CONTENT }
template.conceito=package reflexon; public class NOME implements Template { public String[] getVerbetes(){IN};  public String[] getSignificados(String[] verbetes){OUT}}
template.metodo=package reflexon; public class NOME implements Template { public void setData(Object data){IN};  public Object getData(){OUT}; public void run(){RUN}}";
template.coisa=package reflexon; public class NOME implements Template { public String[] getClasses(){CLASS}; public Method[] getMetodos(){METODOS}; public Field[] getAtributos(); }

 */

    
    boolean contem(String s, String[] ss) {
        for (String v : ss) {
            if (v.equals(s)) {
                return true;
            }
        }
        return false;
    }

    boolean templateContainsContent(Template t, String content) {
        try {
            switch (t.getTipo()) {
                case "conceito":
                    return (boolean) t.getClass().getMethod("contem", String.class).invoke(t, content);
                case "coisa":
                    return getNomeReal().contains(content) || t.contem(content, (String[]) t.getClass().getMethod("getClasses").invoke(t));
                default:
                    return getNomeReal().contains(content);
            }
        } catch (Exception e) {
            sendException(e);
        }
        return false;
    }

    public void sendException(Exception e) {
        instanciador.sendEvent("ERRO", e);
    }

    public void sendErro(String e) {
        instanciador.sendEvent("ERRO", e);
    }

    @Override
    public String toString() {
        return "Template{" + "nome=" + getNomeReal() + ", tipo=" + getTipo() + "}";
    }

}
