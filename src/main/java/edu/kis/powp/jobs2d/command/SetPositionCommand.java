package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.visitor.VisitorCommand;

/**
 * Implementation of Job2dDriverCommand for setPosition command functionality.
 */
public class SetPositionCommand implements DriverCommand {

	private int posX, posY;

	public SetPositionCommand(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void execute(Job2dDriver driver) {
		driver.setPosition(posX, posY);
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return new SetPositionCommand(this.posX, this.posY);
		}
	}
	@Override
	public void accept(VisitorCommand visitor) {
		visitor.visit(this);
	}
}
