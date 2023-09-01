package org.coffeebean.common.cli.command;

import org.coffeebean.common.Input;
import org.coffeebean.common.ui.Application;

public class ExitCommand implements Command {

	private Application app;
	
	public ExitCommand(Application app) {
		super();
		this.app = app;
	}

	@Override
	public void execute() {
		
		String answer = Input.read("종료하시겠습니까? (y/n)");
		
		if(answer.equalsIgnoreCase("y")) {
			app.cleanUp();
			System.exit(0);
		}
	}
}
