package com.cua.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.cua.textprocess.ManagerFiles;

public class MenuBar{
	private JMenuBar menuBar;
	private JMenu[] menus;
	private ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();
	public MenuBar() {
		this.menuBar = new JMenuBar();
	}
	
	public void  createMenus(JMenu [] menus) {
		for(short i=0; i < menus.length; i++) 
			this.menuBar.add(menus[i]);
		this.menus = menus;
		
	}
	
	public void createMenuItems(JMenuItem item, int positionMenu, boolean separator) {
		this.menus[positionMenu].add(item);
		this.items.add(item);
		if(separator)
			this.menus[positionMenu].addSeparator();
		
	}
	
	public JMenuBar instanceMenu() {
		return this.menuBar;
	}
	
	public  void getLengthItems() {
		System.out.println(this.menus.length);
	}
	
	public void registerEventsToItemsMenus(int position, ActionListener listener) {
		System.out.println(this.items.size());
		this.items.get(position).addActionListener(listener);
	}
	
}

