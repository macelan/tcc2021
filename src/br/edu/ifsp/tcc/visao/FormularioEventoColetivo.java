/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.visao;

import br.edu.ifsp.tcc.controle.ControleEventoColetivo;
import br.edu.ifsp.tcc.modelo.EventoColetivo;
import br.edu.ifsp.tcc.modelo.Pavilhao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macel
 */
public class FormularioEventoColetivo extends javax.swing.JDialog {

    private ControleEventoColetivo controle = new ControleEventoColetivo();
    private List<EventoColetivo> eventoColetivos = new ArrayList();

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // o mes tem que ser maiusculo
    DateFormat dfh = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // o mes tem que ser maiusculo
    EventoColetivo f = new EventoColetivo();

    public void atualizaTabela() {
        DefaultTableModel dtm = (DefaultTableModel) jTableEventosColetivo.getModel();
        dtm.setNumRows(0);//apagando todas as linhas
        for (EventoColetivo f : eventoColetivos) {
            dtm.addRow(new Object[]
            {f.getPavilhao().getNome(), dfh.format(f.getDataRegistro()),
                df.format(f.getDataOcorrido()),
                f.getRelato()});
        }

    }

    /**
     * Creates new form FormUsuario
     */
    public FormularioEventoColetivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizaTabela();
        trataEdicao(false);
  //    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void trataEdicao(boolean editando) {
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnAlterar.setEnabled(!editando);
        btnExcluir.setEnabled(!editando);
        btnNovo.setEnabled(!editando);
        dateEventoColetivo.setEditable(editando);
        txtAreaRelato.setEditable(editando);
//      txtLocalizarEventoColetivo.setEditable(editando);
        jTableEventosColetivo.setEnabled(!editando);

    }

    public boolean validaCampos() {
        if (!(dateEventoColetivo.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Data do evento coletivo.");
            return false;
        }
        return true;
    }

    public void carregarLista() {
        eventoColetivos = controle.listarTodos();
    }

    public void pesquisarDinamico(String comando) {
        this.eventoColetivos = controle.pesquisarEventoColetivos(comando);
    }

    public void pesquisar() {
        String str = "from EventoColetivo f ";
        String atributo = "f.relato";

        String filtro = txtLocalizarEventoColetivo.getText();

        if (filtro.length() > 0 && filtro != null) {
            str += "where upper(" + atributo + ") like '" + filtro.toUpperCase() + "%' ";
        }

        str += "order by " + atributo;
        pesquisarDinamico(str);//ATUALIZA A LISTA COM OS DADOS DESTA PESQUISA DINAMICA
        atualizaTabela();//PREENCHE COM OS NOVOS DADOS
    }

    public void limparCampos() {
        dateEventoColetivo.setText("");
        txtLocalizarEventoColetivo.setText("");
        txtAreaRelato.setText("");

    }

    public void salvar() throws ParseException {

        f.setDataOcorrido(df.parse(dateEventoColetivo.getText()));//passando data do formato string para Date
        f.setRelato(txtAreaRelato.getText());
        f.setDataRegistro(new Date());
        f.setPavilhao((Pavilhao)jComboBoxSiglaPavilhao.getSelectedItem()); // foi feito uma conversão para String?
        controle.salvar(f);
        limparCampos();
        carregarLista();
        atualizaTabela();
    }

    public void vincularCampos() {
        EventoColetivo f = eventoColetivos.get(jTableEventosColetivo.getSelectedRow());// pega a linha da tabela
        dateEventoColetivo.setText(df.format(f.getDataOcorrido()));
        txtAreaRelato.setText(f.getRelato());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Tcc_V201PU").createEntityManager();
        queryPavilhao = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("from Pavilhao f order by f.sigla");
        listPavilhao = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryPavilhao.getResultList());
        painelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEventosColetivo = new javax.swing.JTable();
        jButtonPesEventoColetivo = new javax.swing.JButton();
        txtLocalizarEventoColetivo = new javax.swing.JTextField();
        painelAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        painelLogin = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaRelato = new javax.swing.JTextArea();
        dateEventoColetivo = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxSiglaPavilhao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Servidores");

        painelTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Eventos Coletivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jTableEventosColetivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Pavilhão", "Data do Cadastro", "Data Ocorrido", "Relato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableEventosColetivo);

        jButtonPesEventoColetivo.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButtonPesEventoColetivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/localizar.png"))); // NOI18N
        jButtonPesEventoColetivo.setText("Localizar");
        jButtonPesEventoColetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesEventoColetivoActionPerformed(evt);
            }
        });

        txtLocalizarEventoColetivo.setFont(txtLocalizarEventoColetivo.getFont().deriveFont(txtLocalizarEventoColetivo.getFont().getSize()+3f));
        txtLocalizarEventoColetivo.setEnabled(false);
        txtLocalizarEventoColetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalizarEventoColetivoActionPerformed(evt);
            }
        });
        txtLocalizarEventoColetivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocalizarEventoColetivoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTabelaLayout.createSequentialGroup()
                        .addComponent(jButtonPesEventoColetivo)
                        .addGap(18, 18, 18)
                        .addComponent(txtLocalizarEventoColetivo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesEventoColetivo)
                    .addComponent(txtLocalizarEventoColetivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(painelTabela, java.awt.BorderLayout.SOUTH);

        painelAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        btnNovo.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/adicionar.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/atualizar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/deletar.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAcoesLayout = new javax.swing.GroupLayout(painelAcoes);
        painelAcoes.setLayout(painelAcoesLayout);
        painelAcoesLayout.setHorizontalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcoesLayout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );
        painelAcoesLayout.setVerticalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcoesLayout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addGap(0, 44, Short.MAX_VALUE))
        );

        getContentPane().add(painelAcoes, java.awt.BorderLayout.CENTER);

        painelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Evento Coletivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel10.setText("Data  do Ocorrido:");

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel13.setText("Relato:");

        txtAreaRelato.setColumns(20);
        txtAreaRelato.setRows(5);
        txtAreaRelato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAreaRelatoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txtAreaRelato);

        try {
            dateEventoColetivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel11.setText("Sigla Pavilhao:");

        jComboBoxSiglaPavilhao.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listPavilhao, jComboBoxSiglaPavilhao);
        bindingGroup.addBinding(jComboBoxBinding);

        javax.swing.GroupLayout painelLoginLayout = new javax.swing.GroupLayout(painelLogin);
        painelLogin.setLayout(painelLoginLayout);
        painelLoginLayout.setHorizontalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(1000, 1000, 1000)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateEventoColetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxSiglaPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painelLoginLayout.setVerticalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jComboBoxSiglaPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(dateEventoColetivo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painelLogin, java.awt.BorderLayout.NORTH);

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        f = new EventoColetivo();
        trataEdicao(true);
        txtLocalizarEventoColetivo.setEnabled(false);
        dateEventoColetivo.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if (jTableEventosColetivo.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para alterar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            f = eventoColetivos.get(jTableEventosColetivo.getSelectedRow());
            trataEdicao(true);
            dateEventoColetivo.requestFocus();
        }
        carregarLista();
        atualizaTabela();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        carregarLista();
        atualizaTabela();
        limparCampos();
        txtLocalizarEventoColetivo.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    try {
        salvar();
        trataEdicao(false); // ao salvar ativa botão novo
        txtLocalizarEventoColetivo.setEnabled(false);
        } catch (ParseException ex) {
            System.out.println("Erro ao tentar salvar " + ex.getMessage());
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
       if (jTableEventosColetivo.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para excluir", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            EventoColetivo f = eventoColetivos.get(jTableEventosColetivo.getSelectedRow());
            controle.remover(f);
        }
        carregarLista();
        atualizaTabela();

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButtonPesEventoColetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesEventoColetivoActionPerformed
        // TODO add your handling code here:
        
        jButtonPesEventoColetivo.setEnabled(true);
        jButtonPesEventoColetivo.requestFocus();
    }//GEN-LAST:event_jButtonPesEventoColetivoActionPerformed

    private void txtLocalizarEventoColetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizarEventoColetivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizarEventoColetivoActionPerformed

    private void txtAreaRelatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAreaRelatoMouseClicked
        // TODO add your handling code here:
        vincularCampos();
    }//GEN-LAST:event_txtAreaRelatoMouseClicked

    private void txtLocalizarEventoColetivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalizarEventoColetivoKeyReleased
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_txtLocalizarEventoColetivoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioEventoColetivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioEventoColetivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioEventoColetivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioEventoColetivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioEventoColetivo dialog = new FormularioEventoColetivo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField dateEventoColetivo;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonPesEventoColetivo;
    private javax.swing.JComboBox<String> jComboBoxSiglaPavilhao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEventosColetivo;
    private java.util.List<Pavilhao> listPavilhao;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JPanel painelTabela;
    private javax.persistence.Query queryPavilhao;
    private javax.swing.JTextArea txtAreaRelato;
    private javax.swing.JTextField txtLocalizarEventoColetivo;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
