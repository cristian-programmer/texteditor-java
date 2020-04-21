package com.cua.textprocess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextArea;

import com.cua.view.Explorer;

public class Event {
	private ManagerFiles mf;
	private String path;

	private String [] contents;
	private boolean isSave = false; 
	
	
	private void instaceManagerFiles(String path) {
		mf = new ManagerFiles(path);	
		this.path = path;
	}
	
	public ActionListener saveFile(final JTextArea area) {
		
		ActionListener event;
		 
		event = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(area.getText());
				internalSave(area);
			}
		};
		
		return event;
	}
	
	public void  internalSave(JTextArea area) {
		
		Explorer explorer = new Explorer();
		instaceManagerFiles(explorer.prepareSaveFile());
		if(area.getText() != null) {
			mf.prepareWriteFile();
			mf.createFile();
			contents = area.getText().split("\\n");
			for(int i=0; i < contents.length; i ++ ) {
				mf.writeText(contents[i] + "\n");
			}
			this.isSave = true;
			mf.closeWriteFile();
		}
	}
	
	public ActionListener writeFile(final String text) {
		ActionListener event;
		event = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mf.writeText(text);
			}
		};
		
		return event;
	}
	
	public ActionListener explorer(final JTextArea area) {
		ActionListener event;
		
		event = new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				Explorer explorer = new Explorer();
				explorer.openExplorer();
				String path = explorer.listenerOpenFile();
				if(path != null) {
					System.out.println(path);
					instaceManagerFiles(path);
					mf.setPath(path);
					mf.prepareReadFile();
					
					ArrayList <String> data =  mf.readText();
					for(int i=0; i < data.size(); i++) {
						System.out.println(data.get(i));
						area.append(data.get(i));
					}
					mf.closeReadFile();
				}

			}
		};
		
		return event;
	}
	
	public boolean getIsSave() {return isSave;}
	
	public void setIsSave(boolean reset) {this.isSave =  reset; }
	
}
