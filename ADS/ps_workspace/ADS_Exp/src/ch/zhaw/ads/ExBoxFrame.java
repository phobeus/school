package ch.zhaw.ads;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.List;

/**
 * Experimenting Box Application - Used for Praktika in Algorithms &
 * Datastructure Course
 * 
 * @author ?
 * @version	1.00 2012/2/3
 * @version 2.00 2013/2/19 F.Uzdilli Complete Refactoring
 * 
 */
@SuppressWarnings("serial")
public class ExBoxFrame extends JFrame {

	private static final String TITLE_APP_CONNECTED = " connected to ";
	private static final String TITLE_APP = "ExBox";
	private static final String TITLE_FILEDIALOG = "Open";

	private static final String ERROR_PREFIX = "ERROR";
	private static final String ERROR_NOSERVER = "no service connected...";

	private static final String LABEL_ENTER = "enter";

	private static final String MENU_FILE = "File";
	private static final String MENU_OPEN = "Open...";
	private static final String MENU_EXIT = "Exit";
	private static final String MENU_CONNECT = "Connect";

	private JTextField arguments;
	private JComboBox history;
	private JTextArea output;
	private JButton enter;
	private CommandExecuter command;

	public ExBoxFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setTitle(TITLE_APP);
		createMenuBar();
		setSize(new Dimension(400, 400));
		setLookAndFeel();

		buildView();
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createConnectMenu());
		setJMenuBar(menuBar);
	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look & Feel not found");
		}
	}

	private void buildView() {
		setLayout(new BorderLayout());

		output = new JTextArea();
		add(BorderLayout.CENTER, new JScrollPane(output));

		addCommandBox();

		addHistoryBox();

		Panel panel = new Panel(new BorderLayout());
		panel.add(BorderLayout.CENTER, arguments);
		panel.add(BorderLayout.EAST, enter);
		panel.add(BorderLayout.SOUTH, history);
		add(BorderLayout.SOUTH, panel);
	}

	private void addCommandBox() {
		ActionListener commandListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleNewArgument();
			}
		};

		arguments = new JTextField();
		arguments.addActionListener(commandListener);

		enter = new JButton(LABEL_ENTER);
		enter.addActionListener(commandListener);
	}

	private void addHistoryBox() {
		history = new JComboBox();
		history.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				arguments.setText((String) e.getItem());
			}
		});
	}

	private JMenu createConnectMenu() {
		JMenu newSubmenu = new JMenu(MENU_CONNECT);

		ServiceProvider provider = new ServiceProvider();
		List<Class<CommandExecuter>> services = provider.getAllServices();
		
		for (final Class<CommandExecuter> serviceClass : services) {
			addServiceMenuItem(newSubmenu, serviceClass);
		}
		return newSubmenu;
	}

	private void addServiceMenuItem(JMenu menu, Class<CommandExecuter> serviceClass) {
		String serviceName = serviceClass.getName();
		JMenuItem connectItem = new JMenuItem(serviceName);
		ActionListener a = createConnectMenuActionListener(serviceClass);
		connectItem.addActionListener(a);
		menu.add(connectItem);
	}

	private ActionListener createConnectMenuActionListener(final Class<CommandExecuter> serviceClass) {
		final String serviceName = serviceClass.getName();
		ActionListener resultActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					command = serviceClass.newInstance();
					setTitle(TITLE_APP + TITLE_APP_CONNECTED + serviceName);
				} catch (IllegalAccessException ex) {
					ex.printStackTrace();
					logError("Could not instantiate service:" + e);
				} catch (InstantiationException ex) {
					ex.printStackTrace();
					logError("Could not instantiate service:" + e);
				}
			}
		};
		return resultActionListener;

	}

	private void handleNewArgument() {
		if (!arguments.getText().equals(history.getSelectedItem())) {
			history.addItem(arguments.getText());
		}
		interpret(arguments.getText());
	}

	private void handleFileViaOpenDialog() {
		try {
			FileDialog fd = new FileDialog(ExBoxFrame.this, TITLE_FILEDIALOG);
			fd.setVisible(true);
			String name = fd.getFile();
			FileReader r = new FileReader(fd.getDirectory() + "\\" + name);
			BufferedReader br = new BufferedReader(r);
			StringBuffer b = new StringBuffer();

			String command = getCommandFromFile(br, b);
			interpret(command);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			logError(ex + ex.getMessage());
		}
	}

	private String getCommandFromFile(BufferedReader br, StringBuffer b)
			throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			b.append(line);
			b.append('\n');
		}
		br.close();
		String command = b.toString();
		return command;
	}

	private JMenu createFileMenu() {
		JMenu menuFile = new JMenu(MENU_FILE);

		addOpenMenuItem(menuFile);

		addExitMenuItem(menuFile);

		return menuFile;
	}

	private void addOpenMenuItem(JMenu menuFile) {
		JMenuItem open = new JMenuItem(MENU_OPEN);
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleFileViaOpenDialog();

			}
		});
		menuFile.add(open);
	}

	private void addExitMenuItem(JMenu menuFile) {
		JMenuItem menuFileExit = new JMenuItem(MENU_EXIT);
		menuFileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ExBoxFrame.this.dispose();
			}
		});
		menuFile.add(menuFileExit);
	}

	private void interpret(String args) {
		try {
			if (command != null) {
				String s = command.execute(args);
				logInfo(s);
			} else {
				logError(ERROR_NOSERVER);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logError("Could not execute command: " + e);
		}
	}

	private void logInfo(String s) {
		output.append(s + "\n");
	}

	private void logError(String s) {
		output.append(ERROR_PREFIX + ":\t" + s + "\n");
	}

	public static void main(String[] args) {
		new ExBoxFrame().setVisible(true);
	}
}