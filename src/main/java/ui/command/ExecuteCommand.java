package ui.command;

import lombok.NonNull;
import ui.UserInterface;

import java.io.FileNotFoundException;
import java.util.concurrent.*;

public class ExecuteCommand extends NonTerminatingCommand {
    public ExecuteCommand(@NonNull UserInterface userInterface) {
        super(userInterface);
    }

    public static void Execute (String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunable());
        System.out.println(executorService.submit(new MyCallable()).get());
        executorService.shutdown();
    }
    static class MyRunable implements Runnable{

        @Override
        public void run() {

        }
    }
    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            return null;
        }
    }

    @Override
    public void run() throws FileNotFoundException {

    }
}

