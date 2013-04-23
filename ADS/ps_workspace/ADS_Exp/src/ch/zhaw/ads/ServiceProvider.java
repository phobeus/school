package ch.zhaw.ads;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Used for retrieving classes of type {@link CommandExecuter} which have a
 * default constructor. Note that this only works in an environment where the
 * class files are not packaged in an archive file.
 * 
 * @author F.Uzdilli
 * 
 */
public class ServiceProvider {

	/**
	 * Returns all classes of type {@link CommandExecuter}
	 * 
	 * @return all classes of type {@link CommandExecuter}
	 */
	public List<Class<CommandExecuter>> getAllServices() {
		ArrayList<Class<CommandExecuter>> results = new ArrayList<Class<CommandExecuter>>();
		Thread currentThread = Thread.currentThread();
		ClassLoader contextClassLoader = currentThread.getContextClassLoader();
		String folder = contextClassLoader.getResource(".").getPath();
		fillServers(new File(folder), "", results);
		return results;
	}

	private void fillServers(File folder, String packageName, List<Class<CommandExecuter>> servers) {
		for (File file : folder.listFiles()) {
			String classFileName = packageName + "." + file.getName();
			if (file.isDirectory()) {
				fillServers(file, classFileName, servers);
			} else if (classFileName.endsWith(".class")) {
				handleClass(classFileName, servers);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void handleClass(String classFileName, List<Class<CommandExecuter>> servers) {
		String className = classFileName.substring(1, classFileName.length() - 6);
		try {
			Class<?> clazz = Class.forName(className);
			if (!isSubType(clazz)) {
				// class not of interest
			} else if (isAbstract(clazz)) {
				System.err.println(clazz.getName() + " is not a constructable class.");
			} else if (!hasDefaultConstructor(clazz)) {
				System.err.println(clazz.getName() + " has no accessible public default constructor.");
			} else {
				servers.add((Class<CommandExecuter>) clazz);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Unexpected Error - Could not find class: " + className);
			e.printStackTrace();
		}
	}

	private boolean hasDefaultConstructor(Class<?> clazz) {
		try {
			// just trying to retrieve default constructor
			clazz.getConstructor();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isSubType(Class<?> clazz) {
		return CommandExecuter.class.isAssignableFrom(clazz) && clazz != CommandExecuter.class;
	}

	private boolean isAbstract(Class<?> clazz) {
		return Modifier.isAbstract(clazz.getModifiers());
	}

}
