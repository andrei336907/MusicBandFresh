package ui.command;

import ui.UserInterface;

public class HelpCommand extends NonTerminatingCommand {
	public HelpCommand(UserInterface userInterface) {
		super(userInterface);
	}

	@Override
	public void run() {
		getUserInterface().writeMessage("quit, q, exit - exit : завершить программу (без сохранения в файл)");
		getUserInterface().writeMessage("?, ?? - help : вывести справку по доступным командам");
		getUserInterface().writeMessage("add music band, amb - add {element} : добавить новый элемент в коллекцию");
		getUserInterface().writeMessage("get all, ga - info : вывести в стандартный поток вывода информацию о коллекции");
		getUserInterface().writeMessage("clr, clear - clear : очистить коллекцию");
		getUserInterface().writeMessage("sv, save - save : сохранить коллекцию в файл");
		getUserInterface().writeMessage("rf, read file - считать сохраненную коллекцию");
		getUserInterface().writeMessage("upd, update - update id {element} : обновить значение элемента коллекции, id которого равен заданному");
		getUserInterface().writeMessage("rmv, remove - remove_by_id id : удалить элемент из коллекции по его id");
		getUserInterface().writeMessage("i, info - info : вывести в стандартный поток вывода информацию о коллекции ");
		getUserInterface().writeMessage("amn, add min - add_if_max : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
		getUserInterface().writeMessage("amx, add max - add_if_min : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
		getUserInterface().writeMessage("rmg, remove gr - remove_greater : удалить из коллекции все элементы, превышающие заданный");
		getUserInterface().writeMessage("sp, sum parts - sum_of_number_of_participants : вывести сумму значений поля numberOfParticipants для всех элементов коллекции");
		getUserInterface().writeMessage("fp, filter parts - filter_by_number_of_participants numberOfParticipants : вывести элементы, значение поля numberOfParticipants которых равно заданному");
		getUserInterface().writeMessage("fn, filter name - filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку");


	}

}
