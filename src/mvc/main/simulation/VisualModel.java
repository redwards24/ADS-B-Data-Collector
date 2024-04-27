package mvc.main.simulation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import components.Label;
import components.custom.RootPanel;
import components.text.TextField;
import guiutil.Grid;

public class VisualModel 
{
	
	public final JPanel rootPanel = new RootPanel().get();
	
	
	protected final JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
	

	
	
	protected final JPanel titlePanel = new RootPanel().get();
	protected final JPanel titleLabelPanel = new Label("Title").initFontSize(18).toFlowPanel(FlowLayout.CENTER, 10, 10);
	protected final JPanel titleContentPanel = new JPanel(new GridBagLayout());
	
	protected final JTextField titleField = new TextField().initColumns(30).get();
	protected final JTextField subtitleField = new TextField().initColumns(30).get();
	
	protected final GeoplotModel geoplotModel;
	protected final AnimationModel animationModel;
	
	protected VisualModel()
	{
		this.geoplotModel = new GeoplotModel(this);
		this.animationModel = new AnimationModel(this);
		
		this.draw();
		this.assign();
	}
	
	private void draw()
	{
		
		final Grid grid = new Grid();
		grid.setAnchor(Grid.WEST);
		grid.setInset(5, 5, 5, 5);
		
		int x = 0;
		int y = 0;
		
		this.titleContentPanel.add(new JLabel("Title: "), grid.set(x, y)); 
		this.titleContentPanel.add(new JLabel("Subtitle: "), grid.set(x, ++y)); 
		
		x = 1; y = 0;
		grid.setAnchor(Grid.EAST);
		this.titleContentPanel.add(this.titleField, grid.set(x, y));
		this.titleContentPanel.add(this.subtitleField, grid.set(x, ++y));
		
		this.titlePanel.add(this.titleLabelPanel, BorderLayout.NORTH);
		this.titlePanel.add(this.titleContentPanel, BorderLayout.CENTER);
		
		
		
		tabPane.addTab("Geoplot", geoplotModel.rootPanel);
		tabPane.addTab("Animate", animationModel.rootPanel);
		
		rootPanel.add(titlePanel, BorderLayout.NORTH);
		rootPanel.add(tabPane, BorderLayout.CENTER);
	}
	
	private void assign()
	{
		
	}
}
