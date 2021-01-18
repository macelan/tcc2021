/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.visao;

import br.edu.ifsp.tcc.controle.ControleFuncionario;
import br.edu.ifsp.tcc.controle.ControleSentenciado;
import br.edu.ifsp.tcc.controle.ControleSentenciadoDaSindicancia;
import br.edu.ifsp.tcc.controle.ControleSindicancia;
import br.edu.ifsp.tcc.modelo.Funcionario;
import br.edu.ifsp.tcc.modelo.Sentenciado;
import br.edu.ifsp.tcc.modelo.SentenciadoDaSindicancia;
import br.edu.ifsp.tcc.modelo.Sindicancia;
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
public class FormularioSindicancia extends javax.swing.JDialog {
    // Instanciando Sindicancia
    Sindicancia f = new Sindicancia();
    Funcionario fu = new Funcionario();
    Sentenciado se = new Sentenciado();
    // controles
    private ControleSindicancia controlesindicancia = new ControleSindicancia();
    private ControleFuncionario controlefuncionario = new ControleFuncionario();
    private ControleSentenciado controlesentenciado = new ControleSentenciado();

    //Listas
    private List<Sindicancia> listasindicancias = new ArrayList();
    private List<Funcionario> listafuncionarios = new ArrayList();
    private List<Sentenciado> listasentenciados = new ArrayList();
    // DAO
    private ControleSentenciadoDaSindicancia controleSentenciadoDaSindicancia = new ControleSentenciadoDaSindicancia();
   // private ControleFuncionarioDaSindicancia contBebida = new ItemOrcamentoBebidaDAO();
    
    //teste -  duvida tenho que fazer um controle para tabela sindicancia_funcionario
//    private List<Sindi> listafuncionarios = new ArrayList();
//    private List<Sentenciado> listaSentenciados = new ArrayList();

    //adequando a data
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // o mes tem que ser maiusculo
    DateFormat dfh = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // o mes tem que ser maiusculo

    /**
     * METODO RECEBE UM CLIENTE VINDO DA TELA DE PESQUISA E SETA NO NOME DO
     * CLIENTE
     *
     * @param cliente
     */
    public void setSidicancia (Sindicancia sindicancia) {
        this.f = sindicancia;
        f = controlesindicancia.novoSindicancia(f);//persistindo um vazio para obter um id para prosseguir com o orçamento
    }
    
    
    public void atualizarTodasTabelas() {
    atualizaTabelaSentenciado();
    atualizaTabelaFuncionario();

    }

    // TABELAS DOS ITENS DO ORÇAMENTO
    public void atualizaTabelaSentenciado() {
        DefaultTableModel dtm = (DefaultTableModel) tbSentenciado.getModel(); // manipulador de tabela DefaultTableModel
        dtm.setNumRows(0);//apagando todas as linhas / o zero serve para apagar as linhas "é muito rapido"
        for (Sentenciado se : listasentenciados) {
            dtm.addRow(new Object[]{se.getMatricula(), se.getNome(),se.getAliases(),se.getFaccao()}); // Object é um vetor ou coleção com ele não pecisa converter
        }

    }

    public void atualizaTabelaFuncionario() {
        DefaultTableModel dtm = (DefaultTableModel) tbFuncionario.getModel(); // manipulador de tabela DefaultTableModel
        dtm.setNumRows(0);//apagando todas as linhas / o zero serva para apagar as linhas "é muito rapido"
        for (Funcionario f : listafuncionarios) {
        dtm.addRow(new Object[]{f.getNome(), f.getRg()}); // Object é um vetor ou coleção com ele não pecisa converter
        }

    }
    public void carregarListasSindicancia() {
        this.listasindicancias = controlesindicancia.listarTodos();
        this.listasentenciados = controlesentenciado.listarTodos();
        this.listafuncionarios = controlefuncionario.listarTodos();

    }
    
    
//     /**
//     * METODO REALIZA AS PESQUISAS DOS ITENS CONTIDOS NO ORÇAMENTO
//     */
//    public void carregarListasDeItens() {
//        this.funcionario = contAlimento.listarTodos(f.getIdOrcamento());
//        this.sentenciado = contBebida.listarTodos(f.getIdOrcamento());
//    }
//
//    /**
//     * METODO ATUALIZA TODAS AS TABELAS DE ITENS DO ORÇAMENTO
//     */
//    public void atualizarTodasTabelas() {
//        tbFuncionario();
//        tbSentenciado();
//    }
    private void trataEdicao(boolean editando) {
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnAlterar.setEnabled(!editando);
        btnExcluir.setEnabled(!editando);
        btnNovo.setEnabled(!editando);
        dateSindicancia.setEditable(editando);
        txtAreaSindicancia.setEditable(editando);
//        txtLocalizarUsu.setEditable(editando);
        tbSentenciado.setEnabled(!editando);
    }

