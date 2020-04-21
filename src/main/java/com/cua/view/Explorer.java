package com.cua.view;

import java.io.File;

import javax.swing.JFileChooser;

public class Explorer {
	
	private JFileChooser explorer;
	private File file;
	
	public void openExplorer() {
		explorer = new JFileChooser();
		explorer.showOpenDialog(explorer);	
	}
	
	public String prepareSaveFile() {
		explorer = new JFileChooser();
		explorer.showSaveDialog(explorer);
		explorer.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		return (explorer.getSelectedFile().getAbsolutePath()) != null
				? explorer.getSelectedFile().getAbsolutePath() 
				: null;
	}
	
	public String listenerOpenFile() {
		return  (explorer.getSelectedFile().getAbsolutePath()) != null
				? explorer.getSelectedFile().getAbsolutePath() 
				: null;
	}
	
	public void saveFile() {
		
	}
}
