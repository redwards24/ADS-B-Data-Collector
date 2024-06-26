package guiutil;

import java.awt.Component;

import javax.swing.JOptionPane;

import application.Application;

public class OptionPane
{
	public static void showError(final Component parent, final String message)
	{
		JOptionPane.showMessageDialog(parent, message, "Error!", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showError(final String message)
	{
		showError(Application.getApp(), message);
	}
	
	public static void showMessage(final String message)
	{
		JOptionPane.showMessageDialog(Application.getApp(), message, "Message.", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static boolean showYesNoCancel(final String message)
	{
		final int result = JOptionPane.showConfirmDialog(Application.getApp(), message);
		
		if(result == JOptionPane.YES_OPTION)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static String showInput(final String message)
	{
		return JOptionPane.showInputDialog(Application.getApp(), message);
	}
}