    public boolean validaCampos() {
        if (!(dateSindicancia.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe a Data da Sindicancia.");
            return false;
        }
        return true;
    }

    public void carregarLista() {
        //this.listaSentenciados = controlesentenciado.listarTodos(f.getId());
       // this.listafuncionarios = controlefuncionario.listarTodos(f.getId());
       this.listasentenciados = controlesentenciado.listarTodos();
       this.listafuncionarios = controlefuncionario.listarTodos();
       this.listasindicancias = controlesindicancia.listarTodos();

    }
    
    public void pesquisarDinamico(String comando) {
        //      this.sindicancias = controle.pesquisarSindicancias(comando);
    }

    public void pesquisar() {
//        String str = "from Sindicancia f ";
//        String atributo = "f.relato";
//
//        String filtro = txtLocalizarSindicancia.getText();
//
//        if (filtro.length() > 0 && filtro != null) {
//            str += "where upper(" + atributo + ") like '" + filtro.toUpperCase() + "%' ";
//        }
//        str += "order by " + atributo;
//        pesquisarDinamico(str);//ATUALIZA A LISTA COM OS DADOS DESTA PESQUISA DINAMICA
//        atualizarTodasTabelas();//PREENCHE COM OS NOVOS DADOS
    }

    public void limparCampos() {
        dateSindicancia.setText("");
        txtLocalizarSindicancia.setText("");
        txtAreaSindicancia.setText("");

    }

    /**
     * Creates new form FormSindicancia
     */
    public FormularioSindicancia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizarTodasTabelas();
        carregarListasSindicancia();
        trataEdicao(false);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
                                       
    
    public void salvar() throws ParseException {
        f.setDataOcorrencia(df.parse(dateSindicancia.getText()));//passando data do formato string para Date
        f.setRelato(txtAreaSindicancia.getText());
        f.setDataRegisto(new Date());
        f.setFuncionarios(listafuncionarios);
        System.out.println(listafuncionarios);
        System.out.println("cheguei ate aqui");
        System.out.println(listasentenciados);
        f.setSentenciados(listasentenciados);
        System.out.println(listasentenciados);
        controlesindicancia.salvar(f);
        limparCampos();
        //carregarLista(); // verificar mais tarde
       // atualizarTodasTabelas();
    }

//    public void vincularCampos() {
//        Sindicancia f = sindicancias.get(tbSentenciado.getSelectedRow());// pega a linha da tabela
//        dateSindicancia.setText(df.format(f.getDataOcorrencia()));
//        txtAreaSindicancia.setText(f.getRelato());
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelOcorrencia = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaSindicancia = new javax.swing.JTextArea();
        dateSindicancia = new javax.swing.JFormattedTextField();
        jButtonPesquisaSindicancia = new javax.swing.JButton();
        txtLocalizarSindicancia = new javax.swing.JTextField();
        painelfora = new javax.swing.JPanel();
        jPanelIntSentenc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSentenciado = new javax.swing.JTable();
        btAdicionaSentenciadoSindicancia = new javax.swing.JButton();
        btExcluirSentenciado = new javax.swing.JButton();
        jPanelIntFuncio = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbFuncionario = new javax.swing.JTable();
        btAdicionaFuncionarioSindicancia = new javax.swing.JButton();
        btExcluirFuncionario = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        painelAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Servidores");

        painelOcorrencia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Sindicância", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel10.setText("Data da Sindicancia:");

        jLabel13.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel13.setText("Ocorrência:");

        txtAreaSindicancia.setColumns(20);
        txtAreaSindicancia.setRows(5);
        jScrollPane2.setViewportView(txtAreaSindicancia);

        try {
            dateSindicancia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonPesquisaSindicancia.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jButtonPesquisaSindicancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/localizar.png"))); // NOI18N
        jButtonPesquisaSindicancia.setText("Localizar");
        jButtonPesquisaSindicancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaSindicanciaActionPerformed(evt);
            }
        });

        txtLocalizarSindicancia.setFont(txtLocalizarSindicancia.getFont().deriveFont(txtLocalizarSindicancia.getFont().getSize()+3f));
        txtLocalizarSindicancia.setEnabled(false);
        txtLocalizarSindicancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalizarSindicanciaActionPerformed(evt);
            }
        });
        txtLocalizarSindicancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocalizarSindicanciaKeyReleased(evt);
            }
        });

        painelfora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Participantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        jPanelIntSentenc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbSentenciado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Apelido", "Facção"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSentenciado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSentenciadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSentenciado);

        btAdicionaSentenciadoSindicancia.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btAdicionaSentenciadoSindicancia.setText("Adicionar Sentenciado");
        btAdicionaSentenciadoSindicancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionaSentenciadoSindicanciaActionPerformed(evt);
            }
        });

        btExcluirSentenciado.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btExcluirSentenciado.setText("Excluir Sentenciado");
        btExcluirSentenciado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirSentenciadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIntSentencLayout = new javax.swing.GroupLayout(jPanelIntSentenc);
        jPanelIntSentenc.setLayout(jPanelIntSentencLayout);
        jPanelIntSentencLayout.setHorizontalGroup(
            jPanelIntSentencLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIntSentencLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAdicionaSentenciadoSindicancia)
                .addGap(73, 73, 73)
                .addComponent(btExcluirSentenciado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIntSentencLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelIntSentencLayout.setVerticalGroup(
            jPanelIntSentencLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIntSentencLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelIntSentencLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionaSentenciadoSindicancia)
                    .addComponent(btExcluirSentenciado))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        jPanelIntFuncio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "R.G"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbFuncionario);
        if (tbFuncionario.getColumnModel().getColumnCount() > 0) {
            tbFuncionario.getColumnModel().getColumn(1).setResizable(false);
        }

        btAdicionaFuncionarioSindicancia.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btAdicionaFuncionarioSindicancia.setText("Adicionar Funcionário");
        btAdicionaFuncionarioSindicancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionaFuncionarioSindicanciaActionPerformed(evt);
            }
        });

        btExcluirFuncionario.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        btExcluirFuncionario.setText("Excluir Funcionário");

        javax.swing.GroupLayout jPanelIntFuncioLayout = new javax.swing.GroupLayout(jPanelIntFuncio);
        jPanelIntFuncio.setLayout(jPanelIntFuncioLayout);
        jPanelIntFuncioLayout.setHorizontalGroup(
            jPanelIntFuncioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIntFuncioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelIntFuncioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelIntFuncioLayout.createSequentialGroup()
                        .addComponent(btAdicionaFuncionarioSindicancia)
                        .addGap(80, 80, 80)
                        .addComponent(btExcluirFuncionario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelIntFuncioLayout.setVerticalGroup(
            jPanelIntFuncioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIntFuncioLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanelIntFuncioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionaFuncionarioSindicancia)
                    .addComponent(btExcluirFuncionario))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout painelforaLayout = new javax.swing.GroupLayout(painelfora);
        painelfora.setLayout(painelforaLayout);
        painelforaLayout.setHorizontalGroup(
            painelforaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelforaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelIntSentenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelIntFuncio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelforaLayout.setVerticalGroup(
            painelforaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelforaLayout.createSequentialGroup()
                .addComponent(jPanelIntSentenc, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelforaLayout.createSequentialGroup()
                .addComponent(jPanelIntFuncio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout painelOcorrenciaLayout = new javax.swing.GroupLayout(painelOcorrencia);
        painelOcorrencia.setLayout(painelOcorrenciaLayout);
        painelOcorrenciaLayout.setHorizontalGroup(
            painelOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOcorrenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelOcorrenciaLayout.createSequentialGroup()
                        .addGroup(painelOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelOcorrenciaLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(32, 32, 32)
                                .addComponent(dateSindicancia, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisaSindicancia)
                        .addGap(18, 18, 18)
                        .addComponent(txtLocalizarSindicancia, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(painelfora, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelOcorrenciaLayout.setVerticalGroup(
            painelOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOcorrenciaLayout.createSequentialGroup()
                .addGroup(painelOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelOcorrenciaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(dateSindicancia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13))
                    .addGroup(painelOcorrenciaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painelOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonPesquisaSindicancia)
                            .addComponent(txtLocalizarSindicancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelfora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(painelOcorrencia, java.awt.BorderLayout.NORTH);

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
        btnExcluir.setText("Excluir Sindicancia");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAcoesLayout = new javax.swing.GroupLayout(painelAcoes);
        painelAcoes.setLayout(painelAcoesLayout);
        painelAcoesLayout.setHorizontalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1054, Short.MAX_VALUE)
            .addGroup(painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelAcoesLayout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnExcluir)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        painelAcoesLayout.setVerticalGroup(
            painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGroup(painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelAcoesLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addGroup(painelAcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNovo)
                        .addComponent(btnAlterar)
                        .addComponent(btnCancelar)
                        .addComponent(btnSalvar)
                        .addComponent(btnExcluir))
                    .addGap(0, 33, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        f = new Sindicancia();
        trataEdicao(true);
        txtLocalizarSindicancia.setEnabled(false);
        dateSindicancia.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if (tbSentenciado.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para alterar", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
   //         f = sindicancias.get(tbSentenciado.getSelectedRow());
            trataEdicao(true);
            dateSindicancia.requestFocus();
        carregarLista();
        atualizarTodasTabelas();
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        carregarLista();
        atualizarTodasTabelas();
        limparCampos();
       // txtLocalizarSindicancia.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            salvar();
            trataEdicao(false); // ao salvar ativa botão novo
            txtLocalizarSindicancia.setEnabled(false);
        } catch (ParseException ex) {
            System.out.println("Erro ao tentar salvar " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        if (tbSentenciado.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela para excluir", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
//            Sindicancia f = sindicancias.get(tbSentenciado.getSelectedRow());
            controlesindicancia.remover(f);
        }
        carregarLista();
      //  atualizaTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tbSentenciadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSentenciadoMouseClicked
        // TODO add your handling code here:
        //vincularCampos();
    }//GEN-LAST:event_tbSentenciadoMouseClicked

    private void btAdicionaSentenciadoSindicanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionaSentenciadoSindicanciaActionPerformed
        // TODO add your handling code here:
        listasentenciados.clear();
        ConsultarSentenciado tela = new ConsultarSentenciado(null, true);
        tela.setLocationRelativeTo(this);
        tela.setSindicancia(f);// passando o sindicancia para a tela de pesquisa de sentenciaco para ser persistido
        tela.setVisible(true);
        listasentenciados.addAll(tela.getListaSentenciadosSelecionados());
        System.out.println(listasentenciados);
        atualizaTabelaSentenciado();
            
     
    }//GEN-LAST:event_btAdicionaSentenciadoSindicanciaActionPerformed

    private void jButtonPesquisaSindicanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaSindicanciaActionPerformed
        // TODO add your handling code here:
        txtLocalizarSindicancia.setEnabled(true);
        txtLocalizarSindicancia.requestFocus();
    }//GEN-LAST:event_jButtonPesquisaSindicanciaActionPerformed

    private void txtLocalizarSindicanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizarSindicanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizarSindicanciaActionPerformed

    private void txtLocalizarSindicanciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalizarSindicanciaKeyReleased
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_txtLocalizarSindicanciaKeyReleased

    private void btAdicionaFuncionarioSindicanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionaFuncionarioSindicanciaActionPerformed
        // TODO add your handling code here:
        listafuncionarios.clear();
        ConsultarFuncionario telaf = new ConsultarFuncionario(null, true);
        telaf.setLocationRelativeTo(this);
        telaf.setSindicancia(f);// passando o sindicancia para a tela de pesquisa de funcionariopara ser persistido
        telaf.setVisible(true);
        listafuncionarios.addAll(telaf.getListaFuncionariosSelecionados());
        atualizaTabelaFuncionario();
    }//GEN-LAST:event_btAdicionaFuncionarioSindicanciaActionPerformed

    private void btExcluirSentenciadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirSentenciadoActionPerformed
        // TODO add your handling code here:
//        SentenciadoDaSind icancia sentSind = listasentenciados.get(tbSentenciado.getSelectedRow());
//        controleSentenciadoDaSindicancia.excluir(sentSind);//removendo o item
        carregarLista();
        atualizarTodasTabelas();
      

    }//GEN-LAST:event_btExcluirSentenciadoActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioSindicancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioSindicancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioSindicancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioSindicancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioSindicancia dialog = new FormularioSindicancia(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAdicionaFuncionarioSindicancia;
    private javax.swing.JButton btAdicionaSentenciadoSindicancia;
    private javax.swing.JButton btExcluirFuncionario;
    private javax.swing.JButton btExcluirSentenciado;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField dateSindicancia;
    private javax.swing.JButton jButtonPesquisaSindicancia;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelIntFuncio;
    private javax.swing.JPanel jPanelIntSentenc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel painelOcorrencia;
    private javax.swing.JPanel painelfora;
    private javax.swing.JTable tbFuncionario;
    private javax.swing.JTable tbSentenciado;
    private javax.swing.JTextArea txtAreaSindicancia;
    private javax.swing.JTextField txtLocalizarSindicancia;
    // End of variables declaration//GEN-END:variables
}
