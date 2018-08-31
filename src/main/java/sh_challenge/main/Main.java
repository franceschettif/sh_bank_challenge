package sh_challenge.main;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.SimpleThreadScope;

import sh_challenge.domain.model.result.OperationResult;
import sh_challenge.init.Initializer;

public class Main {

	private static FileSystemXmlApplicationContext applicationContext;

	/**
	 * Main class.
	 * 
	 * @param args
	 *            <ol>
	 *            <li>initialAccountId
	 *            <li>initialAccountType
	 *            <li>finalAccountId
	 *            <li>sumToBeTransfered
	 *            </ol>
	 */
	public static void main(String[] args) {
		/**
		 * Based on which String[] args are used one of the following methods is to be
		 * called
		 */

		
		applicationContext = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
		beanFactory.registerScope("request", new SimpleThreadScope());
		beanFactory.registerScope("session", new SimpleThreadScope());
		beanFactory.registerScope("application", new SimpleThreadScope());

		Initializer initializer = applicationContext.getBean(Initializer.class);
		OperationResult result = initializer.start(args);

		// after obtaining result obj we can decide on how to implement eventual error
		// notifications/ logs/ etc..

		applicationContext.close();
	}

}
