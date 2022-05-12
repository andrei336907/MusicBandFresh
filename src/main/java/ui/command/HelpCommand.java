package ui.command;

import ui.UserInterface;

public class HelpCommand extends NonTerminatingCommand {
	public HelpCommand(UserInterface userInterface) {
		super(userInterface);
	}

	@Override
	public void run() {
		getUserInterface("eve").writeMessage("quit, q, exit - exit : завершить программу (без сохранения в файл)");
		getUserInterface("eve").writeMessage("?, ?? - help : вывести справку по доступным командам");
		getUserInterface("eve").writeMessage("add music band, amb - add {element} : добавить новый элемент в коллекцию");
		getUserInterface("eve").writeMessage("get all, ga - info : вывести в стандартный поток вывода информацию о коллекции");
		getUserInterface("eve").writeMessage("clr, clear - clear : очистить коллекцию");
		getUserInterface("eve").writeMessage("sv, save - save : сохранить коллекцию в файл");
		getUserInterface("eve").writeMessage("rf, read file - считать сохраненную коллекцию");
		getUserInterface("eve").writeMessage("upd, update - update id {element} : обновить значение элемента коллекции, id которого равен заданному");
		getUserInterface("eve").writeMessage("rmv, remove - remove_by_id id : удалить элемент из коллекции по его id");
		getUserInterface("eve").writeMessage("i, info - info : вывести в стандартный поток вывода информацию о коллекции ");
		getUserInterface("eve").writeMessage("amn, add min - add_if_max : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
		getUserInterface("eve").writeMessage("amx, add max - add_if_min : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
		getUserInterface("eve").writeMessage("rmg, remove gr - remove_greater : удалить из коллекции все элементы, превышающие заданный");
		getUserInterface("eve").writeMessage("sp, sum parts - sum_of_number_of_participants : вывести сумму значений поля numberOfParticipants для всех элементов коллекции");
		getUserInterface("eve").writeMessage("fp, filter parts - filter_by_number_of_participants numberOfParticipants : вывести элементы, значение поля numberOfParticipants которых равно заданному");
		getUserInterface("eve").writeMessage("fn, filter name - filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку");


	}

}
