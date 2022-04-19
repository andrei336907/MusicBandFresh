//package ui.command;
//
//import model.repository.MusicBandRepo;
//import ui.UserInterface;
//
//import java.io.Console;
//
//public class ExecuteScriptCommand extends NonTerminatingCommand {
//    private MusicBandRepo musicBandRepo;
//
//
//    public ExecuteScriptCommand(UserInterface ui, MusicBandRepo musicBandRepo) {
//        super(ui);
//        this.musicBandRepo = musicBandRepo;
//
///*
//    public int scriptMode(String fileName) {
//        HumanAsker humanAsker = new HumanAsker();
//        String[] userCommand = {"", ""};
//        int commandStatus;
//        scriptStack.add(fileName);
//        try (Scanner scriptScanner = new Scanner(new File(fileName))) {
//            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
//            Scanner tmpScanner = humanAsker.getUserScanner();
//            humanAsker.setUserScanner(scriptScanner);
//            humanAsker.setFileMode();
//            do {
//                userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
//                userCommand[1] = userCommand[1].trim();
//                while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
//                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
//                    userCommand[1] = userCommand[1].trim();
//                }
//                Console.println(Console.PS1 + String.join(" ", userCommand));
//                if (userCommand[0].equals("execute_script")) {
//                    for (String script : scriptStack) {
//                        if (userCommand[1].equals(script)) throw new IllegalStateException();
//                    }
//                }
//                commandStatus = launchCommand(userCommand);
//            } while (commandStatus == 0 && scriptScanner.hasNextLine());
//            humanAsker.setUserScanner(tmpScanner);
//            humanAsker.setUserMode();
//            if (commandStatus == 1 && !(userCommand[0].equals("execute_script") && !userCommand[1].isEmpty()))
//                Console.println("Проверьте скрипт на корректность введенных данных!");
//            return commandStatus;
//        } catch (FileNotFoundException exception) {
//            Console.printerror("Файл со скриптом не найден!");
//        } catch (NoSuchElementException exception) {
//            Console.printerror("Файл со скриптом пуст!");
//        } catch (IllegalStateException exception) {
//            Console.printerror("Непредвиденная ошибка!");
//            System.exit(0);
//        } catch (CommandNotFoundException e) {
//            // todo
//        } finally {
//            scriptStack.remove(scriptStack.size() - 1);
//        }
//        return 1;
//    }
//*/
//
//            /**
//             * Выполнение команды.
//             *
//             * @return Статус выхода из команды.
//             */
//
//            @Override
//            public boolean execute(String argument) {
//                try {
//                    if (argument.isEmpty()) throw new WrongAmountOfElementsException();
//                    Console.println("Выполняю скрипт '" + argument + "'...");
//                    return true;
//                } catch (WrongAmountOfElementsException exception) {
//                    Console.println("Использование: '" + getName() + "'");
//                }
//                return false;
//            }
//        }
//
