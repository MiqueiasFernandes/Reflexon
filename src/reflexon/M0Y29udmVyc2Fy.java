package reflexon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;

public class M0Y29udmVyc2Fy extends Template {

    ;
public String getTipo() {;
        return "metodo";
    }

    ;
public String getNomeReal() {;
        return "conversar";
    }

    ;
public void setData(Object data) {;

    }

    ;
public Object getData() {;
////salvar oque aprendeu
        return null;
    }
    ;

boolean terminou = false;

    JFrame view;
    JTextPane jTextPane1;
    JTextField jTextField1;

    Template entendimento;

    public void run() {;
        try {

            view = new JFrame("Dialogo");

            JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
            jTextPane1 = new javax.swing.JTextPane();

            DefaultCaret caret = (DefaultCaret) jTextPane1.getCaret();
            caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

            jTextField1 = new javax.swing.JTextField();

            jTextPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jTextPane1.setContentType("text/html"); // NOI18N
            jScrollPane2.setViewportView(jTextPane1);

            view.getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

            jTextField1.setText("digite aqui...");

            jTextField1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        receiveFrase(jTextField1.getText());
                        jTextField1.setText("");
                    }
                }
            });

            view.getContentPane().add(jTextField1, java.awt.BorderLayout.PAGE_END);

            view.pack();

            view.setBounds(100, 100, 300, 400);

            view.setVisible(true);

            view.toFront();

////algo salda, pergunta, entende, responde ate terminar
//            instanciador.runTemplateReal("saldação", "temp.conversar.saldar", "dialogo", null);
//            String[] salda = (String[]) MEMORIA.get("temp.conversar.saldar.significados");
            entendimento = instanciador.runTemplateReal("entendimento", "temp.conversar.entendimento", null, null);

            entendimento.getClass().getMethod("addRoteiro", Template.class, String.class).invoke(entendimento, instanciador.getTemplate(instanciador.getNomeClass("roteiro saldar", "M"), null));

            receiveFrase(null);
        } catch (Exception ex) {
            instanciador.sendEvent("ERRO.conversar", ex);
        }
    }

    void sendFrase() {
        try {
            Object[] ret = (Object[]) entendimento.getClass().getMethod("getData").invoke(entendimento);
            conversa.put(conversa.size() + ",S", (String) ret[0]);
            updateView();
            if ((boolean) ret[1]) {
            } else {
                encerrar();
            }
        } catch (Exception e) {
            sendException(e);
        }
    }

    ////////ID FRASE,REMETENTE    : FRASE
    HashMap<String, String> conversa = new HashMap<>();

    void receiveFrase(String frase) {
        try {
            entendimento.getClass().getMethod("setData", Object.class).invoke(entendimento);
            String id = conversa.size() + ",R";
            conversa.put(id, frase);
            updateView();

        } catch (Exception e) {
            sendException(e);
        }
    }

    void updateView() {

        StringBuilder sb = new StringBuilder("<html><head></head><body>");

        conversa.entrySet().forEach((t) -> {

            if (t.getKey().endsWith("S")) {
                sb.append("\n<div style=\"background:#00FFFF; padding: 5; margin: 5; text-align: left; margin-right: 40; \">" + t.getValue() + "</div>\n");
            } else {
                sb.append("\n<div style=\"background: #FFFF00; padding: 5; margin: 5; margin-left: 40;   text-align: right;\">" + t.getValue() + "</div>\n");
            }

        });

        sb.append("</body></html>");

        jTextPane1.setText(sb.toString());
    }

    void encerrar() {
        view.setVisible(false);
        view.dispose();
        instanciador.sendEvent("CONVERSA FINALIZDA", "sucesso");
    }

;
}
