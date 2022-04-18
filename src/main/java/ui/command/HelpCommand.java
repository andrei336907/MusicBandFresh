package ui.command;

import ui.UserInterface;

public class HelpCommand extends NonTerminatingCommand {
	public HelpCommand(UserInterface userInterface) {
		super(userInterface);
	}

	@Override
	public void run() {
		getUserInterface().writeMessage("quit, q, term, terminate - exit : завершить программу (без сохранения в файл)");
		getUserInterface().writeMessage("?, ??, ??? - help : вывести справку по доступным командам");
		getUserInterface().writeMessage("add music band, amb - add {element} : добавить новый элемент в коллекцию");
		getUserInterface().writeMessage("get all, ga - info : вывести в стандартный поток вывода информацию о коллекции");
		getUserInterface().writeMessage("clr, clear - clear : очистить коллекцию");
		getUserInterface().writeMessage("upd, update - update id {element} : обновить значение элемента коллекции, id которого равен заданному");
		getUserInterface().writeMessage("rmv, remove - remove_by_id id : удалить элемент из коллекции по его id");
		getUserInterface().writeMessage("get all, ga - InfoCommand");
		getUserInterface().writeMessage("get all, ga - InfoCommand");


	}

}
