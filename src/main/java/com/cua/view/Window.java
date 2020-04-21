package com.cua.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.cua.textprocess.Event;
import com.cua.textprocess.ManagerFiles;

public class Window extends JFrame{

	private JPanel contentBorderLayout = new JPanel();
	private MenuBar m = new MenuBar();
	private Event event;
	private JTextArea area = new JTextArea();
	
	public Window() {
		super();
		setTitle("Editor de Texto");
		setSize(800, 600);
		setVisible(true);
		
	}
	
	
	public void addMenuBar() {
		JMenu menus [] = {new JMenu("Archivo"), new JMenu("Acerca de")};
		m.createMenus(menus);
		add(m.instanceMenu(), BorderLayout.NORTH);
	}
	
	public void addMenuItems() {
		event = new Event();

		JMenuItem items [] = {new JMenuItem("Guardar"), new JMenuItem("Abrir Archivo"),new JMenuItem("Autor Cristian Vargas")};
		m.createMenuItems(items[0], 0, true);
		m.createMenuItems(items[1], 0, false);
		m.createMenuItems(items[2], 1, false);
		
		m.getLengthItems(); // remove to end
		
		m.registerEventsToItemsMenus(0,event.saveFile(area));
		m.registerEventsToItemsMenus(1, event.explorer(area));

	}
		
	public void addArea() {
		
		JScrollPane scroll = new JScrollPane(area);
		contentBorderLayout.setLayout(new BorderLayout());
		contentBorderLayout.add(scroll);
		add(scroll, BorderLayout.CENTER);
		
	}
	
	public void prepareCloseWindow() {
		event = new Event();
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.print(event.getIsSave());
				// TODO Auto-generated method stub
				if(!area.getText().isEmpty() && event.getIsSave() == false) {
					int option = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?");
					if(option == 0) {
						event.internalSave(area);	
					}
				}
				event.setIsSave(false);
				System.exit(0);	
				
			}
		});
	}
	
}
