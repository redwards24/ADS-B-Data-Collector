package mvc.source;

import java.awt.Dimension;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import components.custom.dialog.Dialog;

public class SourceSelector extends Dialog
{
	
	private final SourceModel model;

	
	public SourceSelector(final JFrame parent, final List<Source.Type> types) 
	{
		super(parent, "Source Selector", true);
		
		this.model = new SourceModel(types);
		
		this.setMode(Dialog.Mode.CANCEL_CONFIRM);
		
		this.addContent(model.rootPanel);
		
		this.setPreferredSize(new Dimension(1500, 900));
		this.pack();
		this.setLocationRelativeTo(parent);
	}

	
	public boolean hasValidSource()
	{
		return model.hasValidSource();
	}
	
	public Source getSource()
	{
		return model.getSource();
	}
	
}
