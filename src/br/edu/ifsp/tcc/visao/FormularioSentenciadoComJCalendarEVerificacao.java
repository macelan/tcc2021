/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.visao;

import br.edu.ifsp.tcc.controle.ControleSentenciado;
import br.edu.ifsp.tcc.modelo.Faccao;
import br.edu.ifsp.tcc.modelo.Sentenciado;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macel
 */
public class FormularioSentenciadoComJCalendarEVerificacao extends javax.swing.JDialog {

    private ControleSentenciado controle = new ControleSentenciado();
    private List<Sentenciado> sentenciados = new ArrayList();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // o mes tem que ser maiusculo
    Sentenciado f = new Sentenciado();

    public void atualizaTabela() {
        DefaultTableModel dtm = (DefaultTableModel) jTableSentenciado.getModel();
        dtm.setNumRows(0);//apagando todas as linhas
        for (Sentenciado f : sentenciados)
            {dtm.addRow(new Object[]
            {f.getMatricula(),
               f.getNome(),
               f.getFaccao(),
               f.getDataNascimento()});// Object é um vetor ou coleção com ele não pecisa converter
        }

    }

    private void trataEdicao(boolean editando) {
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnAlterar.setEnabled(!editando);
        btnExcluir.setEnabled(!editando);
        btnNovo.setEnabled(!editando);
        txtRg.setEditable(editando);
       // txtDataNascimento.setDate(editando);
        txtNome.setEditable(editando);
        txtMatricula.setEditable(editando);
        txtAliase.setEditable(editando);
        //btnPesquisar.setEditable(editando);
        //txtLocalizar.setEditable(editando);
        jTableSentenciado.setEnabled(!editando);
    }

    public boolean validaCampos() {
        if (!(txtMatricula.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Matricula.");
            return false;
        }
        return true;
    }

    public void carregarLista() {
        sentenciados = controle.listarTodos();

    }
    
      public void limparCampos() {
        txtLocalizar.setText("");
        txtRg.setText("");
  //    txtDataNascimento.setDate();
        txtNome.setText("");
        txtAliase.setText("");
        txtMatricula.setText("");

    }

    public void pesquisar() {
        String str = "from Sentenciado f ";
        String atributo = "f.nome";

        String filtro = txtLocalizar.getText();

        if (filtro.length() > 0 && filtro != null) {
            str += "where upper(" + atributo + ") like '" + filtro.toUpperCase() + "%' ";
        }

        str += "order by " + atributo;
        pesquisarDinamico(str);//ATUALIZA A LISTA COM OS DADOS DESTA PESQUISA DINAMICA
        atualizaTabela();//PREENCHE COM OS NOVOS DADOS
    }

    public void pesquisarDinamico(String comando) {
        this.sentenciados = controle.pesquisarSentenciados(comando);
    }

    /**
     * Creates new form FormularioCela
     */
    public FormularioSentenciadoComJCalendarEVerificacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarLista();
        atualizaTabela();
        trataEdicao(false);
    }

    public void salvar() throws ParseException {
//        f.setDataNascimento(txtDataNascimento.getDate());//passando data do formato string para Date
//        f.setNome(txtNome.getText());
//        f.setMatricula(txtMatricula.getText());
//        f.setRg(txtRg.getText());
//        f.setAliases(txtAliase.getText());
//        f.setFaccao((Faccao) jComboBoxFaccao.getSelectedItem()); // foi feito uma conversão para String ou Faccao?
////        f.setAtivo(df.format(calendar.getTime()));
//        controle.salvar(f);
//        limparCampos();
//        carregarLista();
//        atualizaTabela();

        
        
           if (!txtMatricula.getText().equals("")) {
                        if (!txtNome.getText().equals("")) {
                                if (!txtRg.getText().equals("")) {
                                        if (!jComboBoxFaccao.getSelectedItem().equals("")) {
                                                if (txtDataNascimento.getDate() != null) {
                                                     if (!txtAliase.getText().equals("")) {
                                                                        f.setDataNascimento(txtDataNascimento.getDate());//passando data do formato string para Date
                                                                        f.setNome(txtNome.getText().trim());
                                                                        f.setMatricula(txtMatricula.getText());
                                                                        f.setRg(txtRg.getText());
                                                                        f.setAliases(txtAliase.getText().trim());
                                                                        f.setFaccao((Faccao) jComboBoxFaccao.getSelectedItem()); // foi feito uma conversão para String ou Faccao?
                                                                //        f.setAtivo(df.format(calendar.getTime()));
                                                                        
                                                                        controle.salvar(f);
                                                                        limparCampos();
                                                                        carregarLista();
                                                                        atualizaTabela();
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Informe o Apelido do Sentenciado!", "Alerta", JOptionPane.WARNING_MESSAGE);
                                                                txtAliase.requestFocus();
                                                            }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Informe a Data de Nascimento!", "Alerta", JOptionPane.WARNING_MESSAGE);
                                                        txtDataNascimento.requestFocus();
                                                    }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Informe o Facção que o sentenciado pertence!", "Alerta", JOptionPane.WARNING_MESSAGE);
                                                jComboBoxFaccao.requestFocus();
                                            }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Informe a RG!", "Alerta", JOptionPane.WARNING_MESSAGE);
                                        txtRg.requestFocus();
                                    }
                            } else {
                                JOptionPane.showMessageDialog(null, "Informe o nome do Sentenciado!", "Alerta", JOptionPane.WARNING_MESSAGE);
                                txtNome.requestFocus();
                            }
                    } else {
                        JOptionPane.showMessageDialog(null, "Informe o Matricula!", "Alerta", JOptionPane.WARNING_MESSAGE);
                        txtMatricula.requestFocus();
                    }
   
    }

