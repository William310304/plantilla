package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.DepartamentoDAO;
import model.Cargo;

public class Departamento extends JPanel {
    private static final long serialVersionUID = 1L;

    JButton btnAgregar, btnEditar, btnEliminar, btnGuardar, btnCancelar;
    JTextField txtBuscar, txtCodigo, txtDetalle,txtCuenta;



    JTable tblRegistros;
    TableRowSorter<DefaultTableModel> tableRowSorter;

    int index = -1;
    Cargo cargo = new Cargo();
    DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    boolean bHayRegitro;

    public Departamento() {
        setBorder( new LineBorder( new Color(224, 224, 224) ) );
        setBounds(0, 0, 1028, 661);
        setLayout( null );

        JLabel lblPanel = new JLabel("DEPARTAMENTO");
        lblPanel.setBounds(10, 10, 300, 30);
        lblPanel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblPanel.setForeground( Color.RED );
        add(lblPanel);

        JPanel pnlRegistros = new JPanel();
        pnlRegistros.setBorder( new LineBorder( new Color(189, 189, 189) ) );
        pnlRegistros.setBounds(1, 60, 250, 600);
        pnlRegistros.setLayout(null);
        add(pnlRegistros);

        JPanel pnlRegistro = new JPanel();
        pnlRegistro.setBorder( new LineBorder( new Color(189, 189, 189) ) );
        pnlRegistro.setBounds(251, 60, 776, 600);
        pnlRegistro.setLayout(null);
        add(pnlRegistro);

        JLabel lblBuscar = new JLabel("Detalle :");
        lblBuscar.setBorder( new LineBorder( new Color(224, 224, 224) ));
        lblBuscar.setBounds(1, 50, 248, 30);
        pnlRegistros.add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBorder( new LineBorder( new Color(224, 224, 224) ));
        txtBuscar.setBackground( new Color(255, 246, 223) );
        txtBuscar.setBounds(2, 80, 245, 30);
        txtBuscar.setColumns(30);
		txtBuscar.setMargin( new Insets(5, 50, 5, 10) );
        pnlRegistros.add(txtBuscar);

        tblRegistros = new JTable();
		tblRegistros.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		tblRegistros.setBounds(3, 112, 243, 515);
		tblRegistros.setRowHeight(30);
		pnlRegistros.add(tblRegistros);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setBackground( new Color(250, 250, 250) );
        btnAgregar.setBounds(10, 10, 100, 30);
        btnAgregar.setFocusPainted(false);
		btnAgregar.setIcon(new ImageIcon(Login.class.getResource("/ui/img/agregar.png")));
		btnAgregar.setIconTextGap(10);
		btnAgregar.setMargin( new Insets(2, 5, 2, 5) );
        pnlRegistro.add(btnAgregar);
        
        btnEditar = new JButton("Editar");
        btnEditar.setBackground( new Color(250, 250, 250) );
        btnEditar.setBorderPainted(false);
        btnEditar.setBounds(120, 10, 100, 30);
        btnEditar.setFocusPainted(false);
		btnEditar.setIcon(new ImageIcon(Login.class.getResource("/ui/img/editar.png")));
		btnEditar.setIconTextGap(10);
		btnEditar.setMargin( new Insets(2, 5, 2, 5) );
        pnlRegistro.add(btnEditar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground( new Color(250, 250, 250) );
        btnEliminar.setBorderPainted(false);
        btnEliminar.setBounds(230, 10, 100, 30);
        btnEliminar.setFocusPainted(false);
		btnEliminar.setIcon(new ImageIcon(Login.class.getResource("/ui/img/eliminar.png")));
		btnEliminar.setIconTextGap(10);
		btnEliminar.setMargin( new Insets(2, 5, 2, 5) );
        pnlRegistro.add(btnEliminar);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground( new Color(250, 250, 250) );
        btnGuardar.setBorderPainted(false);
        btnGuardar.setBounds(550, 10, 100, 30);
        btnGuardar.setFocusPainted(false);
		btnGuardar.setIcon(new ImageIcon(Login.class.getResource("/ui/img/guardar.png")));
		btnGuardar.setIconTextGap(10);
		btnGuardar.setMargin( new Insets(2, 5, 2, 5) );
        pnlRegistro.add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground( new Color(250, 250, 250) );
        btnCancelar.setBorderPainted(false);
        btnCancelar.setBounds(660, 10, 100, 30);
        btnCancelar.setFocusPainted(false);
		btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/ui/img/cancelar.png")));
		btnCancelar.setIconTextGap(10);
		btnCancelar.setMargin( new Insets(2, 5, 2, 5) );
        pnlRegistro.add(btnCancelar);

        JLabel lblCodigo = new JLabel("Codigo :");
        lblCodigo.setBounds(50, 200, 100, 30);
        pnlRegistro.add(lblCodigo);

        JLabel lblDetalle = new JLabel("Descripción :");
        lblDetalle.setBounds(50, 250, 100, 30);
        pnlRegistro.add(lblDetalle);

        JLabel lblCuenta = new JLabel("Cuenta :");
        lblCuenta.setBounds(50, 300, 100, 30);
        pnlRegistro.add(lblCuenta);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 200, 50, 30);
        txtCodigo.setFocusable(false);
        txtCodigo.setMargin(new Insets(5, 5, 5, 5));
        pnlRegistro.add(txtCodigo);

        txtDetalle = new JTextField();
        txtDetalle.setBounds(150, 250, 200, 30);
        txtDetalle.setColumns(30);
        txtDetalle.setMargin(new Insets(5, 5, 5, 5));
        pnlRegistro.add(txtDetalle);

        txtCuenta = new JTextField();
        txtCuenta.setBounds(150, 300, 200, 30);
        txtCuenta.setColumns(30);
        txtCuenta.setMargin(new Insets(5, 5, 5, 5));
        pnlRegistro.add(txtCuenta);


        btnAgregar.addActionListener( e -> btnAgregar_actionPerformed() );
        btnEditar.addActionListener( e -> btnEditar_actionPerformed() );
        btnEliminar.addActionListener( e -> btnEliminar_actionPerformed() );
        btnGuardar.addActionListener( e -> btnGuardar_actionPerformed() );
        btnCancelar.addActionListener(e -> btnCancelar_actionPerformed() );

        ListSelectionModel listSelectionModel = tblRegistros.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
				if ( !listSelectionModel.isSelectionEmpty()  && btnAgregar.isVisible())
					verRegistro( listSelectionModel.getMinSelectionIndex() );
			}
        });



        txtBuscar.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) { 
                txtBuscar_caretUpdate(); 
        } });

		txtDetalle.addFocusListener(new FocusAdapter() {
            @Override 
            public void focusGained(FocusEvent e) { 
                txtDetalle_focus(true); 
            } 
			@Override 
            public void focusLost(FocusEvent e) { 
                txtDetalle_focus(false);
             } 
            });
        txtCuenta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e){
                txtCuenta_focus(true);
            }
            @Override 
            public void focusLost(FocusEvent e) { 
                txtCuenta_focus(false);
            } 
        });
		
		txtBuscar.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyTyped(KeyEvent e) { 
                txt_keyTyped(e); 
            }
            });
		txtDetalle.addKeyListener(new KeyAdapter() {
			@Override 
            public void keyTyped(KeyEvent e) { 
                txt_keyTyped(e); 
            } });
        txtCuenta.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyTyped(KeyEvent e) { 
                txt_keyTyped(e); 
            } });


        editar(true);
        getRegistros();
    }
    protected void txtDetalle_focus(boolean bFocus) {
		txtDetalle.setBackground( bFocus ? new Color(225, 245, 254) : Color.WHITE );
        // txtCuenta.setBackground( bFocus ? new Color(225, 245, 254) : Color.WHITE  );
	}
    protected void txtCuenta_focus(boolean bFocus) {
		// txtDetalle.setBackground( bFocus ? new Color(225, 245, 254) : Color.WHITE );
        txtCuenta.setBackground( bFocus ? new Color(225, 245, 254) : Color.WHITE  );
	}

    protected void txt_keyTyped(KeyEvent e) {
        JTextField txt = (JTextField) e.getSource();
        char letra = e.getKeyChar();
        String texto = txt.getText();
        int longitud = texto.length();
        boolean isDigito = Character.isDigit(letra);
        boolean isSpace = Character.isWhitespace(letra);

        if (isDigito ||
                (isSpace && (longitud == 0 || texto.endsWith(" "))) ||
                longitud >= txt.getColumns())
            e.consume();
    }

	protected void btnAgregar_actionPerformed() {
        verRegistro(-1);
		editar(false);//false
    }

    protected void btnEditar_actionPerformed() {
    	editar(false);//false
    }

    protected void btnEliminar_actionPerformed() {
    	editar(false);//
    }

    protected void btnGuardar_actionPerformed() {
        int id = txtCodigo.getText() == null || txtCodigo.getText().isEmpty() ? 0 : Integer.parseInt(txtCodigo.getText());
        guardarNuevoDepartamento(id, txtDetalle.getText(), txtCuenta.getText());
        getRegistros();
        verRegistro(tblRegistros.getSelectedRow());
    	editar(true);//true
    }

    
    protected void btnCancelar_actionPerformed() {
    	editar(true);//true
    }
    protected void txtBuscar_caretUpdate() {
		tableRowSorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().toLowerCase(), 6));
	}

    protected void editar( boolean bOnOff ) {
    	Planillas.bEdicion = !bOnOff;
    	
    	
        btnAgregar.setVisible( bOnOff );//bOnOff
        btnEditar.setVisible( bOnOff  );//bOnOff
        btnEliminar.setVisible( bOnOff );//bOnOff
        btnGuardar.setVisible( !bOnOff );//!bOnOff
        btnCancelar.setVisible( !bOnOff );//!bOnOff

        txtBuscar.setFocusable( bOnOff  );//bOnOff
        txtDetalle.setFocusable( !bOnOff );//!bOnOff
        tblRegistros.setEnabled( bOnOff );
        txtCuenta.setFocusable( !bOnOff);
    }
    private void getRegistros() {
        
  		DefaultTableModel modelo = departamentoDAO.getDepartamento();
        tblRegistros.setModel(modelo);
        if (bHayRegitro = tblRegistros.getRowCount()  > 0) {
            for(int i = 0; i < tblRegistros.getColumnCount();i++){
                if(i == 1){
                    tblRegistros.getColumn(tblRegistros.getColumnName(i)).setMinWidth(243);
                    tblRegistros.getColumn(tblRegistros.getColumnName(i)).setMaxWidth(243); 
                }else{
                    tblRegistros.getColumn(tblRegistros.getColumnName(i)).setMinWidth(0);
                    tblRegistros.getColumn(tblRegistros.getColumnName(i)).setMaxWidth(0);
                }
            }
            //crea un espaioc en las columnas
            for (int i = 0 ; i < tblRegistros.getRowCount(); i++){
                tblRegistros.setValueAt("   "+tblRegistros.getValueAt(i, 1), i, 1);
                // System.out.println(filas);
            } 
            //filtrar las filas 
            tblRegistros.setAutoCreateRowSorter(true);
            //
            tableRowSorter = new TableRowSorter<>((DefaultTableModel) tblRegistros.getModel());
            tblRegistros.setRowSorter(tableRowSorter);
            tblRegistros.setRowSelectionInterval(0, 0);
        }
        
        
  	}
      private void verRegistro(int index) {
		this.index = index;
		boolean bLimpiar = index == -1;
		
		txtCodigo.setText( bLimpiar ? "" : tblRegistros.getValueAt(index, 0).toString() );
		txtDetalle.setText( bLimpiar ? "" : tblRegistros.getValueAt(index, 1).toString() );
        txtCuenta.setText( bLimpiar ? "" : tblRegistros.getValueAt(index, 2).toString() );
	}
    private void guardarNuevoDepartamento(int id, String detalle, String cuenta) {
        int _id = id > 0 ? id : -1;
        departamentoDAO.nuevoDepartamento(_id, detalle.trim(), cuenta.trim());
    
    }

}