/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflexon;

/**
 *
 * @author mfernandes
 */
public interface Instanciador {

    public Template getTemplate(String nameClass, String memo) throws Exception;

    public Template getTemplate(Class cls, String memo) throws Exception;

    public Class getTemplateClass(String nome, String classLoader, boolean isURL) throws Exception;

    public Template runTemplate(String nome, String memo, Object in, String classLoader) throws Exception;

    public Template runTemplate(Template t, String nome, String memo, Object in, String classLoader) throws Exception;

    public Template runTemplateReal(String nomeReal, String memo, Object in, String classLoader) throws Exception;

    public Template criar(String nome);

    public String setTemplate(String pref, String template);

    public String getNomeClass(String nome, String tipo);

    public Process storeTemplate(String pref, String name, String content) throws Exception;

    public void sendEvent(String nome, Object data);

    public void setProperty(String key, String value);
}