    public void vincularCampos() {
        Sentenciado f = sentenciados.get(jTableSentenciado.getSelectedRow());// pega a linha da tabela
        txtNome.setText(f.getNome());
        txtMatricula.setText(f.getMatricula());
        txtRg.setText(f.getRg());
        jComboBoxFaccao.setSelectedItem(f.getFaccao()); // foi feito uma conversão para String ou Faccao?
        txtDataNascimento.setDate(f.getDataNascimento());
        txtAliase.setText(f.getAliases());

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

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("Tcc_V34PU").createEntityManager();
        queryFaccao = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("from Faccao f order by f.siglaFaccao");
        listFaccao = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryFaccao.getResultList());
        painelSentenciado = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAliase = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        espaco = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JFormattedTextField();
        txtRg = new javax.swing.JFormattedTextField();
        jComboBoxFaccao = new javax.swing.JComboBox<>();
        jButtonTransferencia_Interna = new javax.swing.JButton();
        jButtonTransferencia_Externa = new javax.swing.JButton();
        txtDataNascimento = new com.toedter.calendar.JDateChooser();
        painelAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        painelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSentenciado = new javax.swing.JTable();
        jButtonPesquisar = new javax.swing.JButton();
        txtLocalizar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelSentenciado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Sentenciado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        painelSentenciado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel8.setText("Matricula:");
        painelSentenciado.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel10.setText("Nome:");
        painelSentenciado.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        txtNome.setFont(txtNome.getFont().deriveFont(txtNome.getFont().getSize()+3f));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        painelSentenciado.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 430, -1));

        jLabel12.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel12.setText("Data de Nascimento:");
        painelSentenciado.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel7.setText("Aliases:");
        painelSentenciado.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel16.setText("Facção:");
        painelSentenciado.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, -1));

        txtAliase.setFont(txtAliase.getFont().deriveFont(txtAliase.getFont().getSize()+3f));
        txtAliase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAliaseActionPerformed(evt);
            }
        });
        painelSentenciado.add(txtAliase, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 400, -1));

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel9.setText("Rg:");
        painelSentenciado.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));
        painelSentenciado.add(espaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 20));

        try {
            txtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        painelSentenciado.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 130, -1));

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.setMinimumSize(new java.awt.Dimension(6, 23));
        txtRg.setPreferredSize(new java.awt.Dimension(109, 23));
        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });
        painelSentenciado.add(txtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 140, -1));

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listFaccao, jComboBoxFaccao);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxFaccao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFaccaoActionPerformed(evt);
            }
        });
        painelSentenciado.add(jComboBoxFaccao, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 70, 130, -1));

        jButtonTransferencia_Interna.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonTransferencia_Interna.setText("Transferencia interna");
        jButtonTransferencia_Interna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransferencia_InternaActionPerformed(evt);
            }
        });
        painelSentenciado.add(jButtonTransferencia_Interna, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        jButtonTransferencia_Externa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonTransferencia_Externa.setText("Transferencia externa");
        jButtonTransferencia_Externa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransferencia_ExternaActionPerformed(evt);
            }
        });
        painelSentenciado.add(jButtonTransferencia_Externa, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, -1, -1));
        painelSentenciado.add(txtDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 160, -1));

        getContentPane().add(painelSentenciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1020, -1));

        painelAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N

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
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelAcoesLayout.setVerticalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAcoesLayout.createSequentialGroup()
                .addGroup(painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        getContentPane().add(painelAcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 174, 1020, -1));

        painelTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Sentenciados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jTableSentenciado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Facção", "Data de Nascimento", "Origem", "Destino"
            }
        ));
        jTableSentenciado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSentenciadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSentenciado);

        jButtonPesquisar.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/localizar.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisa");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        txtLocalizar.setFont(txtLocalizar.getFont().deriveFont(txtLocalizar.getFont().getSize()+3f));
        txtLocalizar.setEnabled(false);
        txtLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalizarActionPerformed(evt);
            }
        });
        txtLocalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocalizarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                    .addGroup(painelTabelaLayout.createSequentialGroup()
                        .addComponent(jButtonPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLocalizar)))
                .addContainerGap())
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(txtLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(painelTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 299, 1020, -1));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtAliaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAliaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAliaseActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        f = new Sentenciado();
        trataEdicao(true);
        limparCampos();
        txtMatricula.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
         if (jTableSentenciado.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para alterar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
        f = sentenciados.get(jTableSentenciado.getSelectedRow());
        trataEdicao(true);
        txtMatricula.requestFocus();
        }
        carregarLista();
        atualizaTabela();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        trataEdicao(false);
        carregarLista();
        atualizaTabela();
        limparCampos();
        txtLocalizar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            salvar();
            trataEdicao(false); // ao salvar ativa botão nov 
            txtLocalizar.setEnabled(false);
        } catch (ParseException ex) {
            System.out.println("Erro ao tentar salvar " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

//         if (jTableObservacao.getSelectedRow() < 0) {
//            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para excluir", "Atenção", JOptionPane.WARNING_MESSAGE);
//        } if else (jTableObservacao.getSelectedRow() > 0) 
//          { 
//        (JOptionPane.showConfirmDialog(null, "Deseja desativar o registro?", "Pergunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
//                
//                }else {
//            Observacao f = observacoes.get(jTableObservacao.getSelectedRow());
//            controle.remover(f);
//        }
//        carregarLista();
//        atualizaTabela();
//
//        
//        
//        int opcao = JOptionPane.showOptionDialog(null,
//                "Confirma a exclusão ? ",
//                "Pergunta",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE, null,
//                new String[]{"Sim", "Não"}, "Sim");
//
        if (jTableSentenciado.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para excluir", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            Sentenciado f = sentenciados.get(jTableSentenciado.getSelectedRow());
            controle.remover(f);
        }
        carregarLista();
        atualizaTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        txtLocalizar.setEnabled(true);
        txtLocalizar.requestFocus();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void txtLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizarActionPerformed

    private void jTableSentenciadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSentenciadoMouseClicked
        // TODO add your handling code here:
        vincularCampos();
    }//GEN-LAST:event_jTableSentenciadoMouseClicked

    private void txtLocalizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalizarKeyReleased
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_txtLocalizarKeyReleased

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void jComboBoxFaccaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFaccaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFaccaoActionPerformed

    private void jButtonTransferencia_ExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransferencia_ExternaActionPerformed
        // TODO add your handling code here:
        FormularioMovimentacaoExterna fme = new FormularioMovimentacaoExterna(null, true);
        fme.setLocationRelativeTo(this);
        fme.setVisible(true);
    }//GEN-LAST:event_jButtonTransferencia_ExternaActionPerformed

    private void jButtonTransferencia_InternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransferencia_InternaActionPerformed
        // TODO add your handling code here:
        FormularioMovimentacaoInterna fmi = new FormularioMovimentacaoInterna(null, true);
        fmi.setLocationRelativeTo(this);
        fmi.setVisible(true);
    }//GEN-LAST:event_jButtonTransferencia_InternaActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioSentenciadoComJCalendarEVerificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioSentenciadoComJCalendarEVerificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioSentenciadoComJCalendarEVerificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioSentenciadoComJCalendarEVerificacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioSentenciadoComJCalendarEVerificacao dialog = new FormularioSentenciadoComJCalendarEVerificacao(new javax.swing.JFrame(), true);
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
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel espaco;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonTransferencia_Externa;
    private javax.swing.JButton jButtonTransferencia_Interna;
    private javax.swing.JComboBox<String> jComboBoxFaccao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSentenciado;
    private java.util.List<Faccao> listFaccao;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelSentenciado;
    private javax.swing.JPanel painelTabela;
    private javax.persistence.Query queryFaccao;
    private javax.swing.JTextField txtAliase;
    private com.toedter.calendar.JDateChooser txtDataNascimento;
    private javax.swing.JTextField txtLocalizar;
    private javax.swing.JFormattedTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
